package janclient;

import org.lwjgl.opengl.Display;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
import net.minecraft.client.Minecraft;

public class DiscordRP {
 
	private boolean running = true;
	private long created = 0;
	
	public static final String NAME = "Jan Client";
	public static final String VERSION = "2.1";
	public static final String NAMEVER = NAME + " v" + VERSION;
	
	public void start() {
		
		
		this.created = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			
			@Override
			public void apply(DiscordUser user) {
				
				System.out.println("[" + Minecraft.getSystemTime() + "] [Discord Thread] Welcome To" + NAMEVER + " " + user.username + "#" + user.discriminator );
				update(NAMEVER + "MC 1.8.8", "");
			}
		}).build();
		
		DiscordRPC.discordInitialize("919689104562716714", handlers, true);
		
		new Thread("DiscordRP Callback") {
			
			public void run() {
				while(running) {
					DiscordRPC.discordRunCallbacks();
				}
			}
		
			
		}.start();
	}
	public void shutdown() {
		this.running = false;
		DiscordRPC.discordShutdown();
	}
	public void update(String firstline, String secondline) {
		
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondline);
		b.setBigImage("large", "");
		b.setDetails(firstline);
		b.setStartTimestamps(created);
		
		DiscordRPC.discordUpdatePresence(b.build());
	}
	

		
}
