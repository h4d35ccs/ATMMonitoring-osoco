package com.ncr.ATMMonitoring.handler;

import java.util.Collection;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.handler.exception.QueueHandlerException;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateQueueBrowser;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateQueueConsumer;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateQueueProducer;

/**
 * Class that encapsulate the ATM ip to be updated queue <br>
 * To use this class is mandatory to load first the queue using the
 * {@link QueueHandler#loadQueue()} method, then execute the operations (add,
 * remove) and finally save the status using {@link QueueHandler#save()}. If the
 * save method is not called, the actual status of the queue will not be save in
 * disk, except if the destroy method is called<br>
 * This class need that the properties <b>config.queue.filestore.path</b> and
 * <b>config.queue.file.name</b> are configured as follows<br>
 * <ul>
 * <li><b>config.queue.filestore.path</b>: must specify a valid system path and
 * end with a /</li>
 * <li><b>config.queue.file.name</b> must specify a file name with extension,
 * example: queue.bin</li>
 * </ul>
 * 
 * @author Otto Abreu
 * 
 */
@Component
public class QueueHandler {

    /** The logger */
    private final static Logger logger = Logger.getLogger(QueueHandler.class);
   

    @Autowired
    private ATMUpdateQueueProducer messageProducer;

    @Autowired
    private ATMUpdateQueueConsumer messageConsumer;

    @Autowired
    private ATMUpdateQueueBrowser queueBrowser;

  
    /**
     * Adds an Update info to the queue<br>
     * 
     * 
     * @param ip
     * @param matricula
     */
    public synchronized void add(String ip, long matricula) {
	
	try {

	    this.validateipString(ip);
	    ATMUpdateInfo updateInfo = instanciateUpdateInfoObject(ip,
		    matricula);
	    addOnlyIfIsNotOnTheQueue(updateInfo);

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new QueueHandlerException(
		    QueueHandlerException.ADD_VALUE_TO_QUEUE + e.getMessage(),
		    e);
	}

    }
    
    public synchronized void add(ATMUpdateInfo updateInfo) {
	logger.debug("validating ip: "+updateInfo.getAtmIp());
	this.validateipString(updateInfo.getAtmIp());
	addOnlyIfIsNotOnTheQueue(updateInfo);
    }

    private ATMUpdateInfo instanciateUpdateInfoObject(String ip, long matricula) {

	ATMUpdateInfo updateInfo = new ATMUpdateInfo(ip, matricula);
	return updateInfo;
    }

    private void addOnlyIfIsNotOnTheQueue(ATMUpdateInfo updateInfo) {

	Queue<ATMUpdateInfo> snapshot = this.getQueueSnapshot();

	if (snapshot.isEmpty() || !snapshot.contains(updateInfo)) {
	    
	    this.validateipString(updateInfo.getAtmIp());
	    logger.info("added to the queue:"+updateInfo);
	    this.addToQueue(updateInfo);
	
	}else{
	    
	    logger.warn("repeated value: "+updateInfo+" won't be added to the queue ");
	}
    }

    private void addToQueue(ATMUpdateInfo updateInfo) {

	this.messageProducer.sendUpdateToQueue(updateInfo);
    }

    /**
     * Adds all the updates from the given collection. <br>
     * 
     * @param updates
     *            Collection <ATMUpdateInfo>
     */
    public synchronized void addAll(Collection<ATMUpdateInfo> updates) {

	try {

	    for (ATMUpdateInfo update : updates) {

		this.addOnlyIfIsNotOnTheQueue(update);
	    }

	} catch (Exception e) {

	    throw new QueueHandlerException(
		    QueueHandlerException.ADD_VALUES_TO_QUEUE + e.getMessage(),
		    e);
	}
	
    }

    /**
     * Tells if the queue is empty
     * 
     * @return boolean
     */
    public boolean isEmpty() {
	boolean isEmpty = false;
	try {

	    isEmpty = queueIsEmpty();

	} catch (Exception e) {
	    logger.warn(QueueHandlerException.GENERAL_ERROR + e.getMessage(), e);
	    throw new QueueHandlerException(QueueHandlerException.GENERAL_ERROR
		    + e.getMessage(), e);
	}

	return isEmpty;
    }

