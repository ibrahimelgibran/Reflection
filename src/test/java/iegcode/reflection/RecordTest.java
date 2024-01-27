package iegcode.reflection;

import iegcode.reflection.data.Product;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;

public class RecordTest {

    @Test
    void testClassRecord() {

        Class<Product> productClass = Product.class;

        System.out.println(productClass.isRecord());
        System.out.println(Arrays.toString(productClass.getDeclaredFields()));
        System.out.println(Arrays.toString(productClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(productClass.getRecordComponents()));
    }

    @Test // kalo manual
    void testGetRecordValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Product> productClass = Product.class;
        Method id = productClass.getDeclaredMethod("id");
        Method name = productClass.getDeclaredMethod("name");
        Method price = productClass.getDeclaredMethod("price");

        Product product = new Product("1", "Macbook m3", 20000000L);
        System.out.println(id.invoke(product));
        System.out.println(name.invoke(product));
        System.out.println(price.invoke(product));
    }

    @Test
    void testGetRecordValueByComponent() throws InvocationTargetException, IllegalAccessException {

        Class<Product> productClass = Product.class;
        RecordComponent[] components = productClass.getRecordComponents();

        Product product = new Product("1", "Macbook m3", 20000000L);

        for (RecordComponent component : components) {
            Method accessor = component.getAccessor();
            System.out.println(accessor.getName());
            System.out.println(accessor.invoke(product));
        }
    }
}
