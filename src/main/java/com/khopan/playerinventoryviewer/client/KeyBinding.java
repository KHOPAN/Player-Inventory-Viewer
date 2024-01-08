package com.khopan.playerinventoryviewer.client;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.KeyMapping;

public class KeyBinding {
	private KeyBinding() {}

	public static final KeyMapping OPEN_PLAYER_INVENTORY_KEY = new KeyMapping("key.playerinventoryviewer.open", GLFW.GLFW_KEY_P, "key.playerinventory.category");
}
