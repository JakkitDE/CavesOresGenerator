package de.tomstahlberg.cavesoresgenerator.events.cavetools;

import de.tomstahlberg.cavesoresgenerator.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;

public class BlockedEventsInCaves implements Listener {
    @EventHandler
    public void worldChange (PlayerTeleportEvent event){
        if(event.getTo().getWorld().getName().equalsIgnoreCase(Main.config.getWorld())){
            Player player = event.getPlayer();
            if(!(player.hasPermission("mine.access.bypass") || player.isOp())){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDu kannst dich nicht in die Mine teleportieren."));
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void useEnderpearl (PlayerInteractEvent event){
        ItemStack mainHand = event.getPlayer().getInventory().getItemInMainHand();
        ItemStack offHand = event.getPlayer().getInventory().getItemInOffHand();
        if( mainHand.getType() != null && mainHand.getType() == Material.ENDER_PEARL ||
            mainHand.getType() != Material.AIR && mainHand.getType() == Material.ENDER_PEARL ||
            offHand.getType() != null && offHand.getType() == Material.ENDER_PEARL ||
            offHand.getType() != Material.AIR && offHand.getType() == Material.ENDER_PEARL){
            Player player = event.getPlayer();
            if(!(player.hasPermission("mine.access.bypass") || player.isOp())){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDu kannst in der Mine keine Enderperlen benutzen."));
                event.setCancelled(true);
            }
        }
    }
}
