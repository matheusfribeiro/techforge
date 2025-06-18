package com.techforge.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {
    public static Activity validActivity() {
        return new Activity(
                1,
                "Lesson 1",
                "lesson-1",
                Status.ACTIVE,
                1,                  // order
                Type.EXPLANATION,
                SectionTest.validSection()
        );
    }

    @Test
    void createActivityShouldPass() {
        assertDoesNotThrow(() -> {
            validActivity();
        });
    }

    @Test void titleCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () ->
                new Activity(1, " ", "lesson", Status.ACTIVE, 1, Type.EXPLANATION, SectionTest.validSection())
        );
    }

    @Test void codeInvalidPatternThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                new Activity(1, "Lesson", "Bad Code!", Status.ACTIVE, 1, Type.EXPLANATION, SectionTest.validSection())
        );
    }

    @Test void orderCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Activity(1, "Lesson", "lesson", Status.ACTIVE, -5, Type.EXPLANATION, SectionTest.validSection())
        );
    }

    @Test void typeCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Activity(1, "Lesson", "lesson", Status.ACTIVE, 1, null, SectionTest.validSection())
        );
    }

    @Test void sectionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Activity(1, "Lesson", "lesson", Status.ACTIVE, 1, Type.EXPLANATION, null)
        );
    }


}