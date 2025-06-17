package com.techforge.models;

public class Course {
    private int id;
    private String name;
    private String code;
    private int estimatedCompletionTime;
    private Visibility visibility;
    private String targetAudience;
    private String instructorName;
    private String syllabus;
    private String developedSkills;
    private Subcategory subcategory;

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

        if (subcategory == null) {
            throw new IllegalArgumentException("Subcategory cannot be null");
        }
        this.subcategory = subcategory;

    }

}
