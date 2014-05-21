package com.ncr.ATMMonitoring.parser.ups.exception;

/**
 * Indicates that some error (unrelated to the read process) happened while
 * executing the parsing operation
 * 
 * @author Otto Abreu
 * 
 */
public class ParserException extends Exception {

    /**
     * The serial field
     */
    private static final long serialVersionUID = -949904629410522332L;

    /**
     * DOCUMENT_BUILDER_ERROR =
     * "Can not get the document builder, the file will not be parsed";
     */
    public static final String PARSER_CONFIGURATION_ERROR = "Can not get the document builder(DOM) or can not get the SAX parser (SAX), the file will not be parsed";

    /**
     * GENERAL_ERROR =
     * "Can not continue with the parse operation due a general error: ";
     */
    public static final String GENERAL_ERROR = "Can not continue with the parse operation due a general error: ";

    /**
     * Constructor that simply accepts a message.
     * 
     * @param message
     *            the exception message
     */
    public ParserException(String message) {
	super(message);
    }

    /**
     * Constructor that accepts another Throwable (usually an Exception) as the
     * cause of the constructed one.
     * 
     * @param exc
     *            the cause of this exception
     */
    public ParserException(Throwable exc) {
	super(exc);
    }

    /**
     * Constructor that accepts both another Throwable (usually an Exception) as
     * the cause of the constructed one and a message.
     * 
     * @param message
     *            the exception message
     * @param exc
     *            the cause of this exception
     */
    public ParserException(String message, Throwable exc) {
	super(message, exc);
    }

}
