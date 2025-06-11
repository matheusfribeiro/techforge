package com.techforge.models;

public class Explanation {
    private int id;
    private String text;

    public Explanation(int id, String text) {
        this.id = id;

        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        this.text = text;
    }
}
