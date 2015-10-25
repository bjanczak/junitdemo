package com.github.bjanczak.junitdemo.chapter9_rules;

import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * TestWatcher takes note of the testing action, without modifying it.
 *
 * @author Bartłomiej Jańczak
 */
public class TestWatcherTest {

    @Rule
    public TestRule watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            System.out.print(new StringBuilder()
                    .append(description.getDisplayName())
                    .append(" ")
                    .append("succeeded!")
                    .toString());
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.print(new StringBuilder()
                    .append(description.getDisplayName())
                    .append(" ")
                    .append(e.getClass().getSimpleName())
                    .append(" ")
                    .append("failed!")
                    .toString());
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.print(new StringBuilder()
                    .append(description.getDisplayName())
                    .append(" ")
                    .append(e.getClass().getSimpleName())
                    .append(" ")
                    .append("skipped!")
                    .toString());
        }

        @Override
        protected void starting(Description description) {
            super.starting(description);
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
        }
    };

    @Test
    public void fail() {
        org.junit.Assert.fail();
    }

    @Test
    public void success() {
    }
}
