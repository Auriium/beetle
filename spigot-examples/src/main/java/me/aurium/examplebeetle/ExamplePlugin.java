package me.aurium.examplebeetle;

import me.aurium.beetle.defaults.command.SimpleRegisterer;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {


    private final SpigotBeetle beetle = new SpigotBeetleFactory(this).build(
            new SpigotOptions.Builder().isDebug(true).build()
    );

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
