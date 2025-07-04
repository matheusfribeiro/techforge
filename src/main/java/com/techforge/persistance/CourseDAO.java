package com.techforge.persistance;

import com.techforge.models.Course;


import java.util.List;

public interface CourseDAO {
    Course getCourseById(int id) ;

    List<Course> getAllCourses() ;

    int addCourse(Course course) ;

    void updateCourse(Course course) ;

    Course deleteCourse(int id) ;
}
