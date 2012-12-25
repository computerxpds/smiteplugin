package me.comp.smite;


import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Smitekill extends Smite {
	   public static Smite plugin;
	   public final Logger logger = Logger.getLogger("Minecraft");
	   
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	   Player player = (Player) sender;
	   World world = player.getWorld();
	   if(commandLabel.equalsIgnoreCase("smitekill")) {
		   if(args.length == 0) {
			   //permissions line, op only for now. ~Comp added v. 3.6P
			   if(player.hasPermission("smite.ground")) {
			   Block targetblock = player.getTargetBlock(null,  50);
			   Location location = targetblock.getLocation();
			   world.strikeLightning(location);
			   //get "blast-radius" config, defualt to 10 if none set. Thanks to morganm for the help :) no good deed goes un-noticed
			   int radius = getConfig().getInt("blast-radius", 10);
			   world.createExplosion(location, radius);
			   //To spawn a creeper no idea how this will work.. Will eventually include a var in the config.
			   //world.spawnCreature(location, org.bukkit.entity.EntityType.CREEPER);
			   world.spawnEntity(location, org.bukkit.entity.EntityType.CREEPER);
			   world.spawnEntity(location, org.bukkit.entity.EntityType.PIG_ZOMBIE);
			   //world.spawnCreature(location, org.bukkit.entity.EntityType.PIG_ZOMBIE);
			   world.createExplosion(location, radius, isEnabled());
			   }else{
				   player.sendMessage("You do not have permission to do this");
				   
			   }
		   }
	   }
	return false;
}
}