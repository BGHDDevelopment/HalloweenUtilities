package com.bghddevelopment.halloweenutils.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.bghddevelopment.halloweenutils.HalloweenUtilities;
import com.bghddevelopment.halloweenutils.utils.Color;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandAlias("pumpkinhead|pumpkinhead")
@Description(" Put a pumpkin on your head!")
@CommandPermission("halloween.pumpkinhead")
@Conditions("noconsole")
public class PumpkinHeadCommand extends BaseCommand {

    @Dependency
    private HalloweenUtilities plugin;

    @Default
    public void onDefault(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        p.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
        p.sendMessage(Color.translate(plugin.getConfig().getString("Messages.PumpkinHeadMessage")));

        return;
    }
}
