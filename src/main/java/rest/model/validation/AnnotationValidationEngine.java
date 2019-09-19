package rest.model.validation;

import rest.model.ChessPositionVoiceCommand;
import rest.model.MovePiece;
import rest.model.validation.CustomAnnotations.ValidatedBy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

public class AnnotationValidationEngine {

    /*
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MovePiece movePiece = new MovePiece(new ChessPositionVoiceCommand('a', 1),
                new ChessPositionVoiceCommand('b', 2));

        runValidationOnBean(movePiece);
    }
    */

    @SuppressWarnings("unchecked")
    private static <V, T> V getValueFromField(Field field, T object) throws IllegalAccessException {
        return (V) field.get(object);
    }

    public static <T> void runValidationOnBean(T obj) throws IllegalAccessException, InstantiationException {
        runValidationOnFieldsWithAnnotationValidation(obj);
    }

    private static <T, V> void runValidationOnFieldsWithAnnotationValidation(T obj) throws IllegalAccessException, InstantiationException {
        for (Field field : obj.getClass().getDeclaredFields())
        {
            if (field.getType().getDeclaredFields().length > 0)
            {
                field.setAccessible(true);
                runValidationOnFieldsWithAnnotationValidation(field.get(obj));
            }

            Optional<? extends Class<? extends Annotation>> annotationClazz = hasValidationAnnotation(field);
            if (annotationClazz.isPresent())
            {
                field.setAccessible(true);
                V value = getValueFromField(field, obj);
                Class<? extends Validator<V>> validator = getValidator(annotationClazz.get());
                validator.newInstance().validate(value);
            }
        }
    }

    private static Optional<? extends Class<? extends Annotation>> hasValidationAnnotation(Field field)
    {
        if (field.getDeclaredAnnotations().length > 0)
        {
            return Arrays.stream(field.getDeclaredAnnotations())
                    .map(Annotation::annotationType)
                    .filter(annotationType -> annotationType.isAnnotationPresent(ValidatedBy.class))
                    .findFirst();
        }
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    private static <T extends Class<? extends Annotation>, V> Class<? extends Validator<V>> getValidator(T annotationClazz)
    {
        return (Class<? extends Validator<V>>) (annotationClazz.getAnnotation(ValidatedBy.class).implClass());
    }

}
