package janclient.cosmetic;

import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticController {

	
	//TODO Use Database ASAP!!!!!!
	public static boolean renderJetpack(AbstractClientPlayer player) {
		if(player.getName() == "mathzexpertxD" || player.getName() == "Ily_Alpha") {
			return true;
		}
		return true;
	}
	
	public static float[] getJetpackColor(AbstractClientPlayer player) {
		//R G B VALUE 0 TO 1
		return new float[] {1, 0, 0};
	}
	
}
