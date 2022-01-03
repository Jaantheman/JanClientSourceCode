package janclient.mods.impl;

import java.awt.Color;

import janclient.event.EventTarget;
import janclient.event.impl.ClientTickEvent;
import janclient.mods.Mod;

public class ModEnchantGlint extends Mod{

	private static final Color DEFAULT_COLOR = new Color(128, 64, 204);
	private Color customColor = new Color(204, 64, 64);
	
	private Color chromaColor = DEFAULT_COLOR;
	
	public Color getColor() {
		if(isEnabled()) {
			return chromaColor;
		} else {
			return DEFAULT_COLOR;
		}
	}
	
	private float hue = 0;
	
	@EventTarget
	public void onTick(ClientTickEvent e) {
		hue += 0.03;
		
		chromaColor = Color.getHSBColor(hue, 0.6F, 0.8F);
		
		if(hue > 1) {
			hue = 0;
		}
	}
}
