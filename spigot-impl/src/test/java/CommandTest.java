import me.aurium.beetle.command.AbstractCommand;
import me.aurium.beetle.command.SpigotCommandData;

public class CommandTest implements AbstractCommand<SpigotCommandData> {


    @Override
    public String getName() {
        return "SpigotCommand";
    }

    @Override
    public String getPermission() {
        return "some.permission";
    }

    @Override
    public boolean execute(SpigotCommandData wrapper, String[] args) {
        wrapper.debugMessage("A debug message!");

        return false;
    }
}
