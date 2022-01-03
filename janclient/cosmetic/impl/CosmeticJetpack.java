package janclient.cosmetic.impl;

import janclient.cosmetic.CosmeticBase;
import janclient.cosmetic.CosmeticModelBase;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.model.ModelRenderer;



public class CosmeticJetpack extends CosmeticBase {

	@Override
	public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
		// TODO Auto-generated method stub
		
	}

	private class ModelJetpack extends CosmeticModelBase {

		private ModelRenderer rockets;
		private ModelRenderer holder;
		
		public ModelJetpack(RenderPlayer player) {
			super(player);
			rockets = new ModelRenderer(playerModel, 0, 0);
			holder = new ModelRenderer(playerModel, 0, 0);
			rockets.addBox(3f, 2f, 2.5f, 2, 4, 2);
			rockets.addBox(3f, 2f, -2.5f, 2, 4, 2);
			holder.addBox(1f, 4f, 1f, 5, 2, 2);
			
		}
		
	}
	@Override
	public void doRenderLayer(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
		// TODO Auto-generated method stub
		
		
		super.doRenderLayer(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, headYaw, headPitch, scale);
	}
	
	
}
