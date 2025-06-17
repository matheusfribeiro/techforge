package com.techforge.models;

public class Section {
    private int id;
    private String name;
    private String code;
    private int order;
    private Status status;
    private boolean isAssessment;
    private Course course;


    public Section(int id, String name, String code, int order, Status status, boolean isAssessment, Course course) {
        this.id = id;

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;

        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        if (!code.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("Code must only contain lowercase letters, numbers, and hyphens. No spaces, accents, or special characters allowed.");
        }
        this.code = code;

        if (order < 1) {
            throw new IllegalArgumentException("Order cannot be negative or zero");
        }
        this.order = order;

        this.status = (status != null) ? status: Status.INACTIVE;

        this.isAssessment = isAssessment;

        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        this.course = course;


    }

    public Status getStatus() {
        return status;
    }
}
