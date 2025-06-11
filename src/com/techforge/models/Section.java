package com.techforge.models;

public class Section {
    private int id;
    private String name;
    private String code;
    private int order;
    private Status status;
    private boolean isAssessment;

    public Section(int id, String name, String code, int order, Status status, boolean isAssessment) {
        this.id = id;

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;

        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        this.code = code;

        if (order < 1) {
            throw new IllegalArgumentException("Order cannot be null or empty");
        }
        this.order = order;

        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        this.status = status;

        this.isAssessment = isAssessment;


    }
}
