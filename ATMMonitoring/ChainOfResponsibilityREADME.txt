Chain of responsibility Configuration and Usage
=================================================

By: Otto Abreu NCR 2014

-------------------------------------------------------------------
Requirements
------------------------------------------------------------------
* JVM 1.7 or higher
* serverchain-0.0.1-SNAPSHOT.jar (contains the core of the chain)

It is important to say that the chain is using an embedded Apache Active MQ
JMS broker, in order to understand how this broker works go to:
http://activemq.apache.org/ or search for the book Active MQ in Action 

http://activemq.apache.org/books.html


-------------------------------------------------------------------
How To? How this works?
-------------------------------------------------------------------
This section explains how to configure and how things works

************************************
How to configure?
************************************
In order to configure the chain in the different nodes, it is
required to add some values to the property file called: chainconfig.properties

The values of this property are:

jms.localbroker.url= specify the local ip of the node and the port where the 
JMS broker will be listening. The ip must be preceded by the protocol to use in 
the broker. Recommended tcp://
Example:
	
	jms.localbroker.url=tcp://192.168.1.21\:61618
	
	
jms.parent.outgoing.topic.url= Specify the parent node URL or address where the 
remote JMS Broker is listening. There is no need to set the protocol
Example:	
	
	jms.parent.outgoing.topic.url=153.57.97.118:61617
	
jms.broker.url.pattern=Specify the complete connection string to use in order to connect to 
the parent broker. More info in how to configure this connection string in : 
http://activemq.apache.org/failover-transport-reference.html.

IMPORTANT: if the protocol was changed in the localbroker property in the parent node, it is required
to change it here too!

Example default:
	
	jms.broker.url.pattern=failover://(tcp://{ip})?startupMaxReconnectAttempts=1&initialReconnectDelay=1

jms.(incoming).(outgoing).topic.name= Define the name of the outgoing topic name, leave this properties as it is
	
	jms.outgoing.topic.name=outgoingTopic
	jms.incoming.topic.name=incomingTopic

===========================
Specific Node Configuration
============================
There are only three kind of nodes, Root node, Middle node and Leaf node, each one of them can be configured as follows:

++++++++++++++++++++++++++++
Root Nodes
+++++++++++++++++++++++++++++
Only the local url is required

Example:

	jms.localbroker.url=tcp://153.57.97.118:61617
	jms.outgoing.topic.name=outgoingTopic
	jms.incoming.topic.name=incomingTopic
	jms.broker.url.pattern=failover://(tcp://{ip})?startupMaxReconnectAttempts=1&initialReconnectDelay=1

++++++++++++++++++++++++++++	
Middle Nodes
+++++++++++++++++++++++++++++
The local url, parent url and broker pattern is required

Example:
	
	jms.localbroker.url=tcp://153.57.97.118:61618
	jms.parent.outgoing.topic.url=153.57.97.118:61617
	jms.broker.url.pattern=failover://(tcp://{ip})?startupMaxReconnectAttempts=1&initialReconnectDelay=1
	jms.outgoing.topic.name=outgoingTopic
	jms.incoming.topic.name=incomingTopic

++++++++++++++++++++++++++++	
Leaf nodes
+++++++++++++++++++++++++++++

Same as middle node. The chain knows that is a leaf node because this node does not have any children subscription.

************************************
How to Install?
************************************
Just deploy the same war file in all the nodes and change the property file chainconfig.properties for each kind of node


***********************************
How the Message Travels?
************************************
The process start as there is no chain, the ATM information is added to the queue and it is removed by the RequestThread. In that class 
If the root node is not the only node (have some child nodes subscribed) will call the chain, otherwise will execute the logic as no chain was present.

The message will go from one node to another, using the router table until it reaches the leaf. There is added to the queue and process by the RequestThread 


************************************
How the Message Strategies Works?
************************************
Each Specific Message is related to a Single Strategy, to link a message to a Strategy just add the annotation as follows:

@StrategyMapper(strategyMapping = Strategy.class)

Each message represent the information and is a simple POJO, the strategy is the class that process each message when it arrives to a node.

To ensure that the logic in a strategy will be executed, the method canProcessSpecificMessage have to return true and then the method processSpecificMessage will be called,
In the end, the method broadcastDirection will be called ( even if the canProcessSpecificMessage is false) in order to know what to do with the message.