    private boolean queueIsEmpty() {

	if (this.queueBrowser.queueSize() == 0) {

	    return true;

	} else {

	    return false;
	}
    }

    /**
     * removes all the elements of the queue
     */
    public synchronized void removeAll() {

	try {
	    this.messageConsumer.cleanQueue();
	} catch (JMSException e) {
	    throw new QueueHandlerException(QueueHandlerException.REMOVE_ALL
		    + e.getMessage(), e);
	}

    }


    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     * 
     * @return String
     */
    public synchronized ATMUpdateInfo poll() {

	ATMUpdateInfo updateInfo = null;
	try {
	    updateInfo = getUpdateInfoFromQueue();

	} catch (Exception e) {

	    throw new QueueHandlerException(
		    QueueHandlerException.GET_VALUE_FROM_QUEUE + e.getMessage(),
		    e);
	}

	return updateInfo;
    }

    private ATMUpdateInfo getUpdateInfoFromQueue() {

	ATMUpdateInfo updateInfo = null;

	if (!this.isEmpty()) {

	    updateInfo = this.messageConsumer.receiveUpdateInfo();
	}

	return updateInfo;
    }

    /**
     * Retrieves, but does not remove, the head of this queue. Null if the queue
     * is empty
     * 
     * @return
     */
    public ATMUpdateInfo element() {
	Queue<ATMUpdateInfo> snapshot = this.getQueueSnapshot();
	ATMUpdateInfo firstUpdate = snapshot.element();

	return firstUpdate;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     * 
     * @return
     */
    public ATMUpdateInfo peek() {
	Queue<ATMUpdateInfo> snapshot = this.getQueueSnapshot();
	ATMUpdateInfo firstUpdate = snapshot.peek();
	return firstUpdate;
    }

    /**
     * Returns a copy of the queue, if the queue is null will return null, empty
     * otherwise
     * 
     * @return Queue<String>
     */
    public Queue<ATMUpdateInfo> viewQueue() {

	Queue<ATMUpdateInfo> snapshot = this.getQueueSnapshot();

	if (snapshot != null && !snapshot.isEmpty()) {

	    return snapshot;
	}
	return null;
    }

    private Queue<ATMUpdateInfo> getQueueSnapshot() {
	Queue<ATMUpdateInfo> snapshot = null;

	try {

	    snapshot = this.queueBrowser.getQueueCopy();

	} catch (Exception e) {

	    throw new QueueHandlerException(
		    QueueHandlerException.GET_QUEUE_COPY + e.getMessage(), e);
	}

	return snapshot;
    }

    /**
     * returns the size of the queue
     * 
     * @return
     * @throws QueueHandlerException
     */
    public int size() {
	int size = 0;

	try {

	    size = this.queueBrowser.queueSize();

	} catch (Exception e) {

	    throw new QueueHandlerException(
		    QueueHandlerException.GET_QUEUE_SIZE + e.getMessage(), e);
	}

	return size;
    }


    /**
     * Validates that the value beeing add is a valid ip
     * 
     * @param ip
     *            String
     * @throws QueueHandlerException
     *             if the string is not a valid ipv4 or ipv6
     */
    private void validateipString(String ip) throws QueueHandlerException {

	String ipv4Regex = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";
	// http://stackoverflow.com/questions/53497/regular-expression-that-matches-valid-ipv6-addresses
	// yes the regex is scary...
	String ipv6Regex = "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|"
		+ "([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|"
		+ "([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|"
		+ "([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|"
		+ "([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|"
		+ "([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|"
		+ "[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)"
		+ "|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|"
		+ "::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])"
		+ "|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))";

	Pattern patIpv4 = Pattern.compile(ipv4Regex);
	Pattern patIpv6 = Pattern.compile(ipv6Regex);

	Matcher matcherIpv4 = patIpv4.matcher(ip);
	Matcher matcherIpv6 = patIpv6.matcher(ip);

	if (!matcherIpv4.find() && !matcherIpv6.find()) {
	    logger.error(QueueHandlerException.NOT_AN_IP + ip);
	    throw new QueueHandlerException(QueueHandlerException.NOT_AN_IP
		    + ip);
	}

    }

}
