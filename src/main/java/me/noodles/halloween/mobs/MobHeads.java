package me.noodles.halloween.mobs;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import java.util.*;
import org.bukkit.event.*;

public class MobHeads implements Listener
{
    
    @EventHandler
    public void onSpawn(final EntitySpawnEvent e) {
        final List<EntityType> types = Arrays.asList(EntityType.ZOMBIE, EntityType.SKELETON, EntityType.VILLAGER);
        if (!types.contains(e.getEntityType())) {
            return;
        }
        final LivingEntity entity = (LivingEntity)e.getEntity();
        entity.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
    }
    
    
    
}
