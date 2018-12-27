package it.xquickglare.quicklib.command;

import lombok.*;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * @author Gio
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
abstract class AbstractCommand {

    @Getter @NonNull private String name;
    @Getter @NonNull protected String permission;
    @Getter protected String permissionMessage = ChatColor.RED + "Insufficient permissions.";
    @Getter protected String invalidArgsMessage = ChatColor.RED + "Invalid arguments.";
    @Getter protected String invalidSenderTypeMessage = ChatColor.RED + "Invalid sender type.";
    @SuppressWarnings("unchecked")
    @Getter protected CommandSenderType[] allowedSenders = CommandSenderType.values();
    @Getter protected boolean ignoreCase = true;
    @Getter protected int minArgsLength;

    /**
     * Method called every time the command is called
     * @param sender Player or console that typed the command
     * @param args Command arguments
     */
    public abstract void onCommand(CommandSender sender, String[] args);
}
