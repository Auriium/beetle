package me.aurium.beetle.core.command;

import me.aurium.beetle.core.human.Person;

import java.util.Collection;


//todo: figure out if we need to type specify the ActivePerson.
public interface AbstractCommand {

    String getName();
    Collection<String> getAliases();
    String getPermission();

    default String getUsage() {
        return "Default Usage for Minecraft-Like APIs";
    }

    default String getDescription() {
        return "Default Description for Minecraft-Like APIs";
    }

    boolean execute(Person<?> sender, String[] args);
    Collection<String> tabComplete(Person<?> sender, String[] args);

}
