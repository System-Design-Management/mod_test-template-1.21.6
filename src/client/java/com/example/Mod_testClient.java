package com.example;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.text.MutableText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class Mod_testClient implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("mod_test");

	@Override
	public void onInitializeClient() {
        LOGGER.info("[ModTest] onInitializeClient is CALLED.");

        // クライアントがワールドに参加した時のイベントを登録
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {

            // ワールドに入った瞬間にメインスレッドで実行
            client.execute(() -> {
                LOGGER.info("[ModTest] Client joined world! Showing title.");

                // 単位はTick。20 Ticks = 1秒
                client.inGameHud.setTitleTicks(10, 40, 10);

                // メインタイトルを設定
                MutableText mainText = Text.literal("これが");
                MutableText redPart = Text.literal("title").formatted(Formatting.RED, Formatting.UNDERLINE);
                MutableText greenPart = Text.literal("コマンド").formatted(Formatting.GREEN, Formatting.UNDERLINE);
                MutableText yellowPart = Text.literal("です").formatted(Formatting.YELLOW);

                mainText.append(redPart).append(greenPart).append(yellowPart);

                client.inGameHud.setTitle(mainText);

                // サブタイトルが必要な場合は設定
                client.inGameHud.setSubtitle(Text.literal("▲こんな風に色々な装飾ができます"));
            });
        });

        LOGGER.info("[ModTest] ClientPlayConnectionEvents.JOIN registered.");
	}
}