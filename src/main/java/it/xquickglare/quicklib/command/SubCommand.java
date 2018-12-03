package it.xquickglare.quicklib.command;

import lombok.Getter;
import org.bukkit.command.CommandSender;

/**
 * @author Gio
 */
public abstract class SubCommand extends Command {

    @Getter private String subname;

    public SubCommand(String subname, String parent, String permission, String permissionMessage, String invalidArgsMessage, String invalidSenderTypeMessage, Class<CommandSender>[] allowedSenders, boolean ignoreCase, int minArgsLength) {
        super(parent,
                permission,
                permissionMessage,
                invalidArgsMessage,
                invalidSenderTypeMessage,
                allowedSenders,
                ignoreCase,
                minArgsLength);
        this.subname = subname;
    }
}
