package com.enjoy.sessions.java8.interfaces.player;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PlayerEntity {

    @Id
    String id;

    String email;

    String firstName;

    String lastName;

    String city;

    String country;

}
