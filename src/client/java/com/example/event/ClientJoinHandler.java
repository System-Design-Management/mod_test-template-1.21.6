package com.example.event;

import com.example.title.TitleManager;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class ClientJoinHandler {

    public static void register() {

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {

            client.execute(() -> {
                TitleManager.showCustomTitle(client);
            });
        });
    }
}
