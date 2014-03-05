/**
 * 
 */
package com.ncr.ATMMonitoring.parser.ups;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import com.ncr.ATMMonitoring.parser.ups.annotation.UPSParser;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;
import com.ncr.ATMMonitoring.parser.ups.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.ups.exception.ParserException;
import com.ncr.ATMMonitoring.parser.ups.exception.XMLNotReadableException;

/**
 * Class that builds and executes the chain of responsibility of UPS Parsers <BR>
 * Is possible to add  parsers just adding classes to the classpath, all the
 * classes that extends from {@link ParseUPSXML} and are annotated with
 * {@link UPSParser} will be added automatically<br>
 * The new classes can be added in jar format, is only required that all the new
 * classes are in the classpath.<br>
 * To prioritize some classes in the chain use the annotation {@link UPSParser} with the value
 * {@link UPSParser#HIGH_PRIORITY} as follows<br>
 * @UPSParser(priority = UPSParser.HIGH_PRIORITY)<br>
 * public class MyParserClass extends ParseUPSXML {<br>
 * }<br>
 * 
 * To start the chain just call the method
 * {@link ParseUPSChainBuilder#parse(InputStream)},
 * 
 * @author ottoabreu
 * 
 */
public class ParseUPSChainBuilder {

	// logger
	protected static final Logger logger = Logger
			.getLogger(ParseUPSChainBuilder.class);

	// holds the classes
	private static final List<Class<? extends ParseUPSXML>> PARSERS_CLASSES;
	// holds the instances
	private final static List<ParseUPSXML> PARSERS_INSTANCES;
	// package where the new parsers class must be
	// private static final String OTHER_PARSERS_PACKAGE =
	// "com.ncr.ATMMonitoring.parser.otherParser";

	static {
		// load all the classes
		List<Class<? extends ParseUPSXML>> unorganizedClasses = ParseUPSChainBuilder
				.findParsersClasses();
		PARSERS_CLASSES = ParseUPSChainBuilder
				.organizeClassesByPriority(unorganizedClasses);
		PARSERS_INSTANCES = new ArrayList<ParseUPSXML>();

		logger.debug("All found parsers: " + PARSERS_CLASSES);
	}

	/**
	 * Extract the information from the given xml in InputStream format
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
	public static UPSInfo parse(InputStream xmlFile) throws ParserException,
			XMLNotReadableException, NoParserFoundException {
		ParseUPSXML firstLink = ParseUPSChainBuilder.getParser();
		return firstLink.parseXML(xmlFile);
	}

	/**
	 * Returns a new instance of the class
	 * 
	 * @return ParseUPSChainBuilder
	 */
	public static ParseUPSChainBuilder getInstance() {
		return new ParseUPSChainBuilder();
	}

	/**
	 * Reads the package <b>com.ncr.ATMMonitoring.parse.otherParsers</B> to add
	 * new parsers to the chain
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static List<Class<? extends ParseUPSXML>> findParsersClasses() {
	
		// gets the classpath 
		Collection<URL> classpathUrls = ClasspathHelper
				.forClassLoader(ParseUPSChainBuilder.class.getClassLoader());
		classpathUrls.addAll(ClasspathHelper
				.forClassLoader(ParseUPSChainBuilder.class.getClassLoader().getParent()));
		
		logger.debug("all the classpath: "+classpathUrls);
		
		Reflections reflections = new Reflections(
				new ConfigurationBuilder().setUrls(classpathUrls));
		
		Set<Class<? extends Object>> subTypes = reflections
				.getTypesAnnotatedWith(UPSParser.class);
		logger.debug("all the classes: "+subTypes);
		
		@SuppressWarnings("unchecked")
		List<Class<? extends ParseUPSXML>> parsersClass = (List<Class<? extends ParseUPSXML>>) CollectionUtils
				.select(subTypes, new Predicate() {
					// only loads concrete classes that extends from ParseUPSXML
					@Override
					public boolean evaluate(Object parser) {
						boolean isParseUPSXML = false;
						Class<? extends Object> parserClass = (Class<? extends Object>) parser;

						if (!Modifier.isAbstract(parserClass.getModifiers())
								&& !Modifier.isInterface(parserClass
										.getModifiers())) {

							if (ParseUPSXML.class.isAssignableFrom(parserClass)) {
								isParseUPSXML = true;
							} else {
								logger.warn("the class "
										+ parserClass
										+ " is not an instance of ParseUPSXML and will be not included");
							}
						}

						return isParseUPSXML;
					}

				});
		logger.debug(" Added parsers: " + parsersClass);
		return parsersClass;
	}

	/**
	 * Execute the {@link Class#newInstance()} in each class element to generate
	 * a new instance, then add it into the Parser Instance list<br>
	 * If the object can not be instantiated will do nothing
	 */
	private static void createInstances() {
		// make sure that always generate a new instance
		PARSERS_INSTANCES.clear();

		for (int i = 0; i < PARSERS_CLASSES.size(); i++) {

			Class<? extends ParseUPSXML> parserClass = (Class<? extends ParseUPSXML>) PARSERS_CLASSES
					.get(i);

			ParseUPSXML instance = null;
			try {

				instance = parserClass.newInstance();
				PARSERS_INSTANCES
						.add((com.ncr.ATMMonitoring.parser.ups.ParseUPSXML) instance);

			} catch (InstantiationException e) {
				logger.warn("Can not instantiate the given parser: "
						+ parserClass + "  and will not be added to the chain",
						e);
				;
			} catch (IllegalAccessException e) {
				logger.warn(
						"Can not instantiate the given parser: "
								+ parserClass
								+ "  because represents an abstract class, an interface, an array class, a primitive type, or void; or if the class has no nullary constructor; ",
						e);
			} catch (Throwable t) {
				logger.warn("Can not instantiate the given parser: "
						+ parserClass + " due  " + t.getMessage()
						+ "  and will not be added to the chain", t);
			}

		}

	}

