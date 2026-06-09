package com.infi.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.hud.PlayerListHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerListHud.class)
public class PlayerListHudMixin {
	/*
	Yes.
	We just return true here, because minecraft checks server encrypting before rendering heads.
	 */
	@ModifyExpressionValue(
			method = "render",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/network/ClientConnection;isEncrypted()Z"
			)
	)
	private boolean onTabRender(boolean original) {
		return true;
	}
}