package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

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
    public static SignUpActivity activity;

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
        activity = this;


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (personName.getText().toString().isEmpty() || personLastname.getText().toString().isEmpty() || personEmail.getText().toString().isEmpty() || password.getText().toString().isEmpty() || rePassword.getText().toString().isEmpty()) {
                    new MaterialAlertDialogBuilder(activity)
                            .setTitle("Kayıt oluşturulamadı")
                            .setMessage("Ad, soyad, eposta, şifre alanları zorunludur, lütfen bu alanları kontrol ediniz.")
                            .setCancelable(true)
                            .setPositiveButton("Tamam", null)
                            .show();
                    return;
                }
                if (checkPersonIfExist()) {
                    Toast.makeText(MainActivity.activity, "Yeni kayıt oluşturulamadı, bu eposta ile daha önce kayıt oluşturulmuştur.", Toast.LENGTH_SHORT).show();
                    System.out.println("user exist");
                    return;
                }

                if (!checkPassword()) {
                    Toast.makeText(MainActivity.activity, "Girdiğiniz şifreler farklı olduğu için kayıt oluşturulamadı.", Toast.LENGTH_SHORT).show();
                    System.out.println("password doesn't match, fail user create");
                    return;
                }

                System.out.println("password mathces user will be creating");
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
                new MaterialAlertDialogBuilder(activity)
                        .setTitle("Tebrikler")
                        .setMessage("Kaydınız başarıyla oluşturuldu, giriş ekranına gitmek için Tamam'a basın.")
                        .setCancelable(true)
                        .setPositiveButton("Tamam", (dialog, which) -> activity.onBackPressed())
                        .show();

            }
        });

    }

    private boolean checkPersonIfExist(){
        List<PersonInfo> persons = SharedPrefHelper.getPersonsList();
        if (persons == null) {
            return false;
        }

        for (PersonInfo person : persons)
            if (personEmail.getText().toString().equals(person.getEmail()))
                return true;
        return false;
    }

    private boolean checkPassword(){
        if (password.getText().toString().equals(rePassword.getText().toString())) {
            return true;
        }
        return false;
    }
}