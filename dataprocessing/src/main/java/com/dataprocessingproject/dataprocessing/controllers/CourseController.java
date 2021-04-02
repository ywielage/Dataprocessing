package com.dataprocessingproject.dataprocessing.controllers;

import com.dataprocessingproject.dataprocessing.models.CourseModel;
import com.dataprocessingproject.dataprocessing.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")// Geeft locatie aan
public class CourseController { // geeft alle functies van Course aan
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<CourseModel> findallCourses(){
        return (List<CourseModel>) courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseModel> findCourseById(@PathVariable(value = "id") String id) {
        Optional<CourseModel> course = courseRepository.findById(id);

        if(course.isPresent()) {
            return ResponseEntity.ok().body(course.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CourseModel saveCourse(@Validated @RequestBody CourseModel course){
        return courseRepository.save(course);
    }
}
