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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class AskActivity extends AppCompatActivity {
    public final static String PREF_NAME = "net.tobysullivan.mynameapp.PREF_NAME";
    public final static String PREF_FILE = "net.tobysullivan.mynameapp.SHARED_PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (hasName()) {
            launchHelloActivity();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void onBtnSaveClick(View v) {
        saveName();
        launchHelloActivity();
    }

    private void launchHelloActivity() {
        Intent intent = new Intent(this, HelloActivity.class);
        startActivity(intent);
    }

    private void saveName() {
        EditText editText = (EditText) findViewById(R.id.editName);
        String name = editText.getText().toString();
        setName(name);
    }

    private void setName(String name) {
        SharedPreferences sharedPref = getPreferences();
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(PREF_NAME, name);
        editor.commit();
    }

    private boolean hasName() {
        SharedPreferences sharedPref = getPreferences();
        return sharedPref.contains(PREF_NAME);
    }

    private SharedPreferences getPreferences() {
        return this.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
    }
}
