package iegcode.reflection;

import iegcode.reflection.data.Person;
import org.junit.jupiter.api.Test;

public class SuperClass {
    @Test
    void testGetSuperClass() {

        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Class<? super Person> objectClass = personClass.getSuperclass();
        System.out.println(objectClass);

        Class<? super Person> nullClass = objectClass.getSuperclass();
        System.out.println(nullClass);
    }
}
