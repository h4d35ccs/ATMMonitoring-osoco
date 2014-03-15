/**
 * 
 */
package test.com.ncr.ATMMonitoring.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.LinkedHashSet;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncr.ATMMonitoring.handler.QueueHandler;
import com.ncr.ATMMonitoring.handler.exception.QueueHandlerException;

/**
 * @author Otto Abreu
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
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
		
			this.qh.destroy();
		} catch (QueueHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp(){
		this.qh.loadQueue();
	}

	/**
	 * Test method for
	 * {@link com.ncr.ATMMonitoring.handler.QueueHandler#add(java.lang.String)}.
	 */
	@Test
	public void testAdd() {
		this.qh.add(IPV4VALUE);
		this.qh.add(IPV6VALUE);
		this.qh.add(IPV6VALUE2);
		this.qh.add(IPV6VALUE_LOOPBACK);
		this.qh.save();
	}

	@Test(expected = QueueHandlerException.class)
	public void testAddNoIP() {
		this.qh.add("hola");
		this.qh.add("200.35.1");
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

	/**
	 * Test method for
	 * {@link com.ncr.ATMMonitoring.handler.QueueHandler#removeAll()}.
	 */
	@Test
	public void testRemoveAll() {
		this.addIps();
		this.qh.save();
		this.qh.removeAll();
		assertTrue(this.qh.isEmpty());
		this.qh.save();
		// i make sure that we save an empty queue
		this.qh.loadQueue();
		assertTrue(this.qh.isEmpty());
	}
	/**
	 * Verify that the order of the elements is the same as they where added
	 */
	@Test
	public void testPreserveOrderOfElements() {
		
		this.addIps();
		this.qh.save();
		LinkedHashSet<String> listIp = this.listIp();
		for(String ip: listIp){
			String ipElement = this.qh.poll();
			if(!ipElement.equals(ip)){
				
				fail("The queue does not have the same order, retreived = "+ipElement+ " expected= "+ip);
				
			}
		}
	}

	/**
	 * Test method for
	 * {@link com.ncr.ATMMonitoring.handler.QueueHandler#removeElement(java.lang.String)}
	 * .
	 */
	@Test
	public void testRemoveElement() {
		this.addIps();
		this.qh.save();
		this.qh.removeElement(IPV4VALUE);
		this.qh.save();
		assertTrue(!(this.qh.peek().equals(IPV4VALUE)));
		// i make sure that we save the queue without the element
		this.qh.loadQueue();
		assertTrue(!(this.qh.peek().equals(IPV4VALUE)));
		
	}

	/**
	 * Test method for
	 * {@link com.ncr.ATMMonitoring.handler.QueueHandler#removeElements(java.util.Collection)}
	 * .
	 */
	@Test
	public void testRemoveElements() {
		this.addIps();
		this.qh.save();
		LinkedHashSet<String> listIp =  new LinkedHashSet<String>();
		listIp.add(IPV4VALUE);
		listIp.add(IPV6VALUE_LOOPBACK);
		this.qh.removeElements(listIp);
		String ip = this.qh.poll();
		while(ip != null ){
			if(ip.equals(IPV4VALUE) || ip.equals(IPV6VALUE_LOOPBACK) ){
				fail("the queue do not remove the elements");
				
			}
			ip = this.qh.poll();
		}
		
	}
	
	/**
	 * Verifies that the queue is erased from the fileSystem
	 */
	@Test
	public void testDestroy(){
		this.addIps();
		this.qh.save();
		this.qh.destroy();
		File queueInFileSystem = new File(this.filestorePath + this.queueName);
		assertFalse(queueInFileSystem.exists());
	}
	/**
	 * Assures that the queue only have one element without duplicates
	 */
	@Test
	public void testAddDuplicated(){
		this.addIps();
		this.qh.save();
		this.qh.add(IPV4VALUE);
		int count = 0;
		
		String ip = this.qh.poll();
		
		while(ip != null){
			
			if(ip.equals(IPV4VALUE)){
				count++;
			}
			 ip = this.qh.poll();
		}
		assertTrue(count == 1);
	}
	
	private void addIps(){
		this.qh.addAll(this.listIp());
	
		
	}
	
	private LinkedHashSet<String> listIp(){
		LinkedHashSet<String> listIp =  new LinkedHashSet<String>();
		listIp.add(IPV4VALUE);
		listIp.add(IPV6VALUE);
		listIp.add(IPV6VALUE2);
		return listIp;
	}
	

}
