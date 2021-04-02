package com.dataprocessingproject.dataprocessing;


import com.dataprocessingproject.dataprocessing.models.CourseModel;
import com.dataprocessingproject.dataprocessing.models.PlayerModel;
import com.dataprocessingproject.dataprocessing.repositories.CourseRepository;
import com.dataprocessingproject.dataprocessing.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/main")
public class MainController {
    @Autowired
    private CourseRepository courseRepository;
    private PlayerRepository playerRepository;

    @GetMapping("/{id}")
    public ResponseEntity<PlayerModel> findCourseById(@PathVariable(value = "id") String id) {
        Optional<CourseModel> course = courseRepository.findById(id);

        if(course.isPresent()) { // Hier dan de maker ophalen en laten zien
            ResponseEntity<String> maker = ResponseEntity.ok().body(course.get().getMaker()); // Haal maker op

            Optional<PlayerModel> player = playerRepository.findById("NolramImpro");

            if(player.isPresent()) {
                return ResponseEntity.ok().body(player.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
