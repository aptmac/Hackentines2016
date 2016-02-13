package com.example.norifurikake.hackenties2016;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lonely Lucy on Valentines");
    }

    public void vibrate() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(20);
    }

    public void toDifficulty(View view){
        Intent intent = new Intent(this, Difficulty.class);
        vibrate();
        startActivity(intent);
    }

    public void toHowtoplay(View view){
        Intent intent = new Intent(this, Howtoplay.class);
        vibrate();
        startActivity(intent);
    }

    public void toAbout(View view){
        Intent intent = new Intent(this, About.class);
        vibrate();
        startActivity(intent);
    }

    public void toSettings(View view){
        Intent intent = new Intent(this, Settings.class);
        vibrate();
        startActivity(intent);
    }
}
