/**
 * 
 */
package com.ncr.ATMMonitoring.parser.ups.imp;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ncr.ATMMonitoring.parser.ups.ParseUPSChainBuilder;
import com.ncr.ATMMonitoring.parser.ups.annotation.UPSParser;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;
import com.ncr.ATMMonitoring.parser.ups.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.ups.exception.ParserException;
import com.ncr.ATMMonitoring.parser.ups.exception.XMLNotReadableException;

/**
 * 
 * 
 * Class that parse an Emerson UPS XML with the following structure:<br>
 * &lt;PK-C1-UPS&gt;<br>
 * &nbsp;&nbsp;&lt;NUMPUESTO&gt;&lt;/NUMPUESTO&gt;<br>
 * &nbsp;&nbsp;&lt;IP_UPS&gt;&lt;/IP_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;FIRMWARE_UPS&gt;&lt;/FIRMWARE_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;ESTADO_UPS&gt;&lt;/ESTADO_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;PORCENTAJE_CARGA_UPS&gt;&lt;/PORCENTAJE_CARGA_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;PORCENTAJE_GASTO_UPS&gt;&lt;/PORCENTAJE_GASTO_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;ALARMAS_UPS&gt;&lt;/ALARMAS_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;NOMBRE_UPS&gt;&lt;/NOMBRE_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;MODELO_UPS&gt;&lt;/MODELO_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;NUM_SERIE_UPS&gt;&lt;/NUM_SERIE_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;TIEMPO_ENCENDIDO_UPS&gt;&lt;/TIEMPO_ENCENDIDO_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;AUTONOMIA_UPS&gt;&lt;/AUTONOMIA_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;AUD_FMO_UPS&gt;&lt;/AUD_FMO_UPS&gt;<br>
 * &nbsp;&nbsp;&lt;STATUS&gt;&lt;/STATUS&gt;<br>
 * &nbsp;&nbsp;&lt;FECHA_ULTIMA_EJECUCION&gt;&lt;/FECHA_ULTIMA_EJECUCION&gt;<br>
 * &lt;PK-C1-UPSS&gt;<br>
 * 
 * <b><i>Do not call the parser directly, call
 * {@link ParseUPSChainBuilder#parse(InputStream)}</i></b>
 * 
 * @author ottoabreu
 * 
 */
@UPSParser(priority = UPSParser.HIGH_PRIORITY)
public class ParseEmersonUPS extends ParseUPSDom {
	// root element
	private static final String ROOT_ELEMENT = "PK-C1-UPS";

	private static final String NUM_POSITION_ELEMENT = "NUMPUESTO";

	private static final String IP_ELEMENT = "IP_UPS";

	private static final String FIRMWARE_ELEMENT = "FIRMWARE_UPS";

	private static final String UPS_STATUS_ELEMENT = "ESTADO_UPS";

	private static final String CHARGE_PERCENTAGE_ELEMENT = "PORCENTAJE_CARGA_UPS";

	private static final String EXPENSE_PERCENTAGE_ELEMENT = "PORCENTAJE_GASTO_UPS";

	private static final String ALARMS_ELEMENT = "ALARMAS_UPS";

	private static final String NAME_ELEMENT = "NOMBRE_UPS";

	private static final String MODEL_ELEMENT = "MODELO_UPS";

	private static final String SERIES_NUMBER_ELEMENT = "NUM_SERIE_UPS";

	private static final String RUNNING_TIME_ELEMENT = "TIEMPO_ENCENDIDO_UPS";

	private static final String AUTONOMY_ELEMENT = "AUTONOMIA_UPS";

	private static final String AUD_FMO_ELEMENT = "AUD_FMO_UPS";

	private static final String GENERAL_STATUS_ELEMENT = "STATUS";

	private static final String LAST_EXECUTION_ELEMENT = "FECHA_ULTIMA_EJECUCION";

	// DATE FORMATS PRESENT IN THE XML
	private static final String AUD_FMO_ELEMENT_DATE_FORMAT = "dd/MM/yyyy";

