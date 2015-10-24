package com.github.bjanczak.junitdemo;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.github.bjanczak.junitdemo.chapter8_categories.ClassA;
import com.github.bjanczak.junitdemo.chapter8_categories.ClassB;
import com.github.bjanczak.junitdemo.chapter8_categories.DevelopmentTests;
import com.github.bjanczak.junitdemo.chapter8_categories.NightlyBuildTests;

/**
 * Categories is a perfect tool for distinguish test types.
 * Categories is a kind of suite.
 *
 * Categories are usually used to distinguish:
 * 1) Automated test type: UnitTests, IntegrationTests, SmokeTests, RegressionTests, PerformanceTests ...
 * 2) Test timing: SlowTests, QuickTests
 * 3) Part of CI build: NightlyBuildTests, MandatoryTests
 * 4) The state of the test: UnstableTests, InProgressTests

 *
 * @author Bartłomiej Jańczak
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(DevelopmentTests.class)
@Categories.ExcludeCategory(NightlyBuildTests.class)
@Suite.SuiteClasses( { ClassA.class,
                       ClassB.class })
public class Chapter8_Categories {
}
