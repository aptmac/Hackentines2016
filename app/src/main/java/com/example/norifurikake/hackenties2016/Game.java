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

    //Set up the variables and the game screen
    public void Initialize() {
        //Initialize the current target value
        target = 100;
        TextView textView = (TextView) findViewById(R.id.txtTarget);
        textView.setText("Target: " + String.valueOf(target));

        //Display the Girl to the Screen
        ImageView imgGirl = (ImageView) findViewById(R.id.imgGirl);
        imgGirl.setImageResource(R.drawable.person1_standing);

        //Initialize base values for the objects & update the activity form
        this.valueChocolate = 1;
        textView = (TextView) findViewById(R.id.txtPerChocolate);
        textView.setText(String.valueOf(valueChocolate));
        this.valueCake = 5;
        textView = (TextView) findViewById(R.id.txtPerCake);
        textView.setText(String.valueOf(valueCake));
        this.valueWine = 10;
        textView = (TextView) findViewById(R.id.txtPerWine);
        textView.setText(String.valueOf(valueWine));
        this.valueRose = 25;
        textView = (TextView) findViewById(R.id.txtPerRose);
        textView.setText(String.valueOf(valueRose));
        this.valueCat = 50;
        textView = (TextView) findViewById(R.id.txtPerCat);
        textView.setText(String.valueOf(valueCat));
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
     * Variables to hold the number of gifts currently given
     */
    public int numCake = 0;
    public int numChocolate = 0;
    public int numWine = 0;
    public int numRose = 0;
    public int numCat = 0;

    /**
     * Variables to hold the running totals of each object
     */
    public int totalChocolate = 0;
    public int totalCake = 0;
    public int totalWine = 0;
    public int totalRose = 0;
    public int totalCat = 0;


    //Function to check if the problem has been solved
    public void isSolved()
    {
        //Create a local ImageView variable
        ImageView imgGirl = (ImageView) findViewById(R.id.imgGirl);

        //If the user has completed the puzzle ...
        if (current == target)
        {
            Log.d("ALERT:", "You win!");

            //Display the smiling Girl
            imgGirl.setImageResource(R.drawable.person1_smiling);
        }
        else
        {
            //Girl is not smiling
            imgGirl.setImageResource(R.drawable.person1_standing);
            //do nothing else
        }
    }

    /**
     * Increase and Decrease the quantity of Chocolate
     */
    public void IncreaseChocolate(View v){
        //Increase the quantities
        numChocolate++;
        totalChocolate = totalChocolate + valueChocolate;
        current = current + valueChocolate;
        Log.d("Increase: ", String.valueOf(numChocolate));
        Log.d("Total Chocolate value: ", String.valueOf(totalChocolate));

        //Update all textviews
        TextView textView = (TextView) findViewById(R.id.txtChocolate);
        textView.setText(String.valueOf(numChocolate));

        textView = (TextView) findViewById(R.id.txtCurrentChocolate);
        textView.setText(String.valueOf(totalChocolate));

        textView = (TextView) findViewById(R.id.txtCurrent);
        textView.setText("Current: " + String.valueOf(current));

        //Check to see if the user has completed the puzzle
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
            //Decrease the correct amount from the current total
            numChocolate--;
            totalChocolate = totalChocolate - valueChocolate;
            current = current - valueChocolate;
            Log.d("Decrease: ", String.valueOf(numChocolate));

            //Update the textviews
            TextView textView = (TextView) findViewById(R.id.txtChocolate);
            textView.setText(String.valueOf(numChocolate));

            textView = (TextView) findViewById(R.id.txtCurrentChocolate);
            textView.setText(String.valueOf(totalChocolate));
            Log.d("Total Chocolate value: ", String.valueOf(totalChocolate));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            //Check to see if the user has solved the puzzle
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
