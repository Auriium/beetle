package me.aurium.beetle.core.logger;

/**
 * Represents something simple that can interface with loggers. Reccommended to simply use Log4J / SLF4J.
 */
public interface SimpleLogger {

    void error(String string);
    void warn(String string);
    void debug(String string);
    void info(String string);

}
