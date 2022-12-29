package com.bghddevelopment.halloweenutils.mobs;

import java.util.Arrays;
import java.util.List;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class Horse implements Listener {

	@EventHandler
    public void onSpawn(final EntitySpawnEvent e) {
		 List<EntityType> types = Arrays.asList(EntityType.HORSE);
	        if (!types.contains(e.getEntityType())) {
	            return;
	        }
	         LivingEntity entity = (LivingEntity)e.getEntity();
	        ((org.bukkit.entity.Horse) entity).setVariant(Variant.SKELETON_HORSE);
	}
	
}
