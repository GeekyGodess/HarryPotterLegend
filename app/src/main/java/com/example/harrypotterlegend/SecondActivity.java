package com.example.harrypotterlegend;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "Second activity";
    public TextView nameCharacter;
    public TextView speciesCharacter;
    public TextView houseCharacter;
    public TextView genderCharacter;
    public String name;
    public String species ;
    public String house;
    public String gender;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG,"onCreate:started");
        nameCharacter = findViewById(R.id.name2);
        speciesCharacter = findViewById(R.id.species2);
        houseCharacter = findViewById(R.id.house);
        genderCharacter = findViewById(R.id.gender);
        Intent intent = getIntent();

            name = intent.getStringExtra("name");
            nameCharacter.setText("Name:" + name);

            species = intent.getStringExtra("species");
            speciesCharacter.setText("Species:" + species );

            house = intent.getStringExtra("house");
            houseCharacter.setText("House:" +house);

            gender = intent.getStringExtra("gender");
            genderCharacter.setText("Gender:" +gender);




    }



}
