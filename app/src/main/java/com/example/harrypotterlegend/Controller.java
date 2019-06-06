package com.example.harrypotterlegend;
import java.util.List;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/*
Cette classe joue le rôle du Controller dans le modèle MVC elle intéragit avec le modèle (Adapter)
pour créer des données pour la Vue (MainActivity)
 */
public class Controller implements Callback<List<Character>> {

    static final String BASE_URL = "https://raw.githubusercontent.com/GeekyGodess/geekygodess.github.io/master/";
    private final MainActivity mainActivity;

    public Controller(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }



    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // va convertir le json
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        HarryPotterAPI harryPotter = retrofit.create(HarryPotterAPI.class);

        Call<List<Character>> call = harryPotter.loadCharacters();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
        if(response.isSuccessful()) {
            List<Character> characterList = response.body();
           mainActivity.displayList(characterList);

        } else {
            System.out.println(response.errorBody());
        }
    }


    @Override
    public void onFailure(Call<List<Character>> call, Throwable t) {
        t.printStackTrace();
    }
}