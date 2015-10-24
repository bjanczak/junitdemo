package com.github.bjanczak.junitdemo.chapter8_categories;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * @author Bartłomiej Jańczak
 */
@Category({NightlyBuildTests.class,
           DevelopmentTests.class})
public class ClassB {

    @Test
    public void c() {
        System.out.print("ClassB.c()");
    }
}
