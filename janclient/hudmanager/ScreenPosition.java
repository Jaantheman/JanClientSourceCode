package janclient.hudmanager;

import com.google.gson.annotations.Expose;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ScreenPosition {

	private static final Minecraft mc = Minecraft.getMinecraft();
	
	private int x, y;
	
	public ScreenPosition(double x, double y) {
		setRelative(x, y);
	}

	public ScreenPosition(int x, int y) {
		setAbsolute(x, y);
	}
	
	public static ScreenPosition fromRelativePosition(double x, double y) {
		return new ScreenPosition(x, y);
	}
	
	public static ScreenPosition fromAbsolute(int x, int y) {
		return new ScreenPosition(x, y);
	}
	
	public int getAbsoluteX() {

		return x;
	}
	
	public int getAbsoluteY() {
		return y;
	}
	
	public double getRelitiveX() {
		ScaledResolution sr = new ScaledResolution(mc);
		return x / sr.getScaledWidth_double();
	}
	
	public double getRelitiveY() {
		ScaledResolution sr = new ScaledResolution(mc);
		return y / sr.getScaledHeight_double();
	}
	
	public void setAbsolute(int x, int y) {
		ScaledResolution res = new ScaledResolution(mc);
		
		this.x = x;
		this.y = y;
	}

	public void setRelative(double x, double y) {
		ScaledResolution sr = new ScaledResolution(mc);
		this.x = (int) (sr.getScaledWidth() / x);
		this.y = (int) (sr.getScaledHeight() / y);
	}
	
}
