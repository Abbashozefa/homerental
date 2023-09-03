package com.example.homerental;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Signin extends AppCompatActivity {
    EditText eusername, epwd;
    Button login;
    int count=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        eusername = (EditText) findViewById(R.id.username);
        epwd = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        String regemail=getIntent().getStringExtra("email");
        String regpwd=getIntent().getStringExtra("userpwd");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newemail=eusername.getText().toString();
                String newpwd=epwd.getText().toString();
                if(regemail.equals(newemail) && regpwd.equals(newpwd)){
                    Toast.makeText(Signin.this, "Login Successful",
                            Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Signin.this,Home.class);
                    startActivity(intent);
                    eusername.setText("");
                    epwd.setText("");
                }
                else if(newemail.equals("abbas") && newpwd.equals("123")){
                    Toast.makeText(Signin.this, "Login Successful",
                            Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Signin.this,Home.class);
                    startActivity(intent);
                    eusername.setText("");
                    epwd.setText("");
                }
                else{
                    count++;
                    Toast.makeText(Signin.this, "Login Failed "+count,
                            Toast.LENGTH_LONG).show();
                    if(count==3)
                    {
                        login.setEnabled(false);
                        Toast.makeText(Signin.this, "Login Failed "+count,
                                Toast.LENGTH_LONG).show();
                    }
                }
            }});
    }
}