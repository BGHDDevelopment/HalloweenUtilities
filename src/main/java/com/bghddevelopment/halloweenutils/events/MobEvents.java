package com.bghddevelopment.halloweenutils.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class MobEvents implements Listener {

    @EventHandler
    public void onHorseSpawn(final EntitySpawnEvent e) {
        List<EntityType> types = Arrays.asList(EntityType.HORSE);
        if (!types.contains(e.getEntityType())) {
            return;
        }
        LivingEntity entity = (LivingEntity) e.getEntity();
        ((org.bukkit.entity.Horse) entity).setVariant(Horse.Variant.SKELETON_HORSE);
    }

    @EventHandler
    public void onMobSpawn(final EntitySpawnEvent e) {
        final List<EntityType> types = Arrays.asList(EntityType.ZOMBIE, EntityType.SKELETON, EntityType.VILLAGER);
        if (!types.contains(e.getEntityType())) {
            return;
        }
        final LivingEntity entity = (LivingEntity) e.getEntity();
        entity.getEquipment().setHelmet(new ItemStack(Material.PUMPKIN));
    }

}
