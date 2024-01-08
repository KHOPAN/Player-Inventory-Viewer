package com.khopan.playerinventoryviewer.client;

import com.khopan.playerinventoryviewer.PlayerInventoryViewer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid=PlayerInventoryViewer.MOD_IDENTIFIER, bus=Bus.MOD, value=Dist.CLIENT)
public class ClientEventHandler {
	@SubscribeEvent
	public void onRegisterKeyMappings(RegisterKeyMappingsEvent Event) {
		Event.register(KeyBinding.OPEN_PLAYER_INVENTORY_KEY);
	}
}
