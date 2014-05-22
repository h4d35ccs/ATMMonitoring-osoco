package com.ncr.ATMMonitoring.updatequeue;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Class that adds to the Update queue the information of an ATM
 * 
 * @author Otto Abreu
 * 
 */
@Component
public class ATMUpdateQueueProducer {

    @Autowired
    private JmsTemplate atmUpdateJmsTemplate;

    /**
     * Adds to the queue the information of one ATM
     * 
     * @param matricula
     *            int
     * @param ip
     *            String
     */
    public void sendUpdateToQueue(Long matricula, String ip) {

	ATMUpdateInfo updateInfo = this.instanciateMessageObject(matricula, ip);

	this.sendObject(updateInfo);
    }

    private ATMUpdateInfo instanciateMessageObject(Long matricula, String ip) {
	ATMUpdateInfo atmUpdateInfo = new ATMUpdateInfo(ip, matricula);
	return atmUpdateInfo;
    }
    
    private void sendObject(ATMUpdateInfo updateInfo){
	this.atmUpdateJmsTemplate.convertAndSend(updateInfo);
    }

    /**
     * Adds to the queue the information of one ATM
     * 
     * @param updateInfo
     *            ATMUpdateInfo
     */
    public void sendUpdateToQueue(ATMUpdateInfo updateInfo) {

	this.sendObject(updateInfo);
    }
    
    /**
     * Adds to the queue the information of several ATM
     * @param updateInfos List<ATMUpdateInfo>
     */
    public void sendUpdateToQueue(Collection<ATMUpdateInfo> updateInfos) {

	for(ATMUpdateInfo updateInfo: updateInfos){
	    
	    this.sendObject(updateInfo);
	}
   	
     }

}
