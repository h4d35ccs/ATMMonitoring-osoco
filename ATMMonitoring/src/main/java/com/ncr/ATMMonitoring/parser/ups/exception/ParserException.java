/**
 * 
 */
package com.ncr.ATMMonitoring.parser.ups.exception;

/**
 * Indicate an error while executing the parsing operation that are not related
 * to the read
 * 
 * @author ottoabreu
 * 
 */
public class ParserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 * @param arg0
	 */
	public ParserException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ParserException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ParserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
