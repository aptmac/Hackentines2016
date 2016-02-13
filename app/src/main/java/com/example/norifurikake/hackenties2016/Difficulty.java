package com.example.norifurikake.hackenties2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.SeekBar;

public class Difficulty extends ActionBarActivity {
    SeekBar seekBar;
    private int difficulty = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Select a difficulty!");
        seekBar = (SeekBar) findViewById(R.id.difficultyBar);
    }

    public void toGame(View view) {
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
        setDifficulty(0);
    }
    public void setDifficultyMedium(View view){
        setDifficulty(8);
    }
    public void setDifficultyHard(View view){
        setDifficulty(10);
    }
}