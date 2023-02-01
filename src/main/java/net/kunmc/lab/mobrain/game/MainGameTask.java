package net.kunmc.lab.mobrain.game;

import net.kunmc.lab.mobrain.MobRain;
import net.kunmc.lab.mobrain.command.CommandConst;
import net.kunmc.lab.mobrain.config.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MainGameTask {

    public static boolean task = false;

    public static void mainTask(){

        task = true;

        new BukkitRunnable(){
            int count = 0;
            int frequency = ConfigManager.integerConfig.get(CommandConst.CONFIG_FREQUENCY);
            int amount = ConfigManager.integerConfig.get(CommandConst.CONFIG_AMOUNT);
            int range = ConfigManager.integerConfig.get(CommandConst.CONFIG_RANGE);
            String playerName = ConfigManager.stringConfig.get(CommandConst.CONFIG_PLAYER);
            @Override
            public void run() {
                if (MobRain.game) {
                    if (!task) {
                        frequency = ConfigManager.integerConfig.get(CommandConst.CONFIG_FREQUENCY);
                        amount = ConfigManager.integerConfig.get(CommandConst.CONFIG_AMOUNT);
                        range = ConfigManager.integerConfig.get(CommandConst.CONFIG_RANGE);
                        playerName = ConfigManager.stringConfig.get(CommandConst.CONFIG_PLAYER);
                        task = true;
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

    }

}
