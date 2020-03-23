package me.noodles.halloween;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.noodles.halloween.commands.BatSwarm;
import me.noodles.halloween.commands.BlindScare;
import me.noodles.halloween.commands.Halloween;
import me.noodles.halloween.commands.Lightning;
import me.noodles.halloween.commands.PumpkinHead;
import me.noodles.halloween.commands.PumpkinHeadAllPlayers;
import me.noodles.halloween.events.PumpkinPlace;
import me.noodles.halloween.mobs.Horse;
import me.noodles.halloween.mobs.MobHeads;

public class Main extends JavaPlugin implements Listener {
	
	public static Main plugin;
	
	
	public static Main getPlugin() {
        return (Main)getPlugin((Class)Main.class);
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
