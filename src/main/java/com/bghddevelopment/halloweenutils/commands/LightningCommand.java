package com.bghddevelopment.halloweenutils.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.bghddevelopment.halloweenutils.HalloweenUtilities;
import com.bghddevelopment.halloweenutils.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("lightning|lightning")
@Description("Haunt players with lightning!")
@CommandPermission("halloween.lightning")
@Conditions("noconsole")
public class LightningCommand extends BaseCommand {

    @Dependency
    private HalloweenUtilities plugin;

    @Default
    public void onDefault(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.getWorld().strikeLightningEffect(players.getLocation());
            players.getWorld().strikeLightningEffect(players.getLocation());
            players.getWorld().strikeLightningEffect(players.getLocation());
            p.sendMessage(Color.translate(plugin.getConfig().getString("Messages.PrivateLightningMessage")));
            players.sendMessage(Color.translate(plugin.getConfig().getString("Messages.PublicLightningMessage")));
        }

        return;
    }
}
