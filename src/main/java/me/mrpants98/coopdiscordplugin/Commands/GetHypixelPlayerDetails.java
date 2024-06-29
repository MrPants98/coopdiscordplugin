package me.mrpants98.coopdiscordplugin.Commands;

import me.mrpants98.coopdiscordplugin.Classes.HypixelPlayer;
import me.mrpants98.coopdiscordplugin.CoopDiscordPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetHypixelPlayerDetails implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player p) {
            if (CoopDiscordPlugin.instance.coop1.containsKey(p.getUniqueId())) {
                HypixelPlayer player = CoopDiscordPlugin.instance.coop1.get(p.getUniqueId());
                p.sendMessage("Displayname: " + player.username + " UUID: " + player.uuid + " Discord Username: " + player.discordUsername);
                return true;
            }
        }

        return false;
    }
}
