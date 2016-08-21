package net.tobysullivan.mynameapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String name = getName();

        TextView txt = (TextView) findViewById(R.id.txtGreeting);
        txt.setText("Hello, "+name+"!");
    }



    private String getName() {
        SharedPreferences sharedPref = getPreferences();
        return sharedPref.getString(AskActivity.PREF_NAME, null);
    }


    private SharedPreferences getPreferences() {
        return this.getSharedPreferences(AskActivity.PREF_FILE, Context.MODE_PRIVATE);
    }

}
