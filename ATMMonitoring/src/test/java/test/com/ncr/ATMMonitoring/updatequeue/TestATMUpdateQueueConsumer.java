package test.com.ncr.ATMMonitoring.updatequeue;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateQueueConsumer;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateQueueProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:updatequeue-config.xml"})
public class TestATMUpdateQueueConsumer {

    @Autowired
    private ATMUpdateQueueProducer messageProducer;
    
    @Autowired
    private ATMUpdateQueueConsumer messageConsumer;
    
    private ATMUpdateInfo updateInfoOne = new ATMUpdateInfo("192.168.1.45", 10l);
    private  ATMUpdateInfo updateInfoTwo = new ATMUpdateInfo("192.168.1.144", 20l);
    private  ATMUpdateInfo updateInfoThree = new ATMUpdateInfo("192.168.1.08", 30l);
    private  ATMUpdateInfo updateInfoFour = new ATMUpdateInfo("192.168.1.60", 40l);
    
    
    @Test
    public void TestMessageConsumption(){
	
	
	List<ATMUpdateInfo> infoToPublish =  generateListToPublish();
	this.messageProducer.sendUpdateToQueue(infoToPublish);
	
	for(int i = 0; i < infoToPublish.size() ; i++){
	   
	    ATMUpdateInfo expected = infoToPublish.get(i);
	    ATMUpdateInfo obtained = consumeFromQueue();
	    assertTrue(expected.equals(obtained));
	}
	
	
	
    }
    
    private ATMUpdateInfo consumeFromQueue(){
	return this.messageConsumer.receiveUpdateInfo();
    }
   
    
    private  List<ATMUpdateInfo> generateListToPublish(){
	
   	List<ATMUpdateInfo> updateInfos = new ArrayList<ATMUpdateInfo> ();
   	updateInfos.add(updateInfoOne);
   	updateInfos.add(updateInfoTwo);
   	updateInfos.add(updateInfoThree);
   	updateInfos.add(updateInfoFour);
   	return updateInfos;
   	
       }
}
