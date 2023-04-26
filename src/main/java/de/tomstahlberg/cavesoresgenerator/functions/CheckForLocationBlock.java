package de.tomstahlberg.cavesoresgenerator.functions;

import de.tomstahlberg.cavesoresgenerator.Main;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class CheckForLocationBlock {
    private List<Location> coalLocations;
    private List<Location> copperLocations;
    private List<Location> ironLocations;
    private List<Location> goldLocations;
    private List<Location> redstoneLocations;
    private List<Location> lapisLocations;
    private List<Location> diamondLocations;
    private List<Location> emeraldLocations;
    public CheckForLocationBlock(){
        try{
            this.coalLocations = (List<Location>) Main.locations.getList("coal");
        }catch(Exception e){
            this.coalLocations = new ArrayList<Location>();
        }
        try{
            this.copperLocations = (List<Location>) Main.locations.getList("copper");
        }catch(Exception e){
            this.copperLocations = new ArrayList<Location>();
        }
        try{
            this.ironLocations = (List<Location>) Main.locations.getList("iron");
        }catch(Exception e){
            this.ironLocations = new ArrayList<Location>();
        }
        try{
            this.goldLocations = (List<Location>) Main.locations.getList("gold");
        }catch(Exception e){
            this.goldLocations = new ArrayList<Location>();
        }
        try{
            this.redstoneLocations = (List<Location>) Main.locations.getList("redstone");
        }catch(Exception e){
            this.redstoneLocations = new ArrayList<Location>();
        }
        try{
            this.lapisLocations = (List<Location>) Main.locations.getList("lapis");
        }catch(Exception e){
            this.lapisLocations = new ArrayList<Location>();
        }
        try{
            this.diamondLocations = (List<Location>) Main.locations.getList("diamond");
        }catch(Exception e){
            this.diamondLocations = new ArrayList<Location>();
        }
        try{
            this.emeraldLocations = (List<Location>) Main.locations.getList("emerald");
        }catch(Exception e){
            this.emeraldLocations = new ArrayList<Location>();
        }
    }
    public Boolean check(Location location){
        boolean is = false;

        for(Location loc : coalLocations){
            if(loc.equals(location)){
                is = true;
                break;
            }
        }
        for(Location loc : copperLocations){
            if(loc.equals(location)){
                is = true;
                break;
            }
        }
        for(Location loc : ironLocations){
            if(loc.equals(location)){
                is = true;
                break;
            }
        }
        for(Location loc : goldLocations){
            if(loc.equals(location)){
                is = true;
                break;
            }
        }
        for(Location loc : redstoneLocations){
            if(loc.equals(location)){
                is = true;
                break;
            }
        }
        for(Location loc : lapisLocations){
            if(loc.equals(location)){
                is = true;
                break;
            }
        }
        for(Location loc : diamondLocations){
            if(loc.equals(location)){
                is = true;
                break;
            }
        }
        for(Location loc : emeraldLocations){
            if(loc.equals(location)){
                is = true;
                break;
            }
        }

        return is;
    }
}
