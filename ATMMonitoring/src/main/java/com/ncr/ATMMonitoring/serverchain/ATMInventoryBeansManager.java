package com.ncr.ATMMonitoring.serverchain;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ncr.ATMMonitoring.scheduledtask.SheduledTaskEnabler;
import com.ncr.serverchain.NodeInformation;

/**
 * Class that kill all the non needed resources.
 * 
 * If a class can not be kill, the process will not stop the deployment of the
 * app
 * 
 * @author Otto Abreu
 * 
 */
@Component
public class ATMInventoryBeansManager implements InitializingBean {

    @Value("${serverchain.beanstodestroy:}")
    private String beansToDestroyComaSeparatedList;

    @Value("${serverchain.taskstostop:}")
    private String tasksToStop;

    @Value("${serverchain.packagestodestroy:}")
    private String packagestodestroy;

    @Value("${serverchain.resourcesbeanstodestroy:}")
    private String resourcesBeansTodestroy;

    @Autowired
    private ApplicationContext springContext;

    @Autowired
    private NodeInformation nodePosition;

    private static final Logger logger = Logger
	    .getLogger(ATMInventoryBeansManager.class);

    private Set<Class<?>> beansClasses = new HashSet<Class<?>>();
    private Set<Class<?>> scheduledTaskClasses = new HashSet<Class<?>>();
    private Set<String> packagesNamesToDestroyBeans = new HashSet<String>();
    private Set<String> resourcesBeansToDestroy = new HashSet<String>();
    private static String BASE_PACKAGE = "com.ncr.ATMMonitoring.";

    private static final Set<Class<? extends Annotation>> SPRING_ANNOTATIONS_CLASSES;

    static {
	SPRING_ANNOTATIONS_CLASSES = new HashSet<Class<? extends Annotation>>();
	SPRING_ANNOTATIONS_CLASSES.add(Component.class);
	SPRING_ANNOTATIONS_CLASSES.add(Service.class);
	SPRING_ANNOTATIONS_CLASSES.add(Controller.class);
	SPRING_ANNOTATIONS_CLASSES.add(Repository.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
	shutdownUnnecesaryBeans();
    }

    private void shutdownUnnecesaryBeans() {

	if (haveConfiguredBeansToShutdown()) {
	    this.getBeanClassesFromProperties();
	    this.getTaskClassesFromProperties();
	    this.getPackagesToDestroyBeans();
	    this.getResourcesBeansToDestroy();

	    logger.debug("Destroying  not needed resources  beans: "
		    + this.resourcesBeansToDestroy);
	    this.killResourcesBeans();

	    logger.debug("Destroying  not needed beans in package: "
		    + this.packagesNamesToDestroyBeans);
	    this.killClassesInPackage();
	    
	    logger.debug("Destroying not needed individual beans:"
		    + this.beansToDestroyComaSeparatedList);
	    this.killAllIndividualBeans();

	    logger.debug("stoping not needed scheduled tasks:" + tasksToStop);
	    this.stopAllTask();
	
	   logger.info("Not needed beans and resources destroyed");


	}
    }
    
  
    private boolean haveConfiguredBeansToShutdown() {

	if ((StringUtils.isNotEmpty(this.beansToDestroyComaSeparatedList))
		|| (StringUtils.isNotEmpty(this.tasksToStop))
		|| (StringUtils.isNotEmpty(this.packagestodestroy))
		|| (StringUtils.isNotEmpty(this.resourcesBeansTodestroy))) {

	    return true;

	} else {

	    return false;
	}

    }

    private void getBeanClassesFromProperties() {

	String[] classNames = this
		.separateClassNameFromProperty(this.beansToDestroyComaSeparatedList);

	if (classNames != null) {

	    this.addEachClassFoundToSet(classNames, this.beansClasses);
	}

    }

    private void getTaskClassesFromProperties() {

	String[] classNames = this
		.separateClassNameFromProperty(this.tasksToStop);

	if (classNames != null) {

	    this.addEachClassFoundToSet(classNames, this.scheduledTaskClasses);
	}

    }

    private void getPackagesToDestroyBeans() {
	String[] packageNames = this
		.separateClassNameFromProperty(this.packagestodestroy);

	if (packageNames != null) {
	    this.addEachPackageFoundToSet(packageNames);
	}

    }

    private void addEachPackageFoundToSet(String[] packagesNames) {

	for (String packageName : packagesNames) {
	    String completePackageName = BASE_PACKAGE + packageName;
	    this.packagesNamesToDestroyBeans.add(completePackageName);
	}
    }

    private void getResourcesBeansToDestroy() {
	String[] resourcesName = this
		.separateClassNameFromProperty(this.resourcesBeansTodestroy);
	if (resourcesName != null) {
	    this.addAllResourcesNamesToSet(resourcesName);

	}
    }

    private void addAllResourcesNamesToSet(String[] resourcesName) {
	for (String resoruce : resourcesName) {
	    this.resourcesBeansToDestroy.add(resoruce);
	}
    }

    private void killAllIndividualBeans() {

	for (Class<?> beanClass : this.beansClasses) {
	    killSingleBean(beanClass);
	}
    }

    private void killSingleBean(Class<?> beanClass) {
	try {
	    killBeanClass(beanClass);
	} catch (Exception e) {
	    logger.warn("Can not kill bean: " + beanClass + " due :"
		    + e.getMessage());
	}
    }

    private void stopAllTask() {

	for (Class<?> scheduledTaskClass : this.scheduledTaskClasses) {
	    stopTask(scheduledTaskClass);

	}
    }

    private void stopTask(Class<?> scheduledTaskClass) {
	try {
	    stopScheduledTask(scheduledTaskClass);
	} catch (Exception e) {
	    logger.warn("can not stop task: " + scheduledTaskClass + " due: "
		    + e.getMessage());
	}
    }

    private void stopScheduledTask(Class<?> scheduledTaskClass) {

	Object scheduledTask = this.getBeanFactory()
		.getBean(scheduledTaskClass);

	if (scheduledTask instanceof SheduledTaskEnabler) {
	    SheduledTaskEnabler sheduledTaskEnabler = (SheduledTaskEnabler) scheduledTask;
	    sheduledTaskEnabler.disableTask();
	    logger.debug("Task disabled: "
		    + scheduledTask.getClass().getSimpleName());
	}
    }

    private String[] separateClassNameFromProperty(String comaSeparatedClasses) {
	String[] classNames = null;

	if (StringUtils.isNotEmpty(comaSeparatedClasses)) {

	    classNames = comaSeparatedClasses.split(",");
	}
	return classNames;
    }

    private void addEachClassFoundToSet(String[] classNames,
	    Set<Class<?>> classSet) {

	for (String className : classNames) {

	    Class<?> classObj = this.getClassFromName(className);

	    if (classObj != null) {
		classSet.add(classObj);
	    }
	}
    }

    private Class<?> getClassFromName(String classname) {
	Class<?> classObj = null;

	try {

	    classObj = this.getClassObjectFromName(classname);

	} catch (ClassNotFoundException e) {

	    logger.warn("Can not destroy bean:" + classname
		    + " because the corresponding class was not found");
	}

	return classObj;
    }

    private Class<?> getClassObjectFromName(String classname)
	    throws ClassNotFoundException {

	Class<?> classObject = this.getClass().getClassLoader()
		.loadClass(BASE_PACKAGE + classname);

	return classObject;
    }

    private void killBeanClass(Class<?> beanClass) {
	try {
	    killNotNeededBean(beanClass);
	} catch (Exception e) {
	    logger.warn("Can not kill bean class: " + beanClass + " due: "
		    + e.getMessage());
	}
    }

    private void killNotNeededBean(Class<?> beanClass) {

	Map<String, ?> beansAndInstances = this.getBeansAndInstances(beanClass);

	Set<String> allBeansNamesAsociatedToClass = this
		.getBeansName(beansAndInstances);

	DefaultListableBeanFactory beanFactory = this.getBeanFactory();

	this.destroyEachBean(allBeansNamesAsociatedToClass, beansAndInstances,
		beanFactory);

    }

    private Map<String, ?> getBeansAndInstances(Class<?> beanClass) {
	return this.springContext.getBeansOfType(beanClass);
    }

    private Set<String> getBeansName(Map<String, ?> beansAndInstances) {
	return beansAndInstances.keySet();

    }

    private DefaultListableBeanFactory getBeanFactory() {

	BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) springContext
		.getAutowireCapableBeanFactory();
	return ((DefaultListableBeanFactory) beanFactory);

    }

