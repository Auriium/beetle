package me.aurium.beetle.api.command;

public class NoHandlerException extends RuntimeException{

    public NoHandlerException() {
        super("No handler found for this command! Please define a handler for this command.");
    }

}
