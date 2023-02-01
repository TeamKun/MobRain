package net.kunmc.lab.mobrain;

import net.kunmc.lab.mobrain.command.CommandConst;
import net.kunmc.lab.mobrain.command.CommandController;
import net.kunmc.lab.mobrain.command.TabCompleter;
import net.kunmc.lab.mobrain.config.ConfigManager;
import net.kunmc.lab.mobrain.game.EntityList;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class MobRain extends JavaPlugin {

    public static MobRain plugin;

    public static boolean game = false;

    public static MobRain getPlugin(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        EntityList.setMob();

        ConfigManager.loadConfig(false);

        getCommand(CommandConst.MAIN).setExecutor(new CommandController());
        getCommand(CommandConst.MAIN).setTabCompleter(new TabCompleter());
    }
}
