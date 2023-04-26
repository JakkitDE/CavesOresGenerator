package de.tomstahlberg.cavesoresgenerator.events.physics;

import de.tomstahlberg.cavesoresgenerator.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class BlockPhysics implements Listener {
    @EventHandler
    public void onBlockChange(BlockPhysicsEvent event){
        if(event.getBlock().getLocation().getWorld().getName().equalsIgnoreCase(Main.config.getWorld())){
            if(Main.editMode == false){
                event.setCancelled(true);
            }
        }
    }
}
