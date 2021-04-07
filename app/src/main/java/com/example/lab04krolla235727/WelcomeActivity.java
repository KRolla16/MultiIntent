package com.example.lab04krolla235727;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class WelcomeActivity extends AppCompatActivity {

    ImageButton btnGoNext;
    EditText editTextName, editTextIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


         editTextName= (EditText)findViewById(R.id.editTextTextPersonName);
         editTextIndex= (EditText)findViewById(R.id.editTextTextPersonIndex);
         btnGoNext = (ImageButton)findViewById(R.id.imageButton);

        btnGoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName  = editTextName.getText().toString();
                String index = editTextIndex.getText().toString();
                Intent intent = new Intent (WelcomeActivity.this, MainActivity3.class);
                if (uName.isEmpty() && index.isEmpty() ){
                    intent.putExtra("username","Anonymous");
                    intent.putExtra("indexNumber","empty");
                }else{
                intent.putExtra("username",editTextName.getText().toString());
                intent.putExtra("indexNumber",editTextIndex.getText().toString());
                }
                startActivity(intent);
            }
        });
    }
}