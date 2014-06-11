package com.ncr.ATMMonitoring.serverchain.test.message;

import com.ncr.ATMMonitoring.serverchain.test.strategy.DummyLeafCommunication;
import com.ncr.serverchain.message.specific.SpecificMessage;
import com.ncr.serverchain.message.specific.strategy.StrategyMapper;

@StrategyMapper(strategyMapping = DummyLeafCommunication.class)
public class DummyMessage implements SpecificMessage {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

}
