package com.khopan.playerinventoryviewer.packet.client;

import com.khopan.playerinventoryviewer.PlayerInventoryViewer;
import com.khopan.playerinventoryviewer.client.screen.PlayerInventoryMenuProvider;
import com.khopan.playerinventoryviewer.packet.ClientPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent.Context;

public class OpenPlayerInventoryPacket implements ClientPacket {
	@Override
	public void encode(FriendlyByteBuf buffer) {

	}

	@Override
	public void decode(FriendlyByteBuf buffer) {

	}

	@Override
	public void executeServer(Context context, ServerPlayer player) {
		PlayerInventoryViewer.LOGGER.info("Open Inventory Key is pressed, opening {}'s inventory", "KHOPAN");
		player.openMenu(new PlayerInventoryMenuProvider(player));
	}
}
