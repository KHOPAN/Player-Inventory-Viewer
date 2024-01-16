package com.khopan.playerinventoryviewer.packet;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public interface Packet {
	void encode(FriendlyByteBuf buffer);
	void decode(FriendlyByteBuf buffer);

	default void consume(Supplier<NetworkEvent.Context> supplier) {

	}
}
