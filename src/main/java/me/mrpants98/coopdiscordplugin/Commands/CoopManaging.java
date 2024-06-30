package me.mrpants98.coopdiscordplugin.Commands;

import me.mrpants98.coopdiscordplugin.Classes.HypixelPlayer;
import me.mrpants98.coopdiscordplugin.CoopDiscordPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CoopManaging implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p) {

            if (strings.length == 0)
                p.sendMessage(ChatColor.RED + "Please specify an argument. Arguments are add, remove, or list");
            else {
                switch (strings[0]) {
                    case "add":
                        AddPlayerToCoop(strings[1]);
                        break;
                    case "remove":
                        RemovePlayerFromCoop(strings[1]);
                        break;
                    case "list":
                        ListAllPlayersInCoop(p);
                        break;
                    default:
                        p.sendMessage(ChatColor.RED + "Please specify an argument. Arguments are add, remove, or list");
                        break;
                }
            }
            return true;
        }
        return false;
    }

    private void AddPlayerToCoop(String playerName) {
        Player player = Bukkit.getPlayer(playerName);
        UUID uuid = player.getUniqueId();

        if (!CoopDiscordPlugin.instance.hypixelPlayers.containsKey(uuid)) {
            player.sendMessage(ChatColor.RED + "Player Doesn't Exist");
        } else {
            HypixelPlayer hypixelPlayer = CoopDiscordPlugin.instance.hypixelPlayers.get(uuid);
            CoopDiscordPlugin.instance.coop1.add(hypixelPlayer);
        }
    }

    private void RemovePlayerFromCoop(String playerName) {
        Player player = Bukkit.getPlayer(playerName);
        UUID uuid = player.getUniqueId();

        if (!CoopDiscordPlugin.instance.hypixelPlayers.containsKey(uuid)) {
            player.sendMessage(ChatColor.RED + "Player Doesn't Exist");
        } else {
            HypixelPlayer hypixelPlayer = CoopDiscordPlugin.instance.hypixelPlayers.get(uuid);
            CoopDiscordPlugin.instance.coop1.remove(hypixelPlayer);
        }
    }

    private  void ListAllPlayersInCoop(Player player) {
        player.sendMessage(ChatColor.GREEN + "All Players in Coop:");

        for (int i = 0; i < CoopDiscordPlugin.instance.coop1.size(); i++) {
            String displayName = CoopDiscordPlugin.instance.coop1.get(i).username;

            player.sendMessage(ChatColor.GOLD + displayName);
        }
    }
}
