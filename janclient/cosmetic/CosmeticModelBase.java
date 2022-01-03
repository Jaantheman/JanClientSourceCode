package janclient.cosmetic;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class CosmeticModelBase extends ModelBase{

	protected final ModelBiped playerModel;
	
	public CosmeticModelBase(RenderPlayer player) {
		
		this.playerModel = player.getMainModel();
		
	}
	
}
