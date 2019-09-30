Feature: Examen de automatización

  Scenario Outline: Como usuario quiero verificar los filtros de busqueda
    Given se encuentra abierto la página de Ebay
    When ingreso "zapatos" en el campo de busqueda
    And hago clic en el botón Buscar
    Then se muestra la etiqueta "zapatos" como resultado de la busqueda
    When selecciono marca "<marca>" para filtrar los resultados
    Then se muestra la etiqueta "<marca>" como resultado
    When selecciono talla "<talla>" para filtrar los resultados
    Then se muestra el total de resultados
    When ordeno por precio ascendente
    Then se ordena el resultado e imprimo los 5 primeros productos
    And imprimo los productos por nombre ascendente
    And imprimo los productos por precio descendente
    And envio reporte por correo

    Examples:
      | marca | talla |
      | PUMA  | 10    |