package com.github.bjanczak.junitdemo;

import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit more construct.
 *
 * 1) One may ignore test using @Ignore annotation.
 * 2) @Test annotation beside marking test method allows as well:
 * 2.1) check whether specific exception by @Test(expected = {exception_class_name}.class),
 * 2.2) apply timeout constraint on method @Test(timeout = {timeout_in_miliseconds}).
 *
 * @author Bartłomiej Jańczak
 */
public class Chapter2_BaseConstructs {

    @Test(expected = NumberFormatException.class)
    public void doubleValueOfNumberFormatExceptionTest() {
        System.out.print("doubleValueOfNumberFormatExceptionTest");
        Double tmpDouble = Double.valueOf("error");
    }

    @Test(timeout = 100)
    public void timeoutTest() throws InterruptedException {
        System.out.print("timeoutTest");
        Thread.sleep(19);
    }

    @Ignore("Test is ignore because I don't like it!")
    public void ignoredTest() {
        System.out.print("ignoredTest");
    }
}
