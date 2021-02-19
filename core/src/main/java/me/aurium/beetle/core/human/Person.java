package me.aurium.beetle.core.human;

/**
 * Wrapper-type interface that stores entities that can
 * do basic actions like sending commands or receiving text
 */
public interface Person<T> {

    /**
     * Gets the wrapped sender. If you want to retrieve an active Player instead of a passive
     * CommandSender, you must cast it yourself.
     *
     * @return wrapped object that this contains
     */
    T getWrapped();

    /**
     * Checks if the person can be considered Active or not. A Player is active, a console is not.
     * @return activity of the person or not.
     */
    boolean isActive();

    /**
     * Checks whether the person is equivalent
     * @param wrapper Person
     * @return whether the person is equivalent or not.
     */
    boolean equals(Person<T> wrapper);

}
