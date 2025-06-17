package com.techforge.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    public static Question validQuestion() {
        return new Question(
                1,
                "What is polymorphism?",
                QuestionType.SINGLE,
                ActivityTest.validActivity()
        );
    }

    @Test
    void createQuestionShouldPass() {
        assertDoesNotThrow(() -> {
            validQuestion();
        });
    }

    @Test void statementCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Question(1, null, QuestionType.SINGLE, ActivityTest.validActivity())
        );
    }

    @Test void questionTypeCannotBeNull() {
        Question question = new Question(1, "Q text", null, ActivityTest.validActivity());
        assertEquals(QuestionType.SINGLE, question.getQuestionType());
    }

    @Test void activityCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Question(1, "Q text", QuestionType.SINGLE, null)
        );
    }

}