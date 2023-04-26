package de.tomstahlberg.cavesoresgenerator.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player){
            if(args.length >= 1){
                if(args[0].equalsIgnoreCase("toggle")){
                    new ToggleCommand((Player) commandSender);
                }else if(args[0].equalsIgnoreCase("save")){
                    new SaveCommand((Player) commandSender);
                }else if (args[0].equalsIgnoreCase("reloadConfig")){
                    try {
                        new ReloadConfigCommand((Player) commandSender);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }else{
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cNur ein Spieler kann den Befehl ausführen."));
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> argsList = new ArrayList<String>();
        if(args.length == 1){
            if(commandSender.hasPermission("cavesoresgenerator.toggle") || commandSender.isOp()){
                argsList.add("toggle");
            }
            if(commandSender.hasPermission("cavesoresgenerator.save") || commandSender.isOp()){
                argsList.add("save");
            }
            if(commandSender.hasPermission("cavesoresgenerator.reloadconfig") || commandSender.isOp()){
                argsList.add("reloadConfig");
            }
        }
        return argsList;
    }
}
