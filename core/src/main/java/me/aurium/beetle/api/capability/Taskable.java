package me.aurium.beetle.api.capability;

import me.aurium.beetle.api.task.Tasker;

/**
 * Fuck it, why even have a centralized beetle at this point?
 *
 * This exists so you can get type guarunteed Taskers
 */
public interface Taskable<T extends Tasker> {

    T getTasker();

}
