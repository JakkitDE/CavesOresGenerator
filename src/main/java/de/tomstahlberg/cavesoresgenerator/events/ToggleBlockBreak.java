package de.tomstahlberg.cavesoresgenerator.events;

import de.tomstahlberg.cavesoresgenerator.CavesOresGenerator;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.List;

public class ToggleBlockBreak implements Listener {

    @EventHandler
    public void onPlayerBlockBreak (BlockBreakEvent event){
        if(!event.getPlayer().isSneaking()){
            Player player = event.getPlayer();
            if(CavesOresGenerator.editMode == true){
                if(player.hasPermission("cavesoresgenerator.edit") || player.isOp()){
                    if(player.getInventory().getItemInMainHand().getType() == Material.COAL_ORE){
                        insertData(player,"coal", event.getBlock().getLocation());
                        event.getBlock().setType(Material.COAL_ORE);
                        event.setCancelled(true);
                    }else if(player.getInventory().getItemInMainHand().getType() == Material.IRON_ORE){
                        insertData(player,"iron", event.getBlock().getLocation());
                        event.getBlock().setType(Material.IRON_ORE);
                        event.setCancelled(true);
                    }else if(player.getInventory().getItemInMainHand().getType() == Material.GOLD_ORE){
                        insertData(player,"gold", event.getBlock().getLocation());
                        event.getBlock().setType(Material.GOLD_ORE);
                        event.setCancelled(true);
                    }else if(player.getInventory().getItemInMainHand().getType() == Material.REDSTONE_ORE){
                        insertData(player,"redstone", event.getBlock().getLocation());
                        event.getBlock().setType(Material.REDSTONE_ORE);
                        event.setCancelled(true);
                    }else if(player.getInventory().getItemInMainHand().getType() == Material.DEEPSLATE_LAPIS_ORE){
                        insertData(player,"lapis", event.getBlock().getLocation());
                        event.getBlock().setType(Material.DEEPSLATE_LAPIS_ORE);
                        event.setCancelled(true);
                    }else if(player.getInventory().getItemInMainHand().getType() == Material.DEEPSLATE_DIAMOND_ORE){
                        insertData(player,"diamond", event.getBlock().getLocation());
                        event.getBlock().setType(Material.DEEPSLATE_DIAMOND_ORE);
                        event.setCancelled(true);
                    }

                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cKeine Rechte."));
                    event.setCancelled(true);
                }
            }
        }
    }

    private void insertData(Player player, String type, Location loc){
        List<Location> locationsList;
        try{
            locationsList = (List<Location>) CavesOresGenerator.locations.getList(type);
        }catch(Exception e){
            locationsList = new ArrayList<Location>();
        }
        if(!locationsList.contains(loc)){
            locationsList.add(loc);
            CavesOresGenerator.locations.set(type, locationsList);
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDieser Block ist bereits registriert. Rechtsklick zum Entfernen."));
        }
    }
}
