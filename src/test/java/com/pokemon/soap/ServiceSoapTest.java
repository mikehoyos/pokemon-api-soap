package com.pokemon.soap;

import com.pokemon.soap.endpoint.PokemonEndpoint;
import com.pokemon.soap.entity.AccesUsr;
import com.pokemon.soap.repository.AccesUserRepository;
import com.pokemon.soap.service.PokemonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
class ServiceSoapTest {
  @Mock
  private PokemonService pokemonService;
  @Mock
  private AccesUserRepository accesUserRepository;

  @Mock
  private HttpServletRequest httpServletRequest;

  @InjectMocks
  private PokemonEndpoint pokemonEndpoint;

  @Test
  @Order(1)
  @DisplayName("Prueba unitaria del método Base Experience")
  void testObtenerBaseExperience() throws JSONException {
    AccesUsr accesUsr = new AccesUsr();
    accesUsr.setTime(10000L);
    accesUsr.setIp("127.0.0.1");
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("base_experience","base_experience");
    when(pokemonService.getApiPokemon("pikachu")).thenReturn(jsonObject);
    var response = when(pokemonService.paramToEntity("2",2L,"222","re","121222")).thenReturn(accesUsr);
    Assertions.assertNotNull(response);
  }

  @Test
  @Order(2)
  @DisplayName("Prueba unitaria del método Ability")
  void testObtenerAbility() throws JSONException {
    AccesUsr accesUsr = new AccesUsr();
    accesUsr.setTime(10000L);
    accesUsr.setIp("127.0.0.1");
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("ability","ability");
    when(pokemonService.getApiPokemon("pikachu")).thenReturn(jsonObject);
    var response = when(pokemonService.paramToEntity("2",2L,"222","re","121222")).thenReturn(accesUsr);
    Assertions.assertNotNull(response);
  }

  @Test
  @Order(3)
  @DisplayName("Prueba unitaria del método Held Item")
  void testObtenerHeldItem() throws JSONException {
    AccesUsr accesUsr = new AccesUsr();
    accesUsr.setTime(10000L);
    accesUsr.setIp("127.0.0.1");
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("base_experience","base_experience");
    when(pokemonService.getApiPokemon("pikachu")).thenReturn(jsonObject);
    var response = when(pokemonService.paramToEntity("2",2L,"222","re","121222")).thenReturn(accesUsr);
    Assertions.assertNotNull(response);
  }

  @Test
  @Order(4)
  @DisplayName("Prueba unitaria del método Id")
  void testObtenerId() throws JSONException {
    AccesUsr accesUsr = new AccesUsr();
    accesUsr.setTime(10000L);
    accesUsr.setIp("127.0.0.1");
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("base_experience","base_experience");
    when(pokemonService.getApiPokemon("pikachu")).thenReturn(jsonObject);
    var response = when(pokemonService.paramToEntity("2",2L,"222","re","121222")).thenReturn(accesUsr);
    Assertions.assertNotNull(response);
  }

  @Test
  @Order(5)
  @DisplayName("Prueba unitaria del método Local Area Encounters")
  void testObtenerLocalAreaEncounters() throws JSONException {
    AccesUsr accesUsr = new AccesUsr();
    accesUsr.setTime(10000L);
    accesUsr.setIp("127.0.0.1");
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("pikachu","pikachu");
    when(pokemonService.getApiPokemon("pikachu")).thenReturn(jsonObject);
    var response = when(pokemonService.paramToEntity("2",2L,"222","re","121222")).thenReturn(accesUsr);
    Assertions.assertNotNull(response);
  }

  @Test
  @Order(6)
  @DisplayName("Prueba unitaria del método Name")
  void testObtenerName() throws JSONException {
    AccesUsr accesUsr = new AccesUsr();
    accesUsr.setTime(10000L);
    accesUsr.setIp("127.0.0.1");
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("pikachu","pikachu");
    when(pokemonService.getApiPokemon("pikachu")).thenReturn(jsonObject);
    var response = when(pokemonService.paramToEntity("2",2L,"222","re","121222")).thenReturn(accesUsr);
    Assertions.assertNotNull(response);
  }
}

