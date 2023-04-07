package de.tomstahlberg.cavesoresgenerator.commands;

import de.tomstahlberg.cavesoresgenerator.CavesOresGenerator;
import de.tomstahlberg.cavesoresgenerator.functions.Locations;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.concurrent.Executor;

public class SaveCommand {
    public SaveCommand(Player player){
        if(player.hasPermission("cavesoresgenerator.save") || player.isOp()){
            try {
                new Locations(CavesOresGenerator.locations).saveConfiguration();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &aErfolgreich in Datei gespeichert."));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cKeine Rechte."));
        }

    }

}
