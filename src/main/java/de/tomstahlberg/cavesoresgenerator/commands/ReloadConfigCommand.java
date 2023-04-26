package de.tomstahlberg.cavesoresgenerator.commands;

import de.tomstahlberg.cavesoresgenerator.Main;
import de.tomstahlberg.cavesoresgenerator.functions.ConfigFunction;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ReloadConfigCommand {
    public ReloadConfigCommand(Player player) throws IOException {
        if(player.hasPermission("cavesoresgenerator.reloadconfig") || player.isOp()){
            Main.config = new ConfigFunction(Main.plugin);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &aConfig neu geladen."));
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cKeine Rechte."));
        }

    }
}
