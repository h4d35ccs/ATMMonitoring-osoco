package com.ncr.ATMMonitoring.parser.ups.exception;

/**
 * Indicates that the XML can not be read by the parser
 * 
 * @author Otto Abreu
 * 
 */
public class XMLNotReadableException extends Exception {

    /**
     * The serial field
     */
    private static final long serialVersionUID = 573882647940391413L;

    /**
     * IO_ERROR = "Can not read the XML due an IO error";
     */
    public static final String IO_ERROR = "Can not read the XML due an IO error";

    /**
     * PARSE_ERROR =
     * "Can not parse the XML due an error while reading the file (SAXExeption) "
     * ;
     */
    public static final String PARSE_ERROR = "Can not parse the XML due an error while reading the file (SAXExeption) ";

    /**
     * PARSE_ELEMENT_ERROR =
     * "A element of the XML does not have the expected format value and can not be read"
     * ;
     */
    public static final String PARSE_ELEMENT_ERROR = "A element of the XML does not have the expected format value and can not be read ";

    /**
     * @param arg0
     */
    public XMLNotReadableException(String arg0) {
	super(arg0);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public XMLNotReadableException(Throwable arg0) {
	super(arg0);
	// TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     */
    public XMLNotReadableException(String arg0, Throwable arg1) {
	super(arg0, arg1);
	// TODO Auto-generated constructor stub
    }

}
