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

Documentation:
--------------

.. toctree::
   :maxdepth: 2
   
   enviroment_setup/environment-setup.rst
   installation/install-deploy.rst
   architecture/architecture.rst
   developer/javadoc.rst
   user/user-main.rst






