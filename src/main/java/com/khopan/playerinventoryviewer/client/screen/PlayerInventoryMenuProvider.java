package com.khopan.playerinventoryviewer.client.screen;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class PlayerInventoryMenuProvider implements MenuProvider {
	public static final Component TITLE = Component.literal("KHOPAN's Inventory");

	private final ServerPlayer viewingPlayer;

	public PlayerInventoryMenuProvider(ServerPlayer viewingPlayer) {
		this.viewingPlayer = viewingPlayer;
	}

	@Override
	public AbstractContainerMenu createMenu(int identifier, Inventory inventory, Player player) {
		return new PlayerInventoryMenu(identifier, inventory, this.viewingPlayer);
	}

	@Override
	public Component getDisplayName() {
		return PlayerInventoryMenuProvider.TITLE;
	}
}
