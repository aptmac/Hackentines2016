package com.example.norifurikake.hackenties2016;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends ActionBarActivity {

    /**
     * Variables to hold the target goal and current progress
     */
    private int target = 0;
    private int current = 0;
    private int valueChocolate = 0;
    private int valueCake = 0;
    private int valueWine = 0;
    private int valueRose = 0;
    private int valueCat = 0;

    /**
     * Variables to hold the number of gifts currently given
     */
    private int numCake = 0;
    private int numChocolate = 0;
    private int numWine = 0;
    private int numRose = 0;
    private int numCat = 0;

    /**
     * Variables to hold the running totals of each object
     */
    private int totalChocolate = 0;
    private int totalCake = 0;
    private int totalWine = 0;
    private int totalRose = 0;
    private int totalCat = 0;

    /**
     * Variables to hold the maximum quantity of each object
     */
    private int maxChocolate = 0;
    private int maxCake = 0;
    private int maxWine = 0;
    private int maxRose = 0;
    private int maxCat = 0;

    private int lucy = 0;

    //Set up the variables and the game screen
    public void Initialize() {
        //Reset the global variables & textViews
        this.current = 0;
        this.numChocolate = this.numCake = this.numWine = this.numRose = this.numCat = 0;
        this.totalChocolate = this.totalCake = this.totalWine = this.totalRose = this.totalCat = 0;
        this.maxChocolate = this.maxCake = this.maxWine = this.maxRose = this.maxCat = 0;

        //Remove Lucy's heart :(
        ImageView imgView = (ImageView)findViewById(R.id.imgGirlHeart);
        imgView.setVisibility(View.GONE);

        //Determine which Lucy gets printed to the screen
        this.lucy = (int)(Math.random()*(5-1)+1);
        Log.d("Lucy:",String.valueOf(this.lucy));
        drawStanding();

        //Reset all textViews
        TextView textView = (TextView) findViewById(R.id.txtCurrent);
        textView.setText("Current: " + String.valueOf(current));
        textView = (TextView) findViewById(R.id.txtCurrentChocolate);
        textView.setText(String.valueOf(totalChocolate));
        textView = (TextView) findViewById(R.id.txtCurrentCake);
        textView.setText(String.valueOf(totalCake));
        textView = (TextView) findViewById(R.id.txtCurrentWine);
        textView.setText(String.valueOf(totalWine));
        textView = (TextView) findViewById(R.id.txtCurrentRose);
        textView.setText(String.valueOf(totalRose));
        textView = (TextView) findViewById(R.id.txtCurrentCat);
        textView.setText(String.valueOf(totalCat));

        textView = (TextView) findViewById(R.id.txtChocolate);
        textView.setText(String.valueOf(numChocolate));
        textView = (TextView) findViewById(R.id.txtCake);
        textView.setText(String.valueOf(numCake));
        textView = (TextView) findViewById(R.id.txtWine);
        textView.setText(String.valueOf(numWine));
        textView = (TextView) findViewById(R.id.txtRose);
        textView.setText(String.valueOf(numRose));
        textView = (TextView) findViewById(R.id.txtCat);
        textView.setText(String.valueOf(numCat));

        //Reset the counters on the buttons
        Button button = (Button)findViewById(R.id.btnChocolateIncrease);
        button.setText(String.valueOf(5));
        button = (Button)findViewById(R.id.btnCakeIncrease);
        button.setText(String.valueOf(5));
        button = (Button)findViewById(R.id.btnWineIncrease);
        button.setText(String.valueOf(5));
        button = (Button)findViewById(R.id.btnRoseIncrease);
        button.setText(String.valueOf(5));
        button = (Button)findViewById(R.id.btnCatIncrease);
        button.setText(String.valueOf(5));

        //Get the difficulty passed from the previous activity
        Intent intent = getIntent();
        String difficultyIntent = intent.getStringExtra("difficulty");
        int difficulty = Integer.parseInt(difficultyIntent);

        //Initialize base values for the objects & update the activity form
        this.valueChocolate = 1 + difficulty*(int)(Math.random()*(difficulty-1)+1);
        textView = (TextView) findViewById(R.id.txtPerChocolate);
        textView.setText(String.valueOf(valueChocolate));

        this.valueCake = 5 + difficulty*(int)(Math.random()*(difficulty-1)+1);
        textView = (TextView) findViewById(R.id.txtPerCake);
        textView.setText(String.valueOf(valueCake));

        this.valueWine = 10 + difficulty*(int)(Math.random()*(difficulty-1)+1);
        textView = (TextView) findViewById(R.id.txtPerWine);
        textView.setText(String.valueOf(valueWine));

        this.valueRose = 25 + difficulty*(int)(Math.random()*(difficulty-1)+1);
        textView = (TextView) findViewById(R.id.txtPerRose);
        textView.setText(String.valueOf(valueRose));

        this.valueCat = 50 + difficulty*(int)(Math.random()*(difficulty-1)+1);
        textView = (TextView) findViewById(R.id.txtPerCat);
        textView.setText(String.valueOf(valueCat));

        //Initialize the current target value
        target = generateTarget();
        textView = (TextView) findViewById(R.id.txtTarget);
        textView.setText("Target: " + String.valueOf(target));
    }

    //Generates the target happiness for Lucy
    public int generateTarget()
    {
        int low = 0;
        int high = 6;

        this.maxChocolate = (int)(Math.random()*(high-low)+low);
        Log.d("Chocolate: ", String.valueOf(this.maxChocolate));
        this.maxCake = (int)(Math.random()*(high-low)+low);
        Log.d("Cake: ", String.valueOf(this.maxCake));
        this.maxWine = (int)(Math.random()*(high-low)+low);
        Log.d("Wine: ", String.valueOf(this.maxWine));
        this.maxRose = (int)(Math.random()*(high-low)+low);
        Log.d("Rose: ", String.valueOf(this.maxRose));
        this.maxCat = (int)(Math.random()*(high-low)+low);
        Log.d("Cat: ", String.valueOf(this.maxCat));

        int total = valueChocolate*this.maxChocolate
                + valueCake*this.maxCake
                + valueWine*this.maxWine
                + valueRose*this.maxRose
                + valueCat*this.maxCat;
        return total;
    }

    //Draws the appropriate non-smiling Lucy to the screen
    public void drawStanding(){
        ImageView imgView;

        if (this.lucy == 1){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person1_standing);
        }else if (this.lucy == 2){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person2_standing);
        }else if (this.lucy == 3){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person3_standing);
        }else if (this.lucy == 4){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person4_standing);
        }else if (this.lucy == 5){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person5_standing);
        }
    }

    //Draws the appropriate smiling Lucy to the screen
    public void drawSmile()
    {
        ImageView imgView;

        if (this.lucy == 1){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person1_smiling);
        }else if (this.lucy == 2){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person2_smiling);
        }else if (this.lucy == 3){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person3_smiling);
        }else if (this.lucy == 4){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person4_smiling);
        }else if (this.lucy == 5){
            imgView = (ImageView)findViewById(R.id.imgGirl);
            imgView.setImageResource(R.drawable.person5_smiling);
        }
    }

    //Function to check if the problem has been solved
    public void isSolved()
    {
        //If the user has completed the puzzle ...
        if (current == target)
        {
            //Display the smiling Girl
            drawSmile();
            ImageView imgHeart = (ImageView) findViewById(R.id.imgGirlHeart);
            imgHeart.setVisibility(View.VISIBLE);

            //When the game is over, ask the user if they'd like a new game, if so, Initialize()
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Congrats! You gave Lucy a Happy Valentines day!\nWould you like to start a new game?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                            Initialize();
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
        else
        {
            //Girl is not smiling
            //do nothing else
        }
    }

    //Sets the button-clicks to vibrate
    public void vibrate() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(20);
    }

    /**
     * Increase and Decrease the quantity of Chocolate
     */
    public void IncreaseChocolate(View v){
        vibrate();
        if (numChocolate == 5)
        {
            //do nothing
        }
        else
        {
            //Increase the quantities
            numChocolate++;
            totalChocolate = totalChocolate + valueChocolate;
            current = current + valueChocolate;

            //Update all textviews & Button Text
            TextView textView = (TextView) findViewById(R.id.txtChocolate);
            textView.setText(String.valueOf(numChocolate));

            textView = (TextView) findViewById(R.id.txtCurrentChocolate);
            textView.setText(String.valueOf(totalChocolate));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnChocolateIncrease);
            button.setText(String.valueOf(5 - numChocolate));

            //Check to see if the user has completed the puzzle
            isSolved();
        }
    }
    public void DecreaseChocolate(View v){
        vibrate();
        if (numChocolate == 0)
        {
            //do nothing
        }
        else
        {
            //Decrease the correct amount from the current total
            numChocolate--;
            totalChocolate = totalChocolate - valueChocolate;
            current = current - valueChocolate;

            //Update the textviews
            TextView textView = (TextView) findViewById(R.id.txtChocolate);
            textView.setText(String.valueOf(numChocolate));

            textView = (TextView) findViewById(R.id.txtCurrentChocolate);
            textView.setText(String.valueOf(totalChocolate));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnChocolateIncrease);
            button.setText(String.valueOf(5 - numChocolate));

            //Check to see if the user has solved the puzzle
            isSolved();
        }
    }


    /**
     * Increase and Decrease the quantity of Cake
     */
    public void IncreaseCake(View v){
        vibrate();
        if (numCake == 5)
        {
            //do nothing
        }
        else
        {
            //Increase the quantities
            numCake++;
            totalCake = totalCake + valueCake;
            current = current + valueCake;

            //Update all textviews
            TextView textView = (TextView) findViewById(R.id.txtCake);
            textView.setText(String.valueOf(numCake));

            textView = (TextView) findViewById(R.id.txtCurrentCake);
            textView.setText(String.valueOf(totalCake));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnCakeIncrease);
            button.setText(String.valueOf(5 - numCake));

            //Check to see if the user has completed the puzzle
            isSolved();
        }
    }
    public void DecreaseCake(View v){
        vibrate();
        if (numCake == 0)
        {
            //do nothing
        }
        else
        {
            //Decrease the correct amount from the current total
            numCake--;
            totalCake = totalCake - valueCake;
            current = current - valueCake;

            //Update the textviews
            TextView textView = (TextView) findViewById(R.id.txtCake);
            textView.setText(String.valueOf(numCake));

            textView = (TextView) findViewById(R.id.txtCurrentCake);
            textView.setText(String.valueOf(totalCake));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnCakeIncrease);
            button.setText(String.valueOf(5 - numCake));

            //Check to see if the user has solved the puzzle
            isSolved();
        }
    }


    /**
     * Increase and Decrease the quantity of Wine
     */
    public void IncreaseWine(View v){
        vibrate();
        if (numWine == 5)
        {
            //do nothing
        }
        else
        {
            //Increase the quantities
            numWine++;
            totalWine = totalWine + valueWine;
            current = current + valueWine;

            //Update all textviews
            TextView textView = (TextView) findViewById(R.id.txtWine);
            textView.setText(String.valueOf(numWine));

            textView = (TextView) findViewById(R.id.txtCurrentWine);
            textView.setText(String.valueOf(totalWine));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnWineIncrease);
            button.setText(String.valueOf(5 - numWine));

            //Check to see if the user has completed the puzzle
            isSolved();
        }
    }
    public void DecreaseWine(View v){
        vibrate();
        if (numWine == 0)
        {
            //do nothing
        }
        else
        {
            //Decrease the correct amount from the current total
            numWine--;
            totalWine = totalWine - valueWine;
            current = current - valueWine;

            //Update the textviews
            TextView textView = (TextView) findViewById(R.id.txtWine);
            textView.setText(String.valueOf(numWine));

            textView = (TextView) findViewById(R.id.txtCurrentWine);
            textView.setText(String.valueOf(totalWine));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnWineIncrease);
            button.setText(String.valueOf(5 - numWine));

            //Check to see if the user has solved the puzzle
            isSolved();
        }
    }


    /**
     * Increase and Decrease the quantity of Rose
     */
    public void IncreaseRose(View v){
        vibrate();
        if (numRose == 5)
        {
            //do nothing
        }
        else
        {
            //Increase the quantities
            numRose++;
            totalRose = totalRose + valueRose;
            current = current + valueRose;

            //Update all textviews
            TextView textView = (TextView) findViewById(R.id.txtRose);
            textView.setText(String.valueOf(numRose));

            textView = (TextView) findViewById(R.id.txtCurrentRose);
            textView.setText(String.valueOf(totalRose));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnRoseIncrease);
            button.setText(String.valueOf(5 - numRose));

            //Check to see if the user has completed the puzzle
            isSolved();
        }
    }
    public void DecreaseRose(View v){
        vibrate();
        if (numRose == 0)
        {
            //do nothing
        }
        else
        {
            //Decrease the correct amount from the current total
            numRose--;
            totalRose = totalRose - valueRose;
            current = current - valueRose;

            //Update the textviews
            TextView textView = (TextView) findViewById(R.id.txtRose);
            textView.setText(String.valueOf(numRose));

            textView = (TextView) findViewById(R.id.txtCurrentRose);
            textView.setText(String.valueOf(totalRose));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnRoseIncrease);
            button.setText(String.valueOf(5 - numRose));

            //Check to see if the user has solved the puzzle
            isSolved();
        }
    }


    /**
     * Increase and Decrease the quantity of Cat
     */
    public void IncreaseCat(View v){
        vibrate();
        if (numCat == 5)
        {
            //do nothing
        }
        else
        {
            //Increase the quantities
            numCat++;
            totalCat = totalCat + valueCat;
            current = current + valueCat;

            //Update all textviews
            TextView textView = (TextView) findViewById(R.id.txtCat);
            textView.setText(String.valueOf(numCat));

            textView = (TextView) findViewById(R.id.txtCurrentCat);
            textView.setText(String.valueOf(totalCat));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnCatIncrease);
            button.setText(String.valueOf(5 - numCat));

            //Check to see if the user has completed the puzzle
            isSolved();
        }
    }
    public void DecreaseCat(View v){
        vibrate();
        if (numCat == 0)
        {
            //do nothing
        }
        else
        {
            //Decrease the correct amount from the current total
            numCat--;
            totalCat = totalCat - valueCat;
            current = current - valueCat;

            //Update the textviews
            TextView textView = (TextView) findViewById(R.id.txtCat);
            textView.setText(String.valueOf(numCat));

            textView = (TextView) findViewById(R.id.txtCurrentCat);
            textView.setText(String.valueOf(totalCat));

            textView = (TextView) findViewById(R.id.txtCurrent);
            textView.setText("Current: " + String.valueOf(current));

            Button button = (Button)findViewById(R.id.btnCatIncrease);
            button.setText(String.valueOf(5 - numCat));

            //Check to see if the user has solved the puzzle
            isSolved();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Lonely Lucy on Valentines");
        Initialize();
    }
}
