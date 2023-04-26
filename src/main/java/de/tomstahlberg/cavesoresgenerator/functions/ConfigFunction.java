package de.tomstahlberg.cavesoresgenerator.functions;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigFunction {
    private File configFile;
    private FileConfiguration config;
    public ConfigFunction(Plugin plugin){
        this.configFile = new File(plugin.getDataFolder(), "settings.yml");
        if(!this.configFile.exists()){
            this.config = new YamlConfiguration();
            config.set("coal", 7.0f);
            config.set("copper", 7.0f);
            config.set("iron", 7.0f);
            config.set("gold", 7.0f);
            config.set("redstone", 7.0f);
            config.set("lapis", 7.0f);
            config.set("emerald", 7.0f);
            config.set("diamond", 7.0f);
            config.set("world", "Mine");
        }else{
            this.config = YamlConfiguration.loadConfiguration(this.configFile);
        }
    }
    public void saveConfig() throws IOException {
        this.config.save(this.configFile);
    }
    public String getWorld(){
        return this.config.getString("world");
    }
    public float getCoalValue(){
        return (float) this.config.getDouble("coal");
    }
    public float getCopperValue(){
        return (float) this.config.getDouble("copper");
    }
    public float getIronValue(){
        return (float) this.config.getDouble("iron");
    }
    public float getGoldValue(){
        return (float) this.config.getDouble("gold");
    }
    public float getRedstoneValue(){
        return (float) this.config.getDouble("redstone");
    }
    public float getLapisValue(){
        return (float) this.config.getDouble("lapis");
    }
    public float getEmeraldValue(){
        return (float) this.config.getDouble("emerald");
    }
    public float getDiamondValue(){
        return (float) this.config.getDouble("diamond");
    }

}
