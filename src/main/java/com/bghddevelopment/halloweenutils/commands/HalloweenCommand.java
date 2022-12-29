package com.bghddevelopment.halloweenutils.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.bghddevelopment.halloweenutils.HalloweenUtilities;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("halloween|halloween")
@Description("Halloween plugin info!")
@CommandPermission("halloween.halloween")
@Conditions("noconsole")
public class HalloweenCommand extends BaseCommand {

    @Dependency
    private HalloweenUtilities plugin;

    @Default
    public void onDefault(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        p.sendMessage(ChatColor.GOLD + "Plugin Info:");
        p.sendMessage(ChatColor.DARK_AQUA + "Created by: BGHDDevelopment");
        p.sendMessage(ChatColor.GOLD + "Plugin Commands:");
        p.sendMessage(ChatColor.DARK_AQUA + "/halloween - This");
        p.sendMessage(ChatColor.DARK_AQUA + "/pumpkinhead - Spawns a pumpkin on your head");
        p.sendMessage(ChatColor.DARK_AQUA + "/pumpkinheadall - Spawns a pumpkin on all players head");
        p.sendMessage(ChatColor.DARK_AQUA + "/lightning - Hits all players with lightning (no damage)");
        p.sendMessage(ChatColor.DARK_AQUA + "/batswarm - Spawns a swarm of bats on all players");
        p.sendMessage(ChatColor.DARK_AQUA + "/scare - Scare all players with effects");

        return;
    }
}
