package iegcode.reflection;

import iegcode.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ConstructorTest {

    @Test
    void testConstructors() {

        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(personClass.getName());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
            System.out.println("==============");
        }
    }

    @Test
    void testCreateUsingConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Person> personClass = Person.class;

        Constructor<Person> constructor = personClass.getConstructor();
        Constructor<Person> constructorParameters = personClass.getConstructor(String.class, String.class);

        Person person1 = constructor.newInstance();
        Person person2 = constructorParameters.newInstance("Ibrahim", "Gibran");

        System.out.println(person1);
        System.out.println(person2);
    }
}
