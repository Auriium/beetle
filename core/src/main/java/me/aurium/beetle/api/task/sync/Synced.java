package me.aurium.beetle.api.task.sync;

/**
 * something that can be compared if it is on the main thread or not.
 * A248, advise me on naming ideas since Synced sounds fucking stupid
 */
public interface Synced {

    boolean isOnMainThread();

}
