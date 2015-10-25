package com.github.bjanczak.junitdemo.chapter9_rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * The TestName Rule makes the current test name available inside test methods.
 *
 * @author Bartłomiej Jańczak
 */
public class TestNameTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void firstTest() {
        org.junit.Assert.assertEquals("firstTest", name.getMethodName());
    }

    @Test
    public void secondTest() {
        org.junit.Assert.assertEquals("secondTest", name.getMethodName());
    }
}
