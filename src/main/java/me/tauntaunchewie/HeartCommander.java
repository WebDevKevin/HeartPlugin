package me.tauntaunchewie;

import me.tauntaunchewie.utils.HeartUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HeartCommander implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Make sure a player is calling this
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Check if player has permission
            if (player.hasPermission("heartplugin.set")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("on")) {
                        HeartUtils.enableHeartSetter(true);
                        player.sendMessage("Add Love enabled.");
                    }
                    else if (args[0].equalsIgnoreCase("off")) {
                        HeartUtils.enableHeartSetter(false);
                        player.sendMessage("Add Love disabled.");
                    }
                    else if (args[0].equalsIgnoreCase("status")) {
                        player.sendMessage("Add Love is currently: " + (HeartUtils.isEnabled() ? "ON" : "OFF"));
                    }
                    else {
                        player.sendMessage("Invalid argument.  Only on/off/status or user and amount allowed");
                        player.sendMessage("Example: /addlove on");
                        player.sendMessage("Example: /addlove " + player.getDisplayName() + " 10");
                    }
                }
                else if (args.length == 2) {

                    // Make sure we have a valid double
                    Double newHealth = -1D;
                    try {
                        newHealth = Double.parseDouble(args[1]);
                    }
                    catch(NumberFormatException e) {
                        // not a double
                    }

                    // If we have a valid double continue
                    if (newHealth != -1) {
                        // Specially handle apply to all
                        if (args[0].equals("@a")) {

                            // Loop all players on the server and set hearts
                            for (final Player target : Bukkit.getOnlinePlayers()) {
                                HeartUtils.setPlayerHearts(player, target, newHealth);

                                player.sendMessage(target.getDisplayName() + " health has been changed to: " + args[1]);
                                target.sendMessage(player.getDisplayName() + " has changed your health to: " + args[1]);
                            }
                        }
                        else {
                            // Set for individual
                            Player target = Bukkit.getPlayerExact(args[0]);

                            // Make sure we have a valid player
                            if (target != null) {
                                HeartUtils.setPlayerHearts(player, target, newHealth);

                                player.sendMessage(target.getDisplayName() + " health has been changed to: " + args[1]);
                                target.sendMessage(player.getDisplayName() + " has changed your health to: " + args[1]);
                            }
                            else {
                                player.sendMessage("This player is not currently on the server");
                            }
                        }
                    }
                    else {
                        player.sendMessage("Not a valid number for the number of hearts: " + args[1]);
                    }
                }
                else {
                    player.sendMessage("Usage: /addlove PLAYERNAME #hearts");
                    player.sendMessage("Example: /addlove " + player.getDisplayName() + " " + 15);
                }
            }
            else {
                player.sendMessage("You do not have permission to execute this command.");
            }

            return true;
        }
        else {
            // Only allow players to invoke
            return false;
        }
    }
}