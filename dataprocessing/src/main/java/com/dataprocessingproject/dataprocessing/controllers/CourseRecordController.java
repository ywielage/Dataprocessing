package com.dataprocessingproject.dataprocessing.controllers;

import com.dataprocessingproject.dataprocessing.models.CourseRecordModel;
import com.dataprocessingproject.dataprocessing.repositories.CourseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courseRecords")// Geeft locatie aan
public class CourseRecordController { // Geeft alle fucnties van courseRecords aan
    @Autowired
    private CourseRecordRepository courseRecordRepository;

    @GetMapping
    public List<CourseRecordModel> findallCourseRecords(){
        return (List<CourseRecordModel>) courseRecordRepository.findAll();
    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity<CourseRecordModel> findCourseRecordByID(@PathVariable(value = "id") String id) {
//        Optional<CourseRecordModel> courseRecord = courseRecordRepository.findById(id);
//
//        if(courseRecord.isPresent()) {
//            return ResponseEntity.ok().body(courseRecord.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/id/{id}")
    public List<CourseRecordModel> findRecordsById(@PathVariable(value = "id") String id) { // Pakt alle records met dit id.
        List<CourseRecordModel> records = (List<CourseRecordModel>) courseRecordRepository.findAll();
        List<CourseRecordModel> foundRecords = new ArrayList<>();

        for(CourseRecordModel r : records) {
            if(r.getId().equals(id)) {
                foundRecords.add(r);
            }
        }
        return foundRecords;
    }

    @GetMapping("/date/{date}")
    public List<CourseRecordModel> findRecordsByDate(@PathVariable(value = "date") String date) { // Pakt alle records met deze date.
        List<CourseRecordModel> records = (List<CourseRecordModel>) courseRecordRepository.findAll();
        List<CourseRecordModel> foundRecords = new ArrayList<>();

        for(CourseRecordModel r : records) {
            if(r.getDate().equals(date)) {
                foundRecords.add(r);
            }
        }
        return foundRecords;
    }

    @GetMapping("/player/{player}")
    public List<CourseRecordModel> findRecordsByPlayer(@PathVariable(value = "player") String player) { // Pakt alle records met deze speler.
        List<CourseRecordModel> records = (List<CourseRecordModel>) courseRecordRepository.findAll();
        List<CourseRecordModel> foundRecords = new ArrayList<>();

        for(CourseRecordModel r : records) {
            if(r.getPlayer().equals(player)) {
                foundRecords.add(r);
            }
        }
        return foundRecords;
    }

    @GetMapping("/record/{record}")
    public List<CourseRecordModel> findRecordsByRecord(@PathVariable(value = "record") String record) { // Pakt alle records met deze record.
        List<CourseRecordModel> records = (List<CourseRecordModel>) courseRecordRepository.findAll();
        List<CourseRecordModel> foundRecords = new ArrayList<>();

        for(CourseRecordModel r : records) {
            if(r.getRecord().equals(record)) {
                foundRecords.add(r);
            }
        }
        return foundRecords;
    }

}
