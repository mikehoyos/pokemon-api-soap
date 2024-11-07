package com.pokemon.soap.service;


import com.pokemon.soap.entity.AccesUsr;
import org.json.JSONObject;

import java.time.LocalDate;

public interface PokemonService {
  /**
   * Método que regresa la respuesta del api de pokemon.
   *
   * @param name nombre del pokemon.
   * @return JSONObject respuesta del servicio.
   */
  JSONObject getApiPokemon(String name);

  /**
   * Método para guardar en base de datos los datos de acceso de usuario.
   *
   * @param accesUsr entidad para guardar.
   */
  void saveDatsUsr(AccesUsr accesUsr);

  /**
   *
   * @param calledMethod CalledMethod donde se guarda el nombre del método qu se llama.
   * @param time Time se guarda en millisegundos el tiempo de la transacción.
   * @param request Request guarda el valor de la petición.
   * @param response Response se almacena la respuesta del método.
   * @param ip Ip donde se origina la petición.
   * @return AccesUsr.
   */
  AccesUsr paramToEntity(String calledMethod,  Long time, String request, String response, String ip);
}
