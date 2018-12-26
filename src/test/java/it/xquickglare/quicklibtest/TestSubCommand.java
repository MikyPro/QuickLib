package it.xquickglare.quicklibtest;

import it.xquickglare.quicklib.command.CommandSenderType;
import it.xquickglare.quicklib.command.SubCommand;
import org.bukkit.command.CommandSender;

/**
 * @author Gio
 */
public class TestSubCommand extends SubCommand {

    public TestSubCommand() {
        super("test2",
                "qlib.test.test2",
                "§cNot enough permissions!",
                "§cInvalid arguments",
                "§cYou are not allowed to execute this command",
                CommandSenderType.values(),
                true,
                1);
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        sender.sendMessage("Subcommand working!");
    }
}
