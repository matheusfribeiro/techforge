package com.techforge.persistance;

import com.techforge.models.Course;
import com.techforge.models.Visibility;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public Course getCourseById(int id) throws SQLException {
        String sql = "SELECT * FROM course WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToCourse(rs);
                } else {
                    return null;
                }
            }
        }
    }

    public List<Course> getAllCourses() throws SQLException {
        String sql = "SELECT * FROM course";
        try (Connection conn = Database.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)) {
            List<Course> list = new ArrayList<>();
            while (rs.next()) {
                list.add(mapRowToCourse(rs));
            }
            return list;
        }
    }

    public int addCourse(Course course) throws SQLException {
        String sql = """
            INSERT INTO course
              (name, code, estimated_completion_time,
               visibility, target_audience, instructor_name,
               syllabus, developed_skills)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, course.getName());
            ps.setString(2, course.getCode());
            ps.setInt   (3, course.getEstimatedCompletionTime());
            ps.setString(4, course.getVisibility().name());
            ps.setString(5, course.getTargetAudience());
            ps.setString(6, course.getInstructorName());
            ps.setString(7, course.getSyllabus());
            ps.setString(8, course.getDevelopedSkills());

            //ps.setObject(9, course.getSubcategory().getId());

            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int id = keys.getInt(1);
                    return id;
                }

                throw new IllegalStateException("Course should have a generated key");

            }
        }
    }

    public void updateCourse(Course course) throws SQLException {
        String sql = """
            UPDATE course SET
              name = ?, code = ?, estimated_completion_time = ?,
              visibility = ?, target_audience = ?, instructor_name = ?,
              syllabus = ?, developed_skills = ?, subcategory_id = ?
            WHERE id = ?
            """;

        try (Connection conn = Database.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course.getName());
            ps.setString(2, course.getCode());
            ps.setInt   (3, course.getEstimatedCompletionTime());
            ps.setString(4, course.getVisibility().name());
            ps.setString(5, course.getTargetAudience());
            ps.setString(6, course.getInstructorName());
            ps.setString(7, course.getSyllabus());
            ps.setString(8, course.getDevelopedSkills());
            ps.setObject(9, course.getSubcategory().getId());
            ps.setInt   (10, course.getId());

            ps.executeUpdate();
        }
    }

    public Course deleteCourse(int id) throws SQLException {
        Course course = getCourseById(id);

        if (course == null) {
            return null;
        }

        String sql = "DELETE FROM course WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

        return course;
    }



    private Course mapRowToCourse(ResultSet rs) throws SQLException {
        return new Course(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("code"),
                rs.getInt("estimated_completion_time"),
                Visibility.valueOf(rs.getString("visibility")),
                rs.getString("target_audience"),
                rs.getString("instructor_name"),
                rs.getString("syllabus"),
                rs.getString("developed_skills"),
                null // subcategoryDAO ?
        );
    }
}
