package fr.gwengwen49.mazeplugin.maze.parts.decorations;

import org.bukkit.Location;
import org.bukkit.Material;

import java.util.Random;

public class TreeDecoration extends MazeDecoration{

    private Material leaves;
    private Material trunk;
    private int trunkHeight;
    private int leavesRadius;
    protected TreeDecoration(Type decorationType, Material material, int spawnRarity) {
        super(decorationType, material, spawnRarity);
    }

    public TreeDecoration(Type decorationType, Material leaves, int maxLeavesRadius, Material trunk, int maxTrunkHeight, int spawnRarity)
    {
        this(decorationType, null, spawnRarity);
        this.leaves = leaves;
        this.trunk = trunk;
        this.trunkHeight = maxTrunkHeight;
        this.leavesRadius = maxLeavesRadius;
    }

    public Material getLeaves() {
        return leaves;
    }

    public Material getTrunk() {
        return trunk;
    }

    public void setLeaves(Material leaves) {
        this.leaves = leaves;
    }

    public void setTrunk(Material trunk) {
        this.trunk = trunk;
    }

    public int getTrunkHeight() {
        return trunkHeight;
    }

    public int getLeavesRadius() {
        return leavesRadius;
    }

    public void setTrunkHeight(int trunkHeight) {
        this.trunkHeight = trunkHeight;
    }

    public void setLeavesRadius(int leavesRadius) {
        this.leavesRadius = leavesRadius;
    }

    @Override
    public void generate(Location startPos) {

        if(random.nextInt(getRarity()) == 1) {
            Location finalRandPlacement = new Location(startPos.getWorld(), startPos.getX(), startPos.getY(), startPos.getZ());
            int random = new Random().nextInt(5);
            for (int maxTrunkHeight = 0; maxTrunkHeight <= getTrunkHeight() - random; maxTrunkHeight++) {

                int x = (int) finalRandPlacement.getX();
                int y = (int) finalRandPlacement.getY();
                int z = (int) finalRandPlacement.getZ();
                finalRandPlacement.getWorld().getBlockAt(x, y + maxTrunkHeight, z).setType(getTrunk());

                if (maxTrunkHeight == getTrunkHeight() - random) {
                    for (int diameterX = x - getLeavesRadius(); diameterX <= x + getLeavesRadius(); diameterX++) {
                        for (int diameterY = z - getLeavesRadius(); diameterY <= z + getLeavesRadius(); diameterY++) {
                            finalRandPlacement.getWorld().getBlockAt(diameterX, y + getTrunkHeight() - random, diameterY).setType(getLeaves());

                        }
                    }
                }
            }
        }
    }
}

