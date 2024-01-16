package com.khopan.playerinventoryviewer.menu;

import com.khopan.playerinventoryviewer.PlayerInventoryViewer;
import com.khopan.playerinventoryviewer.client.screen.PlayerInventoryMenu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuRegistry {
	private MenuRegistry() {}

	public static final DeferredRegister<MenuType<?>> MENU_REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PlayerInventoryViewer.MOD_IDENTIFIER);

	public static final RegistryObject<MenuType<PlayerInventoryMenu>> PLAYER_INVENTORY = MenuRegistry.MENU_REGISTRY.register("fusion_machine", () -> IForgeMenuType.create(PlayerInventoryMenu :: new));

	public static void register(IEventBus bus) {
		PlayerInventoryViewer.LOGGER.info("Registering Menus");
		MenuRegistry.MENU_REGISTRY.register(bus);
	}
}
