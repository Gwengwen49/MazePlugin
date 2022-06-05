package fr.gwengwen49.mazeplugin.maze;

import fr.gwengwen49.injectorapi.InjectionHandler;
import fr.gwengwen49.mazeplugin.maze.parts.Direction;
import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.MazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.SimpleBlockMazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.TreeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.*;
import org.bukkit.Location;
import org.bukkit.Material;

import static fr.gwengwen49.mazeplugin.maze.MazeConfig.chunkSize;
public class MazeChunk {


    public MazeChunk(Location startPos) {
        new Generator(new Floor(), startPos, 1);
        new Generator(new SimpleBlockMazeDecoration(MazeDecoration.Type.FLOOR, Material.COBWEB, 80), startPos, 1);
        new Generator(new TreeDecoration(MazeDecoration.Type.FLOOR, Material.ACACIA_LEAVES, 5, Material.BIRCH_LOG, 10, 200), startPos, 1);
        new Generator(new Wall(Direction.RANDOM), startPos, 13);
        InjectionHandler.inject(this.getClass());
    }


    public static class Generator
    {

        public Location finalPlacement;


        public <T extends Part> Generator(T part, Location startPos, int spawnInterval) {
            InjectionHandler.inject(this.getClass());
                for (int x = -chunkSize; x <= chunkSize; x = x + spawnInterval) {
                    for (int z = -chunkSize; z <= chunkSize; z = z + spawnInterval) {
                        finalPlacement = new Location(startPos.getWorld(), startPos.getX() + x, startPos.getY(), startPos.getZ() + z);
                           part.generate(finalPlacement);

                    }
                }
            }

    }
}