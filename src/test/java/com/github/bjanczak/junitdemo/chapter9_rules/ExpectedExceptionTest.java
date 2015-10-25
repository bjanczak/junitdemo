package com.github.bjanczak.junitdemo.chapter9_rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * The ExpectedException Rule allows in-test specification of expected exception types and messages.
 *
 * @author Bartłomiej Jańczak
 */
public class ExpectedExceptionTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void testThrowingNothing() {

    }

    @Test
    public void testThrowingNumberFormatException() {
        thrown.expect(NumberFormatException.class);
        throw new NumberFormatException();
    }

    @Test
    public void testThrowingNumberFormatExceptionWithMessage() {
        thrown.expect(NumberFormatException.class);
        thrown.expectMessage("wrong!");
        thrown.expectMessage(org.hamcrest.CoreMatchers.startsWith("Something"));
        throw new NumberFormatException("Something went wrong!");
    }
}
