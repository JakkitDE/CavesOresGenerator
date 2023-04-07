package de.tomstahlberg.cavesoresgenerator;

import de.tomstahlberg.cavesoresgenerator.commands.Main;
import de.tomstahlberg.cavesoresgenerator.events.BlockedEvents;
import de.tomstahlberg.cavesoresgenerator.events.PlayerBlockBreak;
import de.tomstahlberg.cavesoresgenerator.events.ToggleBlockBreak;
import de.tomstahlberg.cavesoresgenerator.events.ToggleBlockBreakSneaking;
import de.tomstahlberg.cavesoresgenerator.functions.Locations;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class CavesOresGenerator extends JavaPlugin {
    public static FileConfiguration locations;
    public static Plugin plugin;
    public static Locations locationsConfigurator;
    public static Boolean editMode;


    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;
        editMode = false;
        try {
            locationsConfigurator = new Locations();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        locations = locationsConfigurator.loadConfiguration();

        getServer().getPluginManager().registerEvents(new ToggleBlockBreak(), this);
        getServer().getPluginManager().registerEvents(new ToggleBlockBreakSneaking(), this);
        getServer().getPluginManager().registerEvents(new PlayerBlockBreak(), this);
        getServer().getPluginManager().registerEvents(new BlockedEvents(), this);
        getServer().getPluginCommand("cog").setExecutor(new Main());
        getServer().getPluginCommand("cog").setTabCompleter(new Main());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try {
            new Locations(locations).saveConfiguration();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
