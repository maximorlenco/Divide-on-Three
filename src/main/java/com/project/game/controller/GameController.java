package com.project.game.controller;

import com.project.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/game/start")
    public ResponseEntity startGame() {
        return ResponseEntity.ok().body(gameService.game());
    }

    @PostMapping("/game/{number}")
    public ResponseEntity playerGame(@PathVariable long number) {
        return ResponseEntity.ok().body(gameService.game(number,1));
    }
}
