package com.github.bjanczak.junitdemo.chapter9_rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * The ErrorCollector Rule allows execution of a test to continue after the first problem is found
 * (for example, to collect all the incorrect rows in a table, and report them all at once).
 *
 * @author Bartłomiej Jańczak
 */
public class ErrorCollectTest {
    @Rule
    public ErrorCollector collector= new ErrorCollector();

    @Test
    public void test() {
        collector.addError(new Throwable("first thing went wrong"));
        collector.addError(new Throwable("second thing went wrong"));
    }
}
