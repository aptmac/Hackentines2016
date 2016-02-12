package com.example.norifurikake.hackenties2016;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;


public class Game extends ActionBarActivity {

    public int numCake = 0;
    public int numChocolate = 0;
    public int numWine = 0;
    public int numRose = 0;
    public int numCat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    public void IncreaseCake(){
        numCake++;
        Log.w("test", String.valueOf(numCake));
    }
    public void DecreaseCake(){
        numCake--;
    }
    public void IncreaseChocolate(){
        numChocolate++;
    }
    public void DecreaseChocolate(){
        numChocolate--;
    }
    public void IncreaseWine(){
        numWine++;
    }
    public void DecreaseWine(){
        numWine--;
    }
    public void IncreaseRose(){
        numRose++;
    }
    public void DecreaseRose(){
        numRose--;
    }
    public void IncreaseCat(){
        numCat++;
    }
    public void DecreaseCat(){
        numCat--;
    }
}
