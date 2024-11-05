package com.pokemon.soap.business;

import com.pokemon.soap.entity.AccesUsr;
import com.pokemon.soap.repository.AccesUserRepository;
import com.pokemon.soap.service.PokemonService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
@Service
@AllArgsConstructor
public class PokemonServiceImp implements PokemonService {
  @Autowired
  private AccesUserRepository accesUserRepository;
  /**
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
      if(responseCode != 200) {
        System.out.println("Error "+responseCode);
      }else{
        StringBuilder information = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while(scanner.hasNext()){
          information.append(scanner.nextLine());
        }
        scanner.close();
        jsonObject = new JSONObject((String.valueOf(information)));
      }
    } catch (Exception e) {
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
}
