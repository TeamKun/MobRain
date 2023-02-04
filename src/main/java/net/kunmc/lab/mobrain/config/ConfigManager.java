package net.kunmc.lab.mobrain.config;

import net.kunmc.lab.mobrain.MobRain;
import net.kunmc.lab.mobrain.command.CommandConst;
import net.kunmc.lab.mobrain.game.MainGameTask;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    public static FileConfiguration config;

    public static Map<String,Integer> integerConfig = new HashMap<>();
    public static Map<String,String> stringConfig = new HashMap<>();

    /**
     * configの読み込み
     * @param isReload reloadExecution
     */
    public static void loadConfig(boolean isReload){
        MobRain.plugin.saveDefaultConfig();

        //configのリロード
        if(isReload){
            MobRain.plugin.reloadConfig();
        }

        //configの取得
        config = MobRain.plugin.getConfig();

        //範囲 default:
        String range = CommandConst.CONFIG_RANGE;
        integerConfig.put(range, config.getInt(range));

        //頻度 default:
        String frequency = CommandConst.CONFIG_FREQUENCY;
        integerConfig.put(frequency, config.getInt(frequency));

        //量 default:
        String amount = CommandConst.CONFIG_AMOUNT;
        integerConfig.put(amount, config.getInt(amount));

        //対象のプレイヤー default:roadhog_kun
        String player = CommandConst.CONFIG_PLAYER;
        stringConfig.put(player, config.getString(player));

    }

    /**
     * configの保存
     * @param key configName
     */
    public static void setConfig(String key){
        if(integerConfig.containsKey(key)){
            config.set(key, integerConfig.get(key));
        }else if(stringConfig.containsKey(key)){
            config.set(key, stringConfig.get(key));
        }
        MobRain.plugin.saveConfig();
    }
}
