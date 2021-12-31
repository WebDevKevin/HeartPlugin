package me.tauntaunchewie;

import me.tauntaunchewie.utils.HeartUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class HeartPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        //getLogger().info("onEnable is called!");

        // Populate configs
        HeartUtils.loadDefaults(this);

        getServer().getPluginManager().registerEvents(new WelcomeListener(), this);
        getServer().getPluginManager().registerEvents(new RespawnListener(), this);
        this.getCommand("addlove").setExecutor(new HeartCommander());
    }
    @Override
    public void onDisable() {
        //getLogger().info("onDisable is called!");
    }
}
