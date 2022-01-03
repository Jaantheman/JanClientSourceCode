package janclient.mods.impl;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import janclient.hudmanager.ScreenPosition;
import janclient.mods.ModDraggable;

public class ModCPS extends ModDraggable {

	private List<Long> clicks = new ArrayList<Long>();
	private boolean wasPressed;
	private long lastPressed;
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return font.getStringWidth("CPS: 00");
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return font.FONT_HEIGHT + 10;
	}

	@Override
	public void render(ScreenPosition pos) {
		
		final boolean pressed = Mouse.isButtonDown(0);
		if(pressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis();
			this.wasPressed = pressed;
			if(pressed) {
				this.clicks.add(this.lastPressed);
			}
		}
		
		font.drawString("CPS: " + getCPS(), pos.getAbsoluteX(), pos.getAbsoluteY(), 0xffffff);
		
	}
	
	private int getCPS() {
		
		final long time = System.currentTimeMillis();
		this.clicks.removeIf(aLong -> aLong + 1000 < time);
		return this.clicks.size();
		
	}

}
