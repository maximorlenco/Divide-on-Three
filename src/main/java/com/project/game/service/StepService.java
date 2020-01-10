package com.project.game.service;

import com.project.game.model.Player;
import com.project.game.model.Step;

import java.util.Optional;

public interface StepService {

    Step create(Long number, Player player);

    Optional<Step> getStepById(Long id);
}
