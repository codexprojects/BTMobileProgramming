package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    Button signupButton;
    EditText personName;
    EditText personLastname;
    EditText personEmail;
    EditText password;
    EditText rePassword;
    EditText personPhoneNumber;
    EditText personBirthdate;
    PersonInfo personInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        personName = (EditText) findViewById(R.id.personNameText);
        personLastname = (EditText)findViewById(R.id.editTextTextPersonName2);
        personEmail = (EditText)findViewById(R.id.personEmailText);
        password = (EditText)findViewById(R.id.personPassword);
        rePassword = (EditText)findViewById(R.id.personRepassword);
        personPhoneNumber = (EditText)findViewById(R.id.editTextPhone);
        personBirthdate = (EditText)findViewById(R.id.editTextDate);
        signupButton = (Button)findViewById(R.id.signupVCButton);



        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personInfo = new PersonInfo();

                personInfo.setName(personName.getText().toString());
                personInfo.setLastName(personLastname.getText().toString());
                personInfo.setEmail(personEmail.getText().toString());
                personInfo.setPassword(password.getText().toString());

                List<PersonInfo> persons = SharedPrefHelper.getPersonsList();
                if (persons == null) {
                    persons = new ArrayList<>();
                }
                persons.add(personInfo);
                SharedPrefHelper.putPersonsList(persons);
                Toast.makeText(MainActivity.activity, "Kaydınız başarıyla oluşturuldu.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}