package com.example.hw3q4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Miles_to_Kilometers extends AppCompatActivity
{

    //create edit texts and text views
    private EditText inputMiles;
    private EditText inputKilometers;
    private TextView outputMiles;
    private TextView outputKilometers;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //display screen
        setContentView(R.layout.activity_milekilometers);

        //create TechChangeHandler object , a text watcher
        TextChangeHandler watcher = new TextChangeHandler();

        //accessing the edit texts and text view , adding a text wathcer
        inputMiles = findViewById(R.id.edtTxtMile);
        inputMiles.addTextChangedListener(watcher);

        inputKilometers = findViewById(R.id.edtTxtKilometers);
        inputKilometers.addTextChangedListener(watcher);

        outputMiles = findViewById(R.id.txtViewMiles);

        outputKilometers = findViewById(R.id.txtViewKilometers);

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
            String strMiles = inputMiles.getText().toString();
            double inputMiles;
            try
            {
                inputMiles = Double.parseDouble(strMiles);
            }
            catch (NumberFormatException e)
            {
                inputMiles = 0 ;
            }

            //convert from miles to kilometers
            double mileInKm = inputMiles * 1.609;

            //display how many kilometers in mile
            if(mileInKm != 0) //if the current value is  not zero
                outputKilometers.setText(String.format("%.2f",mileInKm)+" Km");
            else //else display km
                outputKilometers.setText("Km");



            //-number of kilometers entered
            String strKilometers = inputKilometers.getText().toString();
            double inputKilometers;
            try
            {
                inputKilometers = Double.parseDouble(strKilometers);
            } catch (NumberFormatException e)
            {
                inputKilometers = 0 ;
            }

            //convert from kilometers to miles
            double kmInMiles = inputKilometers / 1.609;

            //display how many miles in kilometers
            if(kmInMiles!=0) //if the current value is not zero
                outputMiles.setText(String.format("%.2f",kmInMiles)+" Mi");
            else //else display Miles
                 outputMiles.setText("Miles");

        }
    }

    //event handler ends the current screen
    public void back(View view)
    {
        finish();
    }
}
