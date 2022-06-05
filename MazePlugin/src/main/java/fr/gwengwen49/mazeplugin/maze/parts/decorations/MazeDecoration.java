package fr.gwengwen49.mazeplugin.maze.parts.decorations;

import fr.gwengwen49.mazeplugin.maze.parts.Part;
import org.bukkit.Location;
import org.bukkit.Material;
import java.util.Random;

public abstract class MazeDecoration implements Part
{

    private Material material;
    private Type type;
    private int rarity;
    public MazeDecoration(Type decorationType, Material material, int spawnRarity)
    {
    this.material = material;
    this.type = decorationType;
    this.rarity = spawnRarity;
    }

    public int getRarity()
    {
        return rarity;
    }

    public Type getDecorationType()
    {
        return type;
    }

    public Material getMaterial()
    {
        return material;
    }


    public enum Type
    {
        ROOF,
        MURAL,
        FLOOR;
    }

}
