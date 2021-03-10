package me.aurium.beetle.api.command;

import java.util.Collection;
import java.util.Collections;

/**
 * Represents a command that can provide a specific type of data
 *
 * Use: You can either manually implement this or use the SimpleCommand builder.
 * If you are using Branch alongside Beetle, you can use the builders that it provides.
 *
 * @param <T> the type of data
 */
public interface Command<T> {

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