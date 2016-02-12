package com.example.norifurikake.hackenties2016;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
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

    /**
     * Increase and Decrease the quantity of Cake
     */
    public void IncreaseCake(View v){
        numCake++;
        Log.d("Increase: ", String.valueOf(numCake));
        TextView textView = (TextView) findViewById(R.id.txtCake);
        textView.setText(String.valueOf(numCake));
    }
    public void DecreaseCake(View v){
        if (numCake == 0)
        {
            //do nothing
            Log.d("Error:", "Cannot have negative value.");
        }
        else
        {
            numCake--;
            Log.d("Decrease: ", String.valueOf(numCake));
            TextView textView = (TextView) findViewById(R.id.txtCake);
            textView.setText(String.valueOf(numCake));
        }
    }

    /**
     * Increase and Decrease the quantity of Chocolate
     */
    public void IncreaseChocolate(View v){
        numChocolate++;
        Log.d("Increase: ", String.valueOf(numChocolate));
        TextView textView = (TextView) findViewById(R.id.txtChocolate);
        textView.setText(String.valueOf(numChocolate));
    }
    public void DecreaseChocolate(View v){
        if (numChocolate == 0)
        {
            //do nothing
            Log.d("Error:", "Cannot have negative value.");
        }
        else
        {
            numChocolate--;
            Log.d("Decrease: ", String.valueOf(numChocolate));
            TextView textView = (TextView) findViewById(R.id.txtChocolate);
            textView.setText(String.valueOf(numChocolate));
        }
    }

    /**
     * Increase and Decrease the quantity of Wine
     */
    public void IncreaseWine(View v){
        numWine++;
        Log.d("Increase: ", String.valueOf(numWine));
        TextView textView = (TextView) findViewById(R.id.txtWine);
        textView.setText(String.valueOf(numWine));
    }
    public void DecreaseWine(View v){
        if (numWine == 0)
        {
            //do nothing
            Log.d("Error:", "Cannot have negative value.");
        }
        else
        {
            numWine--;
            Log.d("Decrease: ", String.valueOf(numWine));
            TextView textView = (TextView) findViewById(R.id.txtWine);
            textView.setText(String.valueOf(numWine));
        }
    }

    /**
     * Increase and Decrease the quantity of Cat
     */
    public void IncreaseCat(View v){
        numCat++;
        Log.d("Increase: ", String.valueOf(numCat));
        TextView textView = (TextView) findViewById(R.id.txtCat);
        textView.setText(String.valueOf(numCat));
    }
    public void DecreaseCat(View v){
        if (numCat == 0)
        {
            //do nothing
            Log.d("Error:", "Cannot have negative value.");
        }
        else
        {
            numCat--;
            Log.d("Decrease: ", String.valueOf(numCat));
            TextView textView = (TextView) findViewById(R.id.txtCat);
            textView.setText(String.valueOf(numCat));
        }
    }

    /**
     * Increase and Decrease the quantity of Rose
     */
    public void IncreaseRose(View v){
        numRose++;
        Log.d("Increase: ", String.valueOf(numRose));
        TextView textView = (TextView) findViewById(R.id.txtRose);
        textView.setText(String.valueOf(numRose));
    }
    public void DecreaseRose(View v){
        if (numRose == 0)
        {
            //do nothing
            Log.d("Error:", "Cannot have negative value.");
        }
        else
        {
            numRose--;
            Log.d("Decrease: ", String.valueOf(numRose));
            TextView textView = (TextView) findViewById(R.id.txtRose);
            textView.setText(String.valueOf(numRose));
        }
    }

}
