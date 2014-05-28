package test.com.ncr.ATMMonitoring.updatequeue;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncr.ATMMonitoring.updatequeue.ATMUpdateInfo;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateQueueBrowser;
import com.ncr.ATMMonitoring.updatequeue.ATMUpdateQueueProducer;

/**
 * @author Otto Abreu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:updatequeue-config.xml"})
public class TestATMUpdateQueueBrowser {
    
    @Autowired
    private ATMUpdateQueueProducer messageProducer;
    
   
    
    @Autowired
    private ATMUpdateQueueBrowser queueBrowser;
    
    private ATMUpdateInfo updateInfoOne = new ATMUpdateInfo("192.168.1.1", 1l);
    private  ATMUpdateInfo updateInfoTwo = new ATMUpdateInfo("192.168.1.14", 2l);
    private  ATMUpdateInfo updateInfoThree = new ATMUpdateInfo("192.168.1.8", 3l);
    private  ATMUpdateInfo updateInfoFour = new ATMUpdateInfo("192.168.1.90", 4l);
    
    @Test
    public void testQueueSizeInBrowser(){
	
	List<ATMUpdateInfo> infoToTest = this.generateFourUpdateInfoInorder();
	
	this.publishInQueue(infoToTest);
	
	int publishedSize = infoToTest.size();
	
	int browserSize = queueBrowser.queueSize();
	
	assertTrue(publishedSize == browserSize);
	
    }
    
    @Test
    public void testExrtractedQueueContainsNewValues(){
	
	List<ATMUpdateInfo> infoToTest = this.generateTwoUpdateInfoInorder();
	
	this.publishInQueue(infoToTest);
	
	Queue<ATMUpdateInfo> extractedFromBrowser = this.queueBrowser.getQueueCopy();
	
	assertTrue(queueContains(infoToTest,extractedFromBrowser));
	
    }
    
    private boolean queueContains(List<ATMUpdateInfo> expected,Queue<ATMUpdateInfo> extracted ){
	
	return CollectionUtils.containsAny(expected, extracted);
    }
    
    
    
    private void publishInQueue( List<ATMUpdateInfo> infoToPublish){
	
	
	this.messageProducer.sendUpdateToQueue(infoToPublish);
    }
    
    private  List<ATMUpdateInfo> generateTwoUpdateInfoInorder(){
	
	List<ATMUpdateInfo> updateInfos = new ArrayList<ATMUpdateInfo> ();
	updateInfos.add(updateInfoOne);
	updateInfos.add(updateInfoTwo);
	
	return updateInfos;
	
    }
    
    
    private  List<ATMUpdateInfo> generateFourUpdateInfoInorder(){
	
	List<ATMUpdateInfo> updateInfos = this.generateTwoUpdateInfoInorder();
	updateInfos.add(updateInfoThree);
	updateInfos.add(updateInfoFour);
	
	return updateInfos;
	
    }

}
