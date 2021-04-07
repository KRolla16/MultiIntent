package com.example.lab04krolla235727;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    ImageButton btnLocate, btnContact, btnYoutube;
    Button buttonWeb, btnInternet, btnLocationActivity;
    EditText editWeb;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnLocate = (ImageButton)findViewById(R.id.buttonLocate);
        btnContact = (ImageButton)findViewById(R.id.buttonContacts);
        btnYoutube = (ImageButton)findViewById(R.id.buttonYoutube);
        buttonWeb = (Button)findViewById(R.id.buttonWeb);
        btnInternet = (Button)findViewById(R.id.buttonInternet);
        editWeb = (EditText)findViewById(R.id.editTextTextWeb);
        btnLocationActivity= (Button)findViewById(R.id.buttonAnotherActivity);
        txtName = (TextView)findViewById(R.id.textView);
        txtName.setText("Welcome, "+getIntent().getExtras().getString("username")+"\n your Index number is " +
                getIntent().getExtras().getString("indexNumber"));

        btnLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll= 51.0919969,17.0343117,14");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myData = "content://contacts/people";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
                startActivity(intent);
            }
        });


        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String youtube = "https://www.youtube.com/user/pwrmojeklimaty";
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, youtube);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwr = "https://pwr.edu.pl/";
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, pwr);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


        btnInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String web = editWeb.getText().toString();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, web);
                startActivity(intent);
            }
        });


        btnLocationActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity3.this, LocationActivity.class);
                startActivity(intent);
            }
        });
    }
}