package com.veimar.libreria_digital.interfaces;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MinPagesValidator implements ConstraintValidator<MinPages, Integer> {
    int minPages;

    @Override
    public void initialize(MinPages constraintAnnotation) {
        this.minPages = constraintAnnotation.minimumPages();
    }

    @Override
    public boolean isValid(Integer numPages, ConstraintValidatorContext constraintValidatorContext) {

        if (numPages == null) {
            return false;
        }

        return numPages >= minPages;
    }
}
