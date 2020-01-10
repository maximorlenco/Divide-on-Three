package com.project.game.service.impl;

import com.project.game.model.Player;
import com.project.game.model.Step;
import com.project.game.repository.StepRepository;
import com.project.game.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StepServiceImpl implements StepService {

    @Autowired
    StepRepository stepRepository;

    @Override
    public Step create(Long number, Player player) {
        Step step = Step.builder()
                .number(number)
                .player(player)
                .build();
        return stepRepository.save(step);
    }

    @Override
    public Optional<Step> getStepById(Long id) {
        return stepRepository.findById(id);
    }
}
