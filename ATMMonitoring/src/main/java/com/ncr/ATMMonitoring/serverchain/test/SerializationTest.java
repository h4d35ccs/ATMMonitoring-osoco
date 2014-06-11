package com.ncr.ATMMonitoring.serverchain.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.NetworkMappingResponse;
import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateMultipleRouterTable;
import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateRouterTable;
import com.ncr.ATMMonitoring.serverchain.message.specific.incoming.UpdateSelfRequest;
import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.ChangeLeafNodeRouterTableRequest;
import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.NetworkMappingRequest;
import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.UpdateDataRequest;
import com.ncr.serverchain.message.specific.SpecificMessage;
import com.ncr.serverchain.message.wrapper.IncomingMessage;
import com.ncr.serverchain.message.wrapper.MessageWrapper;
import com.ncr.serverchain.message.wrapper.OutgoingMessage;

public class SerializationTest {
    
    
    private static final String FILE_PATH ="/home/oa250047/";
    
    private static final String FILE_EXTENSION =".bin";
    
    
    public static void main (String[] args) {
	
	UpdateRouterTable urt = new UpdateRouterTable(1000033, "173.123.1.22:616117");
	
	Properties props = new Properties();
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	props.put(1000033, "173.123.1.22:616117");
	
	
	
	UpdateMultipleRouterTable umrt = new UpdateMultipleRouterTable(props) ;
	UpdateSelfRequest usr = new UpdateSelfRequest("184.123.4.1", 100045);
	NetworkMappingResponse nmr = new NetworkMappingResponse();
	
	
	NetworkMappingRequest nmreq = new NetworkMappingRequest();
	UpdateDataRequest udr = new UpdateDataRequest("184.123.4.1", 100045l);
	ChangeLeafNodeRouterTableRequest clnrtr = new ChangeLeafNodeRouterTableRequest("173.123.1.22:616117", props);
	
	OutgoingMessage out1 = getOutgoingMessage(nmreq);
	OutgoingMessage out2 = getOutgoingMessage(udr);
	OutgoingMessage out3 = getOutgoingMessage(clnrtr);
	
	
	IncomingMessage in1 = getIncomingMessage(umrt);
	IncomingMessage in2 = getIncomingMessage(usr);
	IncomingMessage in3 = getIncomingMessage(nmr);
	IncomingMessage in4 = getIncomingMessage(urt);
	
	
	serializeAllWrappers(out1,out2,out3,in1,in2,in3,in4);
	
	long total = totalFileSize(out1,out2,out3,in1,in2,in3,in4);
	System.out.println("total--->"+sizeInString(total));
	float average = average(total, out1,out2,out3,in1,in2,in3,in4);
	System.out.println("average--->"+sizeInString(average));
	
    }
    
    
    
    
    private static OutgoingMessage getOutgoingMessage(SpecificMessage message){
	OutgoingMessage outMessage = new OutgoingMessage("test message for size", 90l);
	outMessage.setSpecificMessage(message);
	
	return outMessage;
	
    }
    
    
    private static IncomingMessage getIncomingMessage(SpecificMessage message){
	IncomingMessage outMessage = new IncomingMessage("test message for size", 90l);
	outMessage.setSpecificMessage(message);
	
	return outMessage;
	
    }
    
    
    private static void serializeAllWrappers(MessageWrapper... wrappers){
	
	for(MessageWrapper wrapper: wrappers){
	    serializeWrapper(wrapper);
	}
	
    }
    
    private static void serializeWrapper (MessageWrapper wrapper){

	String fileName = getFileName(wrapper);
	FileOutputStream fos = null;
	    ObjectOutputStream out = null;
	    try {
	      fos = new FileOutputStream(fileName);
	      out = new ObjectOutputStream(fos);
	      out.writeObject(wrapper);

	      out.close();
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
    }
    
    
    private static String getFileName(MessageWrapper wrapper){
	return  FILE_PATH+wrapper.getClass().getSimpleName()+FILE_EXTENSION;
    }
    
    public static long totalFileSize(MessageWrapper... wrappers){
	long total = 0;
	
	for(MessageWrapper wrapper: wrappers){
	    total +=fileSize(wrapper);
	}
	
	return total;
    }
    
    private static long fileSize(MessageWrapper wrapper){
	String pathname = getFileName(wrapper);
	File wrapperSerialezed = new File(pathname);
	return wrapperSerialezed.length();
    }
    
    private static float average(long total,MessageWrapper... wrappers){
	System.out.println("total-->"+total);
	System.out.println("wrappers-->"+wrappers);
	return (total/wrappers.length);
    }
    
    private static String sizeInString(Number bytesSize){
	double kilobytes = (bytesSize.floatValue()/1024);
	return kilobytes+" Kb";
    }
    
   
}
