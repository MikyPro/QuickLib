package it.xquickglare.quicklib.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * @author Gio
 */
@RequiredArgsConstructor
@AllArgsConstructor
abstract class AbstractCommand {

    @Getter @NonNull private String name;
    @Getter @NonNull protected String permission;
    @Getter protected String permissionMessage = ChatColor.RED + "Insufficient permissions.";
    @Getter protected String invalidArgsMessage = ChatColor.RED + "Invalid arguments.";
    @Getter protected String invalidSenderTypeMessage = ChatColor.RED + "Invalid sender type.";
    @SuppressWarnings("unchecked")
    @Getter protected Class<? extends CommandSender>[] allowedSenders = new Class[] {Player.class, ConsoleCommandSender.class};
    @Getter protected boolean ignoreCase = true;
    @Getter protected int minArgsLength;

    /**
     * Method called every time the command is called
     * @param sender Player or console that typed the command
     * @param args Command arguments
     */
    public abstract void onCommand(CommandSender sender, String[] args);
}
