package block;

import creativeTab.RedoCreateiveTabs;
import event.RedoEvents;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockChromite extends Block {
	
	public BlockChromite() {
		super(Material.ROCK);
		this.setSoundType(SoundType.STONE);
		this.setHardness(50);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(RedoCreateiveTabs.zjkTabs);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, 
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		RedoEvents.PlayerRightClickZJKBlockEvent event;
		event = new RedoEvents.PlayerRightClickZJKBlockEvent(playerIn, pos, worldIn);
		RedoEvents.EVENT_BUS.post(event);
		if (!event.isCanceled() && !worldIn.isRemote) {
			playerIn.swingArm(hand);
			worldIn.setBlockToAir(pos);
			return true;
		}
        return false;
    }
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
		if (!(entityIn instanceof EntityPlayer))
			return;
		RedoEvents.PlayerWalkOnZJKBlockEvent event;
		event = new RedoEvents.PlayerWalkOnZJKBlockEvent((EntityPlayer)(entityIn), pos, worldIn);
		RedoEvents.EVENT_BUS.post(event);
    }
	
}
