package com.pokemon.soap.endpoint;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.springframework.ws.client.core.WebServiceTemplate;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;


public class PokemonEndpointTest {
  private String endpoint;
  private Response response;
  private WebServiceTemplate webServiceTemplate;



  @Given("el endpoint der servicio soap {string}")
  public void el_endpoint_der_servicio_soap(String string) {
    // Write code here that turns the phrase above into concrete actions
    webServiceTemplate = new WebServiceTemplate();
  }
  @When("Se realiza una consulta con el pokemon {string}")
  public void se_realiza_una_consulta_con_el_pokemon(String string) {
    String request = """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://soap.pokemon.com/">
           <soapenv:Header/>
           <soapenv:Body>
              <soap:LocalAreaEncountersRequest>
                 <soap:name>pikachu</soap:name>
              </soap:LocalAreaEncountersRequest>
           </soapenv:Body>
        </soapenv:Envelope>
        """;
    response =
        given().header("Content-Type", "text/xml").and().body(request).when().post(endpoint).then()
            .extract().response();
  }
  @Then("La respuesta debe contener datos del pokemon")
  public void la_respuesta_debe_contener_datos_del_pokemon() {
    String responseBody = response.getBody()
        .asString();
    assertNotNull(responseBody);
  }
}
