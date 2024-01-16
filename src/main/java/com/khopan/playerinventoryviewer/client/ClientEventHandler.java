package com.khopan.playerinventoryviewer.client;

import com.khopan.playerinventoryviewer.PlayerInventoryViewer;
import com.khopan.playerinventoryviewer.client.screen.PlayerInventoryScreen;
import com.khopan.playerinventoryviewer.menu.MenuRegistry;
import com.khopan.playerinventoryviewer.packet.PacketRegistry;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid=PlayerInventoryViewer.MOD_IDENTIFIER, bus=Bus.MOD, value=Dist.CLIENT)
public class ClientEventHandler {
	@SubscribeEvent
	public void onRegisterKeyMappings(RegisterKeyMappingsEvent Event) {
		PlayerInventoryViewer.LOGGER.info("Registering Key Bindings");
		Event.register(KeyBinding.OPEN_PLAYER_INVENTORY_KEY);
	}

	@SubscribeEvent
	public void onCommonSetup(FMLCommonSetupEvent Event) {
		PacketRegistry.register();
	}

	@SubscribeEvent
	public void onClientSetup(FMLClientSetupEvent Event) {
		PlayerInventoryViewer.LOGGER.info("Registering Menu Screens");
		MenuScreens.register(MenuRegistry.PLAYER_INVENTORY.get(), PlayerInventoryScreen :: new);
	}
}
