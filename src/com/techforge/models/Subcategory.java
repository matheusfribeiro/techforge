package com.techforge.models;

public class Subcategory {
    private int id;
    private String name;
    private String code;
    private String shortDescription;
    private String studyGuide;
    private Status status;
    private int order;

    public Subcategory(int id, String name, String code, String shortDescription, String studyGuide, Status status, int order) {
        this.id = id;

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;

        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        this.code = code;

        if (shortDescription == null || shortDescription.isEmpty()) {
            throw new IllegalArgumentException("ShortDescription cannot be null or empty");
        }
        this.shortDescription = shortDescription;

        if (studyGuide == null || studyGuide.isEmpty()) {
            throw new IllegalArgumentException("StudyGuide cannot be null or empty");
        }
        this.studyGuide = studyGuide;

        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        this.status = status;

        if (order < 1) {
            throw new IllegalArgumentException("Order cannot be less than 1");
        }
        this.order = order;

    }
}
