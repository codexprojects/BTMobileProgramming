package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ilkeyucel.btmobilapp.model.QuestionAdapter;
import com.ilkeyucel.btmobilapp.model.SharedPrefHelper;

public class QuestionListActivity extends AppCompatActivity {

    QuestionAdapter questionAdapter;
    RecyclerView questionRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        questionRV = (RecyclerView)findViewById(R.id.questionRV);
        questionAdapter = new QuestionAdapter();
        questionAdapter.setQuestions(SharedPrefHelper.getQuestionList());

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(MainActivity.activity, LinearLayoutManager.VERTICAL, false);
        questionRV.setLayoutManager(layoutManager);
        questionRV.setAdapter(questionAdapter);
    }
}