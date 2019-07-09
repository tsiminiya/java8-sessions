package com.enjoy.sessions.java8.interfaces.player;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class DefaultPlayerService implements PlayerService {

    private PlayerRepository playerRepository;

    @Override
    public Optional<Player> findPlayerByEmail(String email) {
        return playerRepository.findByEmail(email)
                .map(playerEntity -> toPlayer(playerEntity));
        // Above can be replaced by the following:
        // return playerRepository.findById(id).map(this::toPlayer);
    }

}
