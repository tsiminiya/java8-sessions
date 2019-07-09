package com.enjoy.sessions.java8.optional.player;

import java.util.Optional;

public interface PlayerRepository {

    Optional<Player> getPlayer(String username);

}
