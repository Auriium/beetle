package me.aurium.beetle.examples;

import me.aurium.beetle.api.Beetle;
import me.aurium.beetle.defaults.file.config.MutableConfKey;
import me.aurium.beetle.defaults.file.config.MutableConfOptions;
import me.aurium.beetle.spigot.SpigotBeetle;
import me.aurium.beetle.spigot.SpigotBeetleFactory;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotExamples extends JavaPlugin {

    private Beetle beetle = new SpigotBeetleFactory(this,false).build();

    void test() {

        beetle.getFileProvider().registerNewFileProducer(new MutableConfKey<>("someconfig", ExampleConf.class), new MutableConfOptions());

        var prod = beetle.getFileProvider().getProducer(new MutableConfKey<>("someconfig", ExampleConf.class));

        prod.produce();

    }

}
