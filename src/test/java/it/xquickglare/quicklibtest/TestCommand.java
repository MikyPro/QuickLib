package it.xquickglare.quicklibtest;

import it.xquickglare.quicklib.command.Command;
import it.xquickglare.quicklib.command.CommandSenderType;
import org.bukkit.command.CommandSender;

import java.util.Collections;

/**
 * @author Gio
 */
public class TestCommand extends Command {

    public TestCommand() {
        super("test",
                "qlib.test",
                "§cNot enough permissions!",
                "§cInvalid arguments",
                "§cYou are not allowed to execute this command",
                CommandSenderType.values(),
                true,
                0,
                Collections.singletonList(new TestSubCommand()));
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        sender.sendMessage("Command working!");
    }
}
