package com.techforge.models;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(name = "short_description", columnDefinition = "TEXT")
    private String shortDescription;

    @Column(name = "study_guide", columnDefinition = "TEXT")
    private String studyGuide;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "`order`", nullable = false)
    private int order;

    @Column(name = "icon_path")
    private String iconPath;

    @Column(name = "html_color_code")
    private String htmlColorCode;

    protected Category() {}

    public Category(String name, String code, String shortDescription, String studyGuide, Status status, int order, String iconPath, String htmlColorCode) {

        if (name == null || name.trim().isEmpty()) {
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

        if (shortDescription != null && shortDescription.isEmpty()) {
            throw new IllegalArgumentException("ShortDescription cannot be empty");
        }
        this.shortDescription = shortDescription;

        if (studyGuide != null && studyGuide.isEmpty()) {
            throw new IllegalArgumentException("StudyGuide cannot be empty");
        }

        this.studyGuide = studyGuide;


        this.status = (status != null) ? status : Status.INACTIVE;

        if (order < 1) {
            throw new IllegalArgumentException("Order cannot be less than 1");
        }
        this.order = order;

        if (iconPath != null && iconPath.isEmpty()) {
            throw new IllegalArgumentException("IconPath cannot be empty");
        }
        this.iconPath = iconPath;

        if (htmlColorCode != null && !htmlColorCode.isBlank() && !htmlColorCode.matches("^#[0-9A-Fa-f]{6}$")) {
            throw new IllegalArgumentException(
                    "htmlColorCode must be in hexadecimal format #RRGGBB"
            );
        }
        this.htmlColorCode = htmlColorCode;
    }

    public Category(int id, String name, String code, String shortDescription, String studyGuide, Status status, int order, String iconPath, String htmlColorCode) {
        this(name, code, shortDescription, studyGuide, status, order, iconPath, htmlColorCode);

        this.id = id;

    }

    public Status getStatus() {
        return status;
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public int getOrder() {
        return order;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getHtmlColorCode() {
        return htmlColorCode;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public void setHtmlColorCode(String htmlColorCode) {
        this.htmlColorCode = htmlColorCode;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
