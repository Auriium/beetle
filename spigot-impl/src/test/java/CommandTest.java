import me.aurium.beetle.api.command.AbstractCommand;
import org.bukkit.command.CommandSender;

public class CommandTest implements AbstractCommand<CommandSender> {


    @Override
    public String getName() {
        return "SpigotCommand";
    }

    @Override
    public String getPermission() {
        return "some.permission";
    }

    @Override
    public boolean execute(CommandSender wrapper, String[] args) {
        wrapper.sendMessage("lah");

        return false;
    }
}
