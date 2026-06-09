package com.infi.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerTabOverlay.class)
public class PlayerListHudMixin {
	/*
	Yes.
	We just return true here, because minecraft checks server encrypting before rendering heads.
	 */
	@ModifyExpressionValue(
			method = "extractRenderState",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/network/Connection;isEncrypted()Z"
			)
	)
	private boolean onTabRender(boolean original) {
		return true;
	}
}