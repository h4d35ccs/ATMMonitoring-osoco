=============================================
ATMMonitoring: ATM management web application
=============================================

.. sectnum::
   :depth: 3
   :suffix: .
   :start: 0
.. contents:: Table of contents

Introduction to ATMMonitoring
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

ATMMonitoring is a web application which allows us to manage all the data we have from a collection of ATM in an integral way. On top of allowing us to add, delete and edit ATMs and their data, if they have the proper agent installed, server can communicate with them and receive their data at any time, starting the communication from either the server or the ATM (e.g. when it detects a config change). This data updates can also be scheduled weekly or monthly at specific times. It also has a powerful query engine that allows us to impose restrictions onto the ATMs' data and filter them, being particularly useful when combined with the scheduled updates so we can update only a subset of ATMs.

Functionalities summary
***********************

- Management of ATM data with a complete data modelo which includes all its hw and sw components, as well as meta-entities like installation and location.

- Real-time data retrieval from the ATMs [1]_.

- Custom engine query which allows us to filter the ATMs by several operations onto their attributes and related entities.

- Updates of the ATMs' data can be scheduled on a weekly or monthly basis, with the option of using a query for updating only a subset of ATMs.

.. [1] the ATMs must have the agent developed along with the server application correctly installed and configured.

About the sw license
********************

ATMMonitoring checks the user license through some encrypted codes located inside the *config.properties* file. There is a general key license, which
is unique for each user, and two licenses which control the application use in two different ways: first, by the number of different terminals it can
store; and second, by a date limit.
If you surpass the number of terminals your license can handle, it simply won't store more data. And in the case of the date limit, once that date
arrives the database will be deleted and the application can no longer be used.
Because of this, take special care with those fields and don't try to alter them without speaking with NCR support team. If any of the licenses seems
to have been manipulated or has a wrong value, the license will be considered expired and the program will act as described earlier.

User manual
~~~~~~~~~~~

Now we will explain all the functionalities offered by the application, detailing their options and user interfaces:

.. include:: user-main.rst
.. include:: login-logout.rst
.. include:: dashboard.rst
.. include:: terminals.rst
.. include:: reports.rst
.. include:: scheduled_updates.rst
.. include:: users.rst
