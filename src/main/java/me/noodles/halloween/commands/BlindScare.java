package me.noodles.halloween.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindScare implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
            return true;
    	}
        Player p = (Player)sender;
        if (!p.hasPermission("halloween.scare")) {
            sender.sendMessage(ChatColor.RED + "(!) You do not have permission to use this command!");
            return true;
        }
        for (Player players : Bukkit.getOnlinePlayers()) {	
        players.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 25, 0));
        players.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
		players.getWorld().strikeLightningEffect(players.getLocation());
        players.playEffect(EntityEffect.HURT);
        players.playEffect(EntityEffect.HURT);
        players.playEffect(EntityEffect.HURT);
        players.playSound(p.getLocation(), Sound.GHAST_SCREAM, 2.0f, 3.0f);
        }
		return true;
        }
}
