package me.aurium.beetle.api.task.sync;

/**
 * Represents an operation that is large and so should probably be run off the main thread in a tasker's async-callback-runnable
 */
public @interface BlockingOperation {
}
