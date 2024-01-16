package com.khopan.playerinventoryviewer.client.screen;

import com.khopan.playerinventoryviewer.menu.MenuRegistry;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class PlayerInventoryMenu extends AbstractContainerMenu {
	public PlayerInventoryMenu(int identifier, Inventory inventory, FriendlyByteBuf buffer) {
		super(MenuRegistry.PLAYER_INVENTORY.get(), identifier);

		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlot(new Slot(inventory, y * 9 + x + 9, x * 18 + 8, y * 18 + 174));
			}
		}

		for(int i = 0; i < 9; i++) {
			this.addSlot(new Slot(inventory, i, i * 18 + 8, 232));
		}
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		return new ItemStack(Blocks.NETHERITE_BLOCK, 64);
	}

	@Override
	public boolean stillValid(Player player) {
		return true;
	}
}
