package com.github.bjanczak.junitdemo.chapter9_rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

/**
 * ExternalResource is a base class for Rules (like TemporaryFolder) that set up an external resource before
 * a test (a file, socket, server, database connection, etc.), and guarantee to tear it down afterward.
 *
 * @author Bartłomiej Jańczak
 */
public class ExternalResourceTest {
    interface Server {
        void connect();
        void disconnect();
    }

    interface Client {
        void run(Server server);
    }

    Server myServer = new Server(){
        @Override
        public void connect() {
            System.out.println("Server.connect()");
        }

        @Override
        public void disconnect() {
            System.out.println("Server.disconnect()");
        }
    };

    @Rule
    public ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            myServer.connect();
        };

        @Override
        protected void after() {
            myServer.disconnect();
        };
    };

    @Test
    public void test() {
        new Client(){
            @Override
            public void run(Server server) {
                System.out.println("Client.run()");
            }
        }.run(myServer);
    }
}
