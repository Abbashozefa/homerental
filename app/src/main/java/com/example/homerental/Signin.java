package com.example.homerental;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {
    EditText eusername, epwd;
    Button login;
    int count=0;
    private FirebaseAuth mAuth;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        eusername = (EditText) findViewById(R.id.username);
        epwd = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        String regemail=getIntent().getStringExtra("email");
        String regpwd=getIntent().getStringExtra("userpwd");
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newemail=eusername.getText().toString();
                String newpwd=epwd.getText().toString();
//                if(regemail.equals(newemail) && regpwd.equals(newpwd)){
//                    Toast.makeText(Signin.this, "Login Successful",
//                            Toast.LENGTH_LONG).show();
//                    Intent intent=new Intent(Signin.this,Home.class);
//                    startActivity(intent);
//                    eusername.setText("");
//                    epwd.setText("");
//                }
//                else if(newemail.equals("abbas") && newpwd.equals("123")){
//                    Toast.makeText(Signin.this, "Login Successful",
//                            Toast.LENGTH_LONG).show();
//                    Intent intent=new Intent(Signin.this,Home.class);
//                    startActivity(intent);
//                    eusername.setText("");
//                    epwd.setText("");
//                }
//                else{
//                    count++;
//                    Toast.makeText(Signin.this, "Login Failed "+count,
//                            Toast.LENGTH_LONG).show();
//                    if(count==3)
//                    {
//                        login.setEnabled(false);
//                        Toast.makeText(Signin.this, "Login Failed "+count,
//                                Toast.LENGTH_LONG).show();
//                    }
//                }
                mAuth.signInWithEmailAndPassword(newemail, newpwd)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Signin.this, "Authentication Successful",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(Signin.this,Home.class);
                    startActivity(intent);
                    eusername.setText("");
                    epwd.setText("");
                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Signin.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }});
    }
}