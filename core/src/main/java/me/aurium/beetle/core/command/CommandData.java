package me.aurium.beetle.core.command;

/**
 * Marker interface for all data passed down a command, like the command executor.
 */
public interface CommandData {

    /**
     * Send a base-level message to the data holder. Virtually any wrapper for commandData will be able to accept messages.
     * Use this only when casting to a higher-level implementation fails
     *
     * @param string The message you want to send.
     */
    void debugMessage(String string);

}
