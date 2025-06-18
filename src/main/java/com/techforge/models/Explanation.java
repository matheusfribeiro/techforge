package com.techforge.models;

public class Explanation {
    private int id;
    private String text;
    private Activity activity;

    public Explanation(int id, String text, Activity activity) {
        this.id = id;

        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        this.text = text;

        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null");
        }
        this.activity = activity;
    }
}
