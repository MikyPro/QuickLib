package it.xquickglare.quicklib.command;

import lombok.*;
import org.bukkit.command.CommandSender;

/**
 * @author Gio
 */
@ToString
public abstract class SubCommand extends AbstractCommand {

    public SubCommand(String name, String permission, String permissionMessage, String invalidArgsMessage, String invalidSenderTypeMessage, Class<CommandSender>[] allowedSenders, boolean ignoreCase, int minArgsLength) {
        super(name,
                permission,
                permissionMessage,
                invalidArgsMessage,
                invalidSenderTypeMessage,
                allowedSenders,
                ignoreCase,
                minArgsLength);
    }

    public SubCommand(String name, String permission) {
        super(name, permission);
    }
}
