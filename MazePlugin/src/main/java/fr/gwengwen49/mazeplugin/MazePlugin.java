package fr.gwengwen49.mazeplugin;

import fr.gwengwen49.injectorapi.InjectionHandler;
import fr.gwengwen49.mazeplugin.maze.Maze;
import fr.gwengwen49.mazeplugin.util.Constants;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public final class MazePlugin extends JavaPlugin {

    public static MazePlugin INSTANCE;
    @Override
    public void onEnable()
    {
      getServer().getPluginManager().registerEvents(new Events(), this);
      INSTANCE = this;
    }

    @Override
    public void onDisable() {


    }

    public static class Events implements Listener {

        private static Location startPos;
        public static Player player;
        @EventHandler
        public void onJoin(PlayerJoinEvent event)
        {
            player = event.getPlayer();
            if(event.getPlayer().getName().equalsIgnoreCase("Gwengwen49"))
            event.getPlayer().getInventory().setItem(2, Constants.getMazeSpawner());
        }
        @EventHandler
        public void onUse(PlayerInteractEvent event)
        {
            player = event.getPlayer();
            startPos = event.getPlayer().getLocation();
            if(event.getItem().equals(Constants.getMazeSpawner()))
            {
              new Maze(event.getPlayer().getLocation());
                InjectionHandler.inject(this.getClass());
            }

        }


        public static Location getStartPos() {
            return startPos;
        }
    }
}
