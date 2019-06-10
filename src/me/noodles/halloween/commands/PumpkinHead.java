package me.noodles.halloween.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.noodles.halloween.Main;

public class PumpkinHead implements CommandExecutor {

	
	String PumpkinHeadMessage;
	
	 public PumpkinHead() {
	        this.PumpkinHeadMessage = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.PumpkinHeadMessage"));
	
	 } 
	
	 public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    	if (!(sender instanceof Player)) {
	            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
	            return true;
	        }
	        Player p = (Player)sender;
	        if (!p.hasPermission("halloween.pumpkinhead")) {
	            sender.sendMessage(ChatColor.RED + "(!) You do not have permission to use this command!");
	            return true;
	        }
	        p.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
	        p.sendMessage(String.valueOf(this.PumpkinHeadMessage));
			
	        return true;
	 }
}
