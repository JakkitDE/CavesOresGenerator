package de.tomstahlberg.cavesoresgenerator;

import de.tomstahlberg.cavesoresgenerator.events.BlockedEvents;
import de.tomstahlberg.cavesoresgenerator.events.CaveTools.BlockedEventsInCaves;
import de.tomstahlberg.cavesoresgenerator.events.PlayerBlockBreak;
import de.tomstahlberg.cavesoresgenerator.events.ToggleBlockBreak;
import de.tomstahlberg.cavesoresgenerator.events.ToggleBlockBreakSneaking;
import de.tomstahlberg.cavesoresgenerator.functions.ConfigFunction;
import de.tomstahlberg.cavesoresgenerator.functions.Locations;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Main extends JavaPlugin {
    public static FileConfiguration locations;
    public static Plugin plugin;
    public static Locations locationsConfigurator;
    public static Boolean editMode;
    public static ConfigFunction config;


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

        config = new ConfigFunction(plugin);

        getServer().getPluginManager().registerEvents(new ToggleBlockBreak(), this);
        getServer().getPluginManager().registerEvents(new ToggleBlockBreakSneaking(), this);
        getServer().getPluginManager().registerEvents(new PlayerBlockBreak(), this);
        getServer().getPluginManager().registerEvents(new BlockedEvents(), this);
        getServer().getPluginManager().registerEvents(new BlockedEventsInCaves(), this);

        getServer().getPluginCommand("cog").setExecutor(new de.tomstahlberg.cavesoresgenerator.commands.Main());
        getServer().getPluginCommand("cog").setTabCompleter(new de.tomstahlberg.cavesoresgenerator.commands.Main());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try {
            new Locations(locations).saveConfiguration();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            config.saveConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
