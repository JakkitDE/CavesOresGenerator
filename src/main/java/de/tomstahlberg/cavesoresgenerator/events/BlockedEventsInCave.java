package de.tomstahlberg.cavesoresgenerator.events;

import de.tomstahlberg.cavesoresgenerator.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class BlockedEventsInCave implements Listener {
    @EventHandler
    public void worldChange (PlayerTeleportEvent event){
        if(event.getTo().getWorld().getName().equalsIgnoreCase(Main.config.getWorld())){
            Player player = event.getPlayer();
            if(!(player.hasPermission("mine.access.bypass") || player.isOp())){
                if(!Main.teleportedList.contains(player)){
                    Main.teleportedList.add(player);
                    teleport(player);
                }
            }
        }
    }

    @EventHandler
    public void useEnderpearl (PlayerInteractEvent event){
        if(event.getPlayer().getLocation().getWorld().getName().equalsIgnoreCase(Main.config.getWorld())){
            ItemStack mainHand = event.getPlayer().getInventory().getItemInMainHand();
            ItemStack offHand = event.getPlayer().getInventory().getItemInOffHand();
            Boolean cancel = false;
            if( mainHand.getType() != null && mainHand.getType() == Material.ENDER_PEARL ||
                    mainHand.getType() != Material.AIR && mainHand.getType() == Material.ENDER_PEARL ||
                    offHand.getType() != null && offHand.getType() == Material.ENDER_PEARL ||
                    offHand.getType() != Material.AIR && offHand.getType() == Material.ENDER_PEARL){
                cancel = true;
            }
            if(cancel == true){
                Player player = event.getPlayer();
                if(!(player.hasPermission("mine.access.bypass") || player.isOp())){
                    if(!Main.blockedMessagesList.contains(player)){
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDu kannst in der Mine keine Enderperlen benutzen."));
                        Main.blockedMessagesList.add(player);
                        startMessageRemovalTimer(player);
                    }
                    event.setCancelled(true);
                }
            }
        }
    }
    private void startMessageRemovalTimer(Player player){
        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
            @Override
            public void run() {
                Main.blockedMessagesList.remove(player);
            }
        }, 60);
    }
    private void teleport(Player player){
        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
            @Override
            public void run() {
                player.teleport(Main.config.getSpawnLocation());
                Main.teleportedList.remove(player);
            }
        }, 5);
    }
}
