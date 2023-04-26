package de.tomstahlberg.cavesoresgenerator.events;

import de.tomstahlberg.cavesoresgenerator.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.List;

public class ToggleBlockBreakSneaking implements Listener {

     @EventHandler
     public void onPlayerBlockBreakWhileSneaking(BlockBreakEvent event){
         if(event.getPlayer().isSneaking()){
             Player player = event.getPlayer();
             if(Main.editMode == true){
                 if(player.hasPermission("cavesoresgenerator.edit") || player.isOp()){
                     removeLocation(player, event.getBlock().getLocation());
                 }else{
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cKeine Rechte."));
                 }
                 event.setCancelled(true);
             }
         }
     }

    private void removeLocation(Player player, Location loc){
        int i = 0;
        List<Location> coalLocations;
        try{
            coalLocations = (List<Location>) Main.locations.getList("coal");
        }catch(Exception e){
            coalLocations = new ArrayList<Location>();
        }
        if(coalLocations.contains(loc)){
            coalLocations.remove(loc);
            Main.locations.set("coal", coalLocations);
            i++;
        }

        List<Location> copperLocations;
        try{
            copperLocations = (List<Location>) Main.locations.getList("copper");
        }catch(Exception e){
            copperLocations = new ArrayList<Location>();
        }
        if(copperLocations.contains(loc)){
            copperLocations.remove(loc);
            Main.locations.set("copper", copperLocations);
            i++;
        }


        List<Location> ironLocations;
        try{
            ironLocations = (List<Location>) Main.locations.getList("iron");
        }catch(Exception e){
            ironLocations = new ArrayList<Location>();
        }
        if(ironLocations.contains(loc)){
            ironLocations.remove(loc);
            Main.locations.set("iron", ironLocations);
            i++;
        }


        List<Location> goldLocations;
        try{
            goldLocations = (List<Location>) Main.locations.getList("gold");
        }catch(Exception e){
            goldLocations = new ArrayList<Location>();
        }
        if(goldLocations.contains(loc)){
            goldLocations.remove(loc);
            Main.locations.set("gold", goldLocations);
            i++;
        }


        List<Location> redstoneLocations;
        try{
            redstoneLocations = (List<Location>) Main.locations.getList("redstone");
        }catch(Exception e){
            redstoneLocations = new ArrayList<Location>();
        }
        if(redstoneLocations.contains(loc)){
            redstoneLocations.remove(loc);
            Main.locations.set("redstone", redstoneLocations);
            i++;
        }


        List<Location> lapisLocations;
        try{
            lapisLocations = (List<Location>) Main.locations.getList("lapis");
        }catch(Exception e){
            lapisLocations = new ArrayList<Location>();
        }
        if(lapisLocations.contains(loc)){
            lapisLocations.remove(loc);
            Main.locations.set("lapis", lapisLocations);
            i++;
        }


        List<Location> diamondLocations;
        try{
            diamondLocations = (List<Location>) Main.locations.getList("diamond");
        }catch(Exception e){
            diamondLocations = new ArrayList<Location>();
        }
        if(diamondLocations.contains(loc)){
            diamondLocations.remove(loc);
            Main.locations.set("diamond", diamondLocations);
            i++;
        }

        List<Location> emeraldLocations;
        try{
            emeraldLocations = (List<Location>) Main.locations.getList("emerald");
        }catch(Exception e){
            emeraldLocations = new ArrayList<Location>();
        }
        if(emeraldLocations.contains(loc)){
            emeraldLocations.remove(loc);
            Main.locations.set("emerald", emeraldLocations);
            i++;
        }

        if(i==0){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDie Location ist nicht registriert."));
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &e"+i+" &7Location entfernt."));
        }
    }
}
