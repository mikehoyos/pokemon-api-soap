package com.pokemon.soap.endpoint;

import com.pokemon.soap.AbilityRequest;
import com.pokemon.soap.AbilityResponse;
import com.pokemon.soap.BaseExperienceRequest;
import com.pokemon.soap.BaseExperienceResponse;
import com.pokemon.soap.HeldItemsRequest;
import com.pokemon.soap.HeldItemsResponse;
import com.pokemon.soap.IdRequest;
import com.pokemon.soap.IdResponse;
import com.pokemon.soap.LocalAreaEncountersRequest;
import com.pokemon.soap.LocalAreaEncountersResponse;
import com.pokemon.soap.NameRequest;
import com.pokemon.soap.NameResponse;
import com.pokemon.soap.entity.AccesUsr;
import com.pokemon.soap.service.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Slf4j
@AllArgsConstructor
@Endpoint
@Tag(name="SOAP service pokemon")
public class PokemonEndpoint {
  private PokemonService pokemonService;
  private HttpServletRequest httpServletRequest;

  @Autowired
  public void setRequest(HttpServletRequest request) {
    this.httpServletRequest = request;
  }

  private static final String NAMESPACE_URI = "http://soap.pokemon.com/";

  @Operation(summary = "Calls the SOAP operation getBaseExperience")
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "BaseExperienceRequest")
  @ResponsePayload
  public BaseExperienceResponse getBaseExperience(@RequestPayload BaseExperienceRequest request) {

    var start = Instant.now();
    String ip = (this.httpServletRequest.getRemoteAddr() != null) ? this.httpServletRequest.getRemoteAddr() : "";
    BaseExperienceResponse response = new BaseExperienceResponse();
    JSONObject jsonObject = pokemonService.getApiPokemon(request.getName());
    response.setBaseExperience(jsonObject.get("base_experience").toString());
    AccesUsr accesUsr = pokemonService.paramToEntity("base_experience", Duration.between(start, Instant.now()).toMillis(), request.getName(),
        response.toString(), ip);
    pokemonService.saveDatsUsr(accesUsr);
    return response;
  }

  @Operation(summary = "Calls the SOAP operation getId")
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IdRequest")
  @ResponsePayload
  public IdResponse getId(@RequestPayload IdRequest request) {

    var start = Instant.now();
    IdResponse response = new IdResponse();
    JSONObject jsonObject = pokemonService.getApiPokemon(request.getNombre());
    response.setId(jsonObject.get("id").toString());
    AccesUsr accesUsr = pokemonService.paramToEntity("id", Duration.between(start, Instant.now()).toMillis(), request.getNombre(),
        response.toString(), this.httpServletRequest.getRemoteAddr());
    pokemonService.saveDatsUsr(accesUsr);
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "NameRequest")
  @ResponsePayload
  @Operation(summary = "Calls the SOAP getName")
  public NameResponse getName(@RequestPayload NameRequest request) {

    var start = Instant.now();
    NameResponse response = new NameResponse();
    JSONObject jsonObject = pokemonService.getApiPokemon(request.getNombre());
    response.setName(jsonObject.get("name").toString());
    AccesUsr accesUsr = pokemonService.paramToEntity("getName", Duration.between(start, Instant.now()).toMillis(), request.getNombre(),
        response.toString(), this.httpServletRequest.getRemoteAddr());
    pokemonService.saveDatsUsr(accesUsr);
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LocalAreaEncountersRequest")
  @ResponsePayload
  @Operation(summary = "Calls the SOAP getLocalAreaEncounters")
  public LocalAreaEncountersResponse getLocalAreaEncounters(
      @RequestPayload LocalAreaEncountersRequest request) {

    var start = Instant.now();
    LocalAreaEncountersResponse response = new LocalAreaEncountersResponse();
    JSONObject jsonObject = pokemonService.getApiPokemon(request.getName());
    response.setLocalAreaEncounters(jsonObject.get("location_area_encounters").toString());
    AccesUsr accesUsr = pokemonService.paramToEntity("getName", Duration.between(start, Instant.now()).toMillis(), request.getName(),
        response.toString(), this.httpServletRequest.getRemoteAddr());
    pokemonService.saveDatsUsr(accesUsr);
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AbilityRequest")
  @ResponsePayload
  @Operation(summary = "Calls the SOAP getAbility")
  public AbilityResponse getAbility(@RequestPayload AbilityRequest request) {
    AbilityResponse abilityResponse = new AbilityResponse();

    var start = Instant.now();
    AbilityResponse.Abilitys abilitys = new AbilityResponse.Abilitys();

    JSONObject jsonObject = pokemonService.getApiPokemon(request.getBaseExperience());
    JSONArray array = jsonObject.getJSONArray("abilities");
    array.forEach(item -> {
      AbilityResponse.Abilitys.Ability ability = new AbilityResponse.Abilitys.Ability();
      JSONObject jsonObject2 = new JSONObject(item.toString());
      JSONObject obj = jsonObject2.getJSONObject("ability");
      ability.setName(obj.get("name").toString());
      ability.setUrl(obj.get("url").toString());
      abilityResponse.setIsHidden(jsonObject2.getBoolean("is_hidden"));
      abilityResponse.setSlot(jsonObject2.getInt("slot"));
      abilitys.getAbility().addAll(Arrays.asList(ability));
      abilityResponse.setAbilitys(abilitys);

    });
    AccesUsr accesUsr = pokemonService.paramToEntity("getAbility", Duration.between(start, Instant.now()).toMillis() ,request.getBaseExperience(),
        abilityResponse.toString(), this.httpServletRequest.getRemoteAddr());
    pokemonService.saveDatsUsr(accesUsr);
    accesUsr.setRequest(request.getBaseExperience());
    return abilityResponse;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "HeldItemsRequest")
  @ResponsePayload
  @Operation(summary = "Calls the SOAP getHeldItems")
  public HeldItemsResponse getHeldItems(@RequestPayload HeldItemsRequest request) {
    HeldItemsResponse heldItemsResponse = new HeldItemsResponse();
    HeldItemsResponse.VersionDetails versionDetails = new HeldItemsResponse.VersionDetails();

    var start = Instant.now();

    JSONObject jsonObject = pokemonService.getApiPokemon(request.getNombre());
    JSONArray array = jsonObject.getJSONArray("held_items");
    array.forEach(it -> {
      HeldItemsResponse.Item item = new HeldItemsResponse.Item();
      JSONObject jsonObject2 = new JSONObject(it.toString());
      JSONObject obj = (JSONObject) jsonObject2.get("item");
      item.setName(obj.get("name").toString());
      item.setUrl(obj.get("url").toString());
      JSONArray arrayDetails = jsonObject2.getJSONArray("version_details");
      arrayDetails.forEach(details -> {

        HeldItemsResponse.VersionDetails.Version version =
            new HeldItemsResponse.VersionDetails.Version();
        JSONObject jsonDetails = new JSONObject(details.toString());
        versionDetails.setRarity(jsonDetails.getInt("rarity"));
        JSONObject obj2 = (JSONObject) jsonDetails.get("version");
        version.setName(obj2.get("name").toString());
        version.setUrl(obj2.get("url").toString());
        versionDetails.getVersion().addAll(Arrays.asList(version));
        heldItemsResponse.setVersionDetails(versionDetails);
      });

    });

    AccesUsr accesUsr = pokemonService.paramToEntity("getHeldItems", Duration.between(start, Instant.now()).toMillis(), request.getNombre(),
        heldItemsResponse.toString(), this.httpServletRequest.getRemoteAddr());
    pokemonService.saveDatsUsr(accesUsr);
    return heldItemsResponse;
  }
}
