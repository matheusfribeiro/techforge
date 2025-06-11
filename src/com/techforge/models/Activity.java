package com.techforge.models;

public class Activity {

    private int id;
    private String title;
    private String code;
    private Status status;
    private int order;
    private Type type;

    public Activity(int id, String title, String code, Status status, int order, Type type) {
        this.id = id;

        if(title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;

        if(code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        this.code = code;

        if(status == null) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        this.status = status;

        if(order < 0) {
            throw new IllegalArgumentException("Order cannot be negative");
        }
        this.order = order;

        if(type == null) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        this.type = type;
    }
}
