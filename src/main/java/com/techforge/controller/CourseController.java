package com.techforge.controller;

import com.techforge.models.Course;
import com.techforge.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course savedCourse = courseService.save(course);
        return ResponseEntity
                .created(URI.create("/course/" + savedCourse.getId()))
                .body(savedCourse);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        return courseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Optional<ResponseEntity<Course>> updateCourse(@PathVariable int id, @RequestBody Course course) {
        return Optional.of(courseService.findById(id).map(existing -> {
            existing.setName(course.getName());
            existing.setCode(course.getCode());
            existing.setEstimatedCompletionTime(course.getEstimatedCompletionTime());
            existing.setVisibility(course.getVisibility());
            existing.setTargetAudience(course.getTargetAudience());
            existing.setInstructorName(course.getInstructorName());
            existing.setSyllabus(course.getSyllabus());
            existing.setDevelopedSkills(course.getDevelopedSkills());
            existing.setSubcategory(course.getSubcategory());
            Course updated = courseService.save(existing);
            return ResponseEntity.ok(updated);
        }).orElse((ResponseEntity.notFound().build())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable int id) {
        return courseService.deleteById(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
