package me.mrpants98.coopdiscordplugin.Listeners;

import me.mrpants98.coopdiscordplugin.Classes.HypixelPlayer;
import me.mrpants98.coopdiscordplugin.CoopDiscordPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class OnPlayerJoin implements Listener {

    @EventHandler
    //Creates a HypixelPlayer object when a player joins and adds it to a coop
    public void PlayerJoin(PlayerJoinEvent e) {


        Player p = e.getPlayer();
        String displayName = p.getDisplayName();
        UUID uuid = p.getUniqueId();

        if (CoopDiscordPlugin.instance.coop1.containsKey(uuid))
            return;

        HypixelPlayer hypixelPlayer = new HypixelPlayer(displayName, uuid, "");
        CoopDiscordPlugin.instance.coop1.put(uuid, hypixelPlayer);
    }

}
