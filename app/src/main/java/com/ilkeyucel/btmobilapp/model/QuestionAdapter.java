package com.ilkeyucel.btmobilapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ilkeyucel.btmobilapp.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter  extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder>  {
    private List<Question> questionArrayList;

    public void setQuestions( List<Question> data){
        this.questionArrayList = data;
    }

    @NonNull
    @Override
    public QuestionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        return new QuestionAdapter.MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.MyViewHolder holder, int position) {
        Question item  = questionArrayList.get(position);
        holder.question.setText(item.getQuestion());
        holder.choice1.setText(item.getAnswers().get(0).getAnswerText());
        holder.choice2.setText(item.getAnswers().get(1).getAnswerText());
        holder.choice3.setText(item.getAnswers().get(2).getAnswerText());
        holder.choice4.setText(item.getAnswers().get(3).getAnswerText());
    }
    @Override
    public int getItemCount() {
        return questionArrayList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView question;
        CheckBox check1;
        TextView choice1;
        CheckBox check2;
        TextView choice2;
        CheckBox check3;
        TextView choice3;
        CheckBox check4;
        TextView choice4;

        public MyViewHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.question);
            check1 = (CheckBox) itemView.findViewById(R.id.check1);
            choice1 = (TextView) itemView.findViewById(R.id.choice1);
            check2 = (CheckBox) itemView.findViewById(R.id.check2);
            choice2 = (TextView) itemView.findViewById(R.id.choice2);
            check3 = (CheckBox) itemView.findViewById(R.id.check3);
            choice3 = (TextView) itemView.findViewById(R.id.choice3);
            check4 = (CheckBox) itemView.findViewById(R.id.check4);
            choice4 = (TextView) itemView.findViewById(R.id.choice4);
        }
    }
}
