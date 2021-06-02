package me.aurium.beetle.spigotcommons;

import org.bukkit.ChatColor;

public class ChatUtils {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&',string);
    }

}
