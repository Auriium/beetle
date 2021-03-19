package me.aurium.beetle.spigot;

import me.aurium.beetle.api.BeetleOptions;

public class SpigotOptions implements BeetleOptions {

    public boolean isDebug() {
        return isDebug;
    }

    private final boolean isDebug;

    public SpigotOptions(boolean isDebug) {
        this.isDebug = isDebug;
    }
}
