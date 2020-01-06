package com.project.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="STEP")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Step {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(name = "PLAYER",nullable = false)
    private Player player;
}
