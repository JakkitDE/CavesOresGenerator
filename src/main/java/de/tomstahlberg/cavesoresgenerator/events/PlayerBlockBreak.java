package de.tomstahlberg.cavesoresgenerator.events;

import de.tomstahlberg.cavesoresgenerator.CavesOresGenerator;
import de.tomstahlberg.cavesoresgenerator.functions.BlockResetTimer;
import de.tomstahlberg.cavesoresgenerator.functions.CheckForLocationBlock;
import de.tomstahlberg.cavesoresgenerator.functions.PlaceMaterialElsewhere;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerBlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(event.getBlock().getLocation().getWorld().getName().equalsIgnoreCase("Mine")){
            if(CavesOresGenerator.editMode == false){
                Material materialToPlace = Material.AIR;
                if(event.getBlock().getType() == Material.COAL_ORE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COAL));
                    materialToPlace = Material.STONE;
                    new PlaceMaterialElsewhere(Material.COAL_ORE);
                    new BlockResetTimer(event.getBlock().getLocation(), Material.COBBLESTONE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.COPPER_ORE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COAL));
                    materialToPlace = Material.STONE;
                    new PlaceMaterialElsewhere(Material.COPPER_ORE);
                    new BlockResetTimer(event.getBlock().getLocation(), Material.COBBLESTONE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.IRON_ORE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.RAW_IRON));
                    materialToPlace = Material.STONE;
                    new PlaceMaterialElsewhere(Material.IRON_ORE);
                    new BlockResetTimer(event.getBlock().getLocation(), Material.ANDESITE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.GOLD_ORE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.RAW_GOLD));
                    materialToPlace = Material.STONE;
                    new PlaceMaterialElsewhere(Material.GOLD_ORE);
                    new BlockResetTimer(event.getBlock().getLocation(), Material.ANDESITE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.REDSTONE_ORE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.REDSTONE));
                    materialToPlace = Material.STONE;
                    new PlaceMaterialElsewhere(Material.REDSTONE_ORE);
                    new BlockResetTimer(event.getBlock().getLocation(), Material.GRANITE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.DEEPSLATE_LAPIS_ORE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.LAPIS_LAZULI));
                    materialToPlace = Material.STONE;
                    new PlaceMaterialElsewhere(Material.DEEPSLATE_LAPIS_ORE);
                    new BlockResetTimer(event.getBlock().getLocation(), Material.DEEPSLATE_BRICKS);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.DEEPSLATE_DIAMOND_ORE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COAL_ORE));
                    materialToPlace = Material.STONE;
                    new PlaceMaterialElsewhere(Material.DEEPSLATE_DIAMOND_ORE);
                    new BlockResetTimer(event.getBlock().getLocation(), Material.COBBLED_DEEPSLATE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.DEEPSLATE_EMERALD_ORE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COAL_ORE));
                    materialToPlace = Material.STONE;
                    new PlaceMaterialElsewhere(Material.DEEPSLATE_EMERALD_ORE);
                    new BlockResetTimer(event.getBlock().getLocation(), Material.COBBLED_DEEPSLATE);
                    playSound(player);





                }else if(event.getBlock().getType() == Material.COBBLESTONE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBBLESTONE));
                    materialToPlace = Material.BEDROCK;
                    new BlockResetTimer(event.getBlock().getLocation(), Material.COBBLESTONE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.ANDESITE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.ANDESITE));
                    materialToPlace = Material.BEDROCK;
                    new BlockResetTimer(event.getBlock().getLocation(), Material.ANDESITE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.GRANITE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.GRANITE));
                    materialToPlace = Material.BEDROCK;
                    new BlockResetTimer(event.getBlock().getLocation(), Material.GRANITE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.DEEPSLATE_BRICKS){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.DEEPSLATE_BRICKS));
                    materialToPlace = Material.BEDROCK;
                    new BlockResetTimer(event.getBlock().getLocation(), Material.DEEPSLATE_BRICKS);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.COBBLED_DEEPSLATE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBBLED_DEEPSLATE));
                    materialToPlace = Material.BEDROCK;
                    new BlockResetTimer(event.getBlock().getLocation(), Material.COBBLED_DEEPSLATE);
                    playSound(player);
                }else if(event.getBlock().getType() == Material.STONE){
                    //event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.COBBLESTONE));
                    materialToPlace = Material.BEDROCK;
                    if(!new CheckForLocationBlock().check(event.getBlock().getLocation())){
                        new BlockResetTimer(event.getBlock().getLocation(), Material.STONE);
                    }
                    playSound(player);
                }else{
                    event.setCancelled(true);
                }
                if(materialToPlace != Material.AIR){
                    setMaterial(event.getBlock().getLocation(), materialToPlace);
                }
            }else{
                //Wird gewartet
                if(!event.getPlayer().hasPermission("cavesoresgenerator.edit") && !event.getPlayer().isOp()){
                    event.setCancelled(true);
                    playFailedSound(player);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6&lGolden&3&lSky &8x &cDie Mine wird derzeit gewartet."));
                }
            }
        }
    }
    private void playSound(Player player){
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 1F);
    }
    private void playFailedSound(Player player){
        player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_CLUSTER_HIT, 0.5F, 1F);
    }
    private void setMaterial(Location loc, Material material){
        Bukkit.getScheduler().runTask(CavesOresGenerator.plugin, new Runnable() {
            @Override
            public void run() {
                loc.getBlock().setType(material);
            }
        });
    }
}
