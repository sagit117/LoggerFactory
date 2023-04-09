package ru.axel.logger;

import java.util.logging.*;

public abstract class ILogger {
    protected final Logger logger;

    protected ILogger(Level logLevel) {
        logger = LoggerFactory.getLogger(this.getClass(), logLevel);
    }
    protected ILogger(Level logLevel, Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz, logLevel);
    }

    protected void setLogLevel(Level logLevel) {
        logger.setLevel(logLevel);
    }
}
