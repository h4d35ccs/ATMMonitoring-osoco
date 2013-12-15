========================================================
ATMMonitoring: aplicación de gestión de datos de cajeros
========================================================

.. sectnum::
   :depth: 3
   :suffix: .
   :start: 0
.. contents:: Tabla de contenidos

Introducción a ATMMonitoring
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

ATMMonitoring es una aplicación web que nos permite gestionar los datos de un parque de cajeros de manera integral. Además de permitir dar cajeros de alta y de baja y editar su información, si los cajeros tienen instalado el agente adecuado, el servidor puede comunicarse con ellos para recibir sus datos en cualquier momento, tanto por iniciativa del propio cajero (e.g. en el momento en que cambia su configuración) como por peticiones sobre el servidor. Estas actualizaciones también pueden ser planificadas para momentos concretos con periodicidad semanal o mensual. También posee un motor de queries propio que nos permite ejecutar una serie de restricciones sobre todos sus datos a la hora de mostrar un listado de los cajeros, pudiendo combinarse las queries con las actualizaciones programadas para actualizar los datos sólo de un subconjunto de los cajeros almacenados.

Resumen de funcionalidades
--------------------------

- Gestión completa de datos de cajeros con un modelo de datos completo que incluye todos sus componentes hardware y software, además de otras meta-entidades como instalación o localización.

- Recuperación de los datos de los cajeros en tiempo real [1]_.

- Motor de queries propio que nos permite recuperar los cajeros filtrándolos por una serie de valores de sus atributos y entidades componente.

- Posibilidad de planificar actualizaciones de datos de cajeros de manera semanal o mensual, pudiendo hacerlas en base a una query para limitar las actualizaciones a un subconjunto de los cajeros.

.. [1] los cajeros deben tener instalado correctamente el agente que fue desarrollado conjuntamente con la aplicación de servidor.

Manual de uso
~~~~~~~~~~~~~

A continuación explicaremos las distintas funcionalides que nos proporciona la explicación con sus diversas opciones:

.. include:: scheduled_updates.rst
