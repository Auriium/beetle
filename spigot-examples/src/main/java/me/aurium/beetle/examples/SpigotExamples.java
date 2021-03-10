package me.aurium.beetle.examples;

import me.aurium.beetle.defaults.command.SimpleCommandBuilder;
import me.aurium.beetle.spigot.SpigotBeetle;
import me.aurium.beetle.spigot.SpigotBeetleFactory;
import me.aurium.beetle.spigot.SpigotCommandBuilder;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotExamples extends JavaPlugin {


    private SpigotBeetle beetle = new SpigotBeetleFactory(this,false).build();

    void test() {

        /*beetle.getFileProvider().registerNewFileProducer(new MutableConfKey<>("someconfig", ExampleConf.class), new MutableConfOptions());

        var prod = beetle.getFileProvider().getProducer(new MutableConfKey<>("someconfig", ExampleConf.class));

        prod.produce();*/

        SimpleCommandBuilder<CommandSender> builder = SpigotCommandBuilder.of("hello")
                .setDescription("desc")
                .setPermission("myplugin.permission")
                .setUsage("usage")
                .setAliases("hi","herro")
                .setContext(context  -> {
                    context.getSender().sendMessage("sup");
                    return true;
                });

        beetle.getCommandRegistry().registerCommand(builder.build());


    }


}
