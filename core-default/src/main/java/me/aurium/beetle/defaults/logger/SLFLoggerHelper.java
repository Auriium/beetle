package me.aurium.beetle.defaults.logger;

import org.slf4j.LoggerFactory;

public class SLFLoggerHelper {

    SLFLoggerHelper() {}

    public static SLFLogger buildLogger(boolean debug, Class<?> pluginClass) {
        return new SLFLogger(LoggerFactory.getLogger(SLFLoggerHelper.class),debug);
    }

    public static SLFLogger buildLogger(boolean debug, String pluginName) {
        return new SLFLogger(LoggerFactory.getLogger(pluginName),debug);
    }

}
