package com.lei.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by com.lei on 16-4-2.
 */
public class LoggerCamp {
    public static void main(String[] args) {

        /**
         * need  to use -D to pass LOGDIR into JVM.
         */
        Logger loggerA = LoggerFactory.getLogger("A");
        loggerA.debug("this is a debug log in loggerA");
        loggerA.info("this is a info log in loggerA");
        loggerA.warn("this is a warn log in loggerA");
        Logger loggerB = LoggerFactory.getLogger("B");
        loggerB.debug("this is a debug log in loggerB");
        loggerB.info("this is a info log in loggerB");
        loggerB.warn("this is a warn log in loggerB");

    }
}
