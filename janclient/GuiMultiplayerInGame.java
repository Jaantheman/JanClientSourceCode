package janclient;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;

public class GuiMultiplayerInGame extends GuiMultiplayer {

	public GuiMultiplayerInGame() {
		super(null);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		// TODO Auto-generated method stub
		
        if(button.id == 1 || button.id == 4) {
        	disconnect();
        }
		
		super.actionPerformed(button);
	}
	
	@Override
	public void connectToSelected() {
		// TODO Auto-generated method stub
		disconnect();
		super.connectToSelected();
	}

	private void disconnect() {
		// TODO Auto-generated method stub
		if(this.mc.theWorld != null) {
			this.mc.theWorld.sendQuittingDisconnectingPacket();
			this.mc.loadWorld(null);
			this.mc.displayGuiScreen(null);
			this.parentScreen = null;
		}
	}

}
