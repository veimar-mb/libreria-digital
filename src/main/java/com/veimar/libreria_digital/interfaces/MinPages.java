package com.veimar.libreria_digital.interfaces;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinPagesValidator.class)
public @interface MinPages {

    int minimumPages() default 10;
    String message() default "El libro debe tener al menos 10 páginas";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
