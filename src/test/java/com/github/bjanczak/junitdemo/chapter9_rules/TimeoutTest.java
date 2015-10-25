package com.github.bjanczak.junitdemo.chapter9_rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

/**
 * The Timeout Rule applies the same timeout to all test methods in a class.
 *
 * @author Bartłomiej Jańczak
 */
public class TimeoutTest {
    @Rule
    public TestRule globalTimeout = new Timeout(20);

    @Test
    public void testInfiniteLoopTimeoutFirst() {
        while(true){}
    }

    @Test
    public void testInfiniteLoopTimeoutSecond() {
        while(true){}
    }
}
