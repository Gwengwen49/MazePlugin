package fr.gwengwen49.mazeplugin.maze.parts.pieces;

import fr.gwengwen49.mazeplugin.maze.parts.Part;
import org.bukkit.Location;
import org.bukkit.Material;

import static fr.gwengwen49.mazeplugin.maze.MazeConfig.*;
public class MiniMaze extends MazePiece
{

    @Override
    public void generate(Location startPos) {
        for(int x = (int) (startPos.getX()-miniMazeRadius); x <= startPos.getX()+miniMazeRadius; x++)
        {
            for(int z = (int) (startPos.getZ()-miniMazeRadius); z <= startPos.getZ()+miniMazeRadius; z++)
            {
                int randInt = random.nextInt(4);
                for (int y = (int)startPos.getY() + 1; y <= 7; y++) {
                    switch (randInt) {
                        case 0: {

                            startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x, y, z)).setType(Material.STONE_BRICKS);

                        }
                    }
                }

            }
        }
    }
}


