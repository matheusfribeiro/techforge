package com.techforge.service;

import com.techforge.dto.CourseDTO;
import com.techforge.mapper.CourseMapper;
import com.techforge.models.Course;
import com.techforge.repository.CourseRepository;
import com.techforge.repository.SubcategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final SubcategoryRepository subcategoryRepository;

    public CourseService(CourseRepository courseRepository, SubcategoryRepository subcategoryRepository) {
        this.courseRepository = courseRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @Transactional(readOnly = true)
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream()
                .map(CourseMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public Optional<CourseDTO> findById(int id) {
        return courseRepository.findById(id)
                .map(CourseMapper::toDTO);
    }

    @Transactional
    public CourseDTO save(CourseDTO dto) {
        Course entity = CourseMapper.toEntity(dto, subcategoryRepository);
        Course saved = courseRepository.save(entity);
        return CourseMapper.toDTO(saved);
    }

    @Transactional
    public CourseDTO update(int id, CourseDTO dto) {
        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id " + id));

        existing.setName(dto.name());
        existing.setCode(dto.code());
        existing.setEstimatedCompletionTime(dto.estimatedCompletionTime());
        existing.setVisibility(dto.visibility());
        existing.setTargetAudience(dto.targetAudience());
        existing.setInstructorName(dto.instructorName());
        existing.setSyllabus(dto.syllabus());
        existing.setDevelopedSkills(dto.developedSkills());

        var sub = subcategoryRepository.findById(dto.subcategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Subcategory not found with id " + dto.subcategoryId()));
        existing.setSubcategory(sub);

        Course updated = courseRepository.save(existing);
        return CourseMapper.toDTO(updated);
    }

    public boolean deleteById(int id) {
        if (!courseRepository.existsById(id)) {
            return false;
        }
        courseRepository.deleteById(id);
        return true;
    }
}
