package janclient;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class ServerDataFeatured extends ServerData {

	public static final ResourceLocation FEATERED = new ResourceLocation("janclient/star.png");
	
	public ServerDataFeatured(String name, String ip, boolean isLan) {
		super(name, ip, false);
		// TODO Auto-generated constructor stub
	}

}
