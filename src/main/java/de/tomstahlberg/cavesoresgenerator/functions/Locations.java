package de.tomstahlberg.cavesoresgenerator.functions;

import de.tomstahlberg.cavesoresgenerator.Main;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Locations {
    private File file;
    FileConfiguration locations;
    public Locations() throws IOException {
        file = new File(Main.plugin.getDataFolder(), "locations.yml");
        if(file.exists()){
            try{
                this.locations = YamlConfiguration.loadConfiguration(file);
            }catch(Exception e){
                this.locations = createLocationsFile();
            }
        }else{
            this.locations = createLocationsFile();
        }
    }

    public Locations(FileConfiguration config) throws IOException {
        file = new File(Main.plugin.getDataFolder(), "locations.yml");
        this.locations = config;
    }
    public FileConfiguration loadConfiguration(){
        return this.locations;
    }
    public void saveConfiguration() throws IOException {
        this.locations.save(this.file);
    }
    private FileConfiguration createLocationsFile(){
        FileConfiguration newConfig = new YamlConfiguration();
        List<Location> emptyList = new ArrayList<Location>();
        newConfig.set("coal", emptyList);
        newConfig.set("copper", emptyList);
        newConfig.set("iron", emptyList);
        newConfig.set("gold", emptyList);
        newConfig.set("redstone", emptyList);
        newConfig.set("lapis", emptyList);
        newConfig.set("diamond", emptyList);
        newConfig.set("emerald", emptyList);

        return newConfig;
    }
}
