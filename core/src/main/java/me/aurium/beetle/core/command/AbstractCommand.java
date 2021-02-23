package me.aurium.beetle.core.command;

import java.util.Collection;
import java.util.Collections;

public interface AbstractCommand<T extends CommandData> {

    String getName();
    String getPermission();
    boolean execute(T sender, String[] args);


    default Collection<String> getAliases() {
        return Collections.emptySet();
    }

    default Collection<String> tabComplete(T sender, String[] args) {
        return Collections.emptySet();
    }


    default String getUsage() {
        return "Default Usage for Minecraft-Like APIs";
    }
    default String getDescription() {
        return "Default Description for Minecraft-Like APIs";
    }

}