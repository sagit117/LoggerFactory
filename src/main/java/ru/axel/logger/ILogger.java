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
}
