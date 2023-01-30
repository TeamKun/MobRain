package net.kunmc.lab.mobrain;

import net.kunmc.lab.mobrain.command.CommandConst;
import net.kunmc.lab.mobrain.command.CommandController;
import net.kunmc.lab.mobrain.command.TabCompleter;
import net.kunmc.lab.mobrain.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobRain extends JavaPlugin {

    public static MobRain plugin;

    public static boolean game = false;

    public static MobRain getPlugin(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        ConfigManager.loadConfig(false);

        getCommand(CommandConst.MAIN).setExecutor(new CommandController());
        getCommand(CommandConst.MAIN).setTabCompleter(new TabCompleter());
    }
}