	/**
	 * Builds the chain. Iterates over the list of instances and add the next
	 * parser to each parser
	 */
	private static void buildChain() {

		// only iterate to the i-1 element of the list because the last does not
		// need a next parser
		for (int i = 0; i < (PARSERS_INSTANCES.size() - 1); i++) {

			ParseUPSXML instance = PARSERS_INSTANCES.get(i);

			ParseUPSXML nextInstance = PARSERS_INSTANCES.get(i + 1);
			instance.setNextParser(nextInstance);

		}

	}

	/**
	 * Returns the first link in the chain
	 * 
	 * @return ParseUPSXML
	 * @throws NoParserFoundException
	 *             if no parsers were found
	 */
	private static ParseUPSXML getParser() throws NoParserFoundException {
		//always get new instances
		ParseUPSChainBuilder.createInstances();

		if (!PARSERS_INSTANCES.isEmpty()) {
			// create the chain adding the next parser to each instance
			ParseUPSChainBuilder.buildChain();
			return PARSERS_INSTANCES.get(0);
		} else {
			throw new NoParserFoundException(
					NoParserFoundException.NO_PARSERS_FOUND);
		}

	}

	/**
	 * Private constructor
	 */
	private ParseUPSChainBuilder() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static List<Class<? extends ParseUPSXML>> organizeClassesByPriority(
			List<Class<? extends ParseUPSXML>> unorganizedClasses) {

		// holds all the classes marked as high priority
		List<Class<? extends ParseUPSXML>> organized = new ArrayList<Class<? extends ParseUPSXML>>();
		// holds all the classes marked with default priority
		// is final because i want to used it inside an Anonymous class
		final List<Class<? extends ParseUPSXML>> normalPriority = new ArrayList<Class<? extends ParseUPSXML>>();
		// i separate the high from the defautl
		List<Class<? extends ParseUPSXML>> highPriority = (List<Class<? extends ParseUPSXML>>) CollectionUtils
				.select(unorganizedClasses, new Predicate() {

					@Override
					public boolean evaluate(Object classObject) {
						boolean isHighPriority = false;
						Class<? extends ParseUPSXML> parseClass = (Class<? extends ParseUPSXML>) classObject;
						UPSParser annotation = parseClass
								.getAnnotation(UPSParser.class);
						if (annotation.priority()) {
							// is high so CollectionUtil will put it into a new
							// List
							isHighPriority = true;
						} else {
							// is a default, so i added here because the list is
							// final and i avoid another loop
							normalPriority.add(parseClass);
						}

						return isHighPriority;
					}

				});
		// i add first those mark as high priority, then the rest
		organized.addAll(highPriority);
		logger.debug("high priority parsers:" + highPriority);
		organized.addAll(normalPriority);
		logger.debug("default priority parsers:" + normalPriority);
		return organized;
	}

}
