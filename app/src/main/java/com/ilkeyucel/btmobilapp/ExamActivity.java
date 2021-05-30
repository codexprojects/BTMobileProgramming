package com.ilkeyucel.btmobilapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.ilkeyucel.btmobilapp.model.Question;
import com.ilkeyucel.btmobilapp.model.SharedPrefHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExamActivity extends AppCompatActivity {

    Button startExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        startExam = (Button)findViewById(R.id.startExam);

        startExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAndSendQuestions();
            }
        });
    }

    public void saveAndSendQuestions() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        List<Question> data = SharedPrefHelper.getQuestionList();

        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/PrintFiles";
        File file = new File(file_path+"/questions.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileOutputStream fos = null;
        try {

            fos = this.openFileOutput("questions.txt", Context.MODE_PRIVATE);
            fos.write(data.toString().getBytes());
            fos.flush();
            fos.close();

        } catch (Exception e) {

        } finally {
            if (fos != null) {
                fos = null;
            }
        }

        Uri path = Uri.fromFile(file);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "yucel.ilke@gmail.com" });
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Sınav Soruları");
        shareIntent.putExtra(Intent.EXTRA_TEXT, path.toString());
        shareIntent.putExtra(Intent.EXTRA_STREAM, path);
        startActivity(shareIntent);
    }

    public static void save(View v, String fileName , String message){

        FileOutputStream fos = null;

        try {

            fos = v.getContext().openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(message.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}