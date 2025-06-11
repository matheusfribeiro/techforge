package com.techforge.models;

public class Alternative {
    private int id;
    private String explanatoryText;
    private int order;
    private boolean isCorrect;
    private String justification;

    public Alternative(int id, String explanatoryText, int order, boolean isCorrect, String justification) {
        this.id = id;

        if (explanatoryText == null) {
            throw new IllegalArgumentException("explanatoryText cannot be null");
        }
        this.explanatoryText = explanatoryText;

        if (order < 0) {
            throw new IllegalArgumentException("order cannot be negative");
        }
        this.order = order;


        this.isCorrect = isCorrect;


        this.justification = justification;
    }
}
