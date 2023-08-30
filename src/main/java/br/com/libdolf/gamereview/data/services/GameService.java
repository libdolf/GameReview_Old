package br.com.libdolf.gamereview.data.services;

import br.com.libdolf.gamereview.core.exceptions.MissingFieldsException;
import br.com.libdolf.gamereview.domain.entities.Game;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component
public class GameService{
    private static final String IGDB_URL = "https://api.igdb.com/v4/games";
    private static final RestTemplate restTemplate = new RestTemplate();

    private Gson gson = new Gson();

    private HttpHeaders headers(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Client-ID", " jntmlh3mqowal642mb4s5z49ag58at");
        headers.add("Authorization", "Bearer 5mxjoic5hk7rm1s8lbq8kogwg659ei");
        return headers;
    }

    public Game getGameById(Integer id){
        String request = "fields name, genres, platforms; where id = " + id+";";
        HttpEntity<String> httpEntity = new HttpEntity<>(request, headers());
        String response = restTemplate.postForObject(IGDB_URL, httpEntity, String.class);

        return Arrays.stream(gson.fromJson(response, Game[].class)).toList().get(0);
    }





}
