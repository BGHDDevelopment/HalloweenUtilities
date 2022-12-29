package com.bghddevelopment.halloweenutils.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.bghddevelopment.halloweenutils.HalloweenUtilities;
import com.bghddevelopment.halloweenutils.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandAlias("pumpkinheadall|pumpkinheadall")
@Description(" Put a pumpkin on everyone's head!")
@CommandPermission("halloween.pumpkinheadall")
@Conditions("noconsole")
public class PumpkinHeadAllCommand extends BaseCommand {

    @Dependency
    private HalloweenUtilities plugin;

    @Default
    public void onDefault(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
            players.sendMessage(Color.translate(plugin.getConfig().getString("Messages.PumpkinHeadAllPlayersMessage")));

        }
        return;
    }
}
