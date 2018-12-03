package it.xquickglare.quicklib.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;

/**
 * @author Gio
 */
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class Command {

    @Getter @NonNull private String name;
    @Getter private String permission;
    @Getter private String permissionMessage;
    @Getter private String invalidArgsMessage;
    @Getter private String invalidSenderTypeMessage;
    @Getter private Class<CommandSender>[] allowedSenders;
    @Getter private boolean ignoreCase = true;
    @Getter private int minArgsLength;

    @Override
    public String toString() {
        return "Command " + name;
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
     * Method called every time the command is called
     * @param sender Player or console that typed the command
     * @param args Command arguments
     */
    public abstract void onCommand(CommandSender sender, String[] args);
}
