package com.techforge.cli;

import com.techforge.models.*;
import com.techforge.persistance.CourseDAO;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        var courseDAO = new CourseDAO();
        Course course = courseDAO.getCourseById(1);
//        System.out.println(course);
//
//
//        Course newCourse = new Course(
//                "csharp",
//                "csharp-beginners",
//                10,
//                Visibility.PUBLIC,
//                "beginners",
//                "Instructor Beltrano",
//                "Syllabus text",
//                "csharp, OOP",
//                null
//        );
//        int id = courseDAO.addCourse(newCourse);
//        newCourse.setId(id);
//        System.out.println(newCourse);

//        List<Course> allCourses = courseDAO.getAllCourses();
//        for (Course course : allCourses) {
//            System.out.println(course);
//        }


//        courseDAO.deleteCourse(3);
//        Course deleted = courseDAO.deleteCourse(2);
//        if (deleted != null) {
//            System.out.println("deleted course: " + deleted.getName());
//        } else {
//            System.out.println("no course found");
//        }

//        List<Course> allCourses = courseDAO.getAllCourses();
//        for (Course course : allCourses) {
//            System.out.println(course);
//        }


        Category testCategory = new Category(
                1,
                "Programming",
                "programming",
                "Intro to programming",
                "study the book",
                Status.ACTIVE,
                1,
                "programmingicon.png",
                "#FFFFFF"
        );

        Subcategory testSubcategory = new Subcategory(1, "JavaScript basics", "javascript-basics", "learn the basics", "study chapter 4", Status.ACTIVE, 1, testCategory);

        course.setName("Updated course name");
        course.setCode("updated-code");
        course.setEstimatedCompletionTime(15);
        course.setVisibility(Visibility.PRIVATE);
        course.setTargetAudience("advanced");
        course.setInstructorName("fulano updated");
        course.setSyllabus("updated syllabus");
        course.setDevelopedSkills("Java, JDBC, SQL");
        course.setSubcategory(testSubcategory);
        courseDAO.updateCourse(course);

        Course updatedCourse = courseDAO.getCourseById(1);
        System.out.println("Course after update: " + updatedCourse);

    }
}