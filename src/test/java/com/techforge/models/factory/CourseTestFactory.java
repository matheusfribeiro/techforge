package com.techforge.models.factory;

import com.techforge.models.Course;
import com.techforge.models.SubcategoryTest;
import com.techforge.models.Visibility;

public class CourseTestFactory {
    public static Course validCourse() {
        return new Course(
                1,
                "Java for beginners",
                "java-beginners",
                10,
                Visibility.PUBLIC,
                "Beginners",
                "Instructor Fulano",
                "Syllabus text",
                "Java, OOP",
                SubcategoryTest.validSubcategory()
        );
    }
}