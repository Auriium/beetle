package xyz.auriium.beetle.file;

import java.util.Optional;

/**
 * Simple utility for storing nullable values in a less-null state
 * @param <T>
 */
public class StateHolder<T> {

    private T held;

    public Optional<T> getHeld() {
        return Optional.ofNullable(held);
    }

    public void setHeld(T newHeld) {
        this.held = newHeld;
    }

    @Override
    public String toString() {
        return "StateHolder{" +
                "held=" + held +
                '}';
    }
}
