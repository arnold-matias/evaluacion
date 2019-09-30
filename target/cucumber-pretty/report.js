$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Ebay.feature");
formatter.feature({
  "name": "Examen de automatización",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Como usuario quiero verificar los filtros de busqueda",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "se encuentra abierto la página de Ebay",
  "keyword": "Given "
});
formatter.step({
  "name": "ingreso \"zapatos\" en el campo de busqueda",
  "keyword": "When "
});
formatter.step({
  "name": "hago clic en el botón Buscar",
  "keyword": "And "
});
formatter.step({
  "name": "se muestra la etiqueta \"zapatos\" como resultado de la busqueda",
  "keyword": "Then "
});
formatter.step({
  "name": "selecciono marca \"\u003cmarca\u003e\" para filtrar los resultados",
  "keyword": "When "
});
formatter.step({
  "name": "se muestra la etiqueta \"\u003cmarca\u003e\" como resultado",
  "keyword": "Then "
});
formatter.step({
  "name": "selecciono talla \"\u003ctalla\u003e\" para filtrar los resultados",
  "keyword": "When "
});
formatter.step({
  "name": "se muestra el total de resultados",
  "keyword": "Then "
});
formatter.step({
  "name": "ordeno por precio ascendente",
  "keyword": "When "
});
formatter.step({
  "name": "se ordena el resultado e imprimo los 5 primeros productos",
  "keyword": "Then "
});
formatter.step({
  "name": "imprimo los productos por nombre ascendente",
  "keyword": "And "
});
formatter.step({
  "name": "imprimo los productos por precio descendente",
  "keyword": "And "
});
formatter.step({
  "name": "envio reporte por correo",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "marca",
        "talla"
      ]
    },
    {
      "cells": [
        "PUMA",
        "10"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Como usuario quiero verificar los filtros de busqueda",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "se encuentra abierto la página de Ebay",
  "keyword": "Given "
});
formatter.match({
  "location": "EbaySteps.se_encuentra_abierto_la_página_de_Ebay()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "ingreso \"zapatos\" en el campo de busqueda",
  "keyword": "When "
});
formatter.match({
  "location": "EbaySteps.ingreso_en_el_campo_de_busqueda(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "hago clic en el botón Buscar",
  "keyword": "And "
});
formatter.match({
  "location": "EbaySteps.hago_clic_en_el_botón_Buscar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se muestra la etiqueta \"zapatos\" como resultado de la busqueda",
  "keyword": "Then "
});
formatter.match({
  "location": "EbaySteps.se_muestra_la_etiqueta_como_resultado_de_la_busqueda(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selecciono marca \"PUMA\" para filtrar los resultados",
  "keyword": "When "
});
formatter.match({
  "location": "EbaySteps.selecciono_marca_para_filtrar_los_resultados(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se muestra la etiqueta \"PUMA\" como resultado",
  "keyword": "Then "
});
formatter.match({
  "location": "EbaySteps.se_muestra_la_etiqueta_como_resultado(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "selecciono talla \"10\" para filtrar los resultados",
  "keyword": "When "
});
formatter.match({
  "location": "EbaySteps.selecciono_talla_para_filtrar_los_resultados(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se muestra el total de resultados",
  "keyword": "Then "
});
formatter.match({
  "location": "EbaySteps.se_muestra_el_total_de_resultados()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "ordeno por precio ascendente",
  "keyword": "When "
});
formatter.match({
  "location": "EbaySteps.ordeno_por_precio_ascendente()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "se ordena el resultado e imprimo los 5 primeros productos",
  "keyword": "Then "
});
formatter.match({
  "location": "EbaySteps.seOrdenaElResultadoEImprimoLosPrimerosProductos(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "imprimo los productos por nombre ascendente",
  "keyword": "And "
});
formatter.match({
  "location": "EbaySteps.imprimo_los_productos_por_nombre_ascendente()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "imprimo los productos por precio descendente",
  "keyword": "And "
});
formatter.match({
  "location": "EbaySteps.imprimo_los_productos_por_precio_descendente()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "envio reporte por correo",
  "keyword": "And "
});
formatter.match({
  "location": "EbaySteps.envio_reporte_por_correo()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});