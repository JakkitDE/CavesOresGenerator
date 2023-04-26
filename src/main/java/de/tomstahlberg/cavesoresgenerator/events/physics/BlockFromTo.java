package de.tomstahlberg.cavesoresgenerator.events.physics;

import de.tomstahlberg.cavesoresgenerator.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPhysicsEvent;

public class BlockFromTo implements Listener {
    @EventHandler
    public void onBlockChange(BlockFromToEvent event){
        if(event.getBlock().getLocation().getWorld().getName().equalsIgnoreCase(Main.config.getWorld())){
            if(Main.editMode == false){
                event.setCancelled(true);
            }
        }
    }
}
