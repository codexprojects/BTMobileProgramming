package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button signin;
    EditText userName;
    EditText password;
    Button signup;
    int passwordCount = 0;
    public static MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_main);

        signin = (Button)findViewById(R.id.button3);
        userName = (EditText)findViewById(R.id.usernameText);
        password = (EditText)findViewById(R.id.passwordTextview);
        signup = (Button)findViewById(R.id.signupButton);

        signin.setOnClickListener(v -> {
            if (checkPerson()) {
                System.out.println("person matches go to list");
                Intent intent = new Intent(v.getContext(), ListActivity.class);
                v.getContext().startActivity(intent);
            } else {
                passwordCount +=1;
                Toast.makeText(MainActivity.activity, "Hatalı giriş yaptınız.", Toast.LENGTH_SHORT).show();
                if(passwordCount == 3){
                    System.out.println("no person show false alert");
                    new MaterialAlertDialogBuilder(activity)
                            .setTitle("Hata")
                            .setMessage("3 kere hatalı giriş yaptınız, uygulama kapatılacaktır.")
                            .setCancelable(true)
                            .setPositiveButton("Tamam", (dialog, which) -> activity.finish())
                            .show();
                    signin.setEnabled(false);
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
        List<PersonInfo> persons = SharedPrefHelper.getPersonsList();
        if (persons == null) {
           return false;
        }

        for (PersonInfo person : persons){
            if (userName.getText().toString().equals(person.getEmail()) && password.getText().toString().equals(person.getPassword()))
                return true;
        }
        return false;
    }

}