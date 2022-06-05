package fr.gwengwen49.mazeplugin.maze.parts.pieces;

import static fr.gwengwen49.mazeplugin.maze.MazeConfig.*;

import fr.gwengwen49.mazeplugin.maze.parts.Direction;
import org.bukkit.Location;
import org.bukkit.Material;


public class Wall extends MazePiece {

    private int valuePlus = 8;
    private int valueMinus = 4;
    private int randomMaxValueForStartPlacement = 2;
    private int dimX;
    private int dimY;
    private int dimZ;
    private Direction direction;
    private Material[] materials;
    public Wall(int sizeX, int sizeY, int sizeZ, Direction direction, Material... materials) {
        this.dimX = sizeX;
        this.dimY = sizeY;
        this.dimZ = sizeZ;
        this.direction = direction;
        this.materials = materials;
    }

    public Wall(Direction direction) {
        this(wallMaxDimensions[0], wallMaxDimensions[1], wallMaxDimensions[2], direction, wallMaterials);

    }
    public Wall() {

    }

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public int getDimZ() {
        return dimZ;
    }

    public Direction getDirection() {
        return direction;
    }
    public Material[] getMaterials() {
        return materials;
    }

    public Wall setDimX(int sizeX) {
        this.dimX = sizeX;
        return this;
    }

    public Wall setDimY(int dimY) {
        this.dimY = dimY;
        return this;
    }

    public Wall setDimZ(int dimZ) {
        this.dimZ = dimZ;
        return this;
    }

    public Wall setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public Wall setMaterials(Material[] materials) {
        this.materials = materials;
        return this;
    }

    public void setToNorth(Location startPos, int x, int y, int z, Material... materialsList)
    {
        for (int x1 = (int) startPos.getX(); x1 <= startPos.getX()+x; x1++) {
            for (int y1 = (int) startPos.getY(); y1 <= startPos.getY()+y; y1++) {
                for (int z1 = (int) startPos.getZ(); z1 >= startPos.getZ()-z; z1--) {
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x1, y1, z1)).setType(materialsList[random.nextInt(materialsList.length)]);
               }
            }
        }
    }

    public void setToWest(Location startPos, int x, int y, int z, Material... materialsList)
    {
        for (int x1 = (int) startPos.getX(); x1 >= startPos.getX()-x; x1--) {
            for (int y1 = (int) startPos.getY(); y1 <= startPos.getY()+y; y1++) {
                for (int z1 = (int) startPos.getZ(); z1 <= startPos.getZ()+z; z1++) {
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x1, y1, z1)).setType(materialsList[random.nextInt(materialsList.length)]);
                }
            }
        }
    }

    public void setToSouth(Location startPos, int x, int y, int z, Material... materialsList)
    {
        for (int x1 = (int) startPos.getX(); x1 <= startPos.getX()+x; x1++) {
            for (int y1 = (int) startPos.getY(); y1 <= startPos.getY()+y; y1++) {
                for (int z1 = (int) startPos.getZ(); z1 <= startPos.getZ()+z; z1++) {
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x1, y1, z1)).setType(materialsList[random.nextInt(materialsList.length)]);
                }
            }
        }
    }

    public void setToEast(Location startPos, int x, int y, int z, Material... materialsList)
    {
        for (int x1 = (int) startPos.getX(); x1 <= startPos.getX()+x; x1++) {
            for (int y1 = (int) startPos.getY(); y1 <= startPos.getY()+y; y1++) {
                for (int z1 = (int) startPos.getZ(); z1 <= startPos.getZ()+z; z1++) {
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x1, y1, z1)).setType(materialsList[random.nextInt(materialsList.length)]);
                }
            }
        }
    }


    @Override
    public void generate(Location startPos) {
        if (random.nextInt(2) == 1) {
            switch (getDirection()) {
                case NORTH -> this.setToNorth(startPos, getDimX(), getDimY(), getDimZ(), getMaterials());

                case WEST -> this.setToWest(startPos, getDimX(), getDimY(), getDimZ(), getMaterials());

                case SOUTH -> this.setToSouth(startPos, getDimX(), getDimY(), getDimZ(), getMaterials());

                case EAST -> this.setToEast(startPos, getDimX(), getDimY(), getDimZ(), getMaterials());


                case RANDOM -> {
                    switch (random.nextInt(4)) {
                        case 0: {
                            int x = this.getDimX();
                            int z = this.getDimZ();
                            this.setToNorth(new Location(startPos.getWorld(), startPos.getX()+random.nextInt(0,randomMaxValueForStartPlacement), startPos.getY(), startPos.getZ()+random.nextInt(0,4)), random.nextInt(x-valueMinus, x-1), random.nextInt(this.getDimY()-4, this.getDimY()), random.nextInt(z,z+valuePlus), this.getMaterials());

                        }

                        case 1: {
                            int x = this.getDimX();
                            int z = this.getDimZ();
                            this.setToWest(new Location(startPos.getWorld(), startPos.getX()+random.nextInt(0,randomMaxValueForStartPlacement), startPos.getY(), startPos.getZ()+random.nextInt(0,4)), random.nextInt(x,x+valuePlus), random.nextInt(this.getDimY()-4, this.getDimY()), random.nextInt(z-valueMinus, z-1), this.getMaterials());

                        }

                        case 2: {
                            int x = this.getDimX();
                            int z = this.getDimZ();
                            this.setToSouth(new Location(startPos.getWorld(), startPos.getX()+random.nextInt(0,randomMaxValueForStartPlacement), startPos.getY(), startPos.getZ()+random.nextInt(0,4)), random.nextInt(x-valueMinus, x-1), random.nextInt(this.getDimY()-4, this.getDimY()), random.nextInt(z,z+valuePlus), this.getMaterials());

                        }

                        case 3: {
                            int x = this.getDimX();
                            int z = this.getDimZ();
                            this.setToEast(new Location(startPos.getWorld(), startPos.getX()+random.nextInt(0,randomMaxValueForStartPlacement), startPos.getY(), startPos.getZ()+random.nextInt(0,4)), random.nextInt(x,x+valuePlus), random.nextInt(this.getDimY()-4, this.getDimY()), random.nextInt(z-valueMinus, z-1), this.getMaterials());

                        }
                    }
                }
            }
        }
    }
}




