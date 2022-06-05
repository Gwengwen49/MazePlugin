package fr.gwengwen49.mazeplugin.maze;

import org.bukkit.Material;


public class MazeConfig
{

    /**
     * set the walls max dimensions (element[0] is x, element[1] is y and element[2] is z), note that make a random with those max values
     */
    public static int[] wallMaxDimensions = new int[]{5,45,5};


    /**
     * set all the materials you want to your walls and it will a random with those
     */
    public static Material[] wallMaterials = new Material[]{Material.STONE, Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.MOSSY_COBBLESTONE};


    /**
     * like the walls but for the floor
     */
    public static Material[] floorMaterials = new Material[]{Material.STONE, Material.STONE, Material.STONE_BRICKS, Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.POLISHED_ANDESITE, Material.GRASS_BLOCK, Material.ANDESITE};

    /**
     * set the chunk size, but note this value will be multiplied by 2.
     * For more informations about that, check {@link MazeChunk}
     */

    public static short chunkSize = 8;

    public static short miniMazeRadius = 18;







}
