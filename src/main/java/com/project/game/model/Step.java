package com.project.game.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "STEP")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Step {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PLAYER", nullable = false)
    private Player player;

    @Column(name = "NUMBER", nullable = false)
    private Long number;
}
