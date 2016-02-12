package com.example.norifurikake.hackenties2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.SeekBar;

public class Difficulty extends ActionBarActivity {

    private int _difficulty = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void toGame(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("difficulty", this._difficulty);
        startActivity(intent);
    }
    private void setDifficulty(int difficulty){
        SeekBar seekBar = (SeekBar) findViewById(R.id.difficultyBar);
        seekBar.setProgress(difficulty);
        this._difficulty = difficulty;
    }
    public void setDifficultyEasy(View view){
        setDifficulty(0);
    }
    public void setDifficultyMedium(View view){
        setDifficulty(5);
    }
    public void setDifficultyHard(View view){
        setDifficulty(10);
    }
}
