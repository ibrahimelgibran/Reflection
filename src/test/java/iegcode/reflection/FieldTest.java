package iegcode.reflection;

import iegcode.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    void testGetFields() {

        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field firstName = personClass.getDeclaredField("firstName");
        firstName.setAccessible(true);

        Person person1 = new Person("Gibran", "Ibrahim");
        firstName.set(person1, "ElGibran"); // person1.setFirstName("ElGibran")
        System.out.println(person1.getFirstName());

        Person person2 = new Person("Ibrahim", "Gibran");
        String result2 = (String) firstName.get(person2);
        System.out.println(result2);
    }
}
