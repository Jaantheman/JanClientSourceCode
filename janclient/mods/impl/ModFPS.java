package janclient.mods.impl;

import janclient.hudmanager.ScreenPosition;
import janclient.mods.ModDraggable;

public class ModFPS extends ModDraggable{


	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return font.FONT_HEIGHT;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 50;
	}

	
	public void render(ScreenPosition position) {
		// TODO Auto-generated method stub
		if(this.pos == null) {
			this.pos = position;
		}
		font.drawString("FPS: " + mc.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}

	
	public void renderDummy(ScreenPosition position) {
		// TODO Auto-generated method stub
		if(this.pos == null) {
			this.pos = position;
		}
		font.drawString("FPS: " + mc.getDebugFPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
	}


}
