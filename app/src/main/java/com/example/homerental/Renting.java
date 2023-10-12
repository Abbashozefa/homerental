package com.example.homerental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Renting extends AppCompatActivity {
    Button search;
    EditText loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renting);
        search=(Button)findViewById(R.id.search);
        loc = (EditText) findViewById(R.id.loc);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = loc.getText().toString();
                Intent intent = new Intent(Renting.this, com.example.homerental.Rentinglist.class);
                intent.putExtra("loc",location);
                startActivity(intent);

            }
        });
    }
}