package me.aurium.beetle.core.logger;

import org.slf4j.LoggerFactory;

public class SLFLoggerHelper {

    public SLFLoggerHelper() {}

    public SLFLogger buildLogger(boolean debug) {
        return new SLFLogger(LoggerFactory.getLogger(SLFLoggerHelper.class),debug);
    }

}
