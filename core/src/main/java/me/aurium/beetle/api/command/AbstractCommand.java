package me.aurium.beetle.api.command;

import java.util.Collection;
import java.util.Collections;

/**
 * Represents a command that can provide a specific type of data
 * @param <T> the type of data
 */
public interface AbstractCommand<T> {

    String getName();
    String getPermission();
    boolean execute(T sender, String alias, String[] args);


    default Collection<String> getAliases() {
        return Collections.emptySet();
    }

    default Collection<String> tabComplete(T sender, String alias, String[] args) {
        return Collections.emptySet();
    }


    default String getUsage() {
        return "Default Usage for Minecraft-Like APIs";
    }
    default String getDescription() {
        return "Default Description for Minecraft-Like APIs";
    }

}