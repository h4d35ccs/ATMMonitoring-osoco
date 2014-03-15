.. java:import:: java.util Date

UPSInfo
=======

.. java:package:: com.ncr.ATMMonitoring.parser.dto
   :noindex:

.. java:type:: public class UPSInfo

   DTO that holds the basic information retrieved from an UPS XML

   :author: ottoabreu

Constructors
------------
UPSInfo
^^^^^^^

.. java:constructor:: public UPSInfo(String ip, String firmware, String runningStatus, float chargePercentage, float expensePercentage, String alarmMsg, String upsType, String upsModel, String seriesNumber, long runningTimeMilisec, long autonomyMilisec, String numPosition, Date audFmo, String generalStatusMsg, Date lastExecutionDate, String originalXML, UPSExtraInfo extraInfo)
   :outertype: UPSInfo

   Constructor with all the parameters

   :param ip:
   :param firmware:
   :param runningStatus:
   :param chargePercentage:
   :param expensePercentage:
   :param alarmMsg:
   :param upsType:
   :param upsModel:
   :param seriesNumber:
   :param runningTimeMilisec:
   :param autonomyMilisec:
   :param numPosition:
   :param audFmo:
   :param generalStatusMsg:
   :param lastExecutionDate:
   :param originalXML:
   :param extraInfo:

UPSInfo
^^^^^^^

.. java:constructor:: public UPSInfo()
   :outertype: UPSInfo

   COnstructor no param

Methods
-------
getAlarmMsg
^^^^^^^^^^^

.. java:method:: public String getAlarmMsg()
   :outertype: UPSInfo

   Getter method for alarmMsg

   :return: the alarmMsg

getAudFmo
^^^^^^^^^

.. java:method:: public Date getAudFmo()
   :outertype: UPSInfo

   Getter method for audFmo

   :return: the audFmo

getAutonomyMilisec
^^^^^^^^^^^^^^^^^^

.. java:method:: public long getAutonomyMilisec()
   :outertype: UPSInfo

   Getter method for autonomyMilisec

   :return: the autonomyMilisec

getChargePercentage
^^^^^^^^^^^^^^^^^^^

.. java:method:: public float getChargePercentage()
   :outertype: UPSInfo

   Getter method for chargePercentage

   :return: the chargePercentage

getExpensePercentage
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public float getExpensePercentage()
   :outertype: UPSInfo

   Getter method for expensePercentage

   :return: the expensePercentage

getExtraInfo
^^^^^^^^^^^^

.. java:method:: public UPSExtraInfo getExtraInfo()
   :outertype: UPSInfo

   Getter method for extraInfo

   :return: the extraInfo

getFirmware
^^^^^^^^^^^

.. java:method:: public String getFirmware()
   :outertype: UPSInfo

   Getter method for firmware

   :return: the firmware

getGeneralStatusMsg
^^^^^^^^^^^^^^^^^^^

.. java:method:: public String getGeneralStatusMsg()
   :outertype: UPSInfo

   Getter method for generalStatusMsg

   :return: the generalStatusMsg

getIp
^^^^^

.. java:method:: public String getIp()
   :outertype: UPSInfo

   Getter method for ip

   :return: the ip

getLastExecutionDate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Date getLastExecutionDate()
   :outertype: UPSInfo

   Getter method for lastExecutionDate

   :return: the lastExecutionDate

getNumPosition
^^^^^^^^^^^^^^

.. java:method:: public String getNumPosition()
   :outertype: UPSInfo

   Getter method for numPosition

   :return: the numPosition

getOriginalXML
^^^^^^^^^^^^^^

.. java:method:: public String getOriginalXML()
   :outertype: UPSInfo

   Getter method for originalXML

   :return: the originalXML

getRunningStatus
^^^^^^^^^^^^^^^^

.. java:method:: public String getRunningStatus()
   :outertype: UPSInfo

   Getter method for runningStatus

   :return: the runningStatus

getRunningTimeMilisec
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public long getRunningTimeMilisec()
   :outertype: UPSInfo

   Getter method for runningTimeMilisec

   :return: the runningTimeMilisec

getSeriesNumber
^^^^^^^^^^^^^^^

