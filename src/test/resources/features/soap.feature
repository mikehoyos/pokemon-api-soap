Feature: Validación de servicio SOAP

  Scenario: Consultar información de un pokemon
    Given el endpoint der servicio soap "http://localhost:8080/ws/pokemon.wsdl"
    When Se realiza una consulta con el pokemon "pikachu"
    Then La respuesta debe contener datos del pokemon
