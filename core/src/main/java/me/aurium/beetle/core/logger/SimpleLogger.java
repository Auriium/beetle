package me.aurium.beetle.core.logger;

/**
 * Represents something simple that can interface with loggers. Reccommended to simply use Log4J / SLF4J.
 */
public interface SimpleLogger {

    /**
     * Logs an error
     * @param string the error
     */
    void error(String string);

    /**
     * Logs a warning
     * @param string the warning
     */
    void warn(String string);

    /**
     * Logs some debug information if the debug mode is enabled
     * @param string the debug info
     */
    void debug(String string);

    /**
     * Logs some info
     * @param string the info
     */
    void info(String string);

}
