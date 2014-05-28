package com.ncr.ATMMonitoring.parser.office;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.reflections.Reflections;

import com.ncr.ATMMonitoring.parser.exception.FileNotReadableException;
import com.ncr.ATMMonitoring.parser.exception.NoParserFoundException;
import com.ncr.ATMMonitoring.parser.exception.ParserException;
import com.ncr.ATMMonitoring.parser.office.annotation.OfficeParser;
import com.ncr.ATMMonitoring.parser.office.dto.OfficeInfo;
import com.ncr.ATMMonitoring.parser.ups.dto.UPSInfo;

/**
 * Class that builds and executes the chain of responsibility of office
 * (location) Parsers <BR>
 * It's possible to add parsers just by adding classes to the classpath which
 * extend from {@link ParseOfficeTxt} and are annotated with
 * {@link OfficeParser}<br>
 * The new classes can be added in jar format as well, as long as they are in
 * the classpath.<br>
 * To prioritize some classes in the chain use the annotation
 * {@link OfficeParser} with the value {@link OfficeParser#HIGH_PRIORITY} as
 * follows<br>
 * 
 * @UPSParser(priority = OfficeParser.HIGH_PRIORITY)<br>
 *                     public class MyParserClass extends ParseOfficeTxt {<br>
 *                     }<br>
 * 
 *                     To start the chain just call the method
 *                     {@link ParseOfficeChainBuilder#parse(InputStream)},
 * 
 * @author Jorge López Fernández (lopez.fernandez.jorge@gmail.com)
 * @author Otto Abreu
 * 
 */
public class ParseOfficeChainBuilder {

    /** The logger. */
    protected static final Logger logger = Logger
	    .getLogger(ParseOfficeChainBuilder.class);

    /** List with all the possible parser classes. */
    private static final List<Class<? extends ParseOfficeTxt>> PARSERS_CLASSES;

    /** List with all the possible parser instances. */
    private final static List<ParseOfficeTxt> PARSERS_INSTANCES;

    static {
	// load all the classes
	List<Class<? extends ParseOfficeTxt>> unorganizedClasses = ParseOfficeChainBuilder
		.findParsersClasses();
	PARSERS_CLASSES = ParseOfficeChainBuilder
		.organizeClassesByPriority(unorganizedClasses);
	PARSERS_INSTANCES = new ArrayList<ParseOfficeTxt>();

	logger.debug("All found parsers: " + PARSERS_CLASSES);
    }

    /**
     * Extract the information from the given txt in InputStream format
     * 
     * @param txtFile
     *            {@link InputStream}
     * @return {@link UPSInfo}
     * @throws ParserException
     *             if occurs a general error
     * @throws FileNotReadableException
     *             if can not read the txt
     * 
     * 
     * @throws NoParserFoundException
     *             if the end of the chain is reached an no suitable parser was
     *             found to the given txt
     */
    public static Collection<OfficeInfo> parse(InputStream txtFile)
	    throws ParserException, FileNotReadableException,
	    NoParserFoundException {
	ParseOfficeTxt firstLink = ParseOfficeChainBuilder.getParser();
	return firstLink.parseTxt(txtFile);
    }

    /**
     * Returns a new instance of the class
     * 
     * @return ParseUPSChainBuilder
     */
    public static ParseOfficeChainBuilder getInstance() {
	return new ParseOfficeChainBuilder();
    }

    /**
     * Reads the package <b>com.ncr.ATMMonitoring.parse.otherParsers</B> to add
     * new parsers to the chain
     * 
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static List<Class<? extends ParseOfficeTxt>> findParsersClasses() {

	Reflections reflections = new Reflections("");

	Set<Class<? extends Object>> subTypes = reflections
		.getTypesAnnotatedWith(OfficeParser.class);
	logger.debug("all the classes: " + subTypes);

	@SuppressWarnings("unchecked")
	List<Class<? extends ParseOfficeTxt>> parsersClass = (List<Class<? extends ParseOfficeTxt>>) CollectionUtils
		.select(subTypes, new Predicate() {
		    // only loads concrete classes that extends from ParseUPSXML
		    @Override
		    public boolean evaluate(Object parser) {
			boolean isParseUPSXML = false;
			Class<? extends Object> parserClass = (Class<? extends Object>) parser;

			if (!Modifier.isAbstract(parserClass.getModifiers())
				&& !Modifier.isInterface(parserClass
					.getModifiers())) {

			    if (ParseOfficeTxt.class
				    .isAssignableFrom(parserClass)) {
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
	logger.debug("Added parsers: " + parsersClass);
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

	    Class<? extends ParseOfficeTxt> parserClass = (Class<? extends ParseOfficeTxt>) PARSERS_CLASSES
		    .get(i);

	    ParseOfficeTxt instance = null;
	    try {

		instance = parserClass.newInstance();
		PARSERS_INSTANCES
			.add((com.ncr.ATMMonitoring.parser.office.ParseOfficeTxt) instance);

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

	    ParseOfficeTxt instance = PARSERS_INSTANCES.get(i);

	    ParseOfficeTxt nextInstance = PARSERS_INSTANCES.get(i + 1);
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
    private static ParseOfficeTxt getParser() throws NoParserFoundException {
	// always get new instances
	ParseOfficeChainBuilder.createInstances();

	if (!PARSERS_INSTANCES.isEmpty()) {
	    // create the chain adding the next parser to each instance
	    ParseOfficeChainBuilder.buildChain();
	    return PARSERS_INSTANCES.get(0);
	} else {
	    throw new NoParserFoundException(
		    NoParserFoundException.NO_PARSERS_FOUND);
	}

    }

    /**
     * Private constructor
     */
    private ParseOfficeChainBuilder() {
	super();
    }

    /**
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    private static List<Class<? extends ParseOfficeTxt>> organizeClassesByPriority(
	    List<Class<? extends ParseOfficeTxt>> unorganizedClasses) {

	// holds all the classes marked as high priority
	List<Class<? extends ParseOfficeTxt>> organized = new ArrayList<Class<? extends ParseOfficeTxt>>();
	// holds all the classes marked with default priority
	// is final because i want to used it inside an Anonymous class
	final List<Class<? extends ParseOfficeTxt>> normalPriority = new ArrayList<Class<? extends ParseOfficeTxt>>();
	// i separate the high from the defautl
	List<Class<? extends ParseOfficeTxt>> highPriority = (List<Class<? extends ParseOfficeTxt>>) CollectionUtils
		.select(unorganizedClasses, new Predicate() {

		    @Override
		    public boolean evaluate(Object classObject) {
			boolean isHighPriority = false;
			Class<? extends ParseOfficeTxt> parseClass = (Class<? extends ParseOfficeTxt>) classObject;
			OfficeParser annotation = parseClass
				.getAnnotation(OfficeParser.class);
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
	// i add first those marked as high priority, then the rest
	organized.addAll(highPriority);
	logger.debug("high priority parsers:" + highPriority);
	organized.addAll(normalPriority);
	logger.debug("default priority parsers:" + normalPriority);
	return organized;
    }

}
