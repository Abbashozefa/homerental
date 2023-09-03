package com.example.homerental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Rentinglist extends AppCompatActivity {
//    static int j;
//    static  int i;
    EditText zero,one,two;
    int j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentinglist);
        zero = (EditText) findViewById(R.id.zero);
        one = (EditText) findViewById(R.id.one);
        two = (EditText) findViewById(R.id.two);
        String[] houses={"Bunglow","Flat","villa"};
//        houses={"Bunglow","Flat","villa"}
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("/");
//        myRef.child("users").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                }
//                else {
////                    String.valueOf(task.getResult().);
//
////                    int i=0;
////                    Log.e("firebase", );
//                    for(DataSnapshot ds :task.getResult().getChildren()) {
//                        String name = String.valueOf(ds.getKey());
//                        Log.e("firebase", name);
//
//                    }
//                }
//            }
//        });
        String[] loc=new String[3];
        String[] pr=new String[3];
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/");



            myRef.child("users").child(houses[0]).child("location").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    }
                    else {

                        Log.e("firebase", String.valueOf(task.getResult().getValue()));
                        zero.setText(String.valueOf(task.getResult().getValue()));
                    }
                }
            });
            myRef.child("users").child(houses[0]).child("price").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    }
                    else {
                        Log.e("firebase", String.valueOf(task.getResult().getValue()));
                        zero.setText(""+zero.getText()+"\n"+"Price:Rs."+String.valueOf(task.getResult().getValue()));
                    }
                }
            });
        myRef.child("users").child(houses[1]).child("location").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {

                    Log.e("firebase", String.valueOf(task.getResult().getValue()));
                    one.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });
        myRef.child("users").child(houses[1]).child("price").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.e("firebase", String.valueOf(task.getResult().getValue()));
                    one.setText(""+one.getText()+"\n"+"Price:Rs."+String.valueOf(task.getResult().getValue()));
                }
            }
        });
        myRef.child("users").child(houses[2]).child("location").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {

                    Log.e("firebase", String.valueOf(task.getResult().getValue()));
                    two.setText(String.valueOf(task.getResult().getValue()));
                }
            }
        });
        myRef.child("users").child(houses[2]).child("price").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.e("firebase", String.valueOf(task.getResult().getValue()));
                    two.setText(""+two.getText()+"\n"+"Price:Rs"+String.valueOf(task.getResult().getValue()));
                }
            }
        });

//            zero.setText(loc[0]+pr[0]);
//            one.setText(loc[1]+pr[1]);
//            two.setText(loc[2]+pr[2]);


    }
}