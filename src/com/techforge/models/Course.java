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

    public Course(int id, String name, String code, int estimatedCompletionTime, Visibility visibility, String targetAudience, String instructorName, String syllabus, String developedSkills )
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

        if (visibility == null) {
            throw new IllegalArgumentException("Visibility cannot be null");
        }
        this.visibility = visibility;

        if (targetAudience == null || targetAudience.isEmpty()) {
            throw new IllegalArgumentException("TargetAudience cannot be null or empty");
        }
        this.targetAudience = targetAudience;

        if (instructorName == null || instructorName.isEmpty()) {
            throw new IllegalArgumentException("InstructorName cannot be null or empty");
        }
        this.instructorName = instructorName;

        if (syllabus == null || syllabus.isEmpty()) {
            throw new IllegalArgumentException("Syllabus cannot be null or empty");
        }
        this.syllabus = syllabus;

        if (developedSkills == null || developedSkills.isEmpty()) {
            throw new IllegalArgumentException("DevelopedSkills cannot be null or empty");
        }
        this.developedSkills = developedSkills;

    }

}
