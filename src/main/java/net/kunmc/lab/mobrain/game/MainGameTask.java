package net.kunmc.lab.mobrain.game;

import net.kunmc.lab.mobrain.MobRain;
import net.kunmc.lab.mobrain.command.CommandConst;
import net.kunmc.lab.mobrain.config.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.Random;

public class MainGameTask {

    public static boolean cnf = false;

    public static void mainTask(){

        cnf = true;

        new BukkitRunnable(){
            int count = 0;

            int frequency = ConfigManager.integerConfig.get(CommandConst.CONFIG_FREQUENCY);
            int amount = ConfigManager.integerConfig.get(CommandConst.CONFIG_AMOUNT);
            int range = ConfigManager.integerConfig.get(CommandConst.CONFIG_RANGE);

            String playerName = ConfigManager.stringConfig.get(CommandConst.CONFIG_PLAYER);

            @Override
            public void run() {
                if (MobRain.game) {
                    if (!cnf) {
                        frequency = ConfigManager.integerConfig.get(CommandConst.CONFIG_FREQUENCY);
                        amount = ConfigManager.integerConfig.get(CommandConst.CONFIG_AMOUNT);
                        range = ConfigManager.integerConfig.get(CommandConst.CONFIG_RANGE);
                        playerName = ConfigManager.stringConfig.get(CommandConst.CONFIG_PLAYER);
                        cnf = true;
                    }
                    if (count == frequency) {
                        //Mobの生成
                        mobSpawnLogic(amount,range,playerName);
                        count = 0 ;
                    }else{
                        count = count + 1;
                    }

                }
            }
        }.runTaskTimer(MobRain.plugin,0,1);
    }

    public static void mobSpawnLogic(int amount,int range,String playerName){
        //プレイヤー導出
        Player player = Bukkit.getPlayer(Objects.requireNonNull(playerName));
        if(player==null) return;

        Random random = new Random();
        Location loc = player.getLocation();
        Location loc1 = loc,loc2 = loc,loc3=loc;
        EntityType type;
        //Mob生成処理
        for(int i=0; i<amount; i++){
            //半径
            double r = random.nextInt(range);
            //角度
            double t = random.nextInt(360);
            //座標導出
            double x = loc.getX() + (r*Math.cos((t/360)*2*Math.PI));
            double y = 127;
            double z = loc.getZ() + (r*Math.sin((t/360)*2*Math.PI));
            loc.setX(x); loc.setY(y); loc.setZ(z);

            if(loc.getBlock().getType() == Material.BEDROCK){
                loc.setY(player.getLocation().getY() + 20);
                for(int j = 126;j > 0;j--){
                    loc1.setY(j+1);loc2.setY(j);loc3.setY(j-1);
                    if(loc1.getBlock().getType().isAir() && loc2.getBlock().getType().isAir() && loc3.getBlock().getType().isAir() ){
                        loc.setY(j-8);
                        break;
                    }
                }
            }else{
                loc.setY(180);
            }

            //mob処理(0.1%でウィザー)
            if(random.nextInt(1000) == 0){
                type =EntityType.WITHER;
                LivingEntity mob = (LivingEntity) player.getWorld().spawnEntity(loc,type);
            }else{
                type = EntityList.entityList.get(random.nextInt(EntityList.entityList.size()));
                LivingEntity mob = (LivingEntity) player.getWorld().spawnEntity(loc,type);
                //火炎耐性(昼の炎上防止)
                mob.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,1000000,1,true));
                //低速落下(落下ダメージ防止)
                mob.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,1000000,1,true));
            }
        }
    }

}
