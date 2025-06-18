package com.techforge.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExplanationTest {
    public static Explanation validExplanation() {
        return new Explanation(
                1,
                "This is the explanation text.",
                ActivityTest.validActivity()
        );
    }

    @Test
    void createExplanationShouldPass() {
        assertDoesNotThrow(() -> {
            validExplanation();
        });
    }

    @Test void textCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Explanation(1, null, ActivityTest.validActivity())
        );
    }

    @Test void textCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () ->
                new Explanation(1, "   ", ActivityTest.validActivity())
        );
    }

    @Test void activityCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Explanation(1, "Valid text", null)
        );
    }

}