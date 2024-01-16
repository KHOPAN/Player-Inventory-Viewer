package com.khopan.playerinventoryviewer.packet;

import java.util.function.Supplier;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent.Context;

public interface ClientPacket extends Packet {
	@Override
	default void consume(Supplier<Context> supplier) {
		Context context = supplier.get();
		ServerPlayer player = context.getSender();
		context.enqueueWork(() -> this.executeServer(context, player));
	}

	default void executeServer(Context context, ServerPlayer player) {

	}
}
