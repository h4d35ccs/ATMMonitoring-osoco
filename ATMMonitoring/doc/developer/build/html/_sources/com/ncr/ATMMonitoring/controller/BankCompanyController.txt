.. java:import:: java.security Principal

.. java:import:: java.util Locale

.. java:import:: java.util Map

.. java:import:: javax.servlet.http HttpServletRequest

.. java:import:: javax.validation Valid

.. java:import:: org.springframework.beans.factory.annotation Autowired

.. java:import:: org.springframework.beans.factory.annotation Value

.. java:import:: org.springframework.beans.support PagedListHolder

.. java:import:: org.springframework.stereotype Controller

.. java:import:: org.springframework.validation BindingResult

.. java:import:: org.springframework.web.bind.annotation ModelAttribute

.. java:import:: org.springframework.web.bind.annotation PathVariable

.. java:import:: org.springframework.web.bind.annotation RequestMapping

.. java:import:: org.springframework.web.bind.annotation RequestMethod

.. java:import:: org.springframework.web.servlet.support RequestContextUtils

.. java:import:: com.ncr ATMMonitoring.pojo.BankCompany

.. java:import:: com.ncr ATMMonitoring.pojo.User

.. java:import:: com.ncr ATMMonitoring.service.BankCompanyService

.. java:import:: com.ncr ATMMonitoring.service.UserService

BankCompanyController
=====================

.. java:package:: com.ncr.ATMMonitoring.controller
   :noindex:

.. java:type:: @Controller public class BankCompanyController

   The Class BankCompanyController.

   :author: Jorge López Fernández (lopez.fernandez.jorge@gmail.com)

Methods
-------
addBankCompany
^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String addBankCompany(BankCompany bankCompany, BindingResult result, Map<String, Object> map, HttpServletRequest request, String p, Principal principal)
   :outertype: BankCompanyController

   Adds the bank company.

   :param bankCompany: the bank company
   :param result: the result
   :param map: the map
   :param request: the request
   :param p: the p
   :param principal: the principal
   :return: the string

bankCompanyDetails
^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String bankCompanyDetails(Integer bankCompanyId, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: BankCompanyController

   Bank company details.

   :param bankCompanyId: the bank company id
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

deleteBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String deleteBankCompany(Integer bankCompanyId, Principal principal)
   :outertype: BankCompanyController

   Delete bank company.

   :param bankCompanyId: the bank company id
   :param principal: the principal
   :return: the string

listBankCompanies
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String listBankCompanies(Map<String, Object> map, Principal principal, String p, HttpServletRequest request)
   :outertype: BankCompanyController

   List bank companies.

   :param map: the map
   :param principal: the principal
   :param p: the p
   :param request: the request
   :return: the string

redirectToBankCompanys
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String redirectToBankCompanys()
   :outertype: BankCompanyController

   Redirect to bank companys.

   :return: the string

updateBankCompany
^^^^^^^^^^^^^^^^^

.. java:method:: @RequestMapping public String updateBankCompany(BankCompany bankCompany, BindingResult result, Map<String, Object> map, HttpServletRequest request, Principal principal)
   :outertype: BankCompanyController

   Update bank company.

   :param bankCompany: the bank company
   :param result: the result
   :param map: the map
   :param request: the request
   :param principal: the principal
   :return: the string

