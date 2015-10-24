package com.github.bjanczak.junitdemo;

import java.io.Closeable;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

/**
 * JUnit basic constructs.
 *
 * 1) Every test is annotated by @Test annotation.
 * 2) Naming convention
 * 2.1.) Class name -> {tested_class}Test. If you use maven you should use TEST suffix or maven won't see test class.
 * 2.2) Method name -> As a general rule, a test name should explain what the test does so that it can be avoided to
 * read the actual implementation.
 * 3) Class SetUp/TearDown
 * 3.1) @BeforeClass annotates static methods that should be run once before all tests.
 * 3.2) @AfterClass annotates static methods that should be run once after all tests.
 * 4) Method SetUp/TearDown
 * 4.1) @Before annotates methods that should be run once before each tests.
 * 4.2) @After annotates methods that should be run once after each tests.
 *
 * @author Bartłomiej Jańczak
 */
public class Chapter1_TestFictures {

    static class ExpensiveManagedResource implements Closeable {
        @Override
        public void close() throws IOException {}
    }

    static class ManagedResource implements Closeable {
        @Override
        public void close() throws IOException {}
    }


    /**
     * Some static variable.
     */
    private static ExpensiveManagedResource expensiveManagedResource = null;

    /**
     * Some class variable.
     */
    private ManagedResource managedResource = null;



    @BeforeClass
    public static void classSetup() {
        System.out.println("Class setup");
        expensiveManagedResource = new ExpensiveManagedResource();
    }

    @AfterClass
    public static void classTearDown() throws IOException {
        System.out.println("Class tear down");
        expensiveManagedResource.close();
        expensiveManagedResource = null;
    }

    @Before
    public void testSetUp() {
        System.out.println("Test setup");
        managedResource = new ManagedResource();
    }

    @After
    public void testTearDown() throws IOException {
        System.out.println("Test tear down");
        managedResource.close();
        managedResource = null;
    }

    @Test
    public void integerValueOfTest() {
        System.out.println("integerValueOfTest");
        Integer integer = Integer.valueOf("5");
        Assert.assertEquals(integer, Integer.valueOf(5));
    }

    @Test()
    public void doubleValueOfTest() {
        System.out.println("doubleValueOfTest");
        Double tmpDouble = Double.valueOf("5.5");
        Assert.assertEquals(tmpDouble, Double.valueOf(5.5));
    }
}
