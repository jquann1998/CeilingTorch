package bl4ckscor3.mod.ceilingtorch.compat.moshiz;

import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class MoShizCompatClient {
	public static void addListeners() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(MoShizCompatClient::onParticleFactoryRegister);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(MoShizCompatClient::onColorHandlerBlock);
	}

	public static void onParticleFactoryRegister(RegisterParticleProvidersEvent event) {
		event.register(MoShizCompat.DYED_CEILING_FLAME.get(), DyedCeilingFlameParticle.Factory::new);
		event.register(MoShizCompat.DYED_CEILING_SMOKE.get(), DyedCeilingSmokeParticle.Factory::new);
	}

	public static void onColorHandlerBlock(RegisterColorHandlersEvent.Block event) {
		MoShizCompat.ceilingTorchParticleColors.forEach((torch, color) -> event.register((state, level, pos, tintIndex) -> color, torch));
	}
}
