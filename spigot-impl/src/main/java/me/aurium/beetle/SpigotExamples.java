package me.aurium.beetle;

import me.aurium.beetle.file.config.MutableConfKey;
import me.aurium.beetle.file.config.MutableConfOptions;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotExamples extends JavaPlugin {

    private Beetle beetle = new SpigotBeetleFactory(this,false).build();

    void test() {

        beetle.getFileProvider().registerNewFileProducer(new MutableConfKey<>("someconfig",ExampleCommand.class), new MutableConfOptions());

        var prod = beetle.getFileProvider().getProducer(new MutableConfKey<>("someconfig",ExampleCommand.class));

        prod.produce();

    }

}
