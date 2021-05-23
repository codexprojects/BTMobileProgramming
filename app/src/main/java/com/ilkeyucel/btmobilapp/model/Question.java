package com.ilkeyucel.btmobilapp.model;

import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<Answer> answerList;
    private Float difficultRange;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Float getDifficultRange() {
        return difficultRange;
    }

    public void setDifficultRange(Float difficultRange) {
        this.difficultRange = difficultRange;
    }

    public ArrayList<Answer> getAnswers() { return answerList; }

    public void setAnswers(ArrayList<Answer> answerList) { this.answerList = answerList; }

}
