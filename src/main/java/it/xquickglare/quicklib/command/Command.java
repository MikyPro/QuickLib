package it.xquickglare.quicklib.command;

import lombok.Getter;
import lombok.ToString;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gio
 */
@ToString
public abstract class Command extends AbstractCommand {

    @Getter private List<SubCommand> subCommands;

    public Command(String name, String permission, String permissionMessage, String invalidArgsMessage, String invalidSenderTypeMessage, Class<CommandSender>[] allowedSenders, boolean ignoreCase, int minArgsLength, List<SubCommand> subCommands) {
        super(name,
                permission,
                permissionMessage,
                invalidArgsMessage,
                invalidSenderTypeMessage,
                allowedSenders,
                ignoreCase,
                minArgsLength);
        this.subCommands = subCommands;
    }

    public Command(String name, String permission) {
        super(name, permission);
        this.subCommands = new ArrayList<>();
    }

    /**
     * Merges args into a string
     * @param start Start arg index
     * @param args Args array
     * @param separator String separator between args
     * @return Merged args from <tt>start</tt>
     */
    public static String merge(int start, String[] args, String separator) {
        StringBuilder str = new StringBuilder();
        for(int i = start; i < args.length - 1; i++) {
            str.append(args[i]).append(separator);
        }
        return str.toString() + args[args.length - 1];
    }

    /**
     * Adds an additional sub command
     * @param subCommand Sub command
     */
    public void addSubCommand(SubCommand subCommand) {
        subCommands.add(subCommand);
    }
}
