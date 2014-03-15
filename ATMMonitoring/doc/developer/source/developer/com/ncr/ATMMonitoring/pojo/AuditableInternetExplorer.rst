.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence JoinColumn

.. java:import:: javax.persistence ManyToOne

.. java:import:: javax.persistence PrimaryKeyJoinColumn

.. java:import:: javax.persistence SequenceGenerator

AuditableInternetExplorer
=========================

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity public class AuditableInternetExplorer extends Auditable

   The Auditable Internet Explorer Pojo.

   :author: jmartin

Constructors
------------
AuditableInternetExplorer
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AuditableInternetExplorer()
   :outertype: AuditableInternetExplorer

   Default constructor

AuditableInternetExplorer
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public AuditableInternetExplorer(InternetExplorer internetExplorer)
   :outertype: AuditableInternetExplorer

   Constructor

   :param internetExplorer: The internet explorer

Methods
-------
getInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: public InternetExplorer getInternetExplorer()
   :outertype: AuditableInternetExplorer

   Get the internet explorer

   :return: The internet explorer

setInternetExplorer
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setInternetExplorer(InternetExplorer internetExplorer)
   :outertype: AuditableInternetExplorer

   Set the internet explorer

   :param The: internet explorer

