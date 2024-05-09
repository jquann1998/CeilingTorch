package bl4ckscor3.mod.ceilingtorch.compat.bonetorch;

import java.util.Map;

import com.builtbroken.bonetorch.BoneTorchMod;

import bl4ckscor3.mod.ceilingtorch.CeilingTorch;
import bl4ckscor3.mod.ceilingtorch.ICeilingTorchCompat;
import bl4ckscor3.mod.ceilingtorch.compat.vanilla.CeilingTorchBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BoneTorchCompat implements ICeilingTorchCompat {
	public static final DeferredBlock<CeilingTorchBlock> CEILING_BONE_TORCH = CeilingTorch.BLOCKS.register("bonetorch_bonetorch", () -> new CeilingTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), ParticleTypes.FLAME, BoneTorchMod.BONETORCH));
	public static final DeferredBlock<CeilingTorchBlock> CEILING_SOUL_BONE_TORCH = CeilingTorch.BLOCKS.register("bonetorch_soul_bonetorch", () -> new CeilingTorchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_TORCH), ParticleTypes.SOUL_FIRE_FLAME, BoneTorchMod.SOUL_BONETORCH));
	private Map<ResourceLocation, Block> placeEntries;

	@Override
	public Map<ResourceLocation, Block> getPlaceEntries() {
		if (placeEntries == null)
			placeEntries = Map.of(BoneTorchMod.BONETORCH.getId(), CEILING_BONE_TORCH.get(), BoneTorchMod.SOUL_BONETORCH.getId(), CEILING_SOUL_BONE_TORCH.get());

		return placeEntries;
	}
}
