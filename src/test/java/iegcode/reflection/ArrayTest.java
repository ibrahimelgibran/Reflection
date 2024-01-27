package iegcode.reflection;

import iegcode.reflection.data.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {

    @Test
    void testArrayClass() {

        Class<String[]> stringArrayClass = String[].class;
        Class<int[]> intArrayClass = int[].class;
        Class<Person> personClass = Person.class;

        System.out.println(stringArrayClass.isArray());
        System.out.println(intArrayClass.isArray());
        System.out.println(personClass.isArray());
    }

    @Test
    void testArrayMember() {
        Class<String[]> stringArrayClass = String[].class;

        System.out.println(Arrays.toString(stringArrayClass.getDeclaredFields()));
        System.out.println(Arrays.toString(stringArrayClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(stringArrayClass.getDeclaredMethods()));
        System.out.println(stringArrayClass.getComponentType());
    }

    @Test
    void testArrayManipulation() {

        Class<String[]> stringArrayClass = String[].class;

        String[] array = (String[]) Array.newInstance(stringArrayClass.getComponentType(), 5);

        Array.set(array, 0, "Ibarhim");
        Array.set(array, 1, "El");
        Array.set(array, 2, "Gibran");

        System.out.println(Arrays.toString(array));

        System.out.println(Array.get(array, 0));
        System.out.println(Array.get(array, 1));
        System.out.println(Array.get(array, 3));
    }
}
