package janclient.mods.impl;

import janclient.hudmanager.ScreenPosition;
import janclient.mods.ModDraggable;

public class ModHelloWorld extends ModDraggable {

	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return font.FONT_HEIGHT;
	}

	@Override
	public int getWidth() {
		return font.getStringWidth("Hello World(dummy lol)!");
	}

	@Override
	public void render(ScreenPosition position) {
		// TODO Auto-generated method stub
		if(this.pos == null) {
			this.pos = position;
		}
		font.drawString("Hello World!", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
	}

	@Override
	public void renderDummy(ScreenPosition position) {
		if(this.pos == null) {
			this.pos = position;
		}
		
		font.drawString("Hello World(dummy lol)!", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0xFF00FF00);
		
	}

	

}
