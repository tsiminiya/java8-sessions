package com.enjoy.sessions.java8.optional.player;

import java.util.Optional;

// this is an API
public class DefaultPlayerRepository implements PlayerRepository {

    @Override
    public Optional<Player> getPlayer(String username) {
        // this is just a dummy example
        if (username.equalsIgnoreCase("romeo")) {
            return Optional.of(Player.builder()
                    .firstName("Romeo")
                    .lastName("Maranan")
                    .city("Antipolo")
                    .country("Philippines")
                    .build());
        }
        // never return null
        return Optional.empty();
    }

}
