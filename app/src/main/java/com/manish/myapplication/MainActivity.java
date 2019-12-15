package com.manish.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView backArrow, settings, voice, cart, car;
    private EditText nameEdtTxt, emailEdttxt, descriptionEdtTxt, websiteEdtTxt;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private Button button;

    private String country = "";
    private ArrayList<String> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();


        //ArrayList for Spinner

        countries = new ArrayList<>();
        countries.add("United States");
        countries.add("United Kingdom");
        countries.add("Australia");
        countries.add("Canada");

        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this, android.R.layout.simple_spinner_dropdown_item,countries);
        spinner.setAdapter(adapter);


        initOnClickListeners();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishRegistering();

            }
        });


    }

    private void initWidgets(){
        backArrow = findViewById(R.id.backArrow);
        settings = findViewById(R.id.settings);
        voice = findViewById(R.id.voice);
        cart = findViewById(R.id.cart);
        car = findViewById(R.id.car);

        nameEdtTxt = findViewById(R.id.name);
        emailEdttxt = findViewById(R.id.email);
        descriptionEdtTxt = findViewById(R.id.description);
        websiteEdtTxt = findViewById(R.id.websiteTxt);

        spinner = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.rgGroup);
        button = findViewById(R.id.btnSubmit);



    }

    private void finishRegistering(){
        String name = nameEdtTxt.getText().toString();
        String email = emailEdttxt.getText().toString();
        String description = descriptionEdtTxt.getText().toString();
        String website = websiteEdtTxt.getText().toString();

        String gender ="";
        int checkedRb = radioGroup.getCheckedRadioButtonId();

        switch (checkedRb){
            case R.id.rbMale:
                gender = "Male";
                break;

            case R.id.rbFemale:
                gender = "Female";
                break;

            case R.id.rbOther:
                gender = "Other";
                break;
                default:
                    break;

        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country = countries.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                country = "No Country Selected";
            }
        });

        String finalMessage = "Name: "+ name + "\nEmail: " + email + "\nDescription: " + description + "\nWebsite: " + website;

        Toast.makeText(MainActivity.this,finalMessage,Toast.LENGTH_SHORT).show();
    }

    private void  initOnClickListeners() {
    backArrow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Back Arrow Tapped", Toast.LENGTH_SHORT).show();
        }
    });

    settings.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Settings Tapped", Toast.LENGTH_SHORT).show();
        }
    });

    voice.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Voice Tapped", Toast.LENGTH_SHORT).show();

        }
    });

    car.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Voice Tapped", Toast.LENGTH_SHORT).show();
        }
    });

    cart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Cart Tapped", Toast.LENGTH_SHORT).show();
        }
    });
    }
}
