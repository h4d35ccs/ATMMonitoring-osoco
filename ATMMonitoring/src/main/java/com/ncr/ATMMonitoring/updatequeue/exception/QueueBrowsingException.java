package com.ncr.ATMMonitoring.updatequeue.exception;

/**
 * Represent an error while browsing the ATM Update queue
 * 
 * @author Otto Abreu
 * 
 */
public class QueueBrowsingException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * GET_ENUMERATION_ERROR=
     * "Could not obtain the items in the enumeration due an JMSException: ";
     */
    public static final String GET_ENUMERATION_ERROR = "Could not obtain the items in the enumeration from the QueueBrowser due an JMSException: ";

    /**
     * GET_ENUMERATION_ERROR=
     * "Could not obtain the items in the enumeration due an JMSException: ";
     */
    public static final String GET_QUEUE_ERROR = "Could not obtain the Queue representation ( as java.util.Queue) from the QueueBrowser due an JMSException: ";

    
    /**
     * GET_QUEUE_SIZE_ERROR = "Could not obtain the Size of the queue due an JMSException: ";
     */
    public static final String GET_QUEUE_SIZE_ERROR = "Could not obtain the Size of the queue due an JMSException: ";

    public QueueBrowsingException(String message, Throwable cause) {
	super(message, cause);

    }

    public QueueBrowsingException(String message) {
	super(message);
    }

}
