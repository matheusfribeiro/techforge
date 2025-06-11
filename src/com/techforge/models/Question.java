package com.techforge.models;

public class Question {
    private int id;
    private String statement;
    private QuestionType questionType;

    public Question(int id, String statement, QuestionType questionType) {
        this.id = id;

        if (statement == null || statement.isEmpty()) {
            throw new IllegalArgumentException("statement cannot be null or empty");
        }
        this.statement = statement;

        if (questionType == null) {
            throw new IllegalArgumentException("questionType cannot be null");
        }
        this.questionType = questionType;

    }
}
