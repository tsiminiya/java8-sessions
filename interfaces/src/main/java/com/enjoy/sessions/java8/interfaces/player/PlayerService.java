package com.enjoy.sessions.java8.interfaces.player;

import java.util.Optional;

public interface PlayerService {

    Optional<Player> findPlayerByEmail(String email);

    default Player toPlayer(PlayerEntity playerEntity) {
        return Player.builder()
                .id(playerEntity.getId())
                .email(playerEntity.getEmail())
                .firstName(playerEntity.getFirstName())
                .lastName(playerEntity.getLastName())
                .city(playerEntity.getCity())
                .country(playerEntity.getCountry())
                .build();
    }

}
