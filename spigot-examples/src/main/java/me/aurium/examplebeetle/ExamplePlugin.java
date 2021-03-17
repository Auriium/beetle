package me.aurium.examplebeetle;

import me.aurium.beetle.defaults.command.SimpleRegisterer;
import me.aurium.beetle.spigot.SpigotBeetle;
import me.aurium.beetle.spigot.SpigotBeetleFactory;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {


    private final SpigotBeetle beetle = new SpigotBeetleFactory(this,false).build();

    public void onEnable() {

        /*beetle.getFileProvider().registerNewFileProducer(new MutableConfKey<>("someconfig", ExampleConf.class), new MutableConfOptions());

        var prod = beetle.getFileProvider().getProducer(new MutableConfKey<>("someconfig", ExampleConf.class));

        prod.produce();*/


        beetle.getCommandRegistry().registerBuilder(new SimpleRegisterer<CommandSender>("hello")
                .setDescription("desc")
                .setPermission("example.permission")
                .setUsage("usage")
                .setAliases("hi","herro")
                .setContextHandler(context  -> {
                    context.getSender().sendMessage("HELLO WORLD!");
                    return true;
                }));


        beetle.getCommandRegistry().registerCommand(new ExampleCommand());


    }


}
