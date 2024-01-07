package com.khopan.playerinventoryviewer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(PlayerInventoryViewer.MOD_IDENTIFIER)
public class PlayerInventoryViewer {
	public static final String MOD_NAME = "Player Inventory Viewer";
	public static final String MOD_IDENTIFIER = "playerinventoryviewer";

	public static final Logger LOGGER = LoggerFactory.getLogger(PlayerInventoryViewer.MOD_NAME);

	public PlayerInventoryViewer() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this :: onCommonSetup);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public void onCommonSetup(FMLCommonSetupEvent Event) {
		PlayerInventoryViewer.LOGGER.info("HELLO FROM COMMON SETUP");
		PlayerInventoryViewer.LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent Event) {
		PlayerInventoryViewer.LOGGER.info("HELLO from server starting");
	}

	@Mod.EventBusSubscriber(modid=PlayerInventoryViewer.MOD_IDENTIFIER, bus=Mod.EventBusSubscriber.Bus.MOD, value=Dist.CLIENT)
	public static class ClientEventHandler {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent Event) {
			PlayerInventoryViewer.LOGGER.info("HELLO FROM CLIENT SETUP");
			PlayerInventoryViewer.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
		}
	}
}
