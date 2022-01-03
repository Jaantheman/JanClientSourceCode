package janclient;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;


public class JanClientMainMenu extends GuiScreen {

	public Minecraft mc = Minecraft.getMinecraft();
	
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("janclient/download.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, 1920, 1080, this.width, this.height);

        Gui.drawRect(0, 0, 255, this.height, new Color(0, 0, 0, 170).getRGB());
		
		GlStateManager.pushMatrix();
		//GlStateManager.translate((width/2f), (height/2f), 0);
		GlStateManager.scale(1.2, 1.2, 1.2);
		//GlStateManager.translate((width/2f), (height/2f), 0);
		this.drawCenteredString(mc.fontRendererObj,Client.getInstance().getDisRp().NAMEVER,35, height / 2 -207, -1);
		GlStateManager.popMatrix();
		mc.fontRendererObj.drawStringWithShadow("Jan Client. The Fun Client", 10, 60, new Color(0,255,0, 255).getRGB());
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(1, 10, this.height / 2 - 40, "Solo World" ));
		this.buttonList.add(new GuiButton(2, 10, this.height / 2 - 15, "Play Together" ));
		this.buttonList.add(new GuiButton(3, 10, this.height / 2 + 10, "Settings" ));
		this.buttonList.add(new GuiButton(4, 10, this.height / 2 + 35, "I QUIT!!!!!!! >:(" ));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		} else if (button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		} else if (button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		} else {
			mc.shutdown();
		}
		super.actionPerformed(button);
	}
	
}
