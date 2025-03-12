package com.example.hw3q4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Feet_to_Meters extends AppCompatActivity
{
    private EditText inputFeet;
    private EditText inputMeters;
    private TextView outputFeet;
    private TextView outputMeter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //display screen
        setContentView(R.layout.activity_feet_to_meeter);

        //create TechChangeHandler object , a text watcher
        TextChangeHandler watcher = new TextChangeHandler();

        //accessing the edit texts and text view , adding a text watcher
        inputMeters = findViewById(R.id.edtTxtMeters);
        inputMeters.addTextChangedListener(watcher);

        inputFeet = findViewById(R.id.edtTxtFeet);
        inputFeet.addTextChangedListener(watcher);

        outputFeet = findViewById(R.id.txtViewFeet);
        outputMeter = findViewById(R.id.txtViewMeters);
    }

    ////a class that handle text changes
    public class TextChangeHandler implements TextWatcher
    {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s)
        {
            //get the number of feets
            String strFeet = inputFeet.getText().toString();
            double inputFeet;
            try
            {
                 inputFeet = Double.parseDouble(strFeet);
            }
            catch (NumberFormatException e)
            {
                inputFeet = 0 ;
            }

            //convert feet to meters
            double feetInMeters = inputFeet * 0.3048;

            //display how many feet in meter
            if(feetInMeters != 0) // if the current value is not zero , display
                outputMeter.setText(String.format("%.2f",feetInMeters));
            else //else display Meters
                outputMeter.setText("Meters");




            //get the number of meters
            String strMeters = inputMeters.getText().toString();
            double inputMeters;
            try
            {
                inputMeters = Double.parseDouble(strMeters);
            }
            catch (NumberFormatException e)
            {
                inputMeters = 0;
            }

            //convert meters to feet
            double meterInFeet = inputMeters * 3.281;

            //display how many meter in feet
            if(meterInFeet!=0)// if the current value is not zero , display
                outputFeet.setText(String.format("%.2f",meterInFeet));
            else //else display feet
                outputFeet.setText("Feet");
        }
    }

    //event handler that ends current screen
    public void back(View view)
    {
        finish();
    }
}