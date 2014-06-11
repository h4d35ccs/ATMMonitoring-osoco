package com.ncr.ATMMonitoring.serverchain.test.strategy;

import org.apache.log4j.Logger;

import com.ncr.serverchain.message.specific.strategy.imp.DirectLeafNodeCommunication;

public class DummyLeafCommunication extends DirectLeafNodeCommunication{

   
    private static final Logger logger = Logger
	    .getLogger(DummyLeafCommunication.class);
    @Override
    protected void processInLeaf() {
	logger.debug("processed in leaf");
    }

}
