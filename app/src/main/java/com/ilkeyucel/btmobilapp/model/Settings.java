package com.ilkeyucel.btmobilapp.model;

public class Settings {
    private String examDuration;
    private Integer examLevel;
    private String examPoint;

    public String getExamDuration() {
        return examDuration;
    }
    public Integer getExamLevel() {
        return examLevel;
    }
    public String getExamPoint() {
        return examPoint;
    }

    public void setExamDuration(String examDuration) {
        this.examDuration = examDuration;
    }

    public void setExamLevel(Integer examLevel) {
        this.examLevel = examLevel;
    }

    public void setExamPoint(String examPoint) {
        this.examPoint = examPoint;
    }
}
