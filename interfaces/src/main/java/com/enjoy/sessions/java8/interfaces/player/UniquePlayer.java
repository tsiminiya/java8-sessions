package com.enjoy.sessions.java8.interfaces.player;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniquePlayerValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePlayer {

    String message() default "Player already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
