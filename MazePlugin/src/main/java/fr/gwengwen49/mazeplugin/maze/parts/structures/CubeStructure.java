package fr.gwengwen49.mazeplugin.maze.parts.structures;

import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.MazeDecoration;
import org.bukkit.Location;
import org.bukkit.Material;


public class CubeStructure extends MazeStructure
{

    private final Material[] materials;
    private final MazeDecoration.Type type;
    private final int spawnChance;
    private final int radius;


    public CubeStructure(int spawnChance, MazeDecoration.Type type, int radius, Material... materials)
    {
        super(spawnChance, type, materials);
        this.type = type;
        this.materials = materials;
        this.spawnChance = spawnChance;
        this.radius = radius;
    }

    public int getSpawnChance() {return spawnChance;}

    public Material[] getMaterials(){return materials;}

    public MazeDecoration.Type getType(){return type;}

    public int getRadius(){return radius;}


    @Override
    public void generate(Location startPos) {
        for(int x = (int) startPos.getX()-getRadius(); x <= startPos.getX()+radius;x++ )
        {
            for(int y = (int) startPos.getY()-getRadius(); y <= startPos.getX()+radius;y++ )
            {
                for(int z = (int) startPos.getZ()-getRadius(); z <= startPos.getX()+radius;z++ )
                {
                    if(random.nextInt(spawnChance) == getSpawnChance())
                    {
                        startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x, y, z)).setType(getMaterials()[random.nextInt(getMaterials().length)]);
                    }
                }
            }
        }
    }
}
