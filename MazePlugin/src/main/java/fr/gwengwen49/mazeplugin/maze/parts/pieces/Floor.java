package fr.gwengwen49.mazeplugin.maze.parts.pieces;
import fr.gwengwen49.mazeplugin.maze.MazeConfig;
import fr.gwengwen49.mazeplugin.maze.parts.Part;
import org.bukkit.Location;
import org.bukkit.Material;
import java.util.Random;
public class Floor extends MazePiece {

    @Override
    public void generate(Location startPos) {
        int rand = random.nextInt(MazeConfig.floorMaterials.length);
        Material material = MazeConfig.floorMaterials[rand];
        startPos.getWorld().getBlockAt(startPos).setType(material);

    }

}
