package janclient;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;

public class SplashProgress {

	private static final int MAX = 4;
	private static int PROGRESS = 0;
	private static String CURRENT = "";
	private static ResourceLocation splash;
	private static UnicodeFontRenderer ufr;
	private static ResourceLocation font = new ResourceLocation("janclient/COMIC.ttf");
	
	public static void update() {
		if(Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getLanguageManager() == null) {
			return;
		}
		drawSplsh(Minecraft.getMinecraft().getTextureManager());
	}
	public static void setProgress(int givenProgress, String givenText) {
		PROGRESS = givenProgress;
		CURRENT = givenText;
	}
	public static void drawSplsh(TextureManager tm) {
		
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		int scaleFactor = sr.getScaleFactor();
		
		Framebuffer fb = new Framebuffer(sr.getScaledWidth() * scaleFactor, sr.getScaledHeight() * scaleFactor, true);
		fb.bindFramebuffer(false);
		
		GlStateManager.matrixMode(GL11.GL_PROJECTION);
		GlStateManager.loadIdentity();
		GlStateManager.ortho(0.0F, (double)sr.getScaledWidth(), (double)sr.getScaledHeight(), 0.0F, 1000.0F, 3000.0F);
		GlStateManager.matrixMode(GL11.GL_MODELVIEW);
		GlStateManager.loadIdentity();
		GlStateManager.translate(0.0F, 0.0F, -2000.0F);
		GlStateManager.disableLighting();
		GlStateManager.disableFog();
		GlStateManager.disableDepth();
		GlStateManager.enableTexture2D();
		
		if(splash == null) {
			
			splash = new ResourceLocation("janclient/splash.png");
			
		}
		
		tm.bindTexture(splash);
		
		GlStateManager.resetColor();
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		
		Gui.drawScaledCustomSizeModalRect(0, 0, 0, 0, 1920, 1080, sr.getScaledWidth(), sr.getScaledHeight(), 1920, 1080);
		drawProgress();
		fb.unbindFramebuffer();
		fb.framebufferRender(sr.getScaledWidth() * scaleFactor, sr.getScaledHeight() * scaleFactor);
		
		GlStateManager.enableAlpha();
		GlStateManager.alphaFunc(516, 0.1F);
		
		Minecraft.getMinecraft().updateDisplay();
		
	}
	private static void drawProgress() {
		if(Minecraft.getMinecraft().gameSettings == null || Minecraft.getMinecraft().getTextureManager() == null) {
			return;
		}
		if(ufr == null) {
			ufr = UnicodeFontRenderer.getFontFromAssets("COMIC", 20);
		}
		
		ScaledResolution sr2 = new ScaledResolution(Minecraft.getMinecraft());
		
		double endProgress = (double)PROGRESS;
		double cal = (endProgress / MAX) * sr2.getScaledWidth();
		
		Gui.drawRect(0, sr2.getScaledHeight() - 35, sr2.getScaledWidth(), sr2.getScaledHeight(), new Color(0, 0, 0, 50).getRGB());
		
		GlStateManager.resetColor();
		resetTextureState();
		
		ufr.drawString(CURRENT, 20, sr2.getScaledHeight() - 25, 0xFFFFFFFF);
		
		String s = PROGRESS + "/" + MAX;
		ufr.drawString(s, sr2.getScaledWidth() - 20 - ufr.getStringWidth(s), sr2.getScaledHeight(), 0xe1e1e1FF);
				
		GlStateManager.resetColor();
		resetTextureState();
		Gui.drawRect(0, sr2.getScaledHeight() - 2, (int)cal, sr2.getScaledHeight(), new Color(149, 201, 144).getRGB());
		
		Gui.drawRect(0, sr2.getScaledHeight() - 2, sr2.getScaledWidth(), sr2.getScaledHeight(), new Color(0, 0, 0, 10).getRGB());
		
		
		
	}
	private static void resetTextureState() {
		GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName  = -1;
	}
}

