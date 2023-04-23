package net.kunmc.lab.mobrain.event;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallDamage implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        // ダメージが落下ダメージで、エンティティがモブである場合にイベントをキャンセルします。
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL &&
                event.getEntityType() != EntityType.PLAYER) {
            event.setCancelled(true);
        }
    }
}
