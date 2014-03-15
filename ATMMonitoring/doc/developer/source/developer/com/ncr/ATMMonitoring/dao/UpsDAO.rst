.. java:import:: java.util List

.. java:import:: org.hibernate.criterion Criterion

.. java:import:: org.hibernate.criterion Restrictions

.. java:import:: com.ncr ATMMonitoring.pojo.Ups

UpsDAO
======

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface UpsDAO

   Dao interface class that interact with the UPS table

   :author: Otto Abreu

Methods
-------
addUps
^^^^^^

.. java:method::  void addUps(Ups ups)
   :outertype: UpsDAO

   Adds a new Ups to the database

   :param ups:

getUps
^^^^^^

.. java:method::  Ups getUps(int id)
   :outertype: UpsDAO

   returns the UPS entity that matches the given id

   :param id: int

getUpsBySerialNumber
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Ups getUpsBySerialNumber(String seriesNumber)
   :outertype: UpsDAO

   Returns a Ups by the given series number

   :param seriesNumber: String
   :return: Ups

getUpsBySerialNumberAndModel
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Ups getUpsBySerialNumberAndModel(String seriesNumber, String model)
   :outertype: UpsDAO

   Returns a Ups by the given series number and model

   :param seriesNumber: String
   :param model: String
   :return: Ups

listAllUps
^^^^^^^^^^

.. java:method::  List<Ups> listAllUps()
   :outertype: UpsDAO

   Returns all the ups from the db

listUps
^^^^^^^

.. java:method:: public List<Ups> listUps(Criterion... criterions)
   :outertype: UpsDAO

   Returns the ups that matches the given criterions. To add a criterion please use :java:ref:`Restrictions` or another class that implement :java:ref:`Criterion`

   :param criterions: :java:ref:`Criterion`
   :return: List<Ups>

removeUps
^^^^^^^^^

.. java:method::  void removeUps(int id)
   :outertype: UpsDAO

   Removes from the DB the UPS that matches with the given id

   :param id:

updateUps
^^^^^^^^^

.. java:method::  void updateUps(Ups ups)
   :outertype: UpsDAO

   Updates the data of an ups

   :param ups:

