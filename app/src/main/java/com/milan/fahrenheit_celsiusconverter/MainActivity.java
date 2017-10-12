package com.milan.fahrenheit_celsiusconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;


import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.milan.fahrenheit_celsiusconverter.R.id.convertButton;
import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    Button convertButton;
    Button clearButton;

    TextView celsiusText;
    TextView fahrenheitText;
    EditText celsius;
    EditText fahrenheit;
    final double CONVERSION_CONSTANT1 = 1.8;
    final int CONVERSION_CONSTANT2 = 32;
    final double CONVERSION_CONSTANT3 = 0.5556;
    double celsiusResult;
    double fahrenheitResult;
    double celsiusValue;
    double fahrenheitValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertButton = (Button) findViewById(R.id.convertButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        fahrenheitText = (TextView) findViewById(R.id.textViewFahrenheit);
        celsiusText = (TextView) findViewById(R.id.textViewCelsius);
        celsius = (EditText) findViewById(R.id.celsiusValue);
        fahrenheit = (EditText) findViewById(R.id.fahrenheitValue);


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if (fahrenheit.getText().toString().isEmpty()) {

                        celsiusValue = Double.parseDouble(celsius.getText().toString());

                        fahrenheitResult = (celsiusValue * CONVERSION_CONSTANT1) + CONVERSION_CONSTANT2;

                        fahrenheit.setText(String.valueOf(fahrenheitResult));

                    } else if (celsius.getText().toString().isEmpty()) {

                        fahrenheitValue = Double.parseDouble(fahrenheit.getText().toString());

                        celsiusResult = (fahrenheitValue - CONVERSION_CONSTANT2) * CONVERSION_CONSTANT3;

                        celsius.setText(String.valueOf(celsiusResult));


                    }
                } catch (NumberFormatException e) {

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("You must enter Celsius or Fahrenheit value!");
                    alertDialog.setCancelable(true);
                    alertDialog.show();


                }


            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                celsius.setText(null);
                fahrenheit.setText(null);
            }
        });
    }
}
