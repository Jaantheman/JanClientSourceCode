package janclient.mods.impl;

import janclient.hudmanager.ScreenPosition;
import janclient.mods.ModDraggable;

public class ModXYZ extends ModDraggable {

	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return font.getStringWidth(getXYZString());
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return font.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		// TODO Auto-generated method stub
		if(this.pos == null) {
			this.pos = pos;
		}
		font.drawString(getXYZString(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}

	private String getXYZString() {
		// TODO Auto-generated method stub
		return String.format("XYZ: %.1f / %.1f / %.1f", mc.getRenderViewEntity().posX, mc.getRenderViewEntity().posY, mc.getRenderViewEntity().posZ);
	}



}
