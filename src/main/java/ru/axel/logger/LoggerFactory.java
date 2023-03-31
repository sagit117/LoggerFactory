package ru.axel.logger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.logging.*;

/**
 * Класс генератор логгера строгово формата "%1$tF %1$tT [%2$-7s] [%3$s] %4$s %5$s: %6$s %n".
 * @Method getLogger основной метод получения логгера.
 */
public final class LoggerFactory {
    private static final String format = "%1$tF %1$tT [%2$-7s] [%3$s] %4$s %5$s: %6$s %n";

    /**
     * Основной метод получения логгера.
     * @param clazz класс, который необходимо логгировать.
     * @param level уровень лога.
     * @return инстанс логгера.
     */
    public static @NotNull Logger getLogger(@NotNull Class<?> clazz, Level level) {
        final ConsoleHandler loggerHandler = new ConsoleHandler();
        loggerHandler.setFormatter(getFormatter());
        loggerHandler.setLevel(level);

        final Logger logger = Logger.getLogger(clazz.getName());
        logger.setUseParentHandlers(false);

        if (logger.getHandlers().length == 0) {
            logger.addHandler(loggerHandler);
        }

        logger.setLevel(level);
        return logger;
    }

    @Contract(" -> new")
    private static @NotNull Formatter getFormatter() {
        return new SimpleFormatter() {
            public synchronized String format(LogRecord lr) {
                return String.format(
                    format,
                    new Date(lr.getMillis()),
                    lr.getLevel().getLocalizedName(),
                    "thread: " + Thread.currentThread().getName(),
                    lr.getLoggerName(),
                    lr.getSourceMethodName(),
                    lr.getMessage()
                );
            }
        };
    }
}
