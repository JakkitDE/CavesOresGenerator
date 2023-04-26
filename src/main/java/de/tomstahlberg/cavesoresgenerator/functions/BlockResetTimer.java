package de.tomstahlberg.cavesoresgenerator.functions;

import de.tomstahlberg.cavesoresgenerator.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class BlockResetTimer {
    public BlockResetTimer(Location loc, Material wallMaterial){
        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
            @Override
            public void run() {
                loc.getBlock().setType(wallMaterial);
            }
        }, 100);
    }
}
