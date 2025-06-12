package com.techforge.models;

public class Subcategory {
    private int id;
    private String name;
    private String code;
    private String shortDescription;
    private String studyGuide;
    private Status status;
    private int order;
    private Category category;

    public Subcategory(int id, String name, String code, String shortDescription, String studyGuide, Status status, int order, Category category) {
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

        if (shortDescription.isEmpty()) {
            throw new IllegalArgumentException("ShortDescription cannot be null or empty");
        }
        this.shortDescription = shortDescription;

        if (studyGuide.isEmpty()) {
            throw new IllegalArgumentException("StudyGuide cannot be null or empty");
        }
        this.studyGuide = studyGuide;

        this.status = (status != null) ? status : Status.INACTIVE;

        if (order < 1) {
            throw new IllegalArgumentException("Order cannot be less than 1");
        }
        this.order = order;

        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        this.category = category;

    }
}
