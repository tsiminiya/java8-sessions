package com.enjoy.sessions.java8.optional.player;

import lombok.AllArgsConstructor;

import java.util.Optional;

// this is business logic class
@AllArgsConstructor
public class DefaultPlayerService implements PlayerService {

    private PlayerRepository playerRepository;

    // this method can be improved
    @Override
    public Player getPlayer(User user) {
        Optional<String> username = Optional.ofNullable(user.getUsername());
        if (username.isPresent()) {
            Optional<Player> player = playerRepository.getPlayer(username.get());
            if (player.isPresent()) {
                return player.get();
            }
            throw new PlayerNotFoundException(username.get());
        }
        throw new IllegalArgumentException();
    }

}
