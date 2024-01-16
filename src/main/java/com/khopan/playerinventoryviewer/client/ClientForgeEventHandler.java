package com.khopan.playerinventoryviewer.client;

import com.khopan.playerinventoryviewer.PlayerInventoryViewer;
import com.khopan.playerinventoryviewer.packet.PacketRegistry;
import com.khopan.playerinventoryviewer.packet.client.OpenPlayerInventoryPacket;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid=PlayerInventoryViewer.MOD_IDENTIFIER, value=Dist.CLIENT)
public class ClientForgeEventHandler {
	@SubscribeEvent
	public void onKeyPressed(InputEvent.Key Event) {
		if(KeyBinding.OPEN_PLAYER_INVENTORY_KEY.consumeClick()) {
			PacketRegistry.server(new OpenPlayerInventoryPacket());
		}
	}
}
