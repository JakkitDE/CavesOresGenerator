package de.tomstahlberg.cavesoresgenerator.commands;

import de.tomstahlberg.cavesoresgenerator.Main;
import de.tomstahlberg.cavesoresgenerator.functions.Shuffle;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ToggleCommand {
    public ToggleCommand(Player player){
        if(player.hasPermission("cavesoresgenerator.toggle") || player.isOp()){
            if(Main.editMode == true){
                Main.editMode = false;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &eBearbeitung beendet."));
                new Shuffle().setByChance();
            }else{
                Main.editMode = true;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &eBearbeitung gestartet. BlockBreak zum Registrieren, Sneaky BlockBreak zum entfernen."));
                new Shuffle().setAll();
            }
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cKeine Rechte."));
        }
    }
}
