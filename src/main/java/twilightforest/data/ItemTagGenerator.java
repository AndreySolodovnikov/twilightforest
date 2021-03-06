package twilightforest.data;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;

public class ItemTagGenerator extends ItemTagsProvider {
	public static final ITag.INamedTag<Item> PAPER = ItemTags.makeWrapperTag("forge:paper");
	public static final ITag.INamedTag<Item> FEATHER = ItemTags.makeWrapperTag("forge:feather");

	public static final ITag.INamedTag<Item> TOWERWOOD = ItemTags.makeWrapperTag(TwilightForestMod.prefix("towerwood").toString());

	public static final ITag.INamedTag<Item> FIERY_VIAL = ItemTags.makeWrapperTag(TwilightForestMod.prefix("fiery_vial").toString());

	public static final ITag.INamedTag<Item> ARCTIC_FUR = ItemTags.makeWrapperTag(TwilightForestMod.prefix("arctic_fur").toString());
	public static final ITag.INamedTag<Item> CARMINITE_GEMS = ItemTags.makeWrapperTag(TwilightForestMod.prefix("gems/carminite").toString());
	public static final ITag.INamedTag<Item> FIERY_INGOTS = ItemTags.makeWrapperTag(TwilightForestMod.prefix("ingots/fiery").toString());
	public static final ITag.INamedTag<Item> IRONWOOD_INGOTS = ItemTags.makeWrapperTag(TwilightForestMod.prefix("ingots/ironwood").toString());
	public static final ITag.INamedTag<Item> KNIGHTMETAL_INGOTS = ItemTags.makeWrapperTag(TwilightForestMod.prefix("ingots/knightmetal").toString());
	public static final ITag.INamedTag<Item> STEELEAF_INGOTS = ItemTags.makeWrapperTag(TwilightForestMod.prefix("ingots/steeleaf").toString());

	public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ARCTIC_FUR = ItemTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/arctic_fur").toString());
	public static final ITag.INamedTag<Item> STORAGE_BLOCKS_CARMINITE = ItemTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/carminite").toString());
	public static final ITag.INamedTag<Item> STORAGE_BLOCKS_FIERY = ItemTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/fiery").toString());
	public static final ITag.INamedTag<Item> STORAGE_BLOCKS_IRONWOOD = ItemTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/ironwood").toString());
	public static final ITag.INamedTag<Item> STORAGE_BLOCKS_KNIGHTMETAL = ItemTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/knightmetal").toString());
	public static final ITag.INamedTag<Item> STORAGE_BLOCKS_STEELEAF = ItemTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/steeleaf").toString());

	public static final ITag.INamedTag<Item> ORES_IRONWOOD = ItemTags.makeWrapperTag(TwilightForestMod.prefix("ores/ironwood").toString());
	public static final ITag.INamedTag<Item> ORES_KNIGHTMETAL = ItemTags.makeWrapperTag(TwilightForestMod.prefix("ores/knightmetal").toString());

	public ItemTagGenerator(DataGenerator generator, BlockTagsProvider blockprovider) {
		super(generator, blockprovider);
	}

	@Override
	protected void registerTags() {
		this.copy(BlockTags.WOODEN_FENCES, Tags.Items.FENCES_WOODEN);
		this.copy(BlockTags.FENCE_GATES, Tags.Items.FENCE_GATES_WOODEN);
		this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
		this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
		this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
		this.copy(BlockTags.SLABS, ItemTags.SLABS);
		this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
		this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
		this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
		this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
		this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
		this.copy(BlockTags.LOGS, ItemTags.LOGS);
		this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
		this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

		this.copy(BlockTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR, ItemTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_CARMINITE, ItemTagGenerator.STORAGE_BLOCKS_CARMINITE);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_FIERY, ItemTagGenerator.STORAGE_BLOCKS_FIERY);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_IRONWOOD, ItemTagGenerator.STORAGE_BLOCKS_IRONWOOD);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL, ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL);
		this.copy(BlockTagGenerator.STORAGE_BLOCKS_STEELEAF, ItemTagGenerator.STORAGE_BLOCKS_STEELEAF);

		this.copy(BlockTagGenerator.ORES_IRONWOOD, ItemTagGenerator.ORES_IRONWOOD);
		this.copy(BlockTagGenerator.ORES_KNIGHTMETAL, ItemTagGenerator.ORES_KNIGHTMETAL);

		this.copy(BlockTagGenerator.TOWERWOOD, ItemTagGenerator.TOWERWOOD);

		getOrCreateBuilder(PAPER).add(Items.PAPER);
		getOrCreateBuilder(FEATHER).add(Items.FEATHER).add(TFItems.raven_feather.get());

		getOrCreateBuilder(FIERY_VIAL).add(TFItems.fiery_blood.get(), TFItems.fiery_tears.get());

		getOrCreateBuilder(ARCTIC_FUR).add(TFItems.arctic_fur.get());
		getOrCreateBuilder(CARMINITE_GEMS).add(TFItems.carminite.get());
		getOrCreateBuilder(FIERY_INGOTS).add(TFItems.fiery_ingot.get());
		getOrCreateBuilder(IRONWOOD_INGOTS).add(TFItems.ironwood_ingot.get());
		getOrCreateBuilder(KNIGHTMETAL_INGOTS).add(TFItems.knightmetal_ingot.get());
		getOrCreateBuilder(STEELEAF_INGOTS).add(TFItems.steeleaf_ingot.get());

		getOrCreateBuilder(ORES_IRONWOOD).add(TFItems.ironwood_raw.get());
		getOrCreateBuilder(ORES_KNIGHTMETAL).add(TFItems.armor_shard_cluster.get());
	}
}
