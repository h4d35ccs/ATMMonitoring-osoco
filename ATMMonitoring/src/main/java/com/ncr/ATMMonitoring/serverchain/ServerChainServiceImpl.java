/**
 * 
 */
package com.ncr.ATMMonitoring.serverchain;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.ChangeLeafNodeRouterTableRequest;
import com.ncr.ATMMonitoring.serverchain.message.specific.outgoing.NetworkMappingRequest;
import com.ncr.serverchain.MessagePublisher;
import com.ncr.serverchain.NodeInformation;
import com.ncr.serverchain.NodePosition;
import com.ncr.serverchain.networkmap.NetworkMap;
import com.ncr.serverchain.networkmap.NetworkMapHandler;

/**
 * Concrete class of NetworkMappingService
 * @author Otto Abreu
 *
 */
@Service
public class ServerChainServiceImpl implements ServerChainService {

    @Autowired
    private NetworkMapHandler networkMapHandler;
    
    @Autowired
    private NodeInformation nodeInformation;
    
    @Autowired
    private MessagePublisher publisher;
    
    
    /* (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.NetworkMappingService#getNetworkJSON()
     */
    @Override
    public String getNetworkJSON() {
	
	String jsonNetwork ="";
	
	if(isOnlyNode()){
	 
	   jsonNetwork = this.getJsonForEmptyNetwork();
	   
	}else{
	    
	    jsonNetwork =  this.getJsonForNotEmptyNetwork();
	   
	}
	
	
	return jsonNetwork;
    }
    
    
    
    private String getJsonForEmptyNetwork(){
	   String portAndUrl = this.nodeInformation.getLocalUrl();
	   NetworkMap emptyMap =  this.networkMapHandler.constructEmptyNetworkMap(portAndUrl);
	   return emptyMap.toJSON();
    }
    
    private String getJsonForNotEmptyNetwork(){
	
	String jsonNetwork =  this.networkMapHandler.getNetworkMap().toJSON();
	
	if(isEmptyJson(jsonNetwork)){
	    jsonNetwork = getJsonForEmptyNetwork();
	}
	
	return jsonNetwork;
    }
    
    private boolean isEmptyJson(String jsonNetwork){
	
	if(jsonNetwork.equals("{}")){
	    return true;
	}else{
	    return false;
	}
    }
    
    private boolean isOnlyNode(){
	NodePosition position = nodeInformation.getNodePosition();
	
	if(position.equals(NodePosition.ONLY_NODE)){
	    
	    return true;
	    
	}else{
	    
	    return false;
	}
    }

    /*
     * (non-Javadoc)
     * @see com.ncr.ATMMonitoring.service.ServerChainService#editRouterTable(java.lang.String, java.util.Map)
     */
    @Override
    public void editRouterTable(String addressee,
	    Map<String, String> routerTableValues) {
	
	Properties newRouterTable = new Properties();
	newRouterTable.putAll(routerTableValues);
	ChangeLeafNodeRouterTableRequest editMessage = new ChangeLeafNodeRouterTableRequest(addressee,newRouterTable);
	this.publisher.publishOutgoingMessage("Edit Router table request to: "+addressee, editMessage);
	
    }


    /*
     * (non-Javadoc)
     * @see com.ncr.ATMMonitoring.serverchain.ServerChainService#requestNetworkMapping()
     */
    @Override
    public void requestNetworkMapping() {
	  
	  NetworkMappingRequest networkMappingRequest = new NetworkMappingRequest();

	  this.publisher.publishOutgoingMessage("Network Mapping Forced Request",
		    networkMappingRequest);
	
    }

}
