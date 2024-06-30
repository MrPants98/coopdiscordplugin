package me.mrpants98.coopdiscordplugin;

import me.mrpants98.coopdiscordplugin.Classes.HypixelPlayer;
import me.mrpants98.coopdiscordplugin.Commands.AddDiscordUsername;
import me.mrpants98.coopdiscordplugin.Commands.CoopManaging;
import me.mrpants98.coopdiscordplugin.Commands.GetHypixelPlayerDetails;
import me.mrpants98.coopdiscordplugin.Listeners.OnPlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public final class CoopDiscordPlugin extends JavaPlugin {


    public static CoopDiscordPlugin instance;
    //Stand in for the skyblock coop
    public List<HypixelPlayer> coop1 = new ArrayList<HypixelPlayer>();
    public HashMap<UUID, HypixelPlayer> hypixelPlayers = new HashMap<>();

    public SocketClient socketClient;

    @Override
    public void onEnable(){
        // Plugin startup logic
        if (instance == null)
            instance = this;

        getCommand("SetDiscord").setExecutor(new AddDiscordUsername());
        getCommand("GetPlayerDetails").setExecutor(new GetHypixelPlayerDetails());
        getCommand("Coop").setExecutor(new CoopManaging());
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);

        try {
            socketClient = new SocketClient(new URI("ws://localhost:8800"));
            socketClient.connect();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
