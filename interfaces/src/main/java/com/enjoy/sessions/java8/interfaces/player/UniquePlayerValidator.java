package com.enjoy.sessions.java8.interfaces.player;

import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class UniquePlayerValidator implements ConstraintValidator<UniquePlayer, String> {

    private PlayerService playerService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !playerService.findPlayerByEmail(email).isPresent();
    }

}
