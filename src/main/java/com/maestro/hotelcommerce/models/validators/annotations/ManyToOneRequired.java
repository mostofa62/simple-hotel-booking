package com.maestro.hotelcommerce.models.validators.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.maestro.hotelcommerce.models.validators.ManyToOneRequiredHotel;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = {ManyToOneRequiredHotel.class})
public @interface ManyToOneRequired {
	String message() default "Related Model is required";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
