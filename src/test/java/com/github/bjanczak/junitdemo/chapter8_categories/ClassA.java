package com.github.bjanczak.junitdemo.chapter8_categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * @author Bartłomiej Jańczak
 */
public class ClassA {

    @Test
    public void a() {
        System.out.print("ClassA.a()");
    }

    @Category(DevelopmentTests.class)
    @Test
    public void b() {
        System.out.print("ClassA.b()");
    }
}
