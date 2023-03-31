package ru.axel.logger;

import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        new Test().test("text");;

    }

    static class Test extends ILogger {
        public Test() {
            super(Level.ALL);
        }

        public void test(String text) {
            logger.info(text);
        }
    }
}