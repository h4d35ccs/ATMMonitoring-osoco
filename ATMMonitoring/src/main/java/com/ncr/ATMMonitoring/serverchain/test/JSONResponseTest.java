/**
 * 
 */
package com.ncr.ATMMonitoring.serverchain.test;

import java.io.File;
import java.io.IOException;

/**
 * @author Otto Abreu
 *
 */
public class JSONResponseTest {
    
   private static final String OS_PATH_TO_JSON_FOLDER ="/home/oa250047/git/";
    
   private static final String JSON_FILE_PATH = OS_PATH_TO_JSON_FOLDER+"ATMMonitoring-osoco/jsonsExamples/españa/dataDiebold.json";
    
    public static final String getJSONTest(){
	File jsonFile = new File(JSON_FILE_PATH);
	
	String json = "";
	
	try {
	    
	    json = org.apache.commons.io.FileUtils.readFileToString(jsonFile);
	
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	return json;
	
    }
    
}
