package com.techforge.models;

import jakarta.persistence.*;

@Entity
@Table(name = "subcategory")
public class Subcategory {
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

    @Column(nullable = false)
    private int order;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    protected Subcategory() {}

    public Subcategory(int id, String name, String code, String shortDescription, String studyGuide, Status status, int order, Category category) {
        this.id = id;

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

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}
