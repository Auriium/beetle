package me.aurium.beetle.api.task.sync.coordination;

public class SyncConstants {

    private static final Object EMPTY = new Object();

    public static <T> T CONSTANT() {
        return (T) EMPTY;
    }


}
