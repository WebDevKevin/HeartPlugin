package me.tauntaunchewie.utils;

import me.tauntaunchewie.HeartPlugin;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class HeartUtils {
    private static HeartPlugin plugin;
    private static boolean pluginEnabled = false;

    /**
     * Enable or disable the heart setter plugin.  May cause conflicts with other heart based plugins like LifeSteal
     * @param enabled
     */
    public static void enableHeartSetter(boolean enabled) {
        pluginEnabled = enabled;
        plugin.getConfig().set("enabled", enabled);
        plugin.saveConfig();
    }

    /**
     * Return status of plugin enabled/disabled
     * @return
     */
    public static boolean isEnabled() {
        return pluginEnabled;
    }

    /**
     * Common method to get the default amount hearts for an Op
     * @return The number off hearts
     */
    public static double getOpBaseHeartCount() {
        return 20D;
    }

    /**
     * Sets a specific player's heart count
     * @param player The player who is initiating the count (Ops only currently)
     * @param target The player who's hearts are being adjusted
     * @param heartCount The amount of hearts (note since MC denotes a heart as 2, we double what is entered)
     */
    public static void setPlayerHearts(Player player, Player target, Double heartCount) {
        Logger logger = Logger.getLogger("Minecraft");

        // Only perform action if plugin is enabled
        if (isEnabled()) {
            AttributeInstance attribute = target.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            attribute.setBaseValue(heartCount * 2);
            target.setHealth(heartCount * 2);
            logger.info(target.getDisplayName() + " hearts have been set to " + heartCount + " by: " + player.getDisplayName());
        }
    }

    /**
     * Create reference to plugin and retrieve enabled status
     * @param instance
     */
    public static void loadDefaults(HeartPlugin instance) {
        plugin = instance;
        enableHeartSetter(plugin.getConfig().getBoolean("enabled"));
    }
}
