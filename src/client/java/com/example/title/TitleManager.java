package com.example.title;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class TitleManager {

    public static void  showCustomTitle(MinecraftClient client) {
        // メインタイトルを設定
        MutableText mainText = Text.literal("これが");
        MutableText redPart = Text.literal("apple").formatted(Formatting.RED, Formatting.UNDERLINE);
        MutableText greenPart = Text.literal("コマンド").formatted(Formatting.GREEN, Formatting.UNDERLINE);
        MutableText yellowPart = Text.literal("です").formatted(Formatting.YELLOW);
        mainText.append(redPart).append(greenPart).append(yellowPart);

        // 単位はTick。20 Ticks = 1秒
        client.inGameHud.setTitleTicks(10, 40, 10);

        client.inGameHud.setTitle(mainText);
        // サブタイトルが必要な場合は設定
        client.inGameHud.setSubtitle(Text.literal("▲こんな風に色々な装飾ができます"));
    }
}
