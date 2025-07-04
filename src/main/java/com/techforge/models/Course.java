package com.techforge.models;

import jakarta.persistence.*;


@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, name = "estimated_completion_time")
    private int estimatedCompletionTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Visibility visibility;

    @Column( name = "target_audience", columnDefinition = "TEXT")
    private String targetAudience;

    @Column(nullable = false, name = "instructor_name")
    private String instructorName;

    @Column(columnDefinition = "TEXT")
    private String syllabus;

    @Column(name = "developed_skills", columnDefinition = "TEXT")
    private String developedSkills;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    protected Course() {}

    public Course(int id, String name, String code, int estimatedCompletionTime, Visibility visibility, String targetAudience, String instructorName, String syllabus, String developedSkills, Subcategory subcategory )
    {

        this.id = id;
        if (name == null || name.isEmpty()){
            throw new
                    IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;

        if (code == null || code.isEmpty()){
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        if (!code.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("Code must only contain lowercase letters, numbers, and hyphens. No spaces, accents, or special characters allowed.");
        }
        this.code = code;

        if (estimatedCompletionTime < 1 || estimatedCompletionTime > 20) {
            throw new IllegalArgumentException("EstimatedCompletionTime must be between 1 and 20");
        }
        this.estimatedCompletionTime = estimatedCompletionTime;

        this.visibility = (visibility != null) ? visibility : Visibility.PRIVATE;

        if (targetAudience != null && targetAudience.trim().isEmpty()) {
            throw new IllegalArgumentException("TargetAudience cannot be null or empty");
        }
        this.targetAudience = targetAudience;

        if (instructorName == null || instructorName.isEmpty()) {
            throw new IllegalArgumentException("InstructorName cannot be null or empty");
        }
        this.instructorName = instructorName;

        this.syllabus = syllabus;

        this.developedSkills = developedSkills;

//        if (subcategory == null) {
//            throw new IllegalArgumentException("Subcategory cannot be null");
//        }
        this.subcategory = subcategory;

    }

    public Course(String name, String code, int estimatedCompletionTime, Visibility visibility, String targetAudience, String instructorName, String syllabus, String developedSkills, Subcategory subcategory )
    {

        if (name == null || name.isEmpty()){
            throw new
                    IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;

        if (code == null || code.isEmpty()){
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        if (!code.matches("^[a-z0-9-]+$")) {
            throw new IllegalArgumentException("Code must only contain lowercase letters, numbers, and hyphens. No spaces, accents, or special characters allowed.");
        }
        this.code = code;

        if (estimatedCompletionTime < 1 || estimatedCompletionTime > 20) {
            throw new IllegalArgumentException("EstimatedCompletionTime must be between 1 and 20");
        }
        this.estimatedCompletionTime = estimatedCompletionTime;

        this.visibility = (visibility != null) ? visibility : Visibility.PRIVATE;

        if (targetAudience != null && targetAudience.trim().isEmpty()) {
            throw new IllegalArgumentException("TargetAudience cannot be null or empty");
        }
        this.targetAudience = targetAudience;

        if (instructorName == null || instructorName.isEmpty()) {
            throw new IllegalArgumentException("InstructorName cannot be null or empty");
        }
        this.instructorName = instructorName;

        this.syllabus = syllabus;

        this.developedSkills = developedSkills;

//        if (subcategory == null) {
//            throw new IllegalArgumentException("Subcategory cannot be null");
//        }
        this.subcategory = subcategory;

    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", estimatedCompletionTime=" + estimatedCompletionTime +
                ", visibility=" + visibility +
                ", targetAudience='" + targetAudience + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                ", subcategory=" + subcategory +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        this.name = name;
    }

    public void setCode(String code) {
        if (code == null || !code.matches("^[a-z0-9\\-]+$")) {
            throw new IllegalArgumentException("invalid code format");
        }
        this.code = code;
    }

    public void setEstimatedCompletionTime(int estimatedCompletionTime) {
        if (estimatedCompletionTime < 1 || estimatedCompletionTime > 20) {
            throw new IllegalArgumentException("estimatedCompletionTime must be 1–20");
        }
        this.estimatedCompletionTime = estimatedCompletionTime;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = (visibility != null) ? visibility : Visibility.PRIVATE;
    }

    public void setTargetAudience(String targetAudience) {
        if (targetAudience != null && targetAudience.isBlank()) {
            throw new IllegalArgumentException("targetAudience cannot be blank");
        }
        this.targetAudience = targetAudience;
    }

    public void setInstructorName(String instructorName) {
        if (instructorName == null || instructorName.isBlank()) {
            throw new IllegalArgumentException("instructorName is required");
        }
        this.instructorName = instructorName;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = (syllabus != null && syllabus.isBlank()) ? null : syllabus;
    }

    public void setDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
