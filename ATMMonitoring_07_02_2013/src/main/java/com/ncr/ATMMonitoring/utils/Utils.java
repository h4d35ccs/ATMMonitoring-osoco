package com.ncr.ATMMonitoring.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public abstract class Utils {

    public static String concatStrings(List<String> strings, char separator) {
		String result = "", separatorString = String.valueOf(separator);
		Iterator<String> iter = strings.iterator();
		if (iter.hasNext()) {
		    result += iter.next().replace(separatorString,
			    "/" + separatorString);
		    while (iter.hasNext()) {
			result += separator
				+ iter.next().replace(separatorString,
					"/" + separatorString);
		    }
		}
	return result;
    }

    public static List<String> splitStrings(String strings, char separator) {
		List<String> result = new ArrayList<String>();
		String separatorString = String.valueOf(separator);
		Iterator<String> iter = Arrays.asList(
			strings.split(String.valueOf(separator))).iterator();
		while (iter.hasNext()) {
		    result.add(iter.next().replace("/" + separatorString,
			    separatorString));
		}
		return result;
    }

    public static String concatIntegers(List<Integer> integers, char separator) {
		String result = "", separatorString = String.valueOf(separator);
		Iterator<Integer> iter = integers.iterator();
		if (iter.hasNext()) {
		    result += iter.next().toString()
			    .replace(separatorString, "/" + separatorString);
		    while (iter.hasNext()) {
			result += separator
				+ iter.next()
					.toString()
					.replace(separatorString, "/" + separatorString);
		    }
		}
		return result;
    }

    public static List<Integer> splitIntegers(String integers, char separator) {
		List<Integer> result = new ArrayList<Integer>();
		String separatorString = String.valueOf(separator);
		Iterator<String> iter = Arrays.asList(
			integers.split(String.valueOf(separator))).iterator();
		while (iter.hasNext()) {
		    result.add(Integer.decode(iter.next().replace(
			    "/" + separatorString, separatorString)));
		}
		return result;
    }
}