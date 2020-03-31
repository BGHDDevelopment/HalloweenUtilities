package me.noodles.halloween.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PumpkinPlace implements Listener {

    @EventHandler
    public void onPlace(final BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.PUMPKIN) {
            event.getBlock().setType(Material.JACK_O_LANTERN);
        }
    }
}
