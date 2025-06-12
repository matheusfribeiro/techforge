package com.techforge.models;

public class Question {
    private int id;
    private String statement;
    private QuestionType questionType;
    private Activity activity;

    public Question(int id, String statement, QuestionType questionType, Activity activity) {
        this.id = id;

        if (statement == null || statement.isEmpty()) {
            throw new IllegalArgumentException("statement cannot be null or empty");
        }
        this.statement = statement;

        this.questionType = (questionType != null) ? questionType : QuestionType.SINGLE;

        if (activity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        this.activity = activity;

    }
}
