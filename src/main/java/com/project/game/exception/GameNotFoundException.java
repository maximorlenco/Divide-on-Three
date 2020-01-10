package com.project.game.exception;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String msg) {
        super(msg);
    }
}
