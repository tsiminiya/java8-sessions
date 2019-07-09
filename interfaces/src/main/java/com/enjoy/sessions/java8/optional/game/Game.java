package com.enjoy.sessions.java8.optional.game;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Game {

    private GameChannel gameChannel;

    public void connect() {
        GameChannel channel = getGameChannel();
        if (channel != null) {
            GameConnectionPool pool = channel.getConnectionPool();
            if (pool != null && pool.isInitialized()) {
                GameConnection conn = pool.getConnection();
                if (conn != null && conn.isOpen()) {
                    conn.assign(this);
                }
            }
        }
    }

    private GameChannel getGameChannel() {
        return getGameChannel();
    }

}
