package com.enjoy.sessions.java8.optional.game;

public class GameConnectionPool {

    public boolean isInitialized() {
        return true;
    }

    public GameConnection getConnection() {
        return new GameConnection();
    }

}
