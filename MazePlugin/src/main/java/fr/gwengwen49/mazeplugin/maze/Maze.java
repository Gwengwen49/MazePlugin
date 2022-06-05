package fr.gwengwen49.mazeplugin.maze;



import fr.gwengwen49.mazeplugin.MazePlugin;
import fr.gwengwen49.mazeplugin.util.HelpFunctions;
import org.bukkit.Bukkit;
import org.bukkit.Location;


public class Maze {

    private int numbChunks = 8;
    private int line = 0;
    private int nbChunk = 1;
    private int column = 0;
    private int chunkCoord;

        public Maze(Location startPos) {
            int x = (int) startPos.getX();
            int y = (int) startPos.getY();
            int z = (int) startPos.getZ();
            Bukkit.getScheduler().scheduleSyncRepeatingTask(MazePlugin.INSTANCE, () -> {
                Location loc = new Location(startPos.getWorld(), x+line, y, z+column);
                new MazeChunk(loc);
                Bukkit.broadcastMessage(HelpFunctions.convertToPercentage((float) numbChunks*numbChunks, (float) nbChunk)+"%");

                line = line+16;
                nbChunk++;
                chunkCoord = chunkCoord+16;
                if(line == 16*numbChunks)
                {
                    column = column+16;
                    line = 0;
                }
                if(column == 16*numbChunks)
                {
                    Bukkit.getScheduler().cancelTasks(MazePlugin.INSTANCE);
                }
            }, 1, 2*20);

            }

    public int getChunkCoord() {
        return chunkCoord;
    }

    //((chunkCoord/16)+1)+"/"+(numbChunks*numbChunks)


        }

