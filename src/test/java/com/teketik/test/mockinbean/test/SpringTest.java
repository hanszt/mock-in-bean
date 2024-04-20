package com.teketik.test.mockinbean.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.springframework.test.context.TestConstructor.AutowireMode.ALL;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("testing")
@ContextConfiguration(locations = "/app-beans.xml")
@TestConstructor(autowireMode = ALL)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SpringTest {
}
