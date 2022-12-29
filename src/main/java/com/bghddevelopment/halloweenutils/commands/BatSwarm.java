package com.bghddevelopment.halloweenutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import com.bghddevelopment.halloweenutils.Main;

public class BatSwarm implements CommandExecutor {

	
	String BatSwarmMessage;
	
	 public BatSwarm() {
	        this.BatSwarmMessage = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.BatSwarmMessage"));
	
	 } 
	
	 public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    	if (!(sender instanceof Player)) {
	            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
	            return true;
	        }
	        Player p = (Player)sender;
	        if (!p.hasPermission("halloween.batswarm")) {
	            sender.sendMessage(ChatColor.RED + "(!) You do not have permission to use this command!");
	            return true;
	        }
	        for (Player players : Bukkit.getOnlinePlayers()) {
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
	        players.sendMessage(String.valueOf(this.BatSwarmMessage));
			
	        }
	        return true;
	 }
}
