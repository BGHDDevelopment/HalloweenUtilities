package com.bghddevelopment.halloweenutils.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PumpkinEvents implements Listener {

    @EventHandler
    public void onPumpkinPlace(final BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.PUMPKIN) {
            event.getBlock().setType(Material.JACK_O_LANTERN);
        }
    }
}
