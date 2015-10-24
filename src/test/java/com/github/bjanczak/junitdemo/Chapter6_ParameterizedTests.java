package com.github.bjanczak.junitdemo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.google.common.collect.Lists;

/**
 * When running a parameterized test class,
 * instances are created for the cross-product of the test methods and the test data elements.
 *
 * @author Bartłomiej Jańczak
 */
@RunWith(Parameterized.class)
public class Chapter6_ParameterizedTests {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Lists.newArrayList(0), 0},
                {Lists.newArrayList(0, 0), 0},
                {Lists.newArrayList(0, 1, 2), 3},
                {Lists.newArrayList(0, 1, 2, 3), 6}
                });
    }

    /*
     * State.
     */
    private Collection<Integer> input;
    private Integer expected;

    public Chapter6_ParameterizedTests(Collection<Integer> input, Integer expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, Sum.compute(input));
    }

    /**
     * Summing util class.
     */
    private static class Sum {
        public static Integer compute(Collection<Integer> input) {
            Integer result = 0;
            for (Integer element : input) {
                result += element;
            }
            return result;
        }
    }
}
