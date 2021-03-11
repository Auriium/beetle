package me.aurium.examplebeetle;

import me.aurium.beetle.api.command.Command;
import org.bukkit.command.CommandSender;

public class ExampleCommand implements Command<CommandSender> {
    @Override
    public String getName() {
        return "nerd";
    }

    @Override
    public String getPermission() {
        return "nerd.permission";
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {

        sender.sendMessage("This is the Nerd command!");

        return true;
    }
}
