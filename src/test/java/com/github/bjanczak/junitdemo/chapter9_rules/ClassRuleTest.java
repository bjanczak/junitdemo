package com.github.bjanczak.junitdemo.chapter9_rules;

import com.github.bjanczak.junitdemo.Chapter1_TestFictures;
import com.github.bjanczak.junitdemo.Chapter2_BaseConstructs;
import com.github.bjanczak.junitdemo.Chapter3_Assertions;
import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The ClassRule annotation extends the idea of method-level Rules, adding static fields that can affect
 * the operation of a whole class.
 *
 * @author Bartłomiej Jańczak
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Chapter1_TestFictures.class, Chapter2_BaseConstructs.class, Chapter3_Assertions.class})
public class ClassRuleTest {
    interface Server {
        void connect();
        void disconnect();
    }

    public static Server myServer= new Server(){
        @Override
        public void connect() {
            System.out.println("Server.connect()");
        }

        @Override
        public void disconnect() {
            System.out.println("Server.disconnect()");
        }
    };

    @ClassRule
    public static ExternalResource resource= new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            myServer.connect();
        };

        @Override
        protected void after() {
            myServer.disconnect();
        };
    };
}