The posible directions are: 
	* NONE
	* ONE_WAY: The message goes to the next ( previous) node
	* TWO_WAY: The message goes to both next and previous node
	* TURN_BACk: The message returns, if the original message was from Parent to Son, then a message Son to Parent will be generated. If the message was Son to Parent, a Parent to Son
	will be generated.
	
Each strategy is loaded automatically (using Reflection ) using the class in the annotation, when the message arrives.
	
This Strategies are a implementation of the Strategy Pattern ( see http://en.wikipedia.org/wiki/Strategy_pattern or see the book Design patterns 
Elements of reusable object oriented software also known as Gang of Four).


In order to add a new behaviour, simply add a new message and generate a new Strategy and thats all :)

-------------------------------------------------------------------
Child Subscription
-------------------------------------------------------------------

Each node that is not a leaf autodetects all the children nodes when they subscribes.
In order to renew the list it is required to restart the node. The reason is that each subscriber is
a Durable Subscriber in order to ensure that all the message are delivered even if the node is down.

More in Durable Subscribers here: http://activemq.apache.org/manage-durable-subscribers.html.

-------------------------------------------------------------------
Router Table
-------------------------------------------------------------------

The Router table management is made automatically, when an ATM communicate with an Leaf node, the leaf will register the 
ATM matricula in the router table and propagate the change through the whole network automatically.

There is to ways of changing the Router table in a Node, one is going to the administration page in
http://server:port/app/serverchain and in the network map, search for a leaf node and change it. (RECOMENDED)

The other way is to change it manually in all the nodes. (TRY TO NOT DO THIS).


IMPORTANT: It is required to have an empty routerTable.properties file in all nodes, there the router table will be written.

-------------------------------------------------------------------
Network Mapping
-------------------------------------------------------------------
In order to know the network status and show it in the administration page (http://server:port/app/serverchain), the chain app will
send messages to all the node each X time. This configuration is in the class com.ncr.ATMMonitoring.serverchain.executer.NetworkMapExecuter

In the Administration page is also possible to see the network status, this means it is possible to see if a node is currently active or it is down.

The page that handle this feature is networkMap.jsp, and also that page uses an Javascript file called networkPageFunctions.js.

In the networkPageFunctions.js is possible to configure the following:

* The images to show idle and ok nodes 
	** in startNetworkTree(), search for NetworkTree.setupHtmlElements(

* The time to consider a node idle ( or not responding)
	** in startNetworkTree(), search for  NetworkTree.nodeIddleSeconds =;


* The actions when the user clicks on each node:
	** Search for getMenuItems
	
The NetworkTree.js contains all the behaviour of the tree. This Singleton encapsulate the use of jstree, which is the library used to draw the network tree.
For more information of jstree go to: http://www.jstree.com/
	
-------------------------------------------------------------------	
Node Information
-------------------------------------------------------------------
It is possible to see each node configuration in a graphical way, just go to http://nodeAddress:port/app/nodeInfo and there you will see the
actual values of that node (defined in the property file)

-------------------------------------------------------------------
Resources Release
-------------------------------------------------------------------

To avoid the deploy of non needed resources in middle nodes, such as controllers, sockets, services, scheduled task, it is possible to tell the server chain to kill those 
Spring beans, and free resources. The configuration is made in the config.properties as follows:

serverchain.taskstostop= Only add the simple name of the class (avoid the package) in a comma separated list. it is assumed that the package is com.ncr.ATMMonitoring.scheduledtask.

IMPORTANT: Only the task that extends from com.ncr.ATMMonitoring.scheduledtask.SheduledTaskEnabler can be stopped

Example:


	serverchain.taskstostop=scheduledtask.CheckDateLicenseTask,scheduledtask.UPSGetXMLTask,scheduledtask.ScheduledUpdateTask,scheduledtask.OfficeGetTxtTask,scheduledtask.ProcessIpsTask

serverchain.resourcesbeanstodestroy=Destroy the resources defined in the xml, such as connection factories and datasources

Example:
	serverchain.resourcesbeanstodestroy=atmQueueConnectionFactory,atmQueuecachingConnectionFactory,updateAtmQueue,atmUpdateJmsTemplate,dataSource,sessionFactory

serverchain.packagestodestroy= Destroy all the Spring beans found in the given package, the main package assumed is is com.ncr.ATMMonitoring

Example:
	serverchain.packagestodestroy=dao,controller,service,servicefacade,socket


