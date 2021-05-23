package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ilkeyucel.btmobilapp.model.Question;
import com.ilkeyucel.btmobilapp.model.SharedPrefHelper;

import java.util.ArrayList;
import java.util.List;

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
        listQuestion = (TextView)findViewById(R.id.text2);

        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQuesitonAdd = new Intent(v.getContext(), QuestionAddActivity.class);
                v.getContext().startActivity(intentQuesitonAdd);
            }
        });

        listQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Question> questions = SharedPrefHelper.getQuestionList();
                if (questions == null) {
                    Toast.makeText(MainActivity.activity, "Listelenecek soru bulunmamaktadır.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentQuesitonList = new Intent(v.getContext(), QuestionListActivity.class);
                    v.getContext().startActivity(intentQuesitonList);
                }
            }
        });

    }



}