    private void destroyEachBean(Set<String> allBeansNamesAsociatedToClass,
	    Map<String, ?> beansAndInstances,
	    DefaultListableBeanFactory beanFactory) {

	for (String beanName : allBeansNamesAsociatedToClass) {
	    logger.debug("destroying: " + beanName);
	    Object beanInstance = beansAndInstances.get(beanName);
	    beanFactory.destroyBean(beanName, beanInstance);
	    logger.debug("destroyed: " + beanName);
	}
    }

    private void killClassesInPackage() {

	Set<Class<?>> allBeansToDestroy = this.getAllBeansToDestroy();

	for (Class<?> beanToDestroy : allBeansToDestroy) {
	    logger.debug("Killing bean: " + beanToDestroy);
	    this.killBeanClass(beanToDestroy);
	}

    }

    private void killResourcesBeans() {
	for (String resourceId : this.resourcesBeansToDestroy) {
	    DefaultListableBeanFactory beanFactory = this.getBeanFactory();
	    beanFactory.destroySingleton(resourceId);
	    logger.debug("destroyed resource: " + resourceId);
	}
    }

    private Set<Class<?>> getAllBeansToDestroy() {

	Set<Class<?>> allBeansToDestroy = new HashSet<Class<?>>();
	for (String fullPackageName : this.packagesNamesToDestroyBeans) {

	    allBeansToDestroy.addAll(this
		    .getAllBeansFromAPackage(fullPackageName));
	}
	logger.debug("beansToDestroy:" + allBeansToDestroy);
	return allBeansToDestroy;
    }

    private Set<Class<?>> getAllBeansFromAPackage(String packageName) {

	Set<Class<?>> beansToDestroy = new HashSet<Class<?>>();
	this.addAllAnnotatedBeansToSet(beansToDestroy, packageName);
	return beansToDestroy;
    }

    private Set<Class<?>> addAllAnnotatedBeansToSet(
	    Set<Class<?>> beansToDestroy, String packageName) {
	Reflections reflections = new Reflections(packageName);
	for (Class<? extends Annotation> springAnnotationClass : SPRING_ANNOTATIONS_CLASSES) {

	    beansToDestroy.addAll(reflections.getTypesAnnotatedWith(
		    springAnnotationClass, true));
	}

	return beansToDestroy;
    }
}
