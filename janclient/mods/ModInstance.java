package janclient.mods;

import janclient.hudmanager.HUDManager;
import janclient.mods.impl.ModArmorStatus;
import janclient.mods.impl.ModCPS;
import janclient.mods.impl.ModEnchantGlint;
import janclient.mods.impl.ModFPS;
import janclient.mods.impl.ModKeystrokes;
import janclient.mods.impl.ModProjectL;
import janclient.mods.impl.ModXYZ;

public class ModInstance {
	private static ModFPS modFPS;
	
	private static ModEnchantGlint modGlint;
	
	private static ModProjectL modProjectL;
	
	private static ModArmorStatus modArmorStatus;
	
	private static ModXYZ modXyz;
	
	private static ModKeystrokes modKeystrokes;
	
	private static ModCPS modCps;
	
	public static void register(HUDManager api) {
		
		modFPS = new ModFPS();
		
		modGlint = new ModEnchantGlint();
		
		modProjectL = new ModProjectL();
		
		modArmorStatus = new ModArmorStatus();
		
		modXyz = new ModXYZ();
		
		modKeystrokes = new ModKeystrokes();
		
		modCps = new ModCPS();
		
		api.register(modFPS);
		
		api.register(modArmorStatus);
		
		api.register(modXyz);
		
		api.register(modKeystrokes);
		
        api.register(modCps);
	}

	public static ModFPS getModFPS() {
		return modFPS;
	}
	public static ModEnchantGlint getModGlint() {
		return modGlint;
	}
	public static ModArmorStatus getModArmorStatus() {
		return modArmorStatus;
	}
	public static ModProjectL getModProjectL() {
		return modProjectL;
	}
	public static ModKeystrokes getModKeystrokes() {
		return modKeystrokes;
	}
	public static ModXYZ getModXyz() {
		return modXyz;
	}
	
}
