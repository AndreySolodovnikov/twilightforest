package twilightforest.data;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;

public class BlockTagGenerator extends BlockTagsProvider {
	public static final ITag.INamedTag<Block> TOWERWOOD = BlockTags.makeWrapperTag(TwilightForestMod.prefix("towerwood").toString());

	public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ARCTIC_FUR = BlockTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/arctic_fur").toString());
	public static final ITag.INamedTag<Block> STORAGE_BLOCKS_CARMINITE = BlockTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/carminite").toString());
	public static final ITag.INamedTag<Block> STORAGE_BLOCKS_FIERY = BlockTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/fiery").toString());
	public static final ITag.INamedTag<Block> STORAGE_BLOCKS_IRONWOOD = BlockTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/ironwood").toString());
	public static final ITag.INamedTag<Block> STORAGE_BLOCKS_KNIGHTMETAL = BlockTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/knightmetal").toString());
	public static final ITag.INamedTag<Block> STORAGE_BLOCKS_STEELEAF = BlockTags.makeWrapperTag(TwilightForestMod.prefix("storage_blocks/steeleaf").toString());

	public static final ITag.INamedTag<Block> ORES_IRONWOOD = BlockTags.makeWrapperTag(TwilightForestMod.prefix("ores/ironwood").toString());
	public static final ITag.INamedTag<Block> ORES_KNIGHTMETAL = BlockTags.makeWrapperTag(TwilightForestMod.prefix("ores/knightmetal").toString());

