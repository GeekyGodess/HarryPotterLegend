package com.example.harrypotterlegend;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "Second activity";
    public TextView nameCharacter;
    public TextView speciesCharacter;
    public TextView houseCharacter;
    public TextView genderCharacter;
    public ImageView imageCharacter;
    public TextView patronusCharacter;
    public TextView ancestryCharacter;
    public TextView actorCharacter;
    public TextView hairCharacter;
    public TextView birthCharacter;
    public String name;
    public String species ;
    public String house;
    public String gender;
    public String image;
    public String patronus;
    public String ancestry;
    public String actor;
    public String hair;
    public String birth;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG,"onCreate:started");
        nameCharacter = findViewById(R.id.name2);
        speciesCharacter = findViewById(R.id.species2);
        houseCharacter = findViewById(R.id.house);
        genderCharacter = findViewById(R.id.gender);
        imageCharacter = findViewById(R.id.image2);
        patronusCharacter = findViewById(R.id.patronus);
        ancestryCharacter = findViewById(R.id.ancestry);
        actorCharacter = findViewById(R.id.actor);
        hairCharacter = findViewById(R.id.hair);
        birthCharacter = findViewById(R.id.birth);
        Intent intent = getIntent();

            name = intent.getStringExtra("name");
            nameCharacter.setText("Name:" + name);

            species = intent.getStringExtra("species");
            speciesCharacter.setText("Species:" + species );

            house = intent.getStringExtra("house");
            houseCharacter.setText("House:" +house);

            gender = intent.getStringExtra("gender");
            genderCharacter.setText("Gender:" +gender);

            image = intent.getStringExtra("image");
        Glide.with(this.getApplicationContext()).load(image).into(imageCharacter);

            patronus = intent.getStringExtra("patronus");
            patronusCharacter.setText("Patronus:" + patronus);

            ancestry = intent.getStringExtra("ancestry");
            ancestryCharacter.setText("Ancestry:" +ancestry);

            actor= intent.getStringExtra("actor");
            actorCharacter.setText("Actor:" + actor);

            hair = intent.getStringExtra("hair");
            hairCharacter.setText("Hair colour:" + hair);

            birth = intent.getStringExtra("birth");
            birthCharacter.setText("Date of Birth:" + birth);



    }



}
