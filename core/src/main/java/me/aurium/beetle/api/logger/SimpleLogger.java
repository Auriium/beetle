package me.aurium.beetle.api.logger;

/**
 * Represents something simple that can interface with loggers. This will be removed soon.
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
