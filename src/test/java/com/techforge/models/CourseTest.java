package com.techforge.models;

import com.techforge.models.factory.CourseTestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void createCourseShouldPass() {

        assertDoesNotThrow(() -> {
            CourseTestFactory.validCourse();
        });
    }

    @Test
    void targetAudienceCanBeNull() {
        assertDoesNotThrow(() -> {
            var courseObj = new Course(
                    1,
                    "Java for beginners",
                    "java-beginners",
                    10,
                    Visibility.PUBLIC,
                    null,
                    "Instructor Fulano",
                    "Syllabus text",
                    "Java, OOP",
                    SubcategoryTest.validSubcategory()
            );
        });
    }

    @Test
    void targetAudienceCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            var courseObj = new Course(
                    1,
                    "Java for beginners",
                    "java-beginners",
                    10,
                    Visibility.PUBLIC,
                    "",
                    "Instructor Fulano",
                    "Syllabus text",
                    "Java, OOP",
                    SubcategoryTest.validSubcategory()
            );
        });
    }

    @Test
    void targetAudienceCannotBeAllBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            var courseObj = new Course(
                    1,
                    "Java for beginners",
                    "java-beginners",
                    10,
                    Visibility.PUBLIC,
                    "  ",
                    "Instructor Fulano",
                    "Syllabus text",
                    "Java, OOP",
                    SubcategoryTest.validSubcategory()
            );
        });
    }
//test exception both success and fail
}