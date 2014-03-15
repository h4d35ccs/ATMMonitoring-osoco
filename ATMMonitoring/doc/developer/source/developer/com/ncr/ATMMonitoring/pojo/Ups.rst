.. java:import:: java.io Serializable

.. java:import:: java.util Date

.. java:import:: javax.persistence Column

.. java:import:: javax.persistence Entity

.. java:import:: javax.persistence GeneratedValue

.. java:import:: javax.persistence GenerationType

.. java:import:: javax.persistence Id

.. java:import:: javax.persistence SequenceGenerator

.. java:import:: javax.persistence Table

Ups
===

.. java:package:: com.ncr.ATMMonitoring.pojo
   :noindex:

.. java:type:: @Entity @Table public class Ups implements Serializable

   Entity that holds the info of an UPS

   :author: Otto Abreu

Constructors
------------
Ups
^^^

.. java:constructor:: public Ups()
   :outertype: Ups

   default constructor

Methods
-------
getAlarmMsg
^^^^^^^^^^^

.. java:method:: public String getAlarmMsg()
   :outertype: Ups

   Getter method for alarmMsg

   :return: the alarmMsg

getAudFmo
^^^^^^^^^

.. java:method:: public Date getAudFmo()
   :outertype: Ups

   Getter method for audFmo

   :return: the audFmo

getAutonomyMilisec
^^^^^^^^^^^^^^^^^^

.. java:method:: public Long getAutonomyMilisec()
   :outertype: Ups

   Getter method for autonomyMilisec

   :return: the autonomyMilisec

getChargePercentage
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Float getChargePercentage()
   :outertype: Ups

   Getter method for chargePercentage

   :return: the chargePercentage

getExpensePercentage
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Float getExpensePercentage()
   :outertype: Ups

   Getter method for expensePercentage

   :return: the expensePercentage

getFirmware
^^^^^^^^^^^

.. java:method:: public String getFirmware()
   :outertype: Ups

   Getter method for firmware

   :return: the firmware

getGeneralStatusMsg
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getGeneralStatusMsg()
   :outertype: Ups

   Getter method for generalStatusMsg

   :return: the generalStatusMsg

getId
^^^^^

.. java:method:: public Integer getId()
   :outertype: Ups

   Getter method for id

   :return: the id

getIp
^^^^^

.. java:method:: public String getIp()
   :outertype: Ups

   Getter method for ip

   :return: the ip

getLastExecutionDate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Date getLastExecutionDate()
   :outertype: Ups

   Getter method for lastExecutionDate

   :return: the lastExecutionDate

getModel
^^^^^^^^

.. java:method:: public String getModel()
   :outertype: Ups

   Getter method for model

   :return: the model

getNumPosition
^^^^^^^^^^^^^^

.. java:method:: public String getNumPosition()
   :outertype: Ups

   Getter method for numPosition

   :return: the numPosition

getOriginalXML
^^^^^^^^^^^^^^

.. java:method:: public String getOriginalXML()
   :outertype: Ups

   Getter method for originalXML

   :return: the originalXML

getRunningStatus
^^^^^^^^^^^^^^^^

.. java:method:: public String getRunningStatus()
   :outertype: Ups

   Getter method for runningStatus

   :return: the runningStatus

getRunningTimeMilisec
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Long getRunningTimeMilisec()
   :outertype: Ups

   Getter method for runningTimeMilisec

   :return: the runningTimeMilisec

getSeriesNumber
^^^^^^^^^^^^^^^

.. java:method:: public String getSeriesNumber()
   :outertype: Ups

   Getter method for seriesNumber

   :return: the seriesNumber

getType
^^^^^^^

.. java:method:: public String getType()
   :outertype: Ups

   Getter method for type

   :return: the type

setAlarmMsg
^^^^^^^^^^^

.. java:method:: public void setAlarmMsg(String alarmMsg)
   :outertype: Ups

   Setter method for the alarmMsg

   :param alarmMsg: the alarmMsg to set

setAudFmo
^^^^^^^^^

.. java:method:: public void setAudFmo(Date audFmo)
   :outertype: Ups

   Setter method for the audFmo

   :param audFmo: the audFmo to set

setAutonomyMilisec
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAutonomyMilisec(Long autonomyMilisec)
   :outertype: Ups

   Setter method for the autonomyMilisec

   :param autonomyMilisec: the autonomyMilisec to set

setChargePercentage
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setChargePercentage(Float chargePercentage)
   :outertype: Ups

   Setter method for the chargePercentage

   :param chargePercentage: the chargePercentage to set

setExpensePercentage
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setExpensePercentage(Float expensePercentage)
   :outertype: Ups

   Setter method for the expensePercentage

   :param expensePercentage: the expensePercentage to set

setFirmware
^^^^^^^^^^^

.. java:method:: public void setFirmware(String firmware)
   :outertype: Ups

   Setter method for the firmware

   :param firmware: the firmware to set

setGeneralStatusMsg
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setGeneralStatusMsg(String generalStatusMsg)
   :outertype: Ups

   Setter method for the generalStatusMsg

   :param generalStatusMsg: the generalStatusMsg to set

setId
^^^^^

.. java:method:: public void setId(Integer id)
   :outertype: Ups

   Setter method for the id

   :param id: the id to set

setIp
^^^^^

.. java:method:: public void setIp(String ip)
   :outertype: Ups

   Setter method for the ip

   :param ip: the ip to set

setLastExecutionDate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setLastExecutionDate(Date lastExecutionDate)
   :outertype: Ups

   Setter method for the lastExecutionDate

   :param lastExecutionDate: the lastExecutionDate to set

setModel
^^^^^^^^

.. java:method:: public void setModel(String model)
   :outertype: Ups

   Setter method for the model

   :param model: the model to set

setNumPosition
^^^^^^^^^^^^^^

.. java:method:: public void setNumPosition(String numPosition)
   :outertype: Ups

   Setter method for the numPosition

   :param numPosition: the numPosition to set

setOriginalXML
^^^^^^^^^^^^^^

.. java:method:: public void setOriginalXML(String originalXML)
   :outertype: Ups

   Setter method for the originalXML

   :param originalXML: the originalXML to set

setRunningStatus
^^^^^^^^^^^^^^^^

.. java:method:: public void setRunningStatus(String runningStatus)
   :outertype: Ups

   Setter method for the runningStatus

   :param runningStatus: the runningStatus to set

setRunningTimeMilisec
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRunningTimeMilisec(Long runningTimeMilisec)
   :outertype: Ups

   Setter method for the runningTimeMilisec

   :param runningTimeMilisec: the runningTimeMilisec to set

setSeriesNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setSeriesNumber(String seriesNumber)
   :outertype: Ups

   Setter method for the seriesNumber

   :param seriesNumber: the seriesNumber to set

setType
^^^^^^^

.. java:method:: public void setType(String type)
   :outertype: Ups

   Setter method for the type

   :param type: the type to set

