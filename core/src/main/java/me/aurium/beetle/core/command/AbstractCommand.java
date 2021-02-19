package me.aurium.beetle.core.command;

import java.util.Collection;

public interface AbstractCommand {

    public String getName();
    public Collection<String> getAliases();
    public String getPermission();

    public boolean execute(SenderWrapper<?> sender, String[] args);
    public Collection<String> executeTab(SenderWrapper<?> sender, String[] args);

}
