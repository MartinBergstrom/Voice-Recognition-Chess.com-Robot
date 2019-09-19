package rest.model.validation;

public interface Validator<V> {

    void validate(V input);

}
