package item;

import creativeTab.RedoCreateiveTabs;
import entity.ZJKBall;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemZJKWand extends Item {
	
	private long lasttime = 0;
	
	public ItemZJKWand() {
		super();
		this.setCreativeTab(RedoCreateiveTabs.zjkTabs);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
//		long totaltime = worldIn.getTotalWorldTime();
//		if (totaltime - lasttime < 20) 
//			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));;
//		lasttime = totaltime;
		playerIn.swingArm(EnumHand.MAIN_HAND);
		if (worldIn.isRemote) 
			return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		Vec3d look = playerIn.getLookVec();
		Vec3d vec = playerIn.getPositionEyes(1.0F).add(look.scale(2));
		ZJKBall zjkBall = new ZJKBall(worldIn, vec.x, vec.y, vec.z);
		zjkBall.motionX = look.x * 2.0F;
		zjkBall.motionY = look.y * 2.0F;
		zjkBall.motionZ = look.z * 2.0F;
		worldIn.spawnEntity(zjkBall);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
        
    }
	
}
