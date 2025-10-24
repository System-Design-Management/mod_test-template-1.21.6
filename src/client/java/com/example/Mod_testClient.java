package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;
import com.example.event.ClientJoinHandler;

public class Mod_testClient implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("mod_test");

	@Override
	public void onInitializeClient() {
        LOGGER.info("[ModTest] Initializing client...");

        ClientJoinHandler.register();
	}
}