package me.tauntaunchewie;

import me.tauntaunchewie.utils.HeartUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {
    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        // Only reset hearts for operators
        if (player.hasPermission("heartplugin.spawnresethearts")) {
            HeartUtils.setPlayerHearts(player, player, HeartUtils.getOpBaseHeartCount());
        }
    }
}
