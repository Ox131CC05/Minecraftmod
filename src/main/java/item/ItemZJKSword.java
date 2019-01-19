package item;

import java.util.Random;

import creativeTab.RedoCreateiveTabs;
import event.RedoEvents;
import modMain.modMain;
import net.minecraft.block.SoundType;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.renderer.Vector3d;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemZJKSword extends ItemSword {
	
	private long lasttime = 0;
	
	public ItemZJKSword() {
		super(EnumHelper.addToolMaterial("ZJK", 0, 232, 2, 12, 8));
		this.addPropertyOverride(new ResourceLocation("isZJK"), (stack, world, entity) -> entity != null 
				&& entity.getCustomNameTag().equals("ZJK") ? 1.0F : 0.0F);
		this.setCreativeTab(RedoCreateiveTabs.zjkTabs);
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		long totaltime = worldIn.getTotalWorldTime();
//		if (totaltime - lasttime < 20) 
//			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
//		lasttime = totaltime;
		playerIn.swingArm(EnumHand.MAIN_HAND);
		ItemStack itemStack = (ItemStack)playerIn.getHeldItemMainhand();
		itemStack.attemptDamageItem(2, worldIn.rand, null);
//		if (worldIn.isRemote) return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		modMain.instance.getLogger().info("Clicked.");
		for (int i = 30;i >= 1;i--) {
			Vec3d vec3d = playerIn.getPositionVector().add(playerIn.getLookVec().scale(i / 2.0F));
			BlockPos pos = new BlockPos(vec3d.x, vec3d.y, vec3d.z);
			if (!worldIn.isAirBlock(pos)) continue;
			playerIn.setPosition(vec3d.x, vec3d.y, vec3d.z);
			break;
		}
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
	
}
