package com.example.harrypotterlegend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HarryPotterAPI {

    @GET("characters.json")
    Call<List<Character>> loadCharacters();
}