package com.example.lab04krolla235727;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LocationActivity extends AppCompatActivity {

    EditText editLenght, editWidth;
    Button btnFindLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);



        editLenght= (EditText)findViewById(R.id.editTextTextLenght);
        editWidth= (EditText)findViewById(R.id.editTextTextWidth);
        btnFindLocation = (Button) findViewById(R.id.buttonLocation);


        btnFindLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String localization = "google.streetview:" + editLenght.getText().toString() + "," + editWidth.getText().toString();
                Uri gmmIntentUri = Uri.parse(localization);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }
}