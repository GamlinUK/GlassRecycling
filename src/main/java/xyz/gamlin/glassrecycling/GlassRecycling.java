package xyz.gamlin.glassrecycling;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class GlassRecycling extends JavaPlugin {

    private Material[] glassBlocks = {
            Material.WHITE_STAINED_GLASS,
            Material.ORANGE_STAINED_GLASS,
            Material.MAGENTA_STAINED_GLASS,
            Material.LIGHT_BLUE_STAINED_GLASS,
            Material.YELLOW_STAINED_GLASS,
            Material.LIME_STAINED_GLASS,
            Material.PINK_STAINED_GLASS,
            Material.GRAY_STAINED_GLASS,
            Material.LIGHT_GRAY_STAINED_GLASS,
            Material.CYAN_STAINED_GLASS,
            Material.PURPLE_STAINED_GLASS,
            Material.BLUE_STAINED_GLASS,
            Material.BROWN_STAINED_GLASS,
            Material.GREEN_STAINED_GLASS,
            Material.RED_STAINED_GLASS,
            Material.BLACK_STAINED_GLASS
    };

    private Material[] glassPanes = {
            Material.WHITE_STAINED_GLASS_PANE,
            Material.ORANGE_STAINED_GLASS_PANE,
            Material.MAGENTA_STAINED_GLASS_PANE,
            Material.LIGHT_BLUE_STAINED_GLASS_PANE,
            Material.YELLOW_STAINED_GLASS_PANE,
            Material.LIME_STAINED_GLASS_PANE,
            Material.PINK_STAINED_GLASS_PANE,
            Material.GRAY_STAINED_GLASS_PANE,
            Material.LIGHT_GRAY_STAINED_GLASS_PANE,
            Material.CYAN_STAINED_GLASS_PANE,
            Material.PURPLE_STAINED_GLASS_PANE,
            Material.BLUE_STAINED_GLASS_PANE,
            Material.BROWN_STAINED_GLASS_PANE,
            Material.GREEN_STAINED_GLASS_PANE,
            Material.RED_STAINED_GLASS_PANE,
            Material.BLACK_STAINED_GLASS_PANE
    };

    @Override
    public void onEnable() {

        int pluginId = 13109;
        Metrics metrics = new Metrics(this, pluginId);

        getLogger().info("Glass Recycling is registering recipes.");
        ItemStack clearGlassBlock = new ItemStack(Material.GLASS);
        for (Material glassBlock: this.glassBlocks) {
            String key = "gr_glass_" + glassBlock.name();
            NamespacedKey keyGlassBlock = new NamespacedKey(this, key);
            FurnaceRecipe glassRecipe = new FurnaceRecipe(
                    keyGlassBlock,
                    clearGlassBlock,
                    glassBlock,
                    0,
                    200
            );
            Bukkit.addRecipe(glassRecipe);
        }

        ItemStack clearGlassPane = new ItemStack(Material.GLASS_PANE);
        for (Material glassPane: this.glassPanes) {
            String key = "gr_glass_pane_" + glassPane.name();
            NamespacedKey keyGlassPane = new NamespacedKey(this, key);
            FurnaceRecipe glassRecipe = new FurnaceRecipe(
                    keyGlassPane,
                    clearGlassBlock,
                    glassPane,
                    0,
                    200
            );
            Bukkit.addRecipe(glassRecipe);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
