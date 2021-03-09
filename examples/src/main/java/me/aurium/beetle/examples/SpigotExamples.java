package me.aurium.beetle.examples;

import me.aurium.beetle.Beetle;
import me.aurium.beetle.SpigotBeetleFactory;
import me.aurium.beetle.file.config.MutableConfKey;
import me.aurium.beetle.file.config.MutableConfOptions;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotExamples extends JavaPlugin {

    private Beetle beetle = new SpigotBeetleFactory(this,false).build();

    void test() {

        beetle.getFileProvider().registerNewFileProducer(new MutableConfKey<>("someconfig", ExampleConf.class), new MutableConfOptions());

        var prod = beetle.getFileProvider().getProducer(new MutableConfKey<>("someconfig", ExampleConf.class));

        prod.produce();

    }

}
