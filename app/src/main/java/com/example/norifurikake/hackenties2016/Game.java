package com.example.norifurikake.hackenties2016;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class Game extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Initialize();
    }

    public void Initialize() {
        //Initialize the current target value
        target = 100;
        TextView textView = (TextView) findViewById(R.id.txtTarget);
        textView.setText("Target: " + String.valueOf(target));

        ImageView imgGirl = (ImageView) findViewById(R.id.imgGirl);
        imgGirl.setImageResource(R.drawable.person1_standing);
        /**
        //Randomly generate the girl
        Random r = new Random();
        int girl = r.nextInt(5 - 1) + 5;
        ImageView imgGirl = (ImageView) findViewById(R.id.imgGirl);
        if (girl == 1)
        {
            imgGirl.setImageResource(R.drawable.person1_standing);
        }
        else if (girl == 2)
        {
            imgGirl.setImageResource(R.drawable.person2_standing);
        }
        else if (girl == 3)
        {
            imgGirl.setImageResource(R.drawable.person3_standing);
        }
        else if (girl == 4)
        {
            imgGirl.setImageResource(R.drawable.person4_standing);
        }
        else
        {
            imgGirl.setImageResource(R.drawable.person5_standing);
        }
         **/


        //Initialize base values for the objects
        this.valueChocolate = 1;
        this.valueCake = 5;
        this.valueWine = 10;
        this.valueRose = 25;
        this.valueCat = 50;
    }

    /**
     * Variables to hold the target goal and current progress
     */
    public int target = 0;
    public int current = 0;
    public int valueChocolate = 0;
    public int valueCake = 0;
    public int valueWine = 0;
    public int valueRose = 0;
    public int valueCat = 0;

    /**
     * Variables to hold the running totals of each object
     */
    public int totalChocolate = 0;
    public int totalCake = 0;
    public int totalWine = 0;
    public int totalRose = 0;
    public int totalCat = 0;


    /**
     * Variables to hold the number of gifts currently given
     */
    public int numCake = 0;
    public int numChocolate = 0;
    public int numWine = 0;
    public int numRose = 0;
    public int numCat = 0;

    public void isSolved()
    {
        ImageView imgGirl = (ImageView) findViewById(R.id.imgGirl);
        if (current == target)
        {
            Log.d("ALERT:", "You win!");

            imgGirl.setImageResource(R.drawable.person1_smiling);
        }
        else
        {
            imgGirl.setImageResource(R.drawable.person1_standing);
            //do nothing
        }
    }

    /**
     * Increase and Decrease the quantity of Chocolate
     */
    public void IncreaseChocolate(View v){
        numChocolate++;
        totalChocolate = totalChocolate + valueChocolate;
        current = current + valueChocolate;
        Log.d("Increase: ", String.valueOf(numChocolate));
        Log.d("Total Chocolate value: ", String.valueOf(totalChocolate));
        TextView textView = (TextView) findViewById(R.id.txtChocolate);
        textView.setText(String.valueOf(numChocolate));

        textView = (TextView) findViewById(R.id.txtCurrentChocolate);
        textView.setText(String.valueOf(totalChocolate));

        textView = (TextView) findViewById(R.id.txtCurrent);
        textView.setText("Current: " + String.valueOf(current));

        isSolved();
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
            totalChocolate = totalChocolate - valueChocolate;
            current = current - valueChocolate;
            Log.d("Decrease: ", String.valueOf(numChocolate));
            TextView textView = (TextView) findViewById(R.id.txtChocolate);
            textView.setText(String.valueOf(numChocolate));

            textView = (TextView) findViewById(R.id.txtCurrentChocolate);
            textView.setText(String.valueOf(totalChocolate));
            Log.d("Total Chocolate value: ", String.valueOf(totalChocolate));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            isSolved();
        }
    }


    /**
     * Increase and Decrease the quantity of Cake
     */
    public void IncreaseCake(View v){
        numCake++;
        totalCake = totalCake + valueCake;
        current = current + valueCake;
        Log.d("Increase: ", String.valueOf(numCake));
        Log.d("Total cake value: ", String.valueOf(totalCake));
        TextView textView = (TextView) findViewById(R.id.txtCake);
        textView.setText(String.valueOf(numCake));

        textView = (TextView) findViewById(R.id.txtCurrentCake);
        textView.setText(String.valueOf(totalCake));

        textView = (TextView) findViewById(R.id.txtCurrent);
        textView.setText("Current: " + String.valueOf(current));

        isSolved();
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
            totalCake = totalCake - valueCake;
            current = current - valueCake;
            Log.d("Decrease: ", String.valueOf(numCake));
            TextView textView = (TextView) findViewById(R.id.txtCake);
            textView.setText(String.valueOf(numCake));
            textView = (TextView) findViewById(R.id.txtCurrentCake);

            textView.setText(String.valueOf(totalCake));
            Log.d("Total cake value: ", String.valueOf(totalCake));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            isSolved();
        }
    }


    /**
     * Increase and Decrease the quantity of Wine
     */
    public void IncreaseWine(View v){
        numWine++;
        totalWine = totalWine + valueWine;
        current = current + valueWine;
        Log.d("Increase: ", String.valueOf(numWine));
        Log.d("Total Wine value: ", String.valueOf(totalWine));
        TextView textView = (TextView) findViewById(R.id.txtWine);
        textView.setText(String.valueOf(numWine));

        textView = (TextView) findViewById(R.id.txtCurrentWine);
        textView.setText(String.valueOf(totalWine));

        textView = (TextView) findViewById(R.id.txtCurrent);
        textView.setText("Current: " + String.valueOf(current));

        isSolved();
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
            totalWine = totalWine - valueWine;
            current = current - valueWine;
            Log.d("Decrease: ", String.valueOf(numWine));
            TextView textView = (TextView) findViewById(R.id.txtWine);
            textView.setText(String.valueOf(numWine));
            textView = (TextView) findViewById(R.id.txtCurrentWine);

            textView.setText(String.valueOf(totalWine));
            Log.d("Total Wine value: ", String.valueOf(totalWine));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            isSolved();
        }
    }


    /**
     * Increase and Decrease the quantity of Rose
     */
    public void IncreaseRose(View v){
        numRose++;
        totalRose = totalRose + valueRose;
        current = current + valueRose;
        Log.d("Increase: ", String.valueOf(numRose));
        Log.d("Total Rose value: ", String.valueOf(totalRose));
        TextView textView = (TextView) findViewById(R.id.txtRose);
        textView.setText(String.valueOf(numRose));

        textView = (TextView) findViewById(R.id.txtCurrentRose);
        textView.setText(String.valueOf(totalRose));

        textView = (TextView) findViewById(R.id.txtCurrent);
        textView.setText("Current: " + String.valueOf(current));

        isSolved();
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
            totalRose = totalRose - valueRose;
            current = current - valueRose;
            Log.d("Decrease: ", String.valueOf(numRose));
            TextView textView = (TextView) findViewById(R.id.txtRose);
            textView.setText(String.valueOf(numRose));
            textView = (TextView) findViewById(R.id.txtCurrentRose);

            textView.setText(String.valueOf(totalRose));
            Log.d("Total Rose value: ", String.valueOf(totalRose));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            isSolved();
        }
    }


    /**
     * Increase and Decrease the quantity of Cat
     */
    public void IncreaseCat(View v){
        numCat++;
        totalCat = totalCat + valueCat;
        current = current + valueCat;
        Log.d("Increase: ", String.valueOf(numCat));
        Log.d("Total Cat value: ", String.valueOf(totalCat));
        TextView textView = (TextView) findViewById(R.id.txtCat);
        textView.setText(String.valueOf(numCat));

        textView = (TextView) findViewById(R.id.txtCurrentCat);
        textView.setText(String.valueOf(totalCat));

        textView = (TextView) findViewById(R.id.txtCurrent);
        textView.setText("Current: " + String.valueOf(current));

        isSolved();
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
            totalCat = totalCat - valueCat;
            current = current - valueCat;
            Log.d("Decrease: ", String.valueOf(numCat));
            TextView textView = (TextView) findViewById(R.id.txtCat);
            textView.setText(String.valueOf(numCat));
            textView = (TextView) findViewById(R.id.txtCurrentCat);

            textView.setText(String.valueOf(totalCat));
            Log.d("Total Cat value: ", String.valueOf(totalCat));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            isSolved();
        }
    }
}
