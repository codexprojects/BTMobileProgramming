package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button signin;
    EditText userName;
    EditText password;
    Button signup;
    int passwordCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin = (Button)findViewById(R.id.button3);
        userName = (EditText)findViewById(R.id.usernameText);
        password = (EditText)findViewById(R.id.passwordTextview);
        signup = (Button)findViewById(R.id.signupButton);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPerson()) {
                    System.out.println("person matches go to list");
                    Intent intent = new Intent(v.getContext(), ListActivity.class);
                    v.getContext().startActivity(intent);
                } else {
                    passwordCount +=1;
                    if(passwordCount >= 3){
                        System.out.println("no person show false alert");
                        Toast.makeText(MainActivity.this,"3 defa hatalı giriş yaptığınız için tekrar giriş yapamazsınız", Toast.LENGTH_LONG).show();
                        signin.setEnabled(false);
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignup = new Intent(v.getContext(), SignUpActivity.class);
                v.getContext().startActivity(intentSignup);
            }
        });

    }

    private boolean checkPerson(){
        for (PersonInfo person : PersonInfo.getPersonList()){
            if (userName.getText().toString().equals(person.getUserName()) && password.getText().toString().equals(person.getPassword()))
                return true;
        }
        return false;
    }

}