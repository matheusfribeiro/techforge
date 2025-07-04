package com.techforge.persistance.hibernate;

import com.techforge.models.Course;
import com.techforge.persistance.CourseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HibernateCourseDAO implements CourseDAO {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Course getCourseById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Course.class, id);
        }
    }


    public List<Course> getAllCourses() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Course", Course.class).list();
        }
    }

    public int addCourse(Course course) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
            return course.getId();
        }
    }

    public void updateCourse(Course course) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(course);
            session.getTransaction().commit();
        }
    }

    public Course deleteCourse(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Course course = session.find(Course.class, id);
            if (course != null) {
                session.remove(course);
            }
            session.getTransaction().commit();
            return course;
        }
    }
}
