package com.pokemon.soap.endpoint;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;


public class PokemonEndpointTest {
  private String endpoint;
  private Response response;

  @Given("el endpoint der servicio soap {string}")
  public void getSoapPokemon(String name) {
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
  @Then("La respuesta debe contener datos del pokemon {string}")
  public void responsePokemon(String name){
    String responseBody = response.getBody()
        .asString();
    assertTrue(responseBody.contains(name));
  }
}
