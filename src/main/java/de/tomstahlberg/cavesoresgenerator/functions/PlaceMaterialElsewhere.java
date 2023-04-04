package de.tomstahlberg.cavesoresgenerator.functions;

import de.tomstahlberg.cavesoresgenerator.CavesOresGenerator;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.Collections;
import java.util.List;

public class PlaceMaterialElsewhere {
    public PlaceMaterialElsewhere(Material material){
        if(material == Material.COAL_ORE){
            setCoalOre();
        }else if(material == Material.IRON_ORE){
            setIronOre();
        }else if(material == Material.GOLD_ORE){
            setGoldOre();
        }else if(material == Material.REDSTONE_ORE){
            setRedstoneOre();
        }else if(material == Material.DEEPSLATE_LAPIS_ORE){
            setLapisOre();
        }else if(material == Material.DEEPSLATE_DIAMOND_ORE){
            setDiamondOre();
        }
    }
    private void setCoalOre(){
        List<Location> locations = (List<Location>) CavesOresGenerator.locations.getList("coal");
        Collections.shuffle(locations);
        for(Location loc : locations){
            if(loc.getBlock().getType() == Material.COBBLESTONE){
                loc.getBlock().setType(Material.COAL_ORE);
                break;
            }
        }
    }
    private void setIronOre(){
        List<Location> locations = (List<Location>) CavesOresGenerator.locations.getList("iron");
        Collections.shuffle(locations);
        for(Location loc : locations){
            if(loc.getBlock().getType() == Material.ANDESITE){
                loc.getBlock().setType(Material.IRON_ORE);
                break;
            }
        }
    }
    private void setGoldOre(){
        List<Location> locations = (List<Location>) CavesOresGenerator.locations.getList("gold");
        Collections.shuffle(locations);
        for(Location loc : locations){
            if(loc.getBlock().getType() == Material.ANDESITE){
                loc.getBlock().setType(Material.GOLD_ORE);
                break;
            }
        }
    }
    private void setRedstoneOre(){
        List<Location> locations = (List<Location>) CavesOresGenerator.locations.getList("redstone");
        Collections.shuffle(locations);
        for(Location loc : locations){
            if(loc.getBlock().getType() == Material.GRANITE){
                loc.getBlock().setType(Material.REDSTONE_ORE);
                break;
            }
        }
    }

    private void setLapisOre(){
        List<Location> locations = (List<Location>) CavesOresGenerator.locations.getList("lapis");
        Collections.shuffle(locations);
        for(Location loc : locations){
            if(loc.getBlock().getType() == Material.DEEPSLATE_BRICKS){
                loc.getBlock().setType(Material.DEEPSLATE_LAPIS_ORE);
                break;
            }
        }
    }

    private void setDiamondOre(){
        List<Location> locations = (List<Location>) CavesOresGenerator.locations.getList("diamond");
        Collections.shuffle(locations);
        for(Location loc : locations){
            if(loc.getBlock().getType() == Material.COBBLED_DEEPSLATE){
                loc.getBlock().setType(Material.DEEPSLATE_DIAMOND_ORE);
                break;
            }
        }
    }
}
