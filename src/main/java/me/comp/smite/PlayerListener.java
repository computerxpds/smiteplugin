package me.comp.smite;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		   Player player = (Player) e;
		   World world = player.getWorld();
		   Block targetblock = player.getTargetBlock(null,  50);
		   Location location = targetblock.getLocation();
		   world.strikeLightning(location);
		   
	}

}
