package entity;

import item.RedoItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ZJKBall extends EntityThrowable {
	
	public ZJKBall(World worldIn) {
		super(worldIn);
		setSize(0.28F, 0.28F);
	}
	
	public ZJKBall(World worldIn, double x, double y, double z) {
		this(worldIn);
		this.setPosition(x, y, z);
	}
	
//	public ZJKBall(World world, EntityLivingBase throwerIn) {
//		super(world, throwerIn);
//		setSize(0.28F, 0.28F);
//	}
	
	public void onUpdate() {
		super.onUpdate();
		world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, 
				posX - motionX * 0.25D + rand.nextDouble() * 0.6D - 0.3D, 
				posY - motionY * 0.25D - 0.5D, 
				posZ - motionZ * 0.25D + rand.nextDouble() * 0.6D - 0.3D,
				motionX, motionY, motionZ);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.typeOfHit == RayTraceResult.Type.BLOCK ||
				(result.typeOfHit == RayTraceResult.Type.ENTITY
				&& result.entityHit != this.thrower)) {
			setDead();
			if (!world.isRemote) {
				world.createExplosion(this, this.posX
						, this.posY, this.posZ, 4.0F, true);
			}
		}
	} // µ±×²»÷Ê±
	
	protected float getGravityVelocity() {
		return 0;
	}
	
	public boolean isInWater() {
		return false;
	}
	
	public boolean shouldRenderInPass(int pass) {
		return pass == 1;
	}
	
}
