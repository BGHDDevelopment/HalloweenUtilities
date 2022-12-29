package com.bghddevelopment.halloweenutils.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.bghddevelopment.halloweenutils.HalloweenUtilities;
import com.bghddevelopment.halloweenutils.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@CommandAlias("batswarm|batswarm")
@Description("Spawn a swarm of bats on every player!")
@CommandPermission("halloween.batswarm")
@Conditions("noconsole")
public class BatSwarmCommand extends BaseCommand {

    @Dependency
    private HalloweenUtilities plugin;

    @Default
    public void onDefault(CommandSender sender, String[] args) {
        Player p = (Player) sender;

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
            players.sendMessage(Color.translate(plugin.getConfig().getString("Messages.BatSwarmMessage")));

        }
        return;
    }
}
