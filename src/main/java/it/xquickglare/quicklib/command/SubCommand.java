package it.xquickglare.quicklib.command;

import lombok.ToString;

/**
 * @author Gio
 */
@ToString
public abstract class SubCommand extends AbstractCommand {

    public SubCommand(String name, String permission, String permissionMessage, String invalidArgsMessage, String invalidSenderTypeMessage, CommandSenderType[] allowedSenders, boolean ignoreCase, int minArgsLength) {
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
