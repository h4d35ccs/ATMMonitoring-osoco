.. ATMMonitoring documentation master file, created by Otto Abreu Using
   sphinx-quickstart on Fri Jan 10 11:20:39 2014 NCR All Rights Reserved.

ATMMonitoring: ATM's Data Management Application
================================================

Introduction to ATMMonitoring
-----------------------------

ATMMonitoring is a web application that allows us to manage the data of a set of ATM's holistically. On top of allowing us to add, edit and remove an ATM from the system, if the ATMs have the agent supplied with the application installed, the server can communicate with them to receive their data at any time. The agent can also send the ATM data by its own (e.g. when it detects a change in the ATM configuration). 

The application also allows us to schedule updates of the ATM data for specific times on a weekly or monthly basis.

It also has its own queries engine that allows us to execute a series of restrictions on all data when displaying a list of ATMs, the queries can be combined with scheduled updates to update the data of only a subset of ATMs .


Features Summary
----------------

- Full management of ATM data with a complete data model that includes all hardware and software components, and other meta-entities such as installation or location.

- ATM Data recovery in real time [1]_.

- Custom query engine that allows us to fetch the ATMs filtering by checking their attributes through multiple operations.

- Allows to plan the ATM data updates weekly or monthly, can be based on a query to limit updates to a subset of machines.

.. [1] *The agent developed jointly with the server application must be installed in the ATMs.*

Agent collected Information
---------------------------

ATMMonitoring(Server) communicates with an Agent(Client) that is able to catch all the information provided by the ATM in order to be stored in the NCR HSAM Database. Although it is mainly intented to be run in ATMs, it is also able to collect information from any other devices.

It is divided into two main pieces, *HSAMAgent.jar* and *XFSCollector.dll*.

	*  **HSAMAgent.jar** The Java based core of the HSAM Agent. It manages all the processes  to collect the required information from the Operating System, Hardware, Software and any other specific information from ATMs (XFS, J/XFS, Financial Devices, etc).
	* **XFSCollector.dll** A C++ based collector of the information coming from the standard XFS. It is directly managed by the core agent. It automatically detects the highest XFS version supported for each XFS Service Provider starting from XFS 3.10 to XFS 2.00 and extracts the Capabilities information. 

The NCR HSAM Agent performs the following actions:


	* *ATM Information Collector* that gathers all the ATM information and stores it in a JSON formatted file (`<www.json.org>`_).
	* *Server Requests Receptor* for getting on-demand information. When an update order is received the ATM information is refreshed and restored into a JSON file. Once finished, the server is notified.
	* *Request Sender for notifying the server* that an update has been completed and a data update can be requested after a manual or scheduled demand for updating, or after refreshing the ATMinformation the first time the agent starts up.

To know more about the information gathered by the agent please see the :doc:`Agent Collected Information <collected-info>`

Documentation:
--------------

.. toctree::
   :maxdepth: 2
   
   enviroment_setup/environment-setup.rst
   installation/install-main.rst
   architecture/architecture.rst
   developer/javadoc.rst
   user/source/en/user-main.rst






