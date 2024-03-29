package com.khopan.playerinventoryviewer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.khopan.playerinventoryviewer.client.ClientEventHandler;
import com.khopan.playerinventoryviewer.client.ClientForgeEventHandler;
import com.khopan.playerinventoryviewer.menu.MenuRegistry;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PlayerInventoryViewer.MOD_IDENTIFIER)
public class PlayerInventoryViewer {
	public static final String MOD_NAME = "Player Inventory Viewer";
	public static final String MOD_IDENTIFIER = "playerinventoryviewer";
	public static final String MOD_VERSION = "1.0.0";

	public static final String NETWORK_PROTOCOL_VERSION = "1.0.0";

	public static final Logger LOGGER = LoggerFactory.getLogger(PlayerInventoryViewer.MOD_NAME);

	public PlayerInventoryViewer() {
		PlayerInventoryViewer.LOGGER.info("Initializing {}", PlayerInventoryViewer.MOD_IDENTIFIER);
		FMLJavaModLoadingContext context = FMLJavaModLoadingContext.get();
		IEventBus bus = context.getModEventBus();
		bus.register(new ClientEventHandler());
		MinecraftForge.EVENT_BUS.register(new ClientForgeEventHandler());
		MenuRegistry.register(bus);
	}

	public static ResourceLocation location(String path) {
		return new ResourceLocation(PlayerInventoryViewer.MOD_IDENTIFIER, path);
	}
}
