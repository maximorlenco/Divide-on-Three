package com.project.game.service;

import com.project.game.model.Game;
import com.project.game.model.Step;
import org.springframework.stereotype.Service;

public interface GameService {

    Game create();

    Game getGameById(Long id);

    String game(Long number, Integer startPlayer);

    String game();

    Integer choosePlayerForFirstStep();

    void addStepToGame(Long gameId, Step step);

}
