/**
 * 
 */
package com.ncr.ATMMonitoring.handler.exception;

/**
 * Exception that indicate an error while operating over the queue
 * @author Otto Abreu
 *
 */
public class QueueHandlerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6407955972290438414L;
	/**
	 * NULL_OPERATION = "This operation can not be made because the queue is null, either the load method was not called or it fails to load the queue.";
	 */
	public static final String NULL_OPERATION_ERROR = "This operation can not be made because the queue is null, either the load method was not called or it fails to load the queue.";
	/**
	 * FILE_PATH_NOT_FOUND ="Queue File Path not found, check the prioperty file for values: config.queue.filestore.path , and config.queue.file.name";
	 */
	public static final String FILE_PATH_NOT_FOUND ="Queue File Path not found, check the prioperty file for values: config.queue.filestore.path , and config.queue.file.name";
	
	/**
	 * SAVE_IO_ERROR = "Can not save the queue state due a IOException";
	 */
	public static final String SAVE_IO_ERROR = "Can not save the queue state due a IOException";
	
	/**
	 *READ_IO_ERROR = "Can not read the queue  due a IOException";
	 */
	public static final String READ_IO_ERROR = "Can not read the queue  due a IOException";
	/**
	 * GENERAL_ERROR ="A general error occurs while operating over the queue, exception: ";
	 */
	public static final String GENERAL_ERROR ="A general error occurs while operating over the queue, exception: ";
	
	/**
	 * NOT_AN_IP ="The value that is trying to add is not a valid IPV4 or IPV6: value: ";
	 */
	public static final String NOT_AN_IP ="The value that is trying to add is not a valid IPV4 or IPV6: value: ";
	/**
	 *  DESTROY_ERROR ="Can not destroy the queue due an IO error: ";
	 */
	public static final String DESTROY_ERROR ="Can not destroy the queue due an IO error: ";
	
	
	public QueueHandlerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QueueHandlerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public QueueHandlerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
