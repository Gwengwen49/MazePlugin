package fr.gwengwen49.mazeplugin.util;

import fr.gwengwen49.mazeplugin.MazePlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Constants {

    public static final Location DECORATION_FLOOR_STARTPOS = new Location(MazePlugin.Events.getStartPos().getWorld(), MazePlugin.Events.getStartPos().getX(), MazePlugin.Events.getStartPos().getY()+1, MazePlugin.Events.getStartPos().getZ());

    public static final ItemStack getMazeSpawner()
    {
        ItemStack mazeSpawner = new ItemStack(Material.MOJANG_BANNER_PATTERN);
        return mazeSpawner;
    }
}