.. java:method:: public String getSeriesNumber()
   :outertype: UPSInfo

   Getter method for seriesNumber

   :return: the seriesNumber

getUpsModel
^^^^^^^^^^^

.. java:method:: public String getUpsModel()
   :outertype: UPSInfo

   Getter method for upsModel

   :return: the upsModel

getUpsType
^^^^^^^^^^

.. java:method:: public String getUpsType()
   :outertype: UPSInfo

   Getter method for upsType

   :return: the upsType

setAlarmMsg
^^^^^^^^^^^

.. java:method:: public void setAlarmMsg(String alarmMsg)
   :outertype: UPSInfo

   Setter method for the alarmMsg

   :param alarmMsg: the alarmMsg to set

setAudFmo
^^^^^^^^^

.. java:method:: public void setAudFmo(Date audFmo)
   :outertype: UPSInfo

   Setter method for the audFmo

   :param audFmo: the audFmo to set

setAutonomyMilisec
^^^^^^^^^^^^^^^^^^

.. java:method:: public void setAutonomyMilisec(long autonomyMilisec)
   :outertype: UPSInfo

   Setter method for the autonomyMilisec

   :param autonomyMilisec: the autonomyMilisec to set

setChargePercentage
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setChargePercentage(float chargePercentage)
   :outertype: UPSInfo

   Setter method for the chargePercentage

   :param chargePercentage: the chargePercentage to set

setExpensePercentage
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setExpensePercentage(float expensePercentage)
   :outertype: UPSInfo

   Setter method for the expensePercentage

   :param expensePercentage: the expensePercentage to set

setExtraInfo
^^^^^^^^^^^^

.. java:method:: public void setExtraInfo(UPSExtraInfo extraInfo)
   :outertype: UPSInfo

   Setter method for the extraInfo

   :param extraInfo: the extraInfo to set

setFirmware
^^^^^^^^^^^

.. java:method:: public void setFirmware(String firmware)
   :outertype: UPSInfo

   Setter method for the firmware

   :param firmware: the firmware to set

setGeneralStatusMsg
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setGeneralStatusMsg(String generalStatusMsg)
   :outertype: UPSInfo

   Setter method for the generalStatusMsg

   :param generalStatusMsg: the generalStatusMsg to set

setIp
^^^^^

.. java:method:: public void setIp(String ip)
   :outertype: UPSInfo

   Setter method for the ip

   :param ip: the ip to set

setLastExecutionDate
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setLastExecutionDate(Date lastExecutionDate)
   :outertype: UPSInfo

   Setter method for the lastExecutionDate

   :param lastExecutionDate: the lastExecutionDate to set

setNumPosition
^^^^^^^^^^^^^^

.. java:method:: public void setNumPosition(String numPosition)
   :outertype: UPSInfo

   Setter method for the numPosition

   :param numPosition: the numPosition to set

setOriginalXML
^^^^^^^^^^^^^^

.. java:method:: public void setOriginalXML(String originalXML)
   :outertype: UPSInfo

   Setter method for the originalXML

   :param originalXML: the originalXML to set

setRunningStatus
^^^^^^^^^^^^^^^^

.. java:method:: public void setRunningStatus(String runningStatus)
   :outertype: UPSInfo

   Setter method for the runningStatus

   :param runningStatus: the runningStatus to set

setRunningTimeMilisec
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setRunningTimeMilisec(long runningTimeMilisec)
   :outertype: UPSInfo

   Setter method for the runningTimeMilisec

   :param runningTimeMilisec: the runningTimeMilisec to set

setSeriesNumber
^^^^^^^^^^^^^^^

.. java:method:: public void setSeriesNumber(String seriesNumber)
   :outertype: UPSInfo

   Setter method for the seriesNumber

   :param seriesNumber: the seriesNumber to set

setUpsModel
^^^^^^^^^^^

.. java:method:: public void setUpsModel(String upsModel)
   :outertype: UPSInfo

   Setter method for the upsModel

   :param upsModel: the upsModel to set

setUpsType
^^^^^^^^^^

.. java:method:: public void setUpsType(String upsType)
   :outertype: UPSInfo

   Setter method for the upsType

   :param upsType: the upsType to set

toString
^^^^^^^^

.. java:method:: @Override public String toString()
   :outertype: UPSInfo

