package com.khopan.playerinventoryviewer.client;

import com.khopan.playerinventoryviewer.PlayerInventoryViewer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid=PlayerInventoryViewer.MOD_IDENTIFIER, value=Dist.CLIENT)
public class ClientForgeEventHandler {
	@SubscribeEvent
	public void onKeyPressed(InputEvent.Key Event) {
		if(KeyBinding.OPEN_PLAYER_INVENTORY_KEY.consumeClick()) {
			Minecraft minecraft = Minecraft.getInstance();
			LocalPlayer player = minecraft.player;
			player.displayClientMessage(Component.literal("Open Player Inventory key is pressed"), false);
		}
	}
}
