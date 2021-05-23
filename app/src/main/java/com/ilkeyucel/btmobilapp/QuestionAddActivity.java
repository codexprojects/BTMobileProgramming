package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.slider.RangeSlider;
import com.ilkeyucel.btmobilapp.model.Answer;
import com.ilkeyucel.btmobilapp.model.PersonInfo;
import com.ilkeyucel.btmobilapp.model.Question;
import com.ilkeyucel.btmobilapp.model.SharedPrefHelper;

import java.util.ArrayList;
import java.util.List;

public class QuestionAddActivity extends AppCompatActivity {

    EditText question;
    RangeSlider difficultRange;
    MaterialButton saveButton;

    CheckBox check1;
    EditText choice1;
    CheckBox check2;
    EditText choice2;
    CheckBox check3;
    EditText choice3;
    CheckBox check4;
    EditText choice4;

    Question questionItem;
    Answer answer1;
    Answer answer2;
    Answer answer3;
    Answer answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_add);
        prepareView();
    }

    public void prepareView() {
        question = (EditText)findViewById(R.id.question);
        difficultRange = (RangeSlider)findViewById(R.id.difficultRange);
        saveButton = (MaterialButton)findViewById(R.id.saveButton);

        check1 = (CheckBox)findViewById(R.id.check1);
        choice1 = (EditText)findViewById(R.id.choice1);
        check2 = (CheckBox)findViewById(R.id.check2);
        choice2 = (EditText)findViewById(R.id.choice2);
        check3 = (CheckBox)findViewById(R.id.check3);
        choice3 = (EditText)findViewById(R.id.choice3);
        check4 = (CheckBox)findViewById(R.id.check4);
        choice4 = (EditText)findViewById(R.id.choice4);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveQuestionAction();

                List<Question> questions = SharedPrefHelper.getQuestionList();
                if (questions == null) {
                    questions = new ArrayList<>();
                }
                questions.add(questionItem);

                SharedPrefHelper.putQuestionList(questions);

            }
        });


    }

    public void saveQuestionAction() {
        questionItem = new Question();
        answer1 = new Answer();
        answer2 = new Answer();
        answer3 = new Answer();
        answer4 = new Answer();
        ArrayList<Answer> answers = new ArrayList<>();

        questionItem.setQuestion(question.getText().toString());
        answer1.setAnswerText(choice1.getText().toString());
        answer1.setIsAnswer(check2.isSelected());
        answer2.setAnswerText(choice2.getText().toString());
        answer2.setIsAnswer(check2.isSelected());
        answer3.setAnswerText(choice3.getText().toString());
        answer3.setIsAnswer(check3.isSelected());
        answer4.setAnswerText(choice4.getText().toString());
        answer4.setIsAnswer(check4.isSelected());

        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        questionItem.setAnswers(answers);

        questionItem.setDifficultRange(difficultRange.getValues().get(0));

    }
}