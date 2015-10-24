package com.github.bjanczak.junitdemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Using Suite as a runner allows you to manually build a suite containing tests from many classes.
 * To use it, annotate a class with @RunWith(Suite.class) and @SuiteClasses(TestClass.class, ...).
 *
 * @author Bartłomiej Jańczak
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Chapter1_TestFictures.class,
                     Chapter2_BaseConstructs.class,
                     Chapter3_Assertions.class})
public class Chapter5_TestSuits {
}
