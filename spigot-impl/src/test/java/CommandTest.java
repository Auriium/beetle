import me.aurium.beetle.core.command.AbstractCommand;
import me.aurium.beetle.spigot.command.SpigotSenderWrapper;

public class CommandTest implements AbstractCommand<SpigotSenderWrapper> {


    @Override
    public String getName() {
        return "SpigotCommand";
    }

    @Override
    public String getPermission() {
        return "some.permission";
    }

    @Override
    public boolean execute(SpigotSenderWrapper wrapper, String[] args) {
        wrapper.debugMessage("A debug message!");

        return false;
    }
}
