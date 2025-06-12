package com.techforge.models;

public class Alternative {
    private int id;
    private String explanatoryText;
    private int order;
    private boolean isCorrect;
    private String justification;
    private Question question;

    public Alternative(int id, String explanatoryText, int order, boolean isCorrect, String justification, Question question) {
        this.id = id;

        if (explanatoryText == null) {
            throw new IllegalArgumentException("explanatoryText cannot be null");
        }
        this.explanatoryText = explanatoryText;

        if (order < 1) {
            throw new IllegalArgumentException("order cannot be negative");
        }
        this.order = order;


        this.isCorrect = isCorrect;


        this.justification = justification;

        if (question == null) {
            throw new IllegalArgumentException("question cannot be null");
        }
        this.question = question;
    }
}
