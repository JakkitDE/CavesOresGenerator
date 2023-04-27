package de.tomstahlberg.cavesoresgenerator;

import de.tomstahlberg.cavesoresgenerator.events.*;
import de.tomstahlberg.cavesoresgenerator.events.physics.BlockFromTo;
import de.tomstahlberg.cavesoresgenerator.events.physics.BlockPhysics;
import de.tomstahlberg.cavesoresgenerator.functions.ConfigFunction;
import de.tomstahlberg.cavesoresgenerator.functions.Locations;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {
    public static FileConfiguration locations;
    public static Plugin plugin;
    public static Locations locationsConfigurator;
    public static Boolean editMode;
    public static ConfigFunction config;
    public static List<Player> blockedMessagesList = new ArrayList<>();
    public static List<Player> teleportedList = new ArrayList<>();


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
        try {
            config.saveConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        getServer().getPluginManager().registerEvents(new ToggleBlockBreak(), this);
        getServer().getPluginManager().registerEvents(new ToggleBlockBreakSneaking(), this);
        getServer().getPluginManager().registerEvents(new PlayerBlockBreak(), this);
        getServer().getPluginManager().registerEvents(new BlockedEvents(), this);
        getServer().getPluginManager().registerEvents(new BlockedEventsInCave(), this);
        getServer().getPluginManager().registerEvents(new BlockFromTo(), this);
        getServer().getPluginManager().registerEvents(new BlockPhysics(), this);

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
