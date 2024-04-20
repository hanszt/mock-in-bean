package com.teketik.test.mockinbean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BeanUtilsFindFieldTest {

    abstract class BaseClazz {
        String baseField;
    }

    class Clazz1 extends BaseClazz {
        String field1;
        String baseField;
    }

    @Test
    public void testFindField_oneMatch() {
        Assertions.assertNull(BeanUtils.findField(BaseClazz.class, null, Integer.class));
        assertEquals("baseField", BeanUtils.findField(BaseClazz.class, null, String.class).getName());
        assertEquals("baseField", BeanUtils.findField(BaseClazz.class, "baseField", String.class).getName());
        assertEquals("baseField", BeanUtils.findField(BaseClazz.class, "not used", String.class).getName());
    }

    @Test
    public void testFindField_multiMatch() {
        final var ex = Assertions.assertThrows(IllegalArgumentException.class,
                () -> BeanUtils.findField(Clazz1.class, null, String.class));
        assertEquals("Multiple fields of type class java.lang.String in class com.teketik.test.mockinbean.BeanUtilsFindFieldTest$Clazz1. Please specify a name.", ex.getMessage());

        final var e2 = assertThrows(IllegalArgumentException.class,
                () -> BeanUtils.findField(Clazz1.class, "baseField", String.class));
        assertEquals("Multiple fields of type class java.lang.String in class com.teketik.test.mockinbean.BeanUtilsFindFieldTest$Clazz1 with name baseField", e2.getMessage());

        final var e3 = assertThrows(IllegalArgumentException.class,
                () -> BeanUtils.findField(Clazz1.class, "no match", String.class));
        assertEquals("Multiple fields of type class java.lang.String in class com.teketik.test.mockinbean.BeanUtilsFindFieldTest$Clazz1 and none with name no match", e3.getMessage());

        assertEquals("field1", BeanUtils.findField(Clazz1.class, "field1", String.class).getName());
    }

}
