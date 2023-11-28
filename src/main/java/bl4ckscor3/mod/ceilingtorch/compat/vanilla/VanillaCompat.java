package bl4ckscor3.mod.ceilingtorch.compat.vanilla;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import bl4ckscor3.mod.ceilingtorch.CeilingTorch;
import bl4ckscor3.mod.ceilingtorch.ICeilingTorchCompat;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.RegistryObject;

public class VanillaCompat implements ICeilingTorchCompat {
	public static final RegistryObject<Block> CEILING_TORCH = CeilingTorch.BLOCKS.register("torch", () -> new CeilingTorchBlock(Block.Properties.copy(Blocks.TORCH), ParticleTypes.FLAME, () -> Blocks.TORCH));
	public static final RegistryObject<Block> CEILING_REDSTONE_TORCH = CeilingTorch.BLOCKS.register("redstone_torch", () -> new RedstoneCeilingTorchBlock(Block.Properties.copy(Blocks.REDSTONE_TORCH), () -> Blocks.REDSTONE_TORCH));
	public static final RegistryObject<Block> CEILING_SOUL_TORCH = CeilingTorch.BLOCKS.register("soul_torch", () -> new CeilingTorchBlock(Block.Properties.copy(Blocks.SOUL_TORCH), ParticleTypes.SOUL_FIRE_FLAME, () -> Blocks.SOUL_TORCH));
	private Map<ResourceLocation, Block> placeEntries;

	@Override
	public Map<ResourceLocation, Block> getPlaceEntries() {
		if (placeEntries == null) {
			//@formatter:off
			placeEntries = ImmutableMap.of(getRegistryName(Items.TORCH), CEILING_TORCH.get(),
					getRegistryName(Items.REDSTONE_TORCH), CEILING_REDSTONE_TORCH.get(),
					getRegistryName(Items.SOUL_TORCH), CEILING_SOUL_TORCH.get());
			//@formatter:on
		}

		return placeEntries;
	}
}
