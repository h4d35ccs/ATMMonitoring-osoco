package com.ncr.ATMMonitoring.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The Class Utils.
 * 
 * Commodity methods for several purposes.
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 */

public abstract class Utils {

    /** The Gson object. */
    private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    /**
     * Tranforms an object to its Gson json representation.
     * 
     * @param object
     *            the object
     * @return the json string
     */
    public static String toJson(Object object) {
	return gson.toJson(object);
    }

    /**
     * Concats strings with the given separator.
     * 
     * @param strings
     *            the strings
     * @param separator
     *            the separator
     * @return the concatted strings
     */
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

    /**
     * Splits strings concatted with the given separator.
     * 
     * @param strings
     *            the concatted strings
     * @param separator
     *            the separator
     * @return the list with all the split strings
     */
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

    /**
     * Concat integers into an string with the given separator.
     * 
     * @param integers
     *            the integers
     * @param separator
     *            the separator
     * @return the concatted string
     */
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

    /**
     * Split integers concatted into an string with the given separator.
     * 
     * @param integers
     *            the integers
     * @param separator
     *            the separator
     * @return the list with all the split integers
     */
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

    /**
     * Unescape special characters in a json chain.
     * 
     * @param chain
     *            the json chain
     * @return the unescaped chain
     */
    public static String unescapeJsonChain(String chain) {
	return chain.replaceAll("\\\\\\\\", "@@@@")
		.replaceAll("\\\\u003c", "<").replaceAll("\\\\u003d", "=")
		.replaceAll("\\\\u003e", ">").replaceAll("\\\\u0026", "&")
		.replaceAll("\\\\\\\"", "\"")
		.replaceAll("@@@@", Matcher.quoteReplacement("\\"));
    }

    /**
     * Gets the MD5 hex from the given string.
     * 
     * @param content
     *            the string
     * @return the MD5 hex
     */
    public static String getMD5Hex(String content) {
	return DigestUtils.md5Hex(content);
    }
}