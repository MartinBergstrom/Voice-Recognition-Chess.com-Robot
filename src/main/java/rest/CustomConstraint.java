package rest;

import javax.validation.*;
import java.lang.annotation.*;
import java.util.Locale;

public class CustomConstraint {
    private static final Validator validator;

    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }

    private static class TestBean {
        @Language
        private String language;
        @Language
        private boolean boolLang;

        public String getLanguage () {
            return language;
        }

        public void setLanguage (String language) {
            this.language = language;
        }

        public void setBoolLang(boolean boolLang)
        {
            this.boolLang = boolLang;
        }
    }

    public static void main (String[] args) {
        TestBean testBean = new TestBean();
        testBean.setLanguage("english");
        testBean.setBoolLang(true);
        validator.validate(testBean).stream().forEach(CustomConstraint::printError);
    }

    private static void printError (
            ConstraintViolation<TestBean> violation) {
        System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
            ElementType.ANNOTATION_TYPE})

    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = {LanguageValidator.class, LanguageValidator2.class})
    @Documented
    public static @interface Language {
        String message () default "must be a valid language display name." +
                " found: ${validatedValue}";

        Class<?>[] groups () default {};

        Class<? extends Payload>[] payload () default {};
    }

    public static class LanguageValidator implements ConstraintValidator<Language, String> {

        @Override
        public void initialize (Language constraintAnnotation) {
        }

        @Override
        public boolean isValid (String value, ConstraintValidatorContext context) {
            if (value == null) {
                return false;
            }
            for (Locale locale : Locale.getAvailableLocales()) {
                if (locale.getDisplayLanguage().equalsIgnoreCase(value)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static class LanguageValidator2 implements ConstraintValidator<Language, Boolean> {

        @Override
        public void initialize (Language constraintAnnotation) {
        }

        @Override
        public boolean isValid (Boolean value, ConstraintValidatorContext context) {
            if (value == null) {
                return false;
            }
            for (Locale locale : Locale.getAvailableLocales()) {
                //if (locale.getDisplayLanguage().equalsIgnoreCase(value)) {
                return false;
                //}
            }

            return false;
        }
    }
}
