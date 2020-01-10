package com.project.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GAME")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Step.class)
    @JoinTable(name = "GAME_STEPS", joinColumns = {@JoinColumn(name = "GAME_ID")},
            inverseJoinColumns = {@JoinColumn(name = "STEP_ID")})
    private List<Step> steps;

    @Column(name = "WINNER")
    private String winner;
}
