package com.techforge.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlternativeTest {
    public static Alternative validAlternative() {
        return new Alternative(
                1,
                "It allows objects to be treated as instances of their base type.",
                1,
                true,
                "Because subclasses override methods",
                QuestionTest.validQuestion()
        );
    }

    @Test
    void createAlternativeShouldPass() {
        assertDoesNotThrow(() -> {
            validAlternative();
        });
    }

    @Test void explanatoryTextCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Alternative(1, "", 1, false, "Justified", QuestionTest.validQuestion())
        );
    }

    @Test void orderCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Alternative(1, "Alt text", -2, true, "Justified", QuestionTest.validQuestion())
        );
    }

    @Test void questionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Alternative(1, "Alt text", 1, false, "Justified", null)
        );
    }

}