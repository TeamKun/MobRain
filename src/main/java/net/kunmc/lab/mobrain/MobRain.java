package net.kunmc.lab.mobrain;

import net.kunmc.lab.mobrain.command.CommandConst;
import net.kunmc.lab.mobrain.command.CommandController;
import net.kunmc.lab.mobrain.command.TabCompleter;
import net.kunmc.lab.mobrain.config.ConfigManager;
import net.kunmc.lab.mobrain.game.EntityList;
import net.kunmc.lab.mobrain.game.MainGameTask;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MobRain extends JavaPlugin {

    public static MobRain plugin;

    public static boolean game = false;

    @Override
    public void onEnable() {
        plugin = this;

        EntityList.setMob();

        ConfigManager.loadConfig(false);

        Objects.requireNonNull(this.getCommand(CommandConst.MAIN)).setExecutor(new CommandController());
        Objects.requireNonNull(this.getCommand(CommandConst.MAIN)).setTabCompleter(new TabCompleter());
    }

    @Override
    public void onDisable() {
        ConfigManager.loadConfig(true);
        plugin.saveConfig();
    }
}
