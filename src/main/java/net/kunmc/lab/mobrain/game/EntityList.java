package net.kunmc.lab.mobrain.game;

import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class EntityList {
    public static List<EntityType> entityList = new ArrayList<>();

    public static void setMob(){
        //敵対Mob
        entityList.add(EntityType.CREEPER);
        entityList.add(EntityType.WITCH);
        entityList.add(EntityType.VINDICATOR);
        entityList.add(EntityType.VEX);
        entityList.add(EntityType.EVOKER);
        entityList.add(EntityType.ELDER_GUARDIAN);
        entityList.add(EntityType.GUARDIAN);
        entityList.add(EntityType.GHAST);
        entityList.add(EntityType.SKELETON);
        entityList.add(EntityType.STRAY);
        entityList.add(EntityType.SPIDER);
        entityList.add(EntityType.SLIME);
        entityList.add(EntityType.ZOGLIN);
        entityList.add(EntityType.ZOMBIE);
        entityList.add(EntityType.DROWNED);
        entityList.add(EntityType.PIGLIN_BRUTE);
        entityList.add(EntityType.PILLAGER);
        entityList.add(EntityType.PHANTOM);
        entityList.add(EntityType.BLAZE);
        entityList.add(EntityType.HOGLIN);
        entityList.add(EntityType.MAGMA_CUBE);
        entityList.add(EntityType.RAVAGER);
        entityList.add(EntityType.ILLUSIONER);
    }

}
