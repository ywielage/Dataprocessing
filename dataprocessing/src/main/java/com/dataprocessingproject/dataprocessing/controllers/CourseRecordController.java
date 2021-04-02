package com.dataprocessingproject.dataprocessing.controllers;

import com.dataprocessingproject.dataprocessing.models.CourseRecordModel;
import com.dataprocessingproject.dataprocessing.repositories.CourseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courseRecords")// Geeft locatie aan
public class CourseRecordController { // Geeft alle fucnties van courseRecords aan
    @Autowired
    private CourseRecordRepository courseRecordRepository;

    @GetMapping
    public List<CourseRecordModel> findallCourseRecords(){
        return (List<CourseRecordModel>) courseRecordRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseRecordModel> findCourseRecordByID(@PathVariable(value = "id") String id) {
        Optional<CourseRecordModel> courseRecord = courseRecordRepository.findById(id);

        if(courseRecord.isPresent()) {
            return ResponseEntity.ok().body(courseRecord.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
