package com.example.hw3q4;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hw3q4.databinding.ActivityMainBinding;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //display screen
        setContentView(R.layout.activity_main);

        //display too bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }



    //Method displays menu
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

        //if mile to kilometers selected
        if (id == R.id.milesTOkilometers)
        {
            //start miles to kilometers activity
            Intent mileKilmeterActivty = new Intent(this,Miles_to_Kilometers.class);
            startActivity(mileKilmeterActivty);
        }
        //if feet to meters selected
        else if (id == R.id.feetTOmeters)
        {
            //start feet to meters screen
            Intent feetTometersActivity = new Intent(this,Feet_to_Meters.class);
            startActivity(feetTometersActivity);
        }
        //if Inches to Centimeters selected
        else if (id == R.id.inchesTOcentimeters)
        {
            //start Inches to centimeters screen
            Intent inchesCentimetersActivity = new Intent(this,Inches_to_Centimeters.class);
            startActivity(inchesCentimetersActivity);
        }

        return super.onOptionsItemSelected(item);
    }


}