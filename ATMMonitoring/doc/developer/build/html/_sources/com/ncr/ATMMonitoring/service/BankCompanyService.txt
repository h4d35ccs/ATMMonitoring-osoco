.. java:import:: java.util List

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

BankCompanyService
==================

.. java:package:: com.ncr.ATMMonitoring.service
   :noindex:

.. java:type:: public interface BankCompanyService

   The Interface BankCompanyService.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addBankCompany
^^^^^^^^^^^^^^

.. java:method:: public void addBankCompany(BankCompany bank)
   :outertype: BankCompanyService

   Adds the bank company.

   :param bank: the bank

getBankCompany
^^^^^^^^^^^^^^

.. java:method:: public BankCompany getBankCompany(Integer id)
   :outertype: BankCompanyService

   Gets the bank company.

   :param id: the id
   :return: the bank company

listBankCompanies
^^^^^^^^^^^^^^^^^

.. java:method:: public List<BankCompany> listBankCompanies()
   :outertype: BankCompanyService

   List bank companies.

   :return: the list

removeBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: public void removeBankCompany(Integer id)
   :outertype: BankCompanyService

   Removes the bank company.

   :param id: the id

updateBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: public void updateBankCompany(BankCompany bank)
   :outertype: BankCompanyService

   Update bank company.

   :param bank: the bank

