package net.kunmc.lab.mobrain;

import org.bukkit.plugin.java.JavaPlugin;

public final class MobRain extends JavaPlugin {

    private static MobRain plugin;

    public static MobRain getPlugin(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;


    }
}
