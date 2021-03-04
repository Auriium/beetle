package me.aurium.beetle.velo;

import com.velocitypowered.api.command.RawCommand;
import me.aurium.beetle.core.command.CommandData;
import net.kyori.adventure.text.Component;

public class VelocityCommandData implements CommandData {

    private RawCommand.Invocation invocation;

    public VelocityCommandData(RawCommand.Invocation invocation) {
        this.invocation = invocation;
    }

    @Override
    public void debugMessage(String string) {
        invocation.source().sendMessage(Component.text(string));
    }
}
