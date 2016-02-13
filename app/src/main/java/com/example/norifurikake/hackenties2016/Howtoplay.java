package com.example.norifurikake.hackenties2016;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class Howtoplay extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtoplay);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("How to Play");
    }
}
