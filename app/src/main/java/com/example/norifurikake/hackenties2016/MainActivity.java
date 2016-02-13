package com.example.norifurikake.hackenties2016;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hackentines 2016");

    }

    public void toDifficulty(View view){
        Intent intent = new Intent(this, Difficulty.class);
        startActivity(intent);
    }

    public void toHowtoplay(View view){
        Intent intent = new Intent(this, Howtoplay.class);
        startActivity(intent);
    }

    public void toAbout(View view){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void toSettings(View view){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}
