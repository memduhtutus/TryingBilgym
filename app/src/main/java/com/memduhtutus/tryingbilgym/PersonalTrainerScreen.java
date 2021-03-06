package com.memduhtutus.tryingbilgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PersonalTrainerScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_trainer_screen);
    }
    public void chestClicked (View view){
        Intent intent = new Intent(PersonalTrainerScreen.this, Chest.class);
        startActivity(intent);
    }
    public void bicepsClicked (View view){
        Intent intent = new Intent(PersonalTrainerScreen.this, Biceps.class);
        startActivity(intent);
    }
    public void tricepsClicked (View view){
        Intent intent = new Intent(PersonalTrainerScreen.this, Triceps.class);
        startActivity(intent);
    }
    public void backClicked (View view) {
        Intent intent = new Intent(PersonalTrainerScreen.this, Back.class);
        startActivity(intent);
    }
    public void shoulderClicked (View view){
        Intent intent = new Intent(PersonalTrainerScreen.this, Shoulder.class);
        startActivity(intent);
    }
    public void legClicked(View view){
        Intent intent = new Intent(PersonalTrainerScreen.this, Leg.class);
        startActivity(intent);
    }

}