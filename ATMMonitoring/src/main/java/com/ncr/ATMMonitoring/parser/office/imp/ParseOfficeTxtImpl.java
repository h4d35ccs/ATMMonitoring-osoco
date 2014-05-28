package com.ncr.ATMMonitoring.parser.office.imp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.office.ParseOfficeChainBuilder;
import com.ncr.ATMMonitoring.parser.office.ParseOfficeTxt;
import com.ncr.ATMMonitoring.parser.office.annotation.OfficeParser;
import com.ncr.ATMMonitoring.parser.office.dto.OfficeInfo;

/**
 * Class that parses an offices txt.
 * 
 * <b><i>Do not call the parser directly, call
 * {@link ParseOfficeChainBuilder#parse(InputStream)}</i></b>
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * 
 */
@OfficeParser(priority = OfficeParser.HIGH_PRIORITY)
public class ParseOfficeTxtImpl extends ParseOfficeTxt {

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.parser.office.ParseOfficeTxt#canParseTxt()
     */
    @Override
    protected boolean canParseTxt() throws ParserException,
	    FileNotReadableException {
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ncr.ATMMonitoring.parser.office.ParseOfficeTxt#applyParser()
     */
    @Override
    protected Collection<OfficeInfo> applyParser() throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		getTxtFile()));
	String line;
	Collection<OfficeInfo> offices = new HashSet<OfficeInfo>();
	OfficeInfo office;
	while ((line = reader.readLine()) != null) {
	    office = parseLine(line);
	    if (office != null) {
		offices.add(office);
	    }
	}
	reader.close();
	return offices;
    }

    /**
     * Method that parses one line from the offices file and returns an
     * {@link OfficeInfo} with its data.
     * 
     * @param line
     *            the offices txt file line
     * @return an {@link OfficeInfo} with the data
     */
    private OfficeInfo parseLine(String line) {
	if (line.length() >= 142) {
	    OfficeInfo office = new OfficeInfo();
	    office.setCode(line.substring(0, 12).trim());
	    office.setCountry(line.substring(0, 2).trim());
	    line = line.substring(12);
	    office.setName(line.substring(0, 40).trim());
	    line = line.substring(40);
	    office.setAddress(line.substring(0, 36).trim());
	    line = line.substring(36);
	    office.setPostcode(line.substring(0, 5).trim());
	    line = line.substring(5);
	    line = line.substring(9);
	    office.setPostcode(line.substring(0, 40).trim());
	    line = line.substring(40);
	    return office;
	}
	return null;
    }

}
