package ru.axel.logger;

import java.util.logging.*;

public abstract class ILogger {
    protected final Logger logger;

    public ILogger(Level logLevel) {
        logger = LoggerFactory.getLogger(this.getClass(), logLevel);
    }

    public ILogger(Level logLevel, Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz, logLevel);
    }

    public void setLogLevel(Level logLevel) {
        logger.setLevel(logLevel);
    }

//    public void info(String msg) {
//        if (logger.isLoggable(Level.INFO)) logger.info(msg);
//    }
//    public void warning(String msg) {
//        if (logger.isLoggable(Level.WARNING)) logger.warning(msg);
//    }
//    public void finest(String msg) {
//        if (logger.isLoggable(Level.FINEST)) logger.finest(msg);
//    }
}
