package me.mrpants98.coopdiscordplugin.Commands;

import me.mrpants98.coopdiscordplugin.Classes.HypixelPlayer;
import me.mrpants98.coopdiscordplugin.CoopDiscordPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddDiscordUsername implements CommandExecutor {


    @Override
    //Links a player's discord username to their HypixelPlayer Object
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p){
            if (strings.length != 1)
                return false;

            if (CoopDiscordPlugin.instance.coop1.containsKey(p.getUniqueId())) {
                HypixelPlayer player = CoopDiscordPlugin.instance.coop1.get(p.getUniqueId());
                player.discordUsername = strings[0];
                CoopDiscordPlugin.instance.coop1.replace(player.uuid, player);

                return true;
            }
        }

        return false;
    }
}
