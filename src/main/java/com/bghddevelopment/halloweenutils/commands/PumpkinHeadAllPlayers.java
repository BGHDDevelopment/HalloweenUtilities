package com.bghddevelopment.halloweenutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.bghddevelopment.halloweenutils.Main;

public class PumpkinHeadAllPlayers implements CommandExecutor {

	
	String PumpkinHeadAllPlayersMessage;
	
	 public PumpkinHeadAllPlayers() {
	        this.PumpkinHeadAllPlayersMessage = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.PumpkinHeadAllPlayersMessage"));
	
	 } 
	
	 public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    	if (!(sender instanceof Player)) {
	            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
	            return true;
	        }
	        Player p = (Player)sender;
	        if (!p.hasPermission("halloween.pumpkinheadall")) {
	            sender.sendMessage(ChatColor.RED + "(!) You do not have permission to use this command!");
	            return true;
	        }
	        for (Player players : Bukkit.getOnlinePlayers()) {
	        players.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
	        players.sendMessage(String.valueOf(this.PumpkinHeadAllPlayersMessage));
			
	        }
	        return true;
	 }
}
