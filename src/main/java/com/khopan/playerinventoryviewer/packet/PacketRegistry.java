package com.khopan.playerinventoryviewer.packet;

import java.lang.reflect.Modifier;

import com.khopan.playerinventoryviewer.PlayerInventoryViewer;
import com.khopan.playerinventoryviewer.packet.client.OpenPlayerInventoryPacket;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.simple.SimpleChannel.MessageBuilder;

public class PacketRegistry {
	private PacketRegistry() {}

	public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder.named(PlayerInventoryViewer.location("packets"))
			.networkProtocolVersion(() -> PlayerInventoryViewer.NETWORK_PROTOCOL_VERSION)
			.clientAcceptedVersions(version -> PlayerInventoryViewer.NETWORK_PROTOCOL_VERSION.equals(version))
			.serverAcceptedVersions(version -> PlayerInventoryViewer.NETWORK_PROTOCOL_VERSION.equals(version))
			.simpleChannel();

	private static int Identifier;

	public static void register() {
		PlayerInventoryViewer.LOGGER.info("Registering Packets");
		PacketRegistry.register(OpenPlayerInventoryPacket.class);
	}

	public static void client(ServerPacket packet, ServerPlayer player) {
		PacketRegistry.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), packet);
	}

	public static void server(ClientPacket packet) {
		PacketRegistry.CHANNEL.sendToServer(packet);
	}

	private static <T extends Packet> void register(Class<T> packetClass) {
		int modifiers = packetClass.getModifiers();

		if(Modifier.isInterface(modifiers)) {
			return;
		}

		boolean isClient = false;

		if(ClientPacket.class.isAssignableFrom(packetClass)) {
			isClient = true;
		} else if(ServerPacket.class.isAssignableFrom(packetClass)) {
			isClient = false;
		} else {
			throw new InternalError("Packet class must be subclass of either ClientPacket or ServerPacket");
		}

		MessageBuilder<T> builder = PacketRegistry.CHANNEL.messageBuilder(packetClass, PacketRegistry.Identifier, isClient ? NetworkDirection.PLAY_TO_SERVER : NetworkDirection.PLAY_TO_CLIENT)
				.decoder(buffer -> PacketRegistry.decode(buffer, packetClass))
				.encoder(T :: encode);

		if(isClient) {
			builder.consumerMainThread(T :: consume);
		} else {
			builder.consumerNetworkThread(T :: consume);
		}

		builder.add();
		PacketRegistry.Identifier++;
	}

	private static <T extends Packet> T decode(FriendlyByteBuf buffer, Class<T> packetClass) {
		T packet;

		try {
			packet = (T) packetClass.getConstructor().newInstance();
		} catch(Throwable Errors) {
			throw new InternalError("Error while constructing new Packet", Errors);
		}

		packet.decode(buffer);
		return packet;
	}
}
