package com.example.homerental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Listing extends AppCompatActivity {
    Button listhouse;
    EditText housename1,location1,price1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        housename1 = (EditText)findViewById(R.id.housename);
        location1 = (EditText)findViewById(R.id.location);
        price1 = (EditText)findViewById(R.id.price);
        listhouse=(Button)findViewById(R.id.listhouse);
        listhouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String housename=housename1.getText().toString();
                String location=location1.getText().toString();
                String price=price1.getText().toString();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("/");

                myRef.child("users").child(housename).child("location").setValue(location);
                myRef.child("users").child(housename).child("price").setValue(Integer.parseInt(price));
                Toast.makeText(Listing.this, "House is Listed on the market",
                        Toast.LENGTH_LONG).show();
                housename1.setText("");
                location1.setText("");
                price1.setText("");

            }
        });
    }
}