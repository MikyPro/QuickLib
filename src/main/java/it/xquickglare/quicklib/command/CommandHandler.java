package it.xquickglare.quicklib.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author Gio
 */
@AllArgsConstructor
public class CommandHandler implements CommandExecutor {

    @Getter private it.xquickglare.quicklib.command.Command command;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(command.isIgnoreCase() ? command.getName().equalsIgnoreCase(cmd.getName()) : command.getName().equals(cmd.getName())) {
            if(args.length < command.getMinArgsLength()) {
                sender.sendMessage(command.getInvalidArgsMessage());
                return false;
            }
            if(!sender.hasPermission(command.getPermission())) {
                sender.sendMessage(command.getPermissionMessage());
                return false;
            }
            for(Class<? extends CommandSender> type : command.getAllowedSenders()) {
                if(!sender.getClass().isAssignableFrom(type)) {
                    sender.sendMessage(command.getInvalidSenderTypeMessage());
                    return false;
                }
            }
            if(args.length > 0) {
                for(SubCommand subCommand : command.getSubCommands()) {
                    if(subCommand.getName().equalsIgnoreCase(args[0])) {
                        if(args.length < subCommand.getMinArgsLength()) {
                            sender.sendMessage(subCommand.getInvalidArgsMessage());
                            return false;
                        }
                        if(!sender.hasPermission(subCommand.getPermission())) {
                            sender.sendMessage(subCommand.getPermissionMessage());
                            return false;
                        }
                        for(Class<? extends CommandSender> type : subCommand.getAllowedSenders()) {
                            if(!sender.getClass().isAssignableFrom(type)) {
                                sender.sendMessage(subCommand.getInvalidSenderTypeMessage());
                                return false;
                            }
                        }
                    }
                }
            }
            command.onCommand(sender, args);
            return true;
        }
        return false;
    }
}
