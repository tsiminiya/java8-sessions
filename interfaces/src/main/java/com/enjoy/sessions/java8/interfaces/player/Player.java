package com.enjoy.sessions.java8.interfaces.player;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {

    String id;

    @UniquePlayer
    String email;

    String firstName;

    String lastName;

    String city;

    String country;

}
