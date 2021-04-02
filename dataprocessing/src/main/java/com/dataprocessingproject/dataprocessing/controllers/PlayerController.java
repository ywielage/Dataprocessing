package com.dataprocessingproject.dataprocessing.controllers;


import com.dataprocessingproject.dataprocessing.models.PlayerModel;
import com.dataprocessingproject.dataprocessing.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<PlayerModel> findallPlayers(){
        return (List<PlayerModel>) playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerModel> findPlayerById(@PathVariable(value = "id") String id) {
        Optional<PlayerModel> player = playerRepository.findById(id);

        if(player.isPresent()) {
            return ResponseEntity.ok().body(player.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PlayerModel saveCourse(@Validated @RequestBody PlayerModel player) {
        return playerRepository.save(player);
    }
}
