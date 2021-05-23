package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    TextView addQuestion;
    TextView listQuestion;
    TextView createExam;
    TextView settingsExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        addQuestion = (TextView)findViewById(R.id.text1);

        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQuesitonAdd = new Intent(v.getContext(), QuestionAddActivity.class);
                v.getContext().startActivity(intentQuesitonAdd);
            }
        });

    }



}
