package me.tauntaunchewie;

import me.tauntaunchewie.utils.HeartUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class WelcomeListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Welcome player if they have been here before
        if (player.hasPlayedBefore()) {
            player.sendMessage(ChatColor.GREEN + "Welcome back " + ChatColor.BOLD + ChatColor.YELLOW + player.getDisplayName() + "!");

            if (player.hasPermission("heartplugin.spawnresethearts") && HeartUtils.isEnabled()) {
                HeartUtils.setPlayerHearts(player, player, HeartUtils.getOpBaseHeartCount());
            }
        }
        // Welcome the new person
        else {
            player.sendMessage(ChatColor.GREEN + "Thanks for stopping by, hope you like our little server " + ChatColor.BOLD + ChatColor.YELLOW + player.getDisplayName() + "!");

            if (player.hasPermission("heartplugin.spawnresethearts") && HeartUtils.isEnabled()) {
                HeartUtils.setPlayerHearts(player, player, HeartUtils.getOpBaseHeartCount());
            }
        }
    }
}