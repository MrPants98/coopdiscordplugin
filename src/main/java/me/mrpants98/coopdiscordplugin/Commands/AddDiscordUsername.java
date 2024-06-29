package me.mrpants98.coopdiscordplugin.Commands;

import me.mrpants98.coopdiscordplugin.Classes.HypixelPlayer;
import me.mrpants98.coopdiscordplugin.CoopDiscordPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class AddDiscordUsername implements CommandExecutor {


    @Override
    //Links a player's discord username to their HypixelPlayer Object
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p){

            if (strings.length == 0) {
                p.sendMessage(ChatColor.RED + "You must specify a discord username");
            } else {
                String discordUsername = strings[0];

                String playerUsername = p.getDisplayName();
                UUID uuid = p.getUniqueId();

                HypixelPlayer newPlayer = new HypixelPlayer(playerUsername, uuid, discordUsername);

                if (CoopDiscordPlugin.instance.coop1.containsKey(uuid)) {
                    CoopDiscordPlugin.instance.coop1.replace(uuid, newPlayer);
                } else {
                    CoopDiscordPlugin.instance.coop1.put(uuid, newPlayer);
                }
            }

            return true;
        }

        return false;
    }
}
