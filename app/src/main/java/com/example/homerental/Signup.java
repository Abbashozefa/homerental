package com.example.homerental;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import java.util.regex.Pattern;
public class Signup extends AppCompatActivity {
    EditText username, pwd;
    Button signup;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.signup);
        signin = (Button) findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this, com.example.homerental.Signin.class);

                startActivity(intent);

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = username.getText().toString();
                String userpwd = pwd.getText().toString();
                if (email.matches("")) {
                    Toast.makeText(Signup.this, "Username cannot be empty",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (!isvalidPassword(userpwd)) {
                    Toast.makeText(Signup.this, "Invalid Password",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(Signup.this, com.example.homerental.Signin.class);
                intent.putExtra("email", email);
                intent.putExtra("userpwd", userpwd);
                startActivity(intent);

            }
        });

    }
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern special = Pattern.compile("^.*[@#$%^&*(){},.;/].*$");
    private boolean isvalidPassword(String userpwd) {
        if (userpwd.length() < 8) {
            return false;
        }
        if(!lowercase.matcher(userpwd).matches()){
            return false;
        }
        if(!uppercase.matcher(userpwd).matches()){
            return false;
        }
        if(!number.matcher(userpwd).matches()){
            return false;
        }
        if(!special.matcher(userpwd).matches()){
            return false;
        }
        return true;
    }
}