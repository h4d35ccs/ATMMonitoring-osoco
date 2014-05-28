package com.ncr.ATMMonitoring.serverchain.message.specific.outgoing;

import com.ncr.ATMMonitoring.serverchain.message.specific.strategy.imp.UpdateDataRequestStrategy;
import com.ncr.serverchain.message.specific.SpecificMessage;
import com.ncr.serverchain.message.specific.strategy.StrategyMapper;

/**
 * Message to request an update to an ATM
 * @author Otto Abreu
 *
 */
@StrategyMapper(strategyMapping = UpdateDataRequestStrategy.class)
public class UpdateDataRequest implements SpecificMessage {
    
 
    private static final long serialVersionUID = 1L;

    private String atmIp;
    
    private Long matricula;
    
 
    public UpdateDataRequest(String atmIp, long matricula) {
	super();
	this.atmIp = atmIp;
	this.matricula = matricula;
    }

    public String getAtmIp() {
        return atmIp;
    }

    public Long getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("UpdateDataRequest [");
	if (atmIp != null) {
	    builder.append("atmIp=");
	    builder.append(atmIp);
	    builder.append(", ");
	}
	if (matricula != null) {
	    builder.append("matricula=");
	    builder.append(matricula);
	}
	builder.append("]");
	return builder.toString();
    }
    
    

}
