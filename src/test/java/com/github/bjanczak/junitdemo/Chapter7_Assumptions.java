package com.github.bjanczak.junitdemo;

import static org.junit.Assume.*;

import org.junit.Test;

/**
 * Usually developer has control of all the forces that might cause test to fail.
 * But if not, for example, if a test fails when run in a different locale than the developer intended,
 * then the locale can be passed as an argument.
 *
 * When it is not possible or desired. When we would like run a test against code that is currently written
 * or write a test that exposes a known bug. For such situations JUnit allows assumptions.
 *
 * 1) The default JUnit runner treats tests with failing assumptions as ignored.
 * 2) A failing assumption in a @Before or @BeforeClass method will have the same effect as a failing assumption
 * in each @Test method of the class.
 *
 * @author Bartłomiej Jańczak
 */
public class Chapter7_Assumptions {

    @Test
    public void testAssumptionTrue() {
        org.junit.Assume.assumeTrue("success - strings are equal", "text".equals("text"));
        org.junit.Assert.assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void testAssumptionFalse() {
        org.junit.Assume.assumeTrue("failure - strings are not equal", "text".equals("error"));
        org.junit.Assert.assertEquals("failure - strings are not equal", "text", "error");
    }
}
