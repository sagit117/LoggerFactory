package ru.axel.logger;

import java.util.logging.*;

public abstract class ILogger {
    protected final Logger logger;

    public ILogger(Level logLevel) {
        logger = LoggerFactory.getLogger(this.getClass(), logLevel);
    }

    public Logger getSelfLogger() {
        return logger;
    }

    protected void info(String msg) {
        if (logger.isLoggable(Level.INFO)) logger.info(msg);
    }
    protected void warning(String msg) {
        if (logger.isLoggable(Level.WARNING)) logger.warning(msg);
    }
    protected void finest(String msg) {
        if (logger.isLoggable(Level.FINEST)) logger.finest(msg);
    }
}
