// src/main/java/com/techforge/persistence/jpa/JpaCourseDAO.java
package com.techforge.persistance.jpa;

import com.techforge.models.Course;
import com.techforge.persistance.CourseDAO;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaCourseDAO implements CourseDAO {

    @Override
    public Course getCourseById(int id) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(Course.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("from Course", Course.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public int addCourse(Course course) {
        JpaUtil.inTransaction(em -> em.persist(course));
        return course.getId();
    }

    @Override
    public void updateCourse(Course course) {
        JpaUtil.inTransaction(em -> em.merge(course));
    }

    @Override
    public Course deleteCourse(int id) {
        final Course[] deleted = new Course[1];
        JpaUtil.inTransaction(em -> {
            Course c = em.find(Course.class, id);
            if (c != null) {
                em.remove(c);
            }
            deleted[0] = c;
        });
        return deleted[0];
    }
}
