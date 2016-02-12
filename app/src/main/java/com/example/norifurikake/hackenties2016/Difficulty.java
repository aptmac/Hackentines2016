package com.example.norifurikake.hackenties2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Difficulty extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void toGame(View view){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }
}
