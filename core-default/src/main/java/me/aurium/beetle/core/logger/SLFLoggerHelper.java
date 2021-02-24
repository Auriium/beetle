package me.aurium.beetle.core.logger;

import org.slf4j.LoggerFactory;

public class SLFLoggerHelper {

    public SLFLoggerHelper() {}

    public static SLFLogger buildLogger(boolean debug) {
        return new SLFLogger(LoggerFactory.getLogger(SLFLoggerHelper.class),debug);
    }

    public static SLFLogger buildLogger(boolean debug, Class<?> clazz) {
        return new SLFLogger(LoggerFactory.getLogger(clazz),debug);
    }

}
