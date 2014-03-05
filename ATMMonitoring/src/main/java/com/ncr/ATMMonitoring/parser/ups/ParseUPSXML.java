package com.ncr.ATMMonitoring.parser.ups;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;
import com.ncr.ATMMonitoring.parser.ups.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.ups.exception.ParserException;
import com.ncr.ATMMonitoring.parser.ups.exception.XMLNotReadableException;

/**
 * Interface that define a XML UPS Parser ( a Link in the responsibility chain) <br>
 * To start the chain and the parsing process call the
 * {@link ParseUPSChainBuilder#parse(InputStream)}
 * 
 * @author ottoabreu
 * 
 */
public abstract class ParseUPSXML {

	// next link in the chain
	private ParseUPSXML nextParser;
	//
	private InputStream xmlFile;

	private String originalXmlString;

	// logger
	protected static final Logger logger = Logger.getLogger(ParseUPSXML.class);

	/**
	 * Method that parse an XML from an specific UPS<br>
	 * If the XML can not be parsed by this method, the next parser will be
	 * called ( Chain of responsibility pattern)
	 * 
	 * @param xmlFile
	 *            {@link InputStream}
	 * @return {@link UPSInfo}
	 * @throws ParserException
	 *             if occurs a general error
	 * @throws XMLNotReadableException
	 *             if can not read the XML or the content of a node
	 * 
	 * 
	 * @throws NoParserFoundException
	 *             if the end of the chain is reached an no suitable parser was
	 *             found to the given XML
	 */
	public UPSInfo parseXML(InputStream xmlFile) throws ParserException,
			XMLNotReadableException, NoParserFoundException {
		UPSInfo upsInfo = null;
		try {
			// in order to avoid the stream closing after each read,
			// i save the original xml as string an get a new inputstream each
			// time
			this.originalXmlString = IOUtils.toString(xmlFile);
			logger.debug("original xml: " + this.originalXmlString);
			this.xmlFile = IOUtils.toInputStream(this.originalXmlString);

			boolean willProcess = this.canParseXML();
			// verify if the parser can process the file
			if (willProcess) {
				logger.debug(this.getClass() + " this parser will process");
				upsInfo = this.applyParser();
				// otherwise it will call the next in the chain
			} else {
				logger.debug(this.getClass() + " this parser will delegate");
				upsInfo = this.callNextParser();
			}

		} catch (IOException e) {
			logger.error(ParserException.GENERAL_ERROR, e);
			throw new ParserException(ParserException.GENERAL_ERROR, e);
		}

		return upsInfo;
	}

	/**
	 * Returns the XML Inputstream
	 * 
	 * @return InputStream
	 */
	protected InputStream getXmlFile() {
		return xmlFile;
	}

	/**
	 * Indicate if the parser is in charge of read the XML<br>
	 * Return true if the parser will process the file, false if will delegate
	 * the process to other parser
	 * 
	 * @throws XMLNotReadableException
	 *             if can not read the XML or the content of a node
	 * @throws ParserException
	 *             if occurs a general error
	 * 
	 * @return boolean
	 */
	protected abstract boolean canParseXML() throws ParserException,
			XMLNotReadableException;

	/**
	 * Method that holds the specific logic to parse each XML and must be
	 * implemented by all the concrete classes
	 * 
	 * @return UPSInfo
	 */
	protected abstract UPSInfo applyParser() throws ParserException,
			XMLNotReadableException, NoParserFoundException;

	/**
	 * Sets the next parser in the chain
	 * 
	 * @param nextParser
	 *            {@link ParseUPSXML}
	 */
	public void setNextParser(ParseUPSXML nextParser) {
		this.nextParser = nextParser;

	}

	// /**
	// * Transform an InputStream in String<br>
	// * If can not read the InputStream return an empty string
	// *
	// * @param is
	// * {@link InputStream}
	// * @return String
	// */
	// protected String getStringFromInputStream(InputStream is) {
	//
	// // BufferedReader br = null;
	// // StringBuilder sb = new StringBuilder("");
	// //
	// // String line;
	// // try {
	// //
	// // br = new BufferedReader(new InputStreamReader(is));
	// // while ((line = br.readLine()) != null) {
	// // sb.append(line);
	// // }
	// //
	// // } catch (IOException e) {
	// // // can read the inputStrem will return the empty string
	// // logger.warn(
	// //
	// "can not get the XML in string returning empty string, will be not possible to see the XML in the logs",
	// // e);
	// // } finally {
	// // if (br != null) {
	// // try {
	// // br.close();
	// // } catch (IOException e) {
	// // logger.warn(
	// // "can not close the buffer reader while getting the XML in String",
	// // e);
	// // }
	// // }
	// // }
	// //
	// // return sb.toString();
	//
	// }

	/**
	 * Calls the {@link ParseUPSXML#applyParser(InputStream)} method in the next
	 * parser
	 * 
	 * @throws XMLNotReadableException
	 *             if the xml can not be read
	 * @throws NoParserFoundException
	 *             if the xml can not be parsed by any parser in the classpath
	 * @throws ParserException
	 *             if an error occurs
	 * @return {@link UPSInfo}
	 * @throws IOException
	 */

	private UPSInfo callNextParser() throws ParserException,
			XMLNotReadableException, NoParserFoundException, IOException {
		UPSInfo upsInfo = null;

		if (this.nextParser != null) {
			this.xmlFile = IOUtils.toInputStream(this.originalXmlString, null);
			upsInfo = this.nextParser.parseXML(this.xmlFile);

		} else {
			// no parser can read the xml
			throw new NoParserFoundException(
					NoParserFoundException.NO_PARSER_FOUND
							+ this.originalXmlString);
		}
		return upsInfo;
	}

	/**
	 * Returns the original xml in string format
	 * 
	 * @return String
	 */
	protected String getOriginalXmlString() {
		return originalXmlString;
	}

}
