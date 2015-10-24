package com.github.bjanczak.junitdemo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * By design, JUnit does not specify the execution order of test method invocations.
 * The methods were simply invoked in the order returned by the reflection API.
 * However, using the JVM order is unwise since the Java platform does not specify any particular order,
 * and in fact JDK 7 returns a more or less random order.
 *
 * @author Bartłomiej Jańczak
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Chapter4_TestExecutionOrder {

    @Test
    public void testA() {
        System.out.println("testA");
    }

    @Test
    public void testB() {
        System.out.println("testB");
    }

    @Test
    public void testC() {
        System.out.println("testC");
    }
}
