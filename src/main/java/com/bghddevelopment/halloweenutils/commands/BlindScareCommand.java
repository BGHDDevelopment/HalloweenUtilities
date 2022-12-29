package com.bghddevelopment.halloweenutils.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import com.bghddevelopment.halloweenutils.HalloweenUtilities;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@CommandAlias("scare|scare")
@Description("Scare Players!")
@CommandPermission("halloween.scare")
@Conditions("noconsole")
public class BlindScareCommand extends BaseCommand {

    @Dependency
    private HalloweenUtilities plugin;

    @Default
    public void onDefault(CommandSender sender, String[] args) {
        Player p = (Player) sender;

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 25, 0));
            players.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 1));
            players.getWorld().strikeLightningEffect(players.getLocation());
            players.playEffect(EntityEffect.HURT);
            players.playEffect(EntityEffect.HURT);
            players.playEffect(EntityEffect.HURT);
            players.playSound(p.getLocation(), Sound.GHAST_SCREAM, 2.0f, 3.0f);
        }
        return;
    }
}
