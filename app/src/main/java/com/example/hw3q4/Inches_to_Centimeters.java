package com.example.hw3q4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Inches_to_Centimeters extends AppCompatActivity
{
    //create edit texts and text views
    private EditText inputInches;
    private EditText inputCentimeters;
    private TextView outputInches;
    private TextView outputCentimeters;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //display screen
        setContentView(R.layout.activity_inches_to_centimeters);

        //create TechChangeHandler object , a text watcher
        TextChangeHandler watcher = new TextChangeHandler();

        //accessing the edit texts and text view , adding a text wathcer
        inputInches = findViewById(R.id.edtTxtInches);
        inputInches.addTextChangedListener(watcher);

        inputCentimeters = findViewById(R.id.edtTxtCentiMeters);
        inputCentimeters.addTextChangedListener(watcher);

        outputInches = findViewById(R.id.txtViewInches);

        outputCentimeters = findViewById(R.id.txtViewCentiMeters);

    }

    //a class that handle text changes
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
            //-number of miles entered
            String strInches = inputInches.getText().toString();
            double numInches;
            try
            {
                numInches = Double.parseDouble(strInches);
            }
            catch (NumberFormatException e)
            {
                numInches = 0 ;
            }

            //convert from Inches to Centimeters
            double inchesTOcm = numInches * 2.54;

            //display Inches to Centimeters
            if(inchesTOcm != 0) //if the current value is  not zero
                outputCentimeters.setText(String.format("%.2f",inchesTOcm));
            else //else display km
                outputCentimeters.setText("Cm");



            //-number of kilometers entered
            String strCentimeter = inputCentimeters.getText().toString();
            double numCentimeters;
            try
            {
                numCentimeters = Double.parseDouble(strCentimeter);
            } catch (NumberFormatException e)
            {
                numCentimeters = 0 ;
            }

            //convert from Centimeter to Inches
            double centimeterTOinches = numCentimeters / 2.54;

            //display how many miles in kilometers
            if(centimeterTOinches!=0) //if the current value is not zero
                outputInches.setText(String.format("%.2f",centimeterTOinches));
            else //else display Miles
                outputInches.setText("Miles");

        }
    }

    //event handler ends the current screen
    public void back(View view)
    {
        finish();
    }
}
