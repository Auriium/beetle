import me.aurium.beetle.api.command.Command;
import org.bukkit.command.CommandSender;

public class CommandTest implements Command<CommandSender> {


    @Override
    public String getName() {
        return "SpigotCommand";
    }

    @Override
    public String getPermission() {
        return "some.permission";
    }

    @Override
    public boolean execute(CommandSender wrapper, String alias, String[] args) {
        wrapper.sendMessage("lah");

        return false;
    }
}
