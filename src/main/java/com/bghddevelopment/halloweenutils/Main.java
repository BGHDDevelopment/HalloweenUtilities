package com.bghddevelopment.halloweenutils;

import com.bghddevelopment.halloweenutils.commands.*;
import com.bghddevelopment.halloweenutils.events.PumpkinPlace;
import com.bghddevelopment.halloweenutils.mobs.Horse;
import com.bghddevelopment.halloweenutils.mobs.MobHeads;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static Main plugin;


    public static Main getPlugin() {
        return (Main) getPlugin((Class) Main.class);
    }


    public void onEnable() {
        this.getLogger().info("Halloween Utilities by BGHDDevelopment Loading...");
        this.saveDefaultConfig();
        this.reloadConfig();
        this.registerEvents();
        this.registerCommands();
        plugin = this;
    }

    public void registerEvents() {
        final PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new MobHeads(), this);
        pm.registerEvents(new PumpkinPlace(), this);
        pm.registerEvents(new Horse(), this);
    }

    public void registerCommands() {
        this.getCommand("halloween").setExecutor(new Halloween());
        this.getCommand("pumpkinhead").setExecutor(new PumpkinHead());
        this.getCommand("pumpkinheadall").setExecutor(new PumpkinHeadAllPlayers());
        this.getCommand("lightning").setExecutor(new Lightning());
        this.getCommand("batswarm").setExecutor(new BatSwarm());
        this.getCommand("scare").setExecutor(new BlindScare());

    }


}
