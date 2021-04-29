package com.dataprocessingproject.dataprocessing.controllers;

import com.dataprocessingproject.dataprocessing.models.CourseRecordModel;
import com.dataprocessingproject.dataprocessing.repositories.CourseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courseRecords")// Geeft locatie aan
public class CourseRecordController { // Geeft alle fucnties van courseRecords aan
    @Autowired
    private CourseRecordRepository courseRecordRepository;

    @CrossOrigin
    @GetMapping
    public List<CourseRecordModel> findallCourseRecords(){
        return (List<CourseRecordModel>) courseRecordRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/id/{id}")
    public List<CourseRecordModel> findRecordsById(@PathVariable(value = "id") String id) { // Pakt alle records met dit id. TODO gebruiken voor JSON
        List<CourseRecordModel> records = (List<CourseRecordModel>) courseRecordRepository.findAll();
        List<CourseRecordModel> foundRecords = new ArrayList<>();

        for(CourseRecordModel r : records) {
            if(r.getId().equals(id)) {
                foundRecords.add(r);
            }
        }
        return foundRecords;
    }

    @CrossOrigin
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

    @CrossOrigin
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

    @CrossOrigin
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

    @CrossOrigin
    @PostMapping
    public CourseRecordModel saveCourseRecord (@Validated @RequestBody CourseRecordModel courseRecord){
        return courseRecordRepository.save(courseRecord);
    }

    @CrossOrigin
    @PutMapping("/courseRecords/{id}")
    public CourseRecordModel replaceCourseRecord(@RequestBody CourseRecordModel newCourseRecordModel, @PathVariable String id) {
        return courseRecordRepository.findById(id)
                .map(courseRecordModel -> {
                    courseRecordModel.setDate(newCourseRecordModel.getDate());
                    courseRecordModel.setId(newCourseRecordModel.getId());
                    courseRecordModel.setPlayer(newCourseRecordModel.getPlayer());
                    courseRecordModel.setRecord(newCourseRecordModel.getRecord());
                    return courseRecordRepository.save(courseRecordModel);
                })
                .orElseGet(() -> {
                        newCourseRecordModel.setId(id);
                        return courseRecordRepository.save(newCourseRecordModel);
        });
    }

    @DeleteMapping("/courseRecords/{id}")
    public void deleteCourseRecord(@PathVariable String id) {
        courseRecordRepository.deleteById(id);
    }
}
