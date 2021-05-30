package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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
        createExam = (TextView)findViewById(R.id.text3);
        settingsExam = (TextView)findViewById(R.id.text4);

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
                    Intent intentQuestionAdd = new Intent(v.getContext(), QuestionAddActivity.class);
                    new MaterialAlertDialogBuilder(ListActivity.this)
                            .setTitle("Uyarı")
                            .setMessage("Listelenecek soru bulunmamaktadır.Soru eklemek için Tamam'a basın.")
                            .setCancelable(true)
                            .setPositiveButton("Tamam", (dialog, which) ->  v.getContext().startActivity(intentQuestionAdd))
                            .show();
                } else {
                    Intent intentQuesitonList = new Intent(v.getContext(), QuestionListActivity.class);
                    v.getContext().startActivity(intentQuesitonList);
                }
            }
        });

        createExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createExam = new Intent(v.getContext(), ExamActivity.class);
                v.getContext().startActivity(createExam);
            }
        });

        settingsExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsExam = new Intent(v.getContext(), SettingsActivity.class);
                v.getContext().startActivity(settingsExam);
            }
        });

    }



}
