package com.ncr.ATMMonitoring.serverchain;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.ncr.ATMMonitoring.scheduledtask.SheduledTaskEnabler;
import com.ncr.serverchain.NodeInformation;
import com.ncr.serverchain.NodePosition;

/**
 * @author Otto Abreu
 * 
 */
@Component
public class ATMInventoryBeansAdministrator implements InitializingBean {

    @Value("${serverchain.beanstodestroy:}")
    private String beansToDestroyComaSeparatedList;

    @Value("${serverchain.taskstostop:}")
    private String tasksToStop;

    @Autowired
    private ApplicationContext springContext;

    @Autowired
    private NodeInformation nodePosition;

    private static final Logger logger = Logger
	    .getLogger(ATMInventoryBeansAdministrator.class);

    private Set<Class<?>> beansClasses = new HashSet<Class<?>>();
    private Set<Class<?>> scheduledTaskClasses = new HashSet<Class<?>>();

    private static String BASE_PACKAGE = "com.ncr.ATMMonitoring.";

    @Override
    public void afterPropertiesSet() throws Exception {
	shutdownUnnecesaryBeans();
    }

    private void shutdownUnnecesaryBeans() {

	if (haveConfiguredBeansToShutdown()) {

	    logger.info("Destroyiing not needed beans:"
		    + beansToDestroyComaSeparatedList);

	    this.getBeanClassesFromProperties();
	    this.getTaskClassesFromProperties();

	    this.killAllIndividualBeans();
	    logger.info("stoping not needed scheduled tasks:" + tasksToStop);
	    this.stopAllTask();
	    // TODO do the killAllBeansInPackage

	}
    }

    private boolean haveConfiguredBeansToShutdown() {

	if (!StringUtils.isEmpty(this.beansToDestroyComaSeparatedList)
		|| !StringUtils.isEmpty(this.tasksToStop)) {
	    
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

    private void killAllIndividualBeans() {

	for (Class<?> beanClass : this.beansClasses) {
	    killNotNeededBean(beanClass);
	}
    }

    private void stopAllTask() {

	for (Class<?> scheduledTaskClass : this.scheduledTaskClasses) {
	    stopScheduledTask(scheduledTaskClass);

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
	    logger.info("destroyed: " + beanName);
	}
    }

    private void stopScheduledTask(Class<?> scheduledTaskClass) {

	Object scheduledTask = this.getBeanFactory()
		.getBean(scheduledTaskClass);

	if (scheduledTask instanceof SheduledTaskEnabler) {
	    SheduledTaskEnabler sheduledTaskEnabler = (SheduledTaskEnabler) scheduledTask;
	    sheduledTaskEnabler.disableTask();
	    logger.info("Task disabled: "
		    + scheduledTask.getClass().getSimpleName());
	}
    }
}
