/**
 * 
 */
package com.ncr.ATMMonitoring.scheduledtask;

/**
 * Add the feature of avoid to run or avoid runing a scheduled task 
 * @author Otto Abreu
 * 
 */
public abstract class SheduledTaskEnabler {

    private static final boolean ENABLE_RUN_TASK = true;
    private static final boolean DISABLE_RUN_TASK = false;

    private boolean runTask = ENABLE_RUN_TASK;


    /**
     * Tells the Scheduled task to avoid logic execution
     */
    public void disableTask() {
	this.runTask = DISABLE_RUN_TASK;
    }

    /**
     * Tells the Scheduled task to avoid logic execution
     */
    public void enableTask() {
	this.runTask = ENABLE_RUN_TASK;
    }
    /**
     * Executes the logic of the scheduled task if the feature is enabled
     */
    public void runScheduledTask(){
	if(this.runTask){
	    
	    executeLogic();
	}
    }
    /**
     * Holds the logic of the scheduled task
     */
    protected abstract void executeLogic();

}
