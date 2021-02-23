import me.aurium.beetle.core.Beetle;
import me.aurium.beetle.spigot.SpigotBeetleFactory;
import me.aurium.beetle.spigot.SpigotCommandRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotTests extends JavaPlugin {

    //@Test
    public void main() {
        Beetle beetle = new SpigotBeetleFactory(this).build();

        beetle.getServiceRegistry().getService(SpigotCommandRegistry.class).ifPresent(registry -> {
            registry.registerCommand(new CommandTest());
        });


    }


}
