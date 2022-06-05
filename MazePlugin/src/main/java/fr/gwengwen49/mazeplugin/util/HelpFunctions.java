package fr.gwengwen49.mazeplugin.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class HelpFunctions
{

    public static boolean isAir(Location location)
    {
        return location.getWorld().getBlockAt(location).getType() == Material.AIR;
    }

    /**
     * Return true if the block at the specified location is composed by the specified material
     * @param location
     * @param material
     * @return
     */
    public static boolean isMaterial(Location location, Material material)
    {
        return location.getWorld().getBlockAt(location).getType() == material;
    }

    public static int convertToPercentage(float total, float number)
    {
        float finalPercentage = (number/total)*100;
        return (int)finalPercentage;

    }
}
