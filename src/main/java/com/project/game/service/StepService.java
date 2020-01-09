package com.project.game.service;

import com.project.game.model.Player;
import com.project.game.model.Step;

public interface StepService {

    Step create(Long number, Player player);
}
