package com.techforge.models;

public class Activity {

    private int id;
    private String title;
    private String code;
    private Status status;
    private int order;
    private Type type;
    private Section section;

    public Activity(int id, String title, String code, Status status, int order, Type type, Section section) {
        this.id = id;

        if(title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;

        if(code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        if (!code.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("Code must only contain lowercase letters, numbers, and hyphens. No spaces, accents, or special characters allowed.");
        }
        this.code = code;

        this.status = (status != null) ? status : Status.INACTIVE;

        if(order < 1) {
            throw new IllegalArgumentException("Order cannot be negative");
        }
        this.order = order;

        if(type == null) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        this.type = type;

        if(section == null) {
            throw new IllegalArgumentException("Section cannot be null or empty");
        }
        this.section = section;
    }
}
