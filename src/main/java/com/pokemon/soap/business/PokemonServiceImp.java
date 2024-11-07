package com.pokemon.soap.business;

import com.pokemon.soap.entity.AccesUsr;
import com.pokemon.soap.repository.AccesUserRepository;
import com.pokemon.soap.service.PokemonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Clase donde se consume el api de pokemon.
 */
@Service
@AllArgsConstructor
@Slf4j
public class PokemonServiceImp implements PokemonService {
  /**
   * Bean para usar el repositorio.
   */
  private AccesUserRepository accesUserRepository;
  /**
   * Método donde se implementa el consumo del api de pokemon.
   * @return
   */
  @Override
  public JSONObject getApiPokemon(String name) {
    JSONObject jsonObject = new JSONObject();
    try {
      URL url = new URL("https://pokeapi.co/api/v2/pokemon/"+name);
      HttpURLConnection conection = (HttpURLConnection) url.openConnection();
      conection.setRequestMethod("GET");
      int responseCode = conection.getResponseCode();
      if(responseCode == 200) {
        StringBuilder information = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while(scanner.hasNext()){
          information.append(scanner.nextLine());
        }
        scanner.close();
        jsonObject = new JSONObject((String.valueOf(information)));
      }
    } catch (Exception e) {
      log.error("Error al conusmir: {}",e.getMessage());
      throw new RuntimeException(e);
    }
    return jsonObject;
  }

  /**
   * @param accesUsr
   */
  @Override
  public void saveDatsUsr(AccesUsr accesUsr) {
    accesUserRepository.save(accesUsr);
  }

  /**
   * @param calledMethod CalledMethod donde se guarda el nombre del método qu se llama.
   * @param time         Time se guarda en millisegundos el tiempo de la transacción.
   * @param request      Request guarda el valor de la petición.
   * @param response     Response se almacena la respuesta del método.
   * @param ip           Ip donde se origina la petición.
   * @return AccesUsr.
   */
  @Override
  public AccesUsr paramToEntity(String calledMethod, Long time, String request,
      String response, String ip) {
    AccesUsr accesUsr = new AccesUsr();
    accesUsr.setIp(ip);
    accesUsr.setResponse(response);
    accesUsr.setCalledMethod(calledMethod);
    accesUsr.setTimeOn(LocalDate.now());
    accesUsr.setRequest(request);
    accesUsr.setTime(time);
    return accesUsr;
  }
}
