package com.enjoy.sessions.java8.optional.player;

public class PlayerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7089235569516380597L;

    private final String username;

    public PlayerNotFoundException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
