package com.dataprocessingproject.dataprocessing.controllers;


import com.dataprocessingproject.dataprocessing.models.PlayerModel;
import com.dataprocessingproject.dataprocessing.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/players") // Geeft locatie aan
public class PlayerController { // Geeft alle functies van de player aan
    @Autowired
    private PlayerRepository playerRepository;

    @CrossOrigin
    @GetMapping
    public List<PlayerModel> findallPlayers(){
        return (List<PlayerModel>) playerRepository.findAll();
    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity<PlayerModel> findPlayerById(@PathVariable(value = "id") String id) {
//        Optional<PlayerModel> player = playerRepository.findById(id);
//
//        if(player.isPresent()) {
//            return ResponseEntity.ok().body(player.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }

    @CrossOrigin
    @GetMapping("/id/{id}")
    public List<PlayerModel> findPlayersById(@PathVariable(value = "id") String id) { // Pakt alle spelers met dit id.
        List<PlayerModel> players = (List<PlayerModel>) playerRepository.findAll();
        List<PlayerModel> foundPlayers = new ArrayList<>();

        for(PlayerModel p : players) {
            if(p.getId().equals(id)) {
                foundPlayers.add(p);
            }
        }
        return foundPlayers;
    }

    @CrossOrigin
    @GetMapping("/flag/{flag}")
    public List<PlayerModel> findPlayersByFlag(@PathVariable(value = "flag") String flag) { // Pakt alle spelers met dit id.
        List<PlayerModel> players = (List<PlayerModel>) playerRepository.findAll();
        List<PlayerModel> foundPlayers = new ArrayList<>();

        for(PlayerModel p : players) {
            if(p.getFlag().equals(flag)) {
                foundPlayers.add(p);
            }
        }
        return foundPlayers;
    }

    @CrossOrigin
    @GetMapping("/name/{name}")
    public List<PlayerModel> findPlayersByName(@PathVariable(value = "name") String name) { // Pakt alle spelers met dit id.
        List<PlayerModel> players = (List<PlayerModel>) playerRepository.findAll();
        List<PlayerModel> foundPlayers = new ArrayList<>();

        for(PlayerModel p : players) {
            if(p.getName().equals(name)) {
                foundPlayers.add(p);
            }
        }
        return foundPlayers;
    }

    @CrossOrigin
    @GetMapping("/image/{image}")
    public List<PlayerModel> findPlayersByImage(@PathVariable(value = "image") String image) { // Pakt alle spelers met dit id.
        List<PlayerModel> players = (List<PlayerModel>) playerRepository.findAll();
        List<PlayerModel> foundPlayers = new ArrayList<>();

        for(PlayerModel p : players) {
            if(p.getImage().equals(image)) {
                foundPlayers.add(p);
            }
        }
        return foundPlayers;
    }

    @PostMapping
    public PlayerModel saveCourse(@Validated @RequestBody PlayerModel player) {
        return playerRepository.save(player);
    }

    @PutMapping("/players/{id}")
    public PlayerModel replacePlayer(@RequestBody PlayerModel newPlayerModel, @PathVariable String id) {
        return playerRepository.findById(id)
                .map(playerModel -> {
                    playerModel.setId(newPlayerModel.getId());
                    playerModel.setImage(newPlayerModel.getImage());
                    playerModel.setFlag(newPlayerModel.getFlag());
                    playerModel.setName(newPlayerModel.getName());
                    return playerRepository.save(playerModel);
                })
                .orElseGet(() -> {
                    newPlayerModel.setId(id);
                    return playerRepository.save(newPlayerModel);
                });
    }

    @DeleteMapping("/players/{id}")
    public void deleteCourse(@PathVariable String id) {
        playerRepository.deleteById(id);
    }
}
