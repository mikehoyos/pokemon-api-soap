package com.pokemon.soap.service;


import com.pokemon.soap.entity.AccesUsr;
import org.json.JSONObject;

public interface PokemonService {
  JSONObject getApiPokemon(String name);

   void saveDatsUsr(AccesUsr accesUsr);
}
