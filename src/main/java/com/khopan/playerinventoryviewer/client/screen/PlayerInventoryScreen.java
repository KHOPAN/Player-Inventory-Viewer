package com.khopan.playerinventoryviewer.client.screen;

import com.khopan.playerinventoryviewer.PlayerInventoryViewer;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PlayerInventoryScreen extends AbstractContainerScreen<PlayerInventoryMenu> {
	public static final ResourceLocation TEXTURE = PlayerInventoryViewer.location("textures/gui.png");

	public PlayerInventoryScreen(PlayerInventoryMenu menu, Inventory inventory, Component title) {
		super(menu, inventory, title);
		this.imageWidth = 176;
		this.imageHeight = 256;
	}

	@Override
	protected void init() {
		super.init();
		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		this.inventoryLabelX = -font.width(this.playerInventoryTitle) - this.leftPos;
		this.inventoryLabelY = -font.lineHeight - this.topPos;
	}

	@Override
	public void renderBg(PoseStack stack, float tickDelta, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer :: getPositionTexShader);
		RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
		RenderSystem.setShaderTexture(0, PlayerInventoryScreen.TEXTURE);
		this.blit(stack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
	}

	@Override
	public void render(PoseStack stack, int mouseX, int mouseY, float tickDelta) {
		this.renderBackground(stack);
		super.render(stack, mouseX, mouseY, tickDelta);
		this.renderTooltip(stack, mouseX, mouseY);
	}
}
