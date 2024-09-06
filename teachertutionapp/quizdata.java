package com.firstapp.teachertutionapp;

public class quizdata {
    private int id;
    private String question;
    private String options;
    private int correctOption;

    public quizdata() {
        this.id = id;
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }
}
