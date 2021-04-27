package com.dataprocessingproject.dataprocessing.controllers;

import com.dataprocessingproject.dataprocessing.models.CourseModel;
import com.dataprocessingproject.dataprocessing.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courses")// Geeft locatie aan

public class CourseController { // geeft alle functies van Course aan
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<CourseModel> findallCourses(){
        return (List<CourseModel>) courseRepository.findAll();
    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity<CourseModel> findCourseById(@PathVariable(value = "id") String id) {
//        Optional<CourseModel> course = courseRepository.findById(id);
//
//        if(course.isPresent()) {
//            return ResponseEntity.ok().body(course.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/id/{id}")
    public List<CourseModel> findCoursesById(@PathVariable(value = "id") String id) { // Pakt alle records met deze speler.
        List<CourseModel> courses = (List<CourseModel>) courseRepository.findAll();
        List<CourseModel> foundCourses = new ArrayList<>();

        for(CourseModel r : courses) {
            if(r.getId().equals(id)) {
                foundCourses.add(r);
            }
        }
        return foundCourses;
    }

    @GetMapping("/difficulty/{difficulty}")
    public List<CourseModel> findCoursesByDifficulty(@PathVariable(value = "difficulty") String difficulty) { // Pakt alle records met deze speler.
        List<CourseModel> courses = (List<CourseModel>) courseRepository.findAll();
        List<CourseModel> foundCourses = new ArrayList<>();

        for(CourseModel r : courses) {
            if(r.getDifficulty().equals(difficulty)) {
                foundCourses.add(r);
            }
        }
        return foundCourses;
    }

    @GetMapping("/gamestyle/{gamestyle}")
    public List<CourseModel> findCoursesByGamestyle(@PathVariable(value = "gamestyle") String gamestyle) { // Pakt alle records met deze speler.
        List<CourseModel> courses = (List<CourseModel>) courseRepository.findAll();
        List<CourseModel> foundCourses = new ArrayList<>();

        for(CourseModel r : courses) {
            if(r.getGamestyle().equals(gamestyle)) {
                foundCourses.add(r);
            }
        }
        return foundCourses;
    }

    @GetMapping("/maker/{maker}")
    public List<CourseModel> findCoursesByMaker(@PathVariable(value = "maker") String maker) { // Pakt alle records met deze speler.
        List<CourseModel> courses = (List<CourseModel>) courseRepository.findAll();
        List<CourseModel> foundCourses = new ArrayList<>();

        for(CourseModel r : courses) {
            if(r.getMaker().equals(maker)) {
                foundCourses.add(r);
            }
        }
        return foundCourses;
    }

    @GetMapping("/title/{title}")
    public List<CourseModel> findCoursesByTitle(@PathVariable(value = "title") String title) { // Pakt alle records met deze speler.
        List<CourseModel> courses = (List<CourseModel>) courseRepository.findAll();
        List<CourseModel> foundCourses = new ArrayList<>();

        for(CourseModel r : courses) {
            if(r.getTitle().equals(title)) {
                foundCourses.add(r);
            }
        }
        return foundCourses;
    }

    @GetMapping("/thumbnail/{thumbnail}")
    public List<CourseModel> findCoursesByThumbnail(@PathVariable(value = "thumbnail") String thumbnail) { // Pakt alle records met deze speler.
        List<CourseModel> courses = (List<CourseModel>) courseRepository.findAll();
        List<CourseModel> foundCourses = new ArrayList<>();

        for(CourseModel r : courses) {
            if(r.getThumbnail().equals(thumbnail)) {
                foundCourses.add(r);
            }
        }
        return foundCourses;
    }

    @GetMapping("/image/{image}")
    public List<CourseModel> findCoursesByImage(@PathVariable(value = "image") String image) { // Pakt alle records met deze speler.
        List<CourseModel> courses = (List<CourseModel>) courseRepository.findAll();
        List<CourseModel> foundCourses = new ArrayList<>();

        for(CourseModel r : courses) {
            if(r.getImage().equals(image)) {
                foundCourses.add(r);
            }
        }
        return foundCourses;
    }

    @GetMapping("/creation/{creation}")
    public List<CourseModel> findCoursesByCreation(@PathVariable(value = "creation") String creation) { // Pakt alle records met deze speler.
        List<CourseModel> courses = (List<CourseModel>) courseRepository.findAll();
        List<CourseModel> foundCourses = new ArrayList<>();

        for(CourseModel r : courses) {
            if(r.getCreation().equals(creation)) {
                foundCourses.add(r);
            }
        }
        return foundCourses;
    }

    @PostMapping
    public CourseModel saveCourse(@Validated @RequestBody CourseModel course){
        return courseRepository.save(course);
    }
}
