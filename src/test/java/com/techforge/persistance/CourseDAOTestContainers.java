package com.techforge.persistance;

import com.techforge.models.Course;
import com.techforge.persistance.jdbc.JdbcCourseDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// ARRANGE

@Testcontainers
class CourseDAOTestContainers {

    @Container
    private static final MySQLContainer<?> MY_SQL_CONTAINER = new MySQLContainer<>(
            "mysql:8.0"
    ).withInitScripts("schema.sql", "data.sql");
//            .withUsername(DB_USER)
//            .withPassword(DB_PASS)
//            .withDatabaseName(DB_NAME);

    private static CourseDAO courseDAO;

    @BeforeAll
    public static void setUp() {
        System.setProperty("db.url", MY_SQL_CONTAINER.getJdbcUrl());
        System.setProperty("db.user", MY_SQL_CONTAINER.getUsername());
        System.setProperty("db.password", MY_SQL_CONTAINER.getPassword());

        courseDAO = new JdbcCourseDAO();
    }

    @Test
    void listAllCourses() throws SQLException {
        assertTrue(MY_SQL_CONTAINER.isRunning());

        // ACT
        List<Course> allCourses = courseDAO.getAllCourses();

        //ASSERT
        assertNotNull(allCourses);
        assertEquals(2, allCourses.size());
    }

}