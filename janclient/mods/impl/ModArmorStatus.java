package janclient.mods.impl;

import org.lwjgl.opengl.GL11;

import janclient.hudmanager.ScreenPosition;
import janclient.mods.ModDraggable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.*;

public class ModArmorStatus extends ModDraggable{


	
	
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public void render(ScreenPosition pos) {
		for(int i = 0; i < mc.thePlayer.inventory.armorInventory.length; i++) {
			ItemStack itemstack = mc.thePlayer.inventory.armorInventory[i];
			renderItemStack(pos, i, itemstack);
		}
	}
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		// TODO Auto-generated method stub
	
		renderItemStack(pos, 3, new ItemStack(Items.diamond_helmet));
		renderItemStack(pos, 2, new ItemStack(Items.diamond_chestplate));
		renderItemStack(pos, 1, new ItemStack(Items.diamond_leggings));
		renderItemStack(pos, 0, new ItemStack(Items.diamond_boots));
	}

	private void renderItemStack(ScreenPosition pos, int i, ItemStack itemStack) {
		// TODO Auto-generated method stub
		if(itemStack == null) {
			return;
		}
		
		GL11.glPushMatrix();
		int yAdd = (-16 * i) + 48;
		
		if(itemStack.getItem().isDamageable()) {
			double damage = ((itemStack.getMaxDamage() - itemStack.getItemDamage()) / (double) itemStack.getMaxDamage()) * 100;
			font.drawString(String.format("%.2f%%", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, -1);
		}
		
		RenderHelper.enableGUIStandardItemLighting();
		mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
		GL11.glPopMatrix();
		
	} 


}
