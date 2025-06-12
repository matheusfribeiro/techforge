package com.techforge.models;

public class Category {
    private int id;
    private String name;
    private String code;
    private String shortDescription;
    private String studyGuide;
    private Status status;
    private int order;
    private String iconPath;
    private String htmlColorCode;

    public Category(int id, String name, String code, String shortDescription, String studyGuide, Status status, int order, String iconPath, String htmlColorCode) {
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

        this.shortDescription = shortDescription;

        if (studyGuide.isEmpty()) {
            throw new IllegalArgumentException("StudyGuide cannot be empty");
        }
        this.studyGuide = studyGuide;


        this.status = (status != null) ? status : Status.ACTIVE;

        if (order < 1) {
            throw new IllegalArgumentException("Order cannot be less than 1");
        }
        this.order = order;

        if (iconPath.isEmpty()) {
            throw new IllegalArgumentException("IconPath cannot be empty");
        }
        this.iconPath = iconPath;

        if (htmlColorCode != null && !htmlColorCode.isBlank()) {
            if (!htmlColorCode.matches("^#[0-9A-Fa-f]{6}$")) {
                throw new IllegalArgumentException(
                        "htmlColorCode must be in hexadecimal format #RRGGBB"
                );
            }
        }
        this.htmlColorCode = htmlColorCode;
    }
}
