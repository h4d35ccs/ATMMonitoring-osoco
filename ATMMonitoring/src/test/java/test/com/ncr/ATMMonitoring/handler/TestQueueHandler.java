package test.com.ncr.ATMMonitoring.handler;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.Queue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncr.ATMMonitoring.handler.QueueHandler;
import com.ncr.ATMMonitoring.handler.exception.QueueHandlerException;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo;

/**
 * @author Otto Abreu
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:applicationContext.xml","classpath:updatequeue-config.xml"})
public class TestQueueHandler {

    static private Logger logger = Logger.getLogger(TestQueueHandler.class);

    @Autowired
    private QueueHandler qh;
    @Value("${config.queue.filestore}")
    private String filestorePath;
    @Value("${config.queue.name}")
    private String queueName;

    private static String IPV4VALUE = "200.35.1.10";
    private static String IPV6VALUE = "2607:f0d0:1002:51::4";
    private static String IPV6VALUE2 = "2607:f0d0:1002:0051:0000:0000:0000:0004";
    private static String IPV6VALUE_LOOPBACK = "2607:f0d0:1002:51::4/64";

    @After
   public void tearDown() {
	try {
//
//	    this.qh.destroy();
	    this.qh.removeAll();
	} catch (QueueHandlerException e) {
//	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
   }
//
//    @Before
//    public void setUp() {
//	this.qh.loadQueue();
//    }

    /**
     * Test method for
     * {@link com.ncr.ATMMonitoring.handler.QueueHandler#add(java.lang.String)}.
     */
    @Test
    public void testAdd() {
	this.qh.add(IPV4VALUE,2);
	this.qh.add(IPV6VALUE,3);
	this.qh.add(IPV6VALUE2,4);
	this.qh.add(IPV6VALUE_LOOPBACK,5);
//	this.qh.save();
    }

    @Test(expected = QueueHandlerException.class)
    public void testAddNoIP() {
	this.qh.add("hola",1);
	this.qh.add("200.35.1",2);
    }

    /**
     * Test method for
     * {@link com.ncr.ATMMonitoring.handler.QueueHandler#addAll(java.util.Collection)}
     * .
     */
    @Test
    public void testAddAll() {
	this.addIps();
    }

    /**
     * Test method for
     * {@link com.ncr.ATMMonitoring.handler.QueueHandler#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
	assertTrue(this.qh.isEmpty());
    }

//    /**
//     * Test method for
//     * {@link com.ncr.ATMMonitoring.handler.QueueHandler#removeAll()}.
//     */
//    @Test
//    public void testRemoveAll() {
//	this.addIps();
//	this.qh.save();
//	this.qh.removeAll();
//	assertTrue(this.qh.isEmpty());
//	this.qh.save();
//	// i make sure that we save an empty queue
//	this.qh.loadQueue();
//	assertTrue(this.qh.isEmpty());
//    }

    /**
//     * Verify that the order of the elements is the same as they where added
//     */
//    @Test
//    public void testPreserveOrderOfElements() {
//
//	this.addIps();
//	this.qh.save();
//	LinkedHashSet<String> listIp = this.listIp();
//	for (String ip : listIp) {
//	    String ipElement = this.qh.poll();
//	    if (!ipElement.equals(ip)) {
//
//		fail("The queue does not have the same order, retreived = "
//			+ ipElement + " expected= " + ip);
//
//	    }
//	}
//    }

//    /**
//     * Test method for
//     * {@link com.ncr.ATMMonitoring.handler.QueueHandler#removeElement(java.lang.String)}
//     * .
//     */
//    @Test
//    public void testRemoveElement() {
//	this.addIps();
//	this.qh.save();
//	this.qh.removeElement(IPV4VALUE);
//	this.qh.save();
//	assertTrue(!(this.qh.peek().equals(IPV4VALUE)));
//	// i make sure that we save the queue without the element
//	this.qh.loadQueue();
//	assertTrue(!(this.qh.peek().equals(IPV4VALUE)));
//
//    }

//    /**
//     * Test method for
//     * {@link com.ncr.ATMMonitoring.handler.QueueHandler#removeElements(java.util.Collection)}
//     * .
//     */
//    @Test
//    public void testRemoveElements() {
//	this.addIps();
//	this.qh.save();
//	LinkedHashSet<String> listIp = new LinkedHashSet<String>();
//	listIp.add(IPV4VALUE);
//	listIp.add(IPV6VALUE_LOOPBACK);
//	this.qh.removeElements(listIp);
//	String ip = this.qh.poll();
//	while (ip != null) {
//	    if (ip.equals(IPV4VALUE) || ip.equals(IPV6VALUE_LOOPBACK)) {
//		fail("the queue do not remove the elements");
//
//	    }
//	    ip = this.qh.poll();
//	}
//
//    }

//    /**
//     * Verifies that the queue is erased from the fileSystem
//     */
//    @Test
//    public void testDestroy() {
//	this.addIps();
//	this.qh.save();
//	this.qh.destroy();
//	File queueInFileSystem = new File(this.filestorePath + this.queueName);
//	assertFalse(queueInFileSystem.exists());
//    }

    /**
     * Assures that the queue only have one element without duplicates
     */
    @Test
    public void testAddDuplicated() {
	final int matriculaToTest = 1;
	this.addIps();
//	this.qh.save();
	this.qh.add(IPV4VALUE,matriculaToTest);
	this.qh.add(IPV4VALUE,matriculaToTest);
	int count = 0;

	Queue<ATMUpdateInfo> update = this.qh.viewQueue();

	for(ATMUpdateInfo info : update) {

	    if (info.getAtmIp().equals(IPV4VALUE) && info.getAtmMatricula() == matriculaToTest) {
		count++;
	    }
	   
	}
	assertTrue(count == 1);
    }

    private void addIps() {
	this.qh.addAll(this.listIp());

    }

    private LinkedHashSet<ATMUpdateInfo> listIp() {
	LinkedHashSet<ATMUpdateInfo> listIp = new LinkedHashSet<ATMUpdateInfo>();
	listIp.add(new ATMUpdateInfo(IPV4VALUE,1l));
	listIp.add(new ATMUpdateInfo(IPV6VALUE,1l));
	listIp.add(new ATMUpdateInfo(IPV6VALUE2,1l));
	return listIp;
    }

}
