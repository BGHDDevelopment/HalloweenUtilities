package com.bghddevelopment.halloweenutils;

import com.bghddevelopment.halloweenutils.commands.*;
import com.bghddevelopment.halloweenutils.events.PumpkinPlace;
import com.bghddevelopment.halloweenutils.mobs.Horse;
import com.bghddevelopment.halloweenutils.mobs.MobHeads;
import com.bghddevelopment.halloweenutils.utils.Color;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main extends JavaPlugin implements Listener {

    public static Main plugin;


    public static Main getPlugin() {
        return (Main) getPlugin((Class) Main.class);
    }


    public void onEnable() {
        Color.log("Halloween Utilities by BGHDDevelopment Loading...");
        this.saveDefaultConfig();
        this.reloadConfig();
        this.registerEvents();
        this.registerCommands();
        plugin = this;
        updateCheck(Bukkit.getConsoleSender(), true);
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

    public void updateCheck(CommandSender sender, boolean console) {
        try {
            String urlString = "https://updatecheck.bghddevelopment.com";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input;
            StringBuffer response = new StringBuffer();
            while ((input = reader.readLine()) != null) {
                response.append(input);
            }
            reader.close();
            JsonObject object = new JsonParser().parse(response.toString()).getAsJsonObject();

            if (object.has("plugins")) {
                JsonObject plugins = object.get("plugins").getAsJsonObject();
                JsonObject info = plugins.get("HalloweenUtilities").getAsJsonObject();
                String version = info.get("version").getAsString();
                Boolean archived = info.get("archived").getAsBoolean();
                if (archived) {
                    sender.sendMessage(Color.translate(""));
                    sender.sendMessage(Color.translate(""));
                    sender.sendMessage(Color.translate("&cThis plugin has been marked as 'Archived' by BGHDDevelopment LLC."));
                    sender.sendMessage(Color.translate("&cThis version will continue to work but will not receive updates or support."));
                    sender.sendMessage(Color.translate(""));
                    sender.sendMessage(Color.translate(""));
                    return;
                }
                if (version.equals(getDescription().getVersion())) {
                    if (console) {
                        sender.sendMessage(Color.translate("&aHalloweenUtilities is on the latest version."));
                    }
                } else {
                    sender.sendMessage(Color.translate(""));
                    sender.sendMessage(Color.translate(""));
                    sender.sendMessage(Color.translate("&cYour HalloweenUtilities version is out of date!"));
                    sender.sendMessage(Color.translate("&cWe recommend updating ASAP!"));
                    sender.sendMessage(Color.translate(""));
                    sender.sendMessage(Color.translate("&cYour Version: &e" + getDescription().getVersion()));
                    sender.sendMessage(Color.translate("&aNewest Version: &e" + version));
                    sender.sendMessage(Color.translate(""));
                    sender.sendMessage(Color.translate(""));
                }
            } else {
                sender.sendMessage(Color.translate("&cWrong response from update API, contact plugin developer!"));
            }
        } catch (
                Exception ex) {
            sender.sendMessage(Color.translate("&cFailed to get updater check. (" + ex.getMessage() + ")"));
        }
    }


}
