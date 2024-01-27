package iegcode.reflection;

import iegcode.reflection.data.Data;
import org.junit.jupiter.api.Test;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class TypeVariableTest {

    @Test
    void testTypeVariables() {
        Class<Data> dataClass = Data.class;

        TypeVariable<Class<Data>>[] typeVariables = dataClass.getTypeParameters();

        for (TypeVariable<Class<Data>> variable : typeVariables) {
            System.out.println(variable.getName());
            System.out.println(Arrays.toString(variable.getBounds()));
            System.out.println(variable.getGenericDeclaration());

        }
    }
}