	private static final String LAST_EXECUTION_ELEMENT_DATE_FORMAT = "dd/MM/yyyy";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ncr.ATMMonitoring.parser.ParseUPSXML#applyParser(java.io.InputStream)
	 */
	@Override
	protected UPSInfo applyParser() throws ParserException,
			XMLNotReadableException, NoParserFoundException {

		UPSInfo info = null;

		try {
			info = new UPSInfo();

			NodeList content = this.getRootElement().getChildNodes();

			for (int i = 0; i < content.getLength(); i++) {

				Node nNode = content.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					String elementValue = eElement.getTextContent();
					if (eElement.getNodeName().equalsIgnoreCase(
							NUM_POSITION_ELEMENT)) {

						info.setNumPosition(elementValue);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							IP_ELEMENT)) {

						info.setIp(elementValue);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							FIRMWARE_ELEMENT)) {

						info.setFirmware(elementValue);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							UPS_STATUS_ELEMENT)) {

						info.setRunningStatus(elementValue);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							CHARGE_PERCENTAGE_ELEMENT)) {

						float chargePercentage = Float.parseFloat(elementValue);
						info.setChargePercentage(chargePercentage);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							EXPENSE_PERCENTAGE_ELEMENT)) {

						float expensePercentage = Float
								.parseFloat(elementValue);
						info.setExpensePercentage(expensePercentage);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							ALARMS_ELEMENT)) {

						info.setAlarmMsg(elementValue);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							NAME_ELEMENT)) {

						info.setUpsType(elementValue);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							MODEL_ELEMENT)) {

						info.setUpsModel(elementValue);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							SERIES_NUMBER_ELEMENT)) {

						info.setSeriesNumber(elementValue);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							RUNNING_TIME_ELEMENT)) {

						long runningTime = this.parseTime(elementValue);
						info.setRunningTimeMilisec(runningTime);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							AUTONOMY_ELEMENT)) {

						long autonomy = this.parseTime(elementValue);

						info.setAutonomyMilisec(autonomy);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							AUD_FMO_ELEMENT)) {

						Date audFmo = this.parseDate(elementValue,
								AUD_FMO_ELEMENT_DATE_FORMAT);
						info.setAudFmo(audFmo);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							GENERAL_STATUS_ELEMENT)) {

						info.setGeneralStatusMsg(elementValue);

					} else if (eElement.getNodeName().equalsIgnoreCase(
							LAST_EXECUTION_ELEMENT)) {

						Date lastExcecutionDate = this.parseDate(elementValue,
								LAST_EXECUTION_ELEMENT_DATE_FORMAT);
						info.setLastExecutionDate(lastExcecutionDate);
					}

				}
			}

			String xml = this.getStringFromDoc();
			info.setOriginalXML(xml);
			logger.debug("Parsed xml: " + info);
		} catch (ParseException e) {
			throw new XMLNotReadableException(
					XMLNotReadableException.PARSE_ELEMENT_ERROR, e);
		} catch (DOMException e) {
			throw new XMLNotReadableException(
					XMLNotReadableException.PARSE_ELEMENT_ERROR, e);
		} catch (Exception e) {
			throw new ParserException(ParserException.GENERAL_ERROR, e);
		}

		return info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ncr.ATMMonitoring.parser.ParseUPSXML#canParseXML()
	 */
	@Override
	protected boolean canParseXML() throws ParserException,
			XMLNotReadableException {
		boolean willParse = false;
		if (this.getRootElement() != null
				&& this.getRootElement().getNodeName()
						.equalsIgnoreCase(ROOT_ELEMENT)) {
			willParse = true;
			logger.debug("Root element:" + this.getRootElement());
		} 

		return willParse;
	}

	/**
	 * Return the time in long from the String \d* Dias \d* Hor. \d*Min.<br>
	 * Can return 0 if the given String does not have the proper structure or is
	 * blank
	 * 
	 * @param runingTime
	 *            String
	 * @return Long
	 */
	private long parseTime(String runingTime) {

		String regexDays = "^[0-9]* D|d[1]";
		String regexHours = "[0-9]* (H|h[1])or\\.";
		String regexMin = "[0-9]* (M|m[1])in\\.";

		long totalTime = 0;
		Pattern pat = Pattern.compile(regexDays);
		Matcher matcher = pat.matcher(runingTime);

		if (matcher.find()) {
			String days = matcher.group();
			totalTime += this.daysToMilisec(this.getOnlyNumbers(days));

		}

		pat = Pattern.compile(regexHours);
		matcher = pat.matcher(runingTime);

		if (matcher.find()) {
			String hours = matcher.group();
			totalTime += this.hoursToMilisec(this.getOnlyNumbers(hours));

		}

		pat = Pattern.compile(regexMin);
		matcher = pat.matcher(runingTime);

		if (matcher.find()) {
			String min = matcher.group();
			totalTime += this.minToMilisec(this.getOnlyNumbers(min));

		}

		return totalTime;

	}

	/**
	 * transform days to miliseconds
	 * 
	 * @param daysString
	 *            String
	 * @return Long
	 */
	private long daysToMilisec(String daysString) {
		int days = Integer.parseInt(daysString);
		return TimeUnit.MILLISECONDS.convert(days, TimeUnit.DAYS);
	}

	/**
	 * Transforms hours to miliseconds
	 * 
	 * @param hoursString
	 *            String
	 * @return Long
	 */
	private long hoursToMilisec(String hoursString) {
		int hours = Integer.parseInt(hoursString);
		return TimeUnit.MILLISECONDS.convert(hours, TimeUnit.HOURS);
	}

	/**
	 * transform minutes in miliseconds
	 * 
	 * @param minutesString
	 * @return
	 */
	private long minToMilisec(String minutesString) {
		int minutes = Integer.parseInt(minutesString);
		return TimeUnit.MILLISECONDS.convert(minutes, TimeUnit.MINUTES);
	}

	/**
	 * Returns only numbers from a string
	 * 
	 * @param from
	 * @return String
	 */
	private String getOnlyNumbers(String from) {

		String onlyNumbers = "^[0-9]*";
		Pattern pat = Pattern.compile(onlyNumbers);
		Matcher matcher = pat.matcher(from);
		matcher.find();
		String numbers = matcher.group();

		return numbers;

	}

	/**
	 * Returns a date from a string using the given format
	 * 
	 * @param value
	 *            String
	 * @param format
	 *            String
	 * @return Date
	 * @throws ParseException
	 *             if the value does not match the format
	 */
	private Date parseDate(String value, String format) throws ParseException {

		Date parseDate = null;
		if (value != null && !value.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);

			parseDate = sdf.parse(value);

		}
		return parseDate;
	}

}
