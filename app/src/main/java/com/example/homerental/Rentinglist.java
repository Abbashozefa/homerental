package com.example.homerental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.List;

public class Rentinglist extends AppCompatActivity {
//    static int j;
//    static  int i;
    TextView zero,one,two;
    Button uno,dos,tres;

    int j=0;
//    ArrayList<String> list= new ArrayList<String>(10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentinglist);
        zero = (TextView) findViewById(R.id.zero);
        one = (TextView) findViewById(R.id.one);
        two = (TextView) findViewById(R.id.two);
        uno = (Button) findViewById(R.id.uno);
        dos = (Button) findViewById(R.id.dos);
        tres = (Button) findViewById(R.id.tres);
        String loc=getIntent().getStringExtra("loc");
//        String[] list=new String[100];

//        String key1,key2,key3;
//        DatabaseReference rootref = FirebaseDatabase.getInstance().getReference("/users");
//        ValueEventListener valueeventlistener = new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot datasnapshot) {
//
//                for(DataSnapshot ds : datasnapshot.getChildren()) {
//                    if(j==0)
//                    {
//                        String key = ds.getKey();
//                        key1=key;
//                        j++;
//                        Log.d("firebase", key);
//                    }
////                    String key = ds.getKey();
////                    list.add(j,key);
////                    j++;
////                    Log.d("firebase", key);
//                    if(j==1)
//                    {
//                        String key = ds.getKey();
//                        key2=key;
//                        j++;
//                        Log.d("firebase", key);
//
//                    }
//                    if(j==2)
//                    {
//                        String key = ds.getKey();
//                        key3=key;
//                        j++;
//                        Log.d("firebase", key);
//                        break;
//                    }
//
//                }
//
//                //do what you need to do with your list
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseerror) {
//                Log.d("firebase", databaseerror.getMessage()); //don't ignore errors!
//            }
//        };
//        rootref.addListenerForSingleValueEvent(valueeventlistener);
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
//        String[] loc=new String[5];
//        String[] pr=new String[5];
        String[] houses={"Bunglow","Flat","Vikas"};
        ArrayList<String> house = new ArrayList<String>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("/");




            myRef.child("location").child(loc).child(houses[0]).child("location").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
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
        myRef.child("location").child(loc).child(houses[0]).child("price").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    }
                    else {
                        Log.e("firebase", String.valueOf(task.getResult().getValue()));
                        zero.setText(""+zero.getText()+"\n"+"Price:Rs "+String.valueOf(task.getResult().getValue()));
                    }
                }
            });
        myRef.child("location").child(loc).child(houses[1]).child("location").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
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
        myRef.child("location").child(loc).child(houses[1]).child("price").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.e("firebase", String.valueOf(task.getResult().getValue()));
                    one.setText(""+one.getText()+"\n"+"Price:Rs "+String.valueOf(task.getResult().getValue()));
                }
            }
        });
        myRef.child("location").child(loc).child(houses[2]).child("location").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
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
        myRef.child("location").child(loc).child(houses[2]).child("price").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.e("firebase", String.valueOf(task.getResult().getValue()));
                    two.setText(""+two.getText()+"\n"+"Price:Rs "+String.valueOf(task.getResult().getValue()));
                }
            }
        });
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Rentinglist.this, Payment.class);
                startActivity(intent);
            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Rentinglist.this, Payment.class);
                startActivity(intent);

            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Rentinglist.this, Payment.class);
                startActivity(intent);
            }
        });

//            zero.setText(loc[0]+pr[0]);
//            one.setText(loc[1]+pr[1]);
//            two.setText(loc[2]+pr[2]);


    }
}