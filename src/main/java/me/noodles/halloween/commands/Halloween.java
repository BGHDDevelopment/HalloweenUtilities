package me.noodles.halloween.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Halloween implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
            return true;
    	}
        Player p = (Player)sender;
        if (!p.hasPermission("halloween.halloween")) {
            sender.sendMessage(ChatColor.RED + "(!) You do not have permission to use this command!");
            return true;
        }
        p.sendMessage(ChatColor.GOLD + "Plugin Info:");
        p.sendMessage(ChatColor.DARK_AQUA + "Created by: BGHDDevelopment");
        p.sendMessage(ChatColor.GOLD + "Plugin Commands:");
        p.sendMessage(ChatColor.DARK_AQUA + "/halloween - This");
        p.sendMessage(ChatColor.DARK_AQUA + "/pumpkinhead - Spawns a pumpkin on your head");
        p.sendMessage(ChatColor.DARK_AQUA + "/pumpkinheadall - Spawns a pumpkin on all players head");
        p.sendMessage(ChatColor.DARK_AQUA + "/lightning - Hits all players with lightning (no damage)");
        p.sendMessage(ChatColor.DARK_AQUA + "/batswarm - Spawns a swarm of bats on all players");
        p.sendMessage(ChatColor.DARK_AQUA + "/scare - Scare all players with effects");
		return true;
	}
}
