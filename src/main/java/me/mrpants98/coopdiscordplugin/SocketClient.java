package me.mrpants98.coopdiscordplugin;

import org.bukkit.Bukkit;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class SocketClient extends WebSocketClient {
    public SocketClient(URI serverURI) {
        super(serverURI);
    }
    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        send("Plugin Connected");
    }

    @Override
    public void onMessage(String message) {
        Bukkit.broadcastMessage("Message from our overlords: " + message);
    }

    @Override
    public void onClose(int i, String s, boolean b) {

    }

    @Override
    public void onError(Exception e) {
        Bukkit.broadcastMessage(e.getMessage());
    }
}
