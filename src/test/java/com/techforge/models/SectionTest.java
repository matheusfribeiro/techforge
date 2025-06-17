package com.techforge.models;

import com.techforge.models.factory.CourseTestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectionTest {
    @Test
    void createSectionShouldPass() {
        assertDoesNotThrow(() -> {
            validSection();
        });
    }

    public static Section validSection() {
        return new Section(
                1,
                "Introduction",
                "introduction",
                1,
                Status.ACTIVE,
                false,
                CourseTestFactory.validCourse()
        );
    }

    @Test void nameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Section(1, null, "intro", 1, Status.ACTIVE, false, CourseTestFactory.validCourse())
        );
    }

    @Test void codeCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () ->
                new Section(1, "Intro", "", 1, Status.ACTIVE, false, CourseTestFactory.validCourse())
        );
    }

    @Test void orderCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Section(1, "Intro", "intro", -1, Status.ACTIVE, false, CourseTestFactory.validCourse())
        );
    }

    @Test void orderCannotBeZero() {
        assertThrows(IllegalArgumentException.class, () ->
                new Section(1, "Intro", "intro", 0, Status.ACTIVE, false, CourseTestFactory.validCourse())
        );
    }



    @Test void statusCannotBeNull() {
        Section section = new Section(1, "Intro", "intro", 1, null, false, CourseTestFactory.validCourse());
        assertEquals(Status.INACTIVE, section.getStatus());
    }

    @Test void courseCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Section(1, "Intro", "intro", 1, Status.ACTIVE, false, null)
        );
    }

}