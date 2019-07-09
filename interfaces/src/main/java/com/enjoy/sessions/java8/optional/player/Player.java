package com.enjoy.sessions.java8.optional.player;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {

    String id;

    String firstName;

    String lastName;

    String city;

    String country;

}
