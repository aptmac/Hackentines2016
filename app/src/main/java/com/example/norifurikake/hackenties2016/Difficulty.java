package com.example.norifurikake.hackenties2016;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.SeekBar;

public class Difficulty extends ActionBarActivity {
    SeekBar seekBar;
    private int difficulty = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Select a difficulty!");
        seekBar = (SeekBar) findViewById(R.id.difficultyBar);
    }

    public void vibrate() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(20);
    }

    public void toGame(View view) {
        vibrate();
        this.difficulty = seekBar.getProgress();
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("difficulty", String.valueOf(difficulty));
        startActivity(intent);
    }
    private void setDifficulty(int difficulty){
        seekBar.setProgress(difficulty);
        this.difficulty = difficulty;
    }
    public void setDifficultyEasy(View view){
        vibrate();
        setDifficulty(0);
    }
    public void setDifficultyMedium(View view){
        vibrate();
        setDifficulty(5);
    }
    public void setDifficultyHard(View view){
        vibrate();
        setDifficulty(10);
    }
}