package fr.gwengwen49.mazeplugin.maze.parts;

import org.bukkit.Location;

import java.util.Random;

public interface Part {

    Random random = new Random();
    void generate(Location startPos);

}
