package twilightforest.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.resources.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.loading.FMLPaths;
import twilightforest.TwilightForestMod;
import twilightforest.client.renderer.entity.LayerIce;
import twilightforest.client.renderer.entity.LayerShields;
import twilightforest.entity.TFEntities;
import twilightforest.inventory.TFContainers;
import twilightforest.item.ItemTFArcticArmor;
import twilightforest.item.ItemTFFieryArmor;
import twilightforest.item.ItemTFKnightlyArmor;
import twilightforest.item.ItemTFPhantomArmor;
import twilightforest.item.ItemTFYetiArmor;
import twilightforest.item.TFItems;
import twilightforest.tileentity.TFTileEntities;
import twilightforest.world.TFDimensions;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TFClientSetup {
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent evt) {
		TFItems.addItemModelProperties();

		ItemTFKnightlyArmor.initArmorModel();
		ItemTFPhantomArmor.initArmorModel();
		ItemTFYetiArmor.initArmorModel();
		ItemTFArcticArmor.initArmorModel();
		ItemTFFieryArmor.initArmorModel();
		// FIXME MinecraftForge.EVENT_BUS.register(new LoadingScreenListener());
		RenderLayerRegistration.init();
		TFEntities.registerEntityRenderer();
		TFTileEntities.registerTileEntityRenders();
		TFContainers.renderScreens();

		TwilightForestRenderInfo renderInfo = new TwilightForestRenderInfo(128.0F, false, DimensionRenderInfo.FogType.NONE, false, false);
		DimensionRenderInfo.field_239208_a_.put(TwilightForestMod.prefix("renderer"), renderInfo);
	}

	public static void addLegacyPack() {
		Minecraft.getInstance().getResourcePackList().addPackFinder(
				(consumer, iFactory) -> consumer.accept(
						ResourcePackInfo.createResourcePack(
								TwilightForestMod.prefix("classic_textures").toString(),
								false,
								() -> new TwilightLegacyPack(
										ModList
												.get()
												.getModFileById(TwilightForestMod.ID)
												.getFile()
								),
								iFactory,
								ResourcePackInfo.Priority.TOP,
								iTextComponent -> iTextComponent
						)
				)
		);
	}

	@SubscribeEvent // FIXME there's a few IDE warnings, find out what this is all about
	public static void loadComplete(FMLLoadCompleteEvent evt) {
		Minecraft.getInstance().getRenderManager().renderers.values().forEach(r -> {
			if (r instanceof LivingRenderer) {
				((LivingRenderer) r).addLayer(new LayerShields((LivingRenderer) r));
				((LivingRenderer) r).addLayer(new LayerIce((LivingRenderer) r));
			}
		});
	}
}
