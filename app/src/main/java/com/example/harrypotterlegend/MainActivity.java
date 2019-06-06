package com.example.harrypotterlegend;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;



import java.util.ArrayList;
import java.util.List;
/*
Joue le rôle de la vue dans le modèle MVC: IHM pour l'utilisateur et envoie
les commandes rentrées par l'utilisateur au controlleur
 */
public class MainActivity extends Activity  {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        Controller controller = new Controller(this);
        controller.start();
    }

    public void displayList(List<Character> characterList) {
        Log.d("projectA","DisplayList Started");

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(characterList);
        recyclerView.setAdapter(mAdapter);
    }

}
