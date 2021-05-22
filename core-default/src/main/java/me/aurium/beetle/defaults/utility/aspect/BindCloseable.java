package me.aurium.beetle.defaults.utility.aspect;

public interface BindCloseable<K> extends KeyCloseable<K> {

    /**
     * Attach a closeable to this so that when this is closed the param is closed as well
     * @param otherCloseable another closable
     */
    void bind(KeyCloseable<K> otherCloseable);

}
