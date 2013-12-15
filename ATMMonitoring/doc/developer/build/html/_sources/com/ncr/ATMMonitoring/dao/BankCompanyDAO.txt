.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

BankCompanyDAO
==============

.. java:package:: com.ncr.ATMMonitoring.dao
   :noindex:

.. java:type:: public interface BankCompanyDAO

   The Interface BankCompanyDAO.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addBankCompany
^^^^^^^^^^^^^^

.. java:method:: public void addBankCompany(BankCompany bank)
   :outertype: BankCompanyDAO

   Adds the bank company.

   :param bank: the bank

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: public BankCompany getBankCompany(Integer id)
   :outertype: BankCompanyDAO

   Gets the bank company.

   :param id: the id
   :return: the bank company

listBankCompanies
^^^^^^^^^^^^^^^^^

.. java:method:: public List<BankCompany> listBankCompanies()
   :outertype: BankCompanyDAO

   List bank companies.

   :return: the list

removeBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: public void removeBankCompany(Integer id)
   :outertype: BankCompanyDAO

   Removes the bank company.

   :param id: the id

updateBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: public void updateBankCompany(BankCompany bank)
   :outertype: BankCompanyDAO

   Update bank company.

   :param bank: the bank

