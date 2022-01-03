package janclient;

import org.lwjgl.opengl.Display;

import janclient.event.EventManager;
import janclient.event.EventTarget;
import janclient.event.impl.ClientTickEvent;
import janclient.hudmanager.HUDManager;
import janclient.hudmanager.ScreenPosition;
import janclient.mods.ModInstance;
import janclient.util.SessionChanger;
import net.minecraft.client.Minecraft;

public class Client {

	private static final Client INSTANCE = new Client();
	public static final Client getInstance() {
		return INSTANCE;
	}
	private DiscordRP disrp = new DiscordRP();
	
	private HUDManager api;
	
	public ScreenPosition pos;
	
	public void init() {
		FileManager.init();
		SplashProgress.setProgress(4, "Initizilizing Discord RP and setting title");
		disrp.start();
		Display.setTitle(DiscordRP.NAMEVER + " Minecraft 1.8.9");
		EventManager.register(this);
	}
	public void shutdown() {
		disrp.shutdown();
	}
	public DiscordRP getDisRp() {
		return disrp;
	}
	public void hudinit() {
		api = HUDManager.getInstance();
		ModInstance.register(api);
	}
	
	@EventTarget
	public void onTick(ClientTickEvent e) {
		if(Minecraft.getMinecraft().gameSettings.CLIENT_MOD.isPressed()) {
			api.openConfigScreen();
		}
		if(pos == null) {
			pos = ScreenPosition.fromRelativePosition(0.5, 0.5);
		}
	}
	
}
