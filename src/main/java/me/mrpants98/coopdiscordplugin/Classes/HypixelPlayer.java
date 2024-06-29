package me.mrpants98.coopdiscordplugin.Classes;

import java.util.UUID;

public class HypixelPlayer {
    public String username;
    public UUID uuid;
    public String discordUsername;

    public HypixelPlayer(String username, UUID uuid, String discordUsername) {
        this.username = username;
        this.uuid = uuid;
        this.discordUsername = discordUsername;
    }
}
