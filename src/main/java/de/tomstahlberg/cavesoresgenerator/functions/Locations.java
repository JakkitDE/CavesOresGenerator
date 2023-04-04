package de.tomstahlberg.cavesoresgenerator.functions;

import de.tomstahlberg.cavesoresgenerator.CavesOresGenerator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Locations {
    private File file;
    FileConfiguration locations;
    public Locations() throws IOException {
        file = new File(CavesOresGenerator.plugin.getDataFolder(), "locations.yml");
        if(file.exists()){
            this.locations = YamlConfiguration.loadConfiguration(file);
        }else{
            this.locations = new YamlConfiguration();
        }
    }

    public Locations(FileConfiguration config) throws IOException {
        file = new File(CavesOresGenerator.plugin.getDataFolder(), "locations.yml");
        this.locations = config;
    }
    public FileConfiguration loadConfiguration(){
        return this.locations;
    }
    public void saveConfiguration() throws IOException {
        this.locations.save(this.file);
    }
}
