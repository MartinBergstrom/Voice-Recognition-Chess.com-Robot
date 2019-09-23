package rest.model.customValidation;

import annotations.ValidatedBy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ValidatedBy(implClass = ChessDigitValidator.class)
public @interface ChessDigit { }
