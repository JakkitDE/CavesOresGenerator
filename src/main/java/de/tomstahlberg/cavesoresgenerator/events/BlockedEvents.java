package de.tomstahlberg.cavesoresgenerator.events;

import de.tomstahlberg.cavesoresgenerator.Main;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockedEvents implements Listener {

    /*@EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getPlayer().getWorld().getName().equalsIgnoreCase("Mine")){
            if(CavesOresGenerator.editMode == true){
                if(player.hasPermission("cavesoresgenerator.edit") || player.isOp()){
                    event.setCancelled(false);
                }else{
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDie Mine wird derzeit gewartet."));
                }
            }else{
                event.setCancelled(true);
            }
        }
    }*/

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(event.getPlayer().getWorld().getName().equalsIgnoreCase(Main.config.getWorld())){
            if(Main.editMode == true){
                if(player.hasPermission("cavesoresgenerator.edit") || player.isOp()){
                    event.setCancelled(false);
                }else{
                    playFailedSound(player);
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDie Mine wird derzeit gewartet."));
                }
            }else{
                playFailedSound(player);
                event.setCancelled(true);
            }
        }
    }

    private void playFailedSound(Player player){
        player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_HIT, 0.5F, 1F);
    }
}