	public BlockTagGenerator(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void registerTags() {
		getOrCreateBuilder(BlockTags.WOODEN_FENCES)
				.add(TFBlocks.twilight_oak_fence.get(), TFBlocks.canopy_fence.get(), TFBlocks.mangrove_fence.get(), TFBlocks.dark_fence.get())
				.add(TFBlocks.time_fence.get(), TFBlocks.trans_fence.get(), TFBlocks.mine_fence.get(), TFBlocks.sort_fence.get());
		getOrCreateBuilder(BlockTags.FENCE_GATES)
				.add(TFBlocks.twilight_oak_gate.get(), TFBlocks.canopy_gate.get(), TFBlocks.mangrove_gate.get(), TFBlocks.dark_gate.get())
				.add(TFBlocks.time_gate.get(), TFBlocks.trans_gate.get(), TFBlocks.mine_gate.get(), TFBlocks.sort_gate.get());
		getOrCreateBuilder(BlockTags.WOODEN_DOORS)
				.add(TFBlocks.twilight_oak_door.get(), TFBlocks.canopy_door.get(), TFBlocks.mangrove_door.get(), TFBlocks.dark_door.get())
				.add(TFBlocks.time_door.get(), TFBlocks.trans_door.get(), TFBlocks.mine_door.get(), TFBlocks.sort_door.get());
		getOrCreateBuilder(BlockTags.WOODEN_SLABS)
				.add(TFBlocks.twilight_oak_slab.get(), TFBlocks.canopy_slab.get(), TFBlocks.mangrove_slab.get(), TFBlocks.dark_slab.get())
				.add(TFBlocks.time_slab.get(), TFBlocks.trans_slab.get(), TFBlocks.mine_slab.get(), TFBlocks.sort_slab.get());
		getOrCreateBuilder(BlockTags.WOODEN_STAIRS)
				.add(TFBlocks.twilight_oak_stairs.get(), TFBlocks.canopy_stairs.get(), TFBlocks.mangrove_stairs.get(), TFBlocks.dark_stairs.get())
				.add(TFBlocks.time_stairs.get(), TFBlocks.trans_stairs.get(), TFBlocks.mine_stairs.get(), TFBlocks.sort_stairs.get());
		// vanilla slab/stair tags don't include the wooden subtags by default, so we have to add them again >.>
		getOrCreateBuilder(BlockTags.SLABS)
				.add(TFBlocks.aurora_slab.get())
				.add(TFBlocks.twilight_oak_slab.get(), TFBlocks.canopy_slab.get(), TFBlocks.mangrove_slab.get(), TFBlocks.dark_slab.get())
				.add(TFBlocks.time_slab.get(), TFBlocks.trans_slab.get(), TFBlocks.mine_slab.get(), TFBlocks.sort_slab.get());
		getOrCreateBuilder(BlockTags.STAIRS)
				.add(TFBlocks.castle_stairs_brick.get(), TFBlocks.castle_stairs_worn.get(), TFBlocks.castle_stairs_cracked.get(), TFBlocks.castle_stairs_mossy.get(), TFBlocks.castle_stairs_encased.get(), TFBlocks.castle_stairs_bold.get())
				.add(TFBlocks.nagastone_stairs_left.get(), TFBlocks.nagastone_stairs_right.get(), TFBlocks.nagastone_stairs_mossy_left.get(), TFBlocks.nagastone_stairs_mossy_right.get(), TFBlocks.nagastone_stairs_weathered_left.get(), TFBlocks.nagastone_stairs_weathered_right.get())
				.add(TFBlocks.twilight_oak_stairs.get(), TFBlocks.canopy_stairs.get(), TFBlocks.mangrove_stairs.get(), TFBlocks.dark_stairs.get())
				.add(TFBlocks.time_stairs.get(), TFBlocks.trans_stairs.get(), TFBlocks.mine_stairs.get(), TFBlocks.sort_stairs.get());
		getOrCreateBuilder(BlockTags.WOODEN_BUTTONS)
				.add(TFBlocks.twilight_oak_button.get(), TFBlocks.canopy_button.get(), TFBlocks.mangrove_button.get(), TFBlocks.dark_button.get())
				.add(TFBlocks.time_button.get(), TFBlocks.trans_button.get(), TFBlocks.mine_button.get(), TFBlocks.sort_button.get());
		getOrCreateBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
				.add(TFBlocks.twilight_oak_plate.get(), TFBlocks.canopy_plate.get(), TFBlocks.mangrove_plate.get(), TFBlocks.dark_plate.get())
				.add(TFBlocks.time_plate.get(), TFBlocks.trans_plate.get(), TFBlocks.mine_plate.get(), TFBlocks.sort_plate.get());
		getOrCreateBuilder(BlockTags.WOODEN_TRAPDOORS)
				.add(TFBlocks.twilight_oak_trapdoor.get(), TFBlocks.canopy_trapdoor.get(), TFBlocks.mangrove_trapdoor.get(), TFBlocks.dark_trapdoor.get())
				.add(TFBlocks.time_trapdoor.get(), TFBlocks.trans_trapdoor.get(), TFBlocks.mine_trapdoor.get(), TFBlocks.sort_trapdoor.get());
		getOrCreateBuilder(BlockTags.LEAVES)
				.add(TFBlocks.rainboak_leaves.get(), TFBlocks.oak_leaves.get(), TFBlocks.canopy_leaves.get(), TFBlocks.mangrove_leaves.get(), TFBlocks.dark_leaves.get())
				.add(TFBlocks.time_leaves.get(), TFBlocks.transformation_leaves.get(), TFBlocks.mining_leaves.get(), TFBlocks.sorting_leaves.get())
				.add(TFBlocks.thorn_leaves.get(), TFBlocks.beanstalk_leaves.get(), TFBlocks.giant_leaves.get());
		getOrCreateBuilder(BlockTags.LOGS)
				.add(TFBlocks.oak_log.get(), TFBlocks.canopy_log.get(), TFBlocks.mangrove_log.get(), TFBlocks.dark_log.get())
				.add(TFBlocks.time_log.get(), TFBlocks.transformation_log.get(), TFBlocks.mining_log.get(), TFBlocks.sorting_log.get());
		getOrCreateBuilder(BlockTags.PLANKS)
				.add(TFBlocks.twilight_oak_planks.get(), TFBlocks.canopy_planks.get(), TFBlocks.mangrove_planks.get(), TFBlocks.dark_planks.get())
				.add(TFBlocks.time_planks.get(), TFBlocks.trans_planks.get(), TFBlocks.mine_planks.get(), TFBlocks.sort_planks.get())
				.add(TFBlocks.tower_wood.get(), TFBlocks.tower_wood_encased.get(), TFBlocks.tower_wood_cracked.get(), TFBlocks.tower_wood_mossy.get(), TFBlocks.tower_wood_infested.get());
		getOrCreateBuilder(BlockTags.SAPLINGS)
				.add(TFBlocks.oak_sapling.get(), TFBlocks.canopy_sapling.get(), TFBlocks.mangrove_sapling.get(), TFBlocks.darkwood_sapling.get())
				.add(TFBlocks.time_sapling.get(), TFBlocks.transformation_sapling.get(), TFBlocks.mining_sapling.get(), TFBlocks.sorting_sapling.get())
				.add(TFBlocks.hollow_oak_sapling.get(), TFBlocks.rainboak_sapling.get());

		getOrCreateBuilder(BlockTags.BEACON_BASE_BLOCKS).add(
				TFBlocks.knightmetal_block.get(),
				TFBlocks.ironwood_block.get(),
				TFBlocks.fiery_block.get(),
				TFBlocks.steeleaf_block.get(),
				TFBlocks.arctic_fur_block.get(),
				TFBlocks.carminite_block.get()
		);

		getOrCreateBuilder(TOWERWOOD).add(TFBlocks.tower_wood.get(), TFBlocks.tower_wood_mossy.get(), TFBlocks.tower_wood_cracked.get(), TFBlocks.tower_wood_infested.get());

		getOrCreateBuilder(STORAGE_BLOCKS_ARCTIC_FUR).add(TFBlocks.arctic_fur_block.get());
		getOrCreateBuilder(STORAGE_BLOCKS_CARMINITE).add(TFBlocks.carminite_block.get());
		getOrCreateBuilder(STORAGE_BLOCKS_FIERY).add(TFBlocks.fiery_block.get());
		getOrCreateBuilder(STORAGE_BLOCKS_IRONWOOD).add(TFBlocks.ironwood_block.get());
		getOrCreateBuilder(STORAGE_BLOCKS_KNIGHTMETAL).add(TFBlocks.knightmetal_block.get());
		getOrCreateBuilder(STORAGE_BLOCKS_STEELEAF).add(TFBlocks.steeleaf_block.get());

		getOrCreateBuilder(ORES_IRONWOOD);
		getOrCreateBuilder(ORES_KNIGHTMETAL);
	}
}
