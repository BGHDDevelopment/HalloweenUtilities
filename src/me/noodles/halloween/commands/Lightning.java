package me.noodles.halloween.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.noodles.halloween.Main;

public class Lightning implements CommandExecutor {

	
	String PrivateLightningMessage;
	String PublicLightningMessage;
	
	 public Lightning() {
	        this.PrivateLightningMessage = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.PrivateLightningMessage"));
	        this.PublicLightningMessage = ChatColor.translateAlternateColorCodes('&', Main.getPlugin().getConfig().getString("Messages.PublicLightningMessage"));
	
	 } 
	
	 
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
            return true;
    	}
        Player p = (Player)sender;
        if (!p.hasPermission("halloween.lightning")) {
            sender.sendMessage(ChatColor.RED + "(!) You do not have permission to use this command!");
            return true;
        }
        for (Player players : Bukkit.getOnlinePlayers()) {
    		players.getWorld().strikeLightningEffect(players.getLocation());
    		players.getWorld().strikeLightningEffect(players.getLocation());
    		players.getWorld().strikeLightningEffect(players.getLocation());
    		p.sendMessage(String.valueOf(this.PrivateLightningMessage));
    		players.sendMessage(String.valueOf(this.PublicLightningMessage));
        }
		
        return true;
 }
}
