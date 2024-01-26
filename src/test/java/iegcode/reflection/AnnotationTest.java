package iegcode.reflection;

import iegcode.reflection.data.Person;
import iegcode.reflection.validation.Validator;
import org.junit.jupiter.api.Test;

public class AnnotationTest {

    @Test
    void testValidateUsingAnnotation() throws IllegalAccessException {

        Person person = new Person("Ibrahim", "Gibran");
        Validator.validateNotBlank(person);
    }
}
