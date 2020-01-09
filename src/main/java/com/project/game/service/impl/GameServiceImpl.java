package com.project.game.service.impl;

import com.project.game.exception.GameNotFoundException;
import com.project.game.model.Game;
import com.project.game.model.Player;
import com.project.game.model.Step;
import com.project.game.repository.GameRepository;
import com.project.game.service.GameService;
import com.project.game.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    StepService stepService;

    @Override
    public Game create() {
        Game game =new Game();
        List<Step> stepList =new LinkedList<>();
        game.setSteps(stepList);
        return gameRepository.save(game);
    }

    @Override
    public Game getGameById(Long id) {
        Optional<Game> byId = gameRepository.findById(id);
        if (!byId.isPresent()) {
            throw new GameNotFoundException("Game with id :" + id + "is not found");
        }
        return byId.get();
    }

    @Override
    public Game play(Long number, Integer startPlayer) {
        Game newGame = create();

        Player firstPlayer;
        Player secondPlayer;
        Player PlayerInThisStep;
        if (startPlayer == 0) {
            firstPlayer = Player.COMPUTER;
            secondPlayer = Player.PLAYER;
        } else {
            firstPlayer = Player.PLAYER;
            secondPlayer = Player.COMPUTER;
        }
        addStepToGame(newGame.getId(), stepService.create(number, firstPlayer));
        stepService.create(number, firstPlayer);

        Long numberToDivide = number;
        for (int i = 1; numberToDivide >1; i++) {
            if (i % 2 == 0) {
                PlayerInThisStep = secondPlayer;
            } else {
                PlayerInThisStep = firstPlayer;
            }
            if (numberToDivide % 3 == 0) {
                numberToDivide = divideOnThree(numberToDivide);
                addStepToGame(newGame.getId(), stepService.create(numberToDivide, PlayerInThisStep));
            } else {
                if (numberToDivide++ % 3 == 0) {
                    numberToDivide = divideOnThree(numberToDivide);
                    addStepToGame(newGame.getId(), stepService.create(numberToDivide, PlayerInThisStep));
                } else if (numberToDivide-- % 3 == 0) {
                    numberToDivide = divideOnThree(numberToDivide);
                    addStepToGame(newGame.getId(), stepService.create(numberToDivide, PlayerInThisStep));
                }
            }
        }


        return gameRepository.save(newGame);
    }


    @Override
    public Integer choosePlayerForFirstStep() {
        Random gen = new Random();
        return gen.nextInt((1 - 0) + 1) + 0;
    }

    @Override
    public void addStepToGame(Long gameId, Step step) {
        Game game = getGameById(gameId);
        List<Step> steps = game.getSteps();
        steps.add(step);
        gameRepository.save(game);
    }

    public static Long divideOnThree(Long number) {
        return number / 3;
    }

}
