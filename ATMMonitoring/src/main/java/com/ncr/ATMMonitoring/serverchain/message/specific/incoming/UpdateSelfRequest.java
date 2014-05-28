package com.ncr.ATMMonitoring.serverchain.message.specific.incoming;

import com.ncr.serverchain.message.specific.SpecificMessage;
import com.ncr.serverchain.message.specific.strategy.StrategyMapper;
import com.ncr.ATMMonitoring.serverchain.message.specific.strategy.imp.UpdateSelfRequestStrategy;

/**
 * Holds the information regarding an ATM asking for an update
 * @author Otto Abreu
 * 
 */
@StrategyMapper(strategyMapping= UpdateSelfRequestStrategy.class)
public class UpdateSelfRequest implements SpecificMessage {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String atmIp;

    private long matricula;
    
    
    public UpdateSelfRequest(String atmIp, long matricula) {
	super();
	this.atmIp = atmIp;
	this.matricula = matricula;
    }

    public String getAtmIp() {
        return atmIp;
    }

    public long getMatricula() {
        return matricula;
    }

    
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("UpdateSelfRequest [");
	if (atmIp != null) {
	    builder.append("atmIp=");
	    builder.append(atmIp);
	    builder.append(", ");
	}
	builder.append("matricula=");
	builder.append(matricula);
	builder.append("]");
	return builder.toString();
    }
    
    

}
