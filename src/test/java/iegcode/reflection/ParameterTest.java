package iegcode.reflection;

import iegcode.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterTest {

    @Test
    void testGetParameter() {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Parameter Name = " + parameter.getName());
                System.out.println("Parameter Type = " + parameter.getType());
            }
            System.out.println("==========");
        }
    }

    @Test // memanggil
    void testInvokeMethodWithParameter() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method setFirstName = personClass.getDeclaredMethod("setFirstName", String.class);

        Person person = new Person("Ibarhim", "El");
        setFirstName.invoke(person,"Gibran");

        System.out.println(person.getFirstName());
    }
}
