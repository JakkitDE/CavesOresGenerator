package de.tomstahlberg.cavesoresgenerator.functions;

import de.tomstahlberg.cavesoresgenerator.CavesOresGenerator;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Shuffle {
    private List<Location> coalLocations;
    private List<Location> ironLocations;
    private List<Location> goldLocations;
    private List<Location> redstoneLocations;
    private List<Location> lapisLocations;
    private List<Location> diamondLocations;
    public Shuffle(){
        //fill Lists
        try{
            this.coalLocations = (List<Location>) CavesOresGenerator.locations.getList("coal");
        }catch(Exception e){
            this.coalLocations = new ArrayList<Location>();
        }
        try{
            this.ironLocations = (List<Location>) CavesOresGenerator.locations.getList("iron");
        }catch(Exception e){
            this.ironLocations = new ArrayList<Location>();
        }
        try{
            this.goldLocations = (List<Location>) CavesOresGenerator.locations.getList("gold");
        }catch(Exception e){
            this.goldLocations = new ArrayList<Location>();
        }
        try{
            this.redstoneLocations = (List<Location>) CavesOresGenerator.locations.getList("redstone");
        }catch(Exception e){
            this.redstoneLocations = new ArrayList<Location>();
        }
        try{
            this.lapisLocations = (List<Location>) CavesOresGenerator.locations.getList("lapis");
        }catch(Exception e){
            this.lapisLocations = new ArrayList<Location>();
        }
        try{
            this.diamondLocations = (List<Location>) CavesOresGenerator.locations.getList("diamond");
        }catch(Exception e){
            this.diamondLocations = new ArrayList<Location>();
        }

    }
    public void setByChance(){
        //shuffle
        for(Location loc : coalLocations){
            if(getRandomBoolean(5.0f) == true){
                loc.getBlock().setType(Material.COAL_ORE);
            }else{
                loc.getBlock().setType(Material.COBBLESTONE);
            }
        }
        for(Location loc : ironLocations){
            if(getRandomBoolean(2.0f) == true){
                loc.getBlock().setType(Material.IRON_ORE);
            }else{
                loc.getBlock().setType(Material.ANDESITE);
            }
        }
        for(Location loc : goldLocations){
            if(getRandomBoolean(0.8f) == true){
                loc.getBlock().setType(Material.GOLD_ORE);
            }else{
                loc.getBlock().setType(Material.ANDESITE);
            }
        }
        for(Location loc : redstoneLocations){
            if(getRandomBoolean(0.6f) == true){
                loc.getBlock().setType(Material.REDSTONE_ORE);
            }else{
                loc.getBlock().setType(Material.GRANITE);
            }
        }
        for(Location loc : lapisLocations){
            if(getRandomBoolean(0.6f) == true){
                loc.getBlock().setType(Material.DEEPSLATE_LAPIS_ORE);
            }else{
                loc.getBlock().setType(Material.DEEPSLATE_BRICKS);
            }
        }
        for(Location loc : diamondLocations){
            if(getRandomBoolean(0.2f) == true){
                loc.getBlock().setType(Material.DEEPSLATE_DIAMOND_ORE);
            }else{
                loc.getBlock().setType(Material.COBBLED_DEEPSLATE);
            }
        }
    }
    public void setAll(){
        //set all ores to their locations to better toggle
        for(Location loc : coalLocations){
            loc.getBlock().setType(Material.COAL_ORE);
        }
        for(Location loc : ironLocations){
            loc.getBlock().setType(Material.IRON_ORE);
        }
        for(Location loc : goldLocations){
            loc.getBlock().setType(Material.GOLD_ORE);
        }
        for(Location loc : redstoneLocations){
            loc.getBlock().setType(Material.REDSTONE_ORE);
        }
        for(Location loc : lapisLocations){
            loc.getBlock().setType(Material.DEEPSLATE_LAPIS_ORE);
        }
        for(Location loc : diamondLocations){
            loc.getBlock().setType(Material.DEEPSLATE_DIAMOND_ORE);
        }
    }
    private boolean getRandomBoolean(float probability) {
        double randomValue = Math.random()*100;  //0.0 to 99.9
        return randomValue <= probability;
    }
}
