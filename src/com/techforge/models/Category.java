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

        if (iconPath == null || iconPath.isEmpty()) {
            throw new IllegalArgumentException("IconPath cannot be null or empty");
        }
        this.iconPath = iconPath;

        if (htmlColorCode == null || htmlColorCode.isEmpty()) {
            throw new IllegalArgumentException("HtmlColorCode cannot be null or empty");
        }
        this.htmlColorCode = htmlColorCode;
    }
}
