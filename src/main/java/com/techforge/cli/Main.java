package com.techforge.cli;

import com.techforge.models.*;
import com.techforge.persistance.CourseDAO;
import com.techforge.persistance.hibernate.HibernateCourseDAO;
import com.techforge.persistance.jdbc.JdbcCourseDAO;
import com.techforge.persistance.jpa.JpaCourseDAO;
import com.techforge.persistance.jpa.JpaUtil;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//        var courseDAO = new CourseDAO();
//        Course course = courseDAO.getCourseById(1);
//        System.out.println(course);

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


//        Category testCategory = new Category(
//                1,
//                "Programming",
//                "programming",
//                "Intro to programming",
//                "study the book",
//                Status.ACTIVE,
//                1,
//                "programmingicon.png",
//                "#FFFFFF"
//        );
//
//        Subcategory testSubcategory = new Subcategory(1, "JavaScript basics", "javascript-basics", "learn the basics", "study chapter 4", Status.ACTIVE, 1, testCategory);
//
//        course.setName("Updated course name");
//        course.setCode("updated-code");
//        course.setEstimatedCompletionTime(15);
//        course.setVisibility(Visibility.PRIVATE);
//        course.setTargetAudience("advanced");
//        course.setInstructorName("fulano updated");
//        course.setSyllabus("updated syllabus");
//        course.setDevelopedSkills("Java, JDBC, SQL");
//        course.setSubcategory(testSubcategory);
//        courseDAO.updateCourse(course);

//        Course updatedCourse = courseDAO.getCourseById(1);
//        System.out.println("Course after update: " + updatedCourse);
        CourseDAO dao = new JpaCourseDAO();

        //create
        Course course = new Course(
                "Test for echo",
                "jpa-code",
                4,
                Visibility.PUBLIC,
                "Java Devs",
                "Instrutora Maria",
                "Learn JPA with Hibernate",
                "JPA, Hibernate",
                null
        );
        int newId = dao.addCourse(course);
        System.out.println("Created course: " + course);
//
        // read by id
        Course fetched = dao.getCourseById(newId);
        System.out.println("Fetched course: " + fetched);

        // read all
        List<Course> all = dao.getAllCourses();
        System.out.println("All course names:");
        for (Course c : all) {
            System.out.println("  " + c.getName());
        }

        // update
//        fetched.setName("JPA Course (Updated)");
//        dao.updateCourse(fetched);
//        Course updated = dao.getCourseById(7);
//        System.out.println("After update: " + updated);

        //delete
//        Course deleted = dao.deleteCourse(7);
//        System.out.println("Deleted course: " + deleted);



//        dao.addCourse(course);
//        System.out.println(course);

//        //read
//        Course fetchedCourse = dao.getCourseById(1);
//        System.out.println(fetchedCourse);
//
//        List<Course> allCourses = dao.getAllCourses();
//        System.out.println("All courses in database:");
//        for (Course courses : allCourses) {
//            System.out.println(courses);
//        }
//
//        //update
//        fetchedCourse.setName("Spring (Updated AGAIN)");
//        dao.updateCourse(fetchedCourse);
//        Course updated = dao.getCourseById(1);
//        System.out.println("After update, name is: " + updated.getName());
//
//        //delete
//        Course deleted = dao.deleteCourse(6);
//        System.out.println("Deleted course: " + deleted.getName());
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//
//            try{
//
//
//
//                session.persist(course);
//
//                session.getTransaction().commit();
//                System.out.println("Saved course with ID: " + course.getId());
//            } catch (Exception e){
//                session.getTransaction().rollback();
//             }
    }
}