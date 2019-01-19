package entity;

import entity.render.ZJKBallRender;
import modMain.modMain;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RedoEntity {

	public static void init() {
		EntityRegistry.registerModEntity(new ResourceLocation(modMain.MODID, "zjk_ball"), ZJKBall.class
				, "zjk_ball", 0, modMain.instance, 64, 1, true);
	}
	
	@SideOnly(Side.CLIENT)
	public static <T extends Entity> void registerEntityRender(Class<T> entityClass,
			Class<? extends Render<T>> render) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass,
				new EntityRenderFactory<T>(render));
	}
	
	@SideOnly(Side.CLIENT) 
	public static void registerRenders() {
		registerEntityRender(ZJKBall.class, ZJKBallRender.class);
	}
	
	
}
