package janclient.cosmetic;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.layers.*;

public abstract class CosmeticBase implements LayerRenderer<AbstractClientPlayer> {

	@Override
	public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		// TODO Auto-generated method stub
		if(player.hasPlayerInfo() && !player.isInvisible()) {
			render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
		}
		
	}
	
	public abstract void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale);
		
	

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}

}
