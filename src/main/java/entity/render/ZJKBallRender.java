package entity.render;

import entity.ZJKBall;
import modMain.modMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ZJKBallRender extends RenderSnowball<ZJKBall> {
	
	public ZJKBallRender(RenderManager renderManagerIn) {
		super(renderManagerIn, Items.FIRE_CHARGE, Minecraft.getMinecraft().getRenderItem());
	}

}
