package janclient.mods.impl;

import janclient.event.EventTarget;
import janclient.event.impl.MouseEvent;
import janclient.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.*;
import net.minecraft.client.Minecraft;

public class ModProjectL extends Mod {

	@EventTarget
	public void onMouse(MouseEvent event) {
		if (this.isEnabled() && (event.dx != 0 || event.dy != 0)) {
		      EntityPlayerSP entity = (Minecraft.getMinecraft().thePlayer);
		      if (entity != null) {
		          entity.prevRenderYawOffset = entity.renderYawOffset;
		    	  entity.prevRotationYawHead = entity.rotationYawHead;
		    	  entity.prevRotationYaw = entity.rotationYaw;
		    	  entity.prevRotationPitch = entity.rotationPitch;
		      } 
		    } 
	}
	
}
