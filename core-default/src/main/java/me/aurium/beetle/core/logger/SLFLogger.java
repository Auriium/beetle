package me.aurium.beetle.core.logger;


import org.slf4j.Logger;

/**
 * Default logger. Only use the other loggers if slf4j is broken or something
 */
public class SLFLogger implements SimpleLogger {

    private final Logger logger;
    private final boolean debug;

    SLFLogger(Logger logger, boolean debug) {
        this.logger = logger;
        this.debug = debug;
    }

    @Override
    public void error(String string) {
        logger.error(string);
    }

    @Override
    public void warn(String string) {
        logger.warn(string);
    }

    @Override
    public void debug(String string) {
        if (debug) {
            logger.debug(string);
        }
    }

    @Override
    public void info(String string) {
        logger.info(string);
    }
}
