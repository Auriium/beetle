package me.aurium.beetle.velocity;

import com.velocitypowered.api.command.RawCommand;
import net.kyori.adventure.text.Component;

public class VelocityCommandData {

    private RawCommand.Invocation invocation;

    public VelocityCommandData(RawCommand.Invocation invocation) {
        this.invocation = invocation;
    }

}
