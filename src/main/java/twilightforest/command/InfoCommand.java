package twilightforest.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import twilightforest.TFFeature;

public class InfoCommand {
    public static LiteralArgumentBuilder<CommandSource> register() {
        return Commands.literal("info").executes(InfoCommand::run);
    }

    private static int run(CommandContext<CommandSource> ctx) throws CommandSyntaxException {
        CommandSource source = ctx.getSource();

        if (!TFWorld.isTwilightForest(source.getWorld())) {
            throw TFCommand.NOT_IN_TF.create();
        }

        BlockPos pos = new BlockPos(source.getPos());

        // nearest feature
        TFFeature nearbyFeature = TFFeature.getFeatureAt(pos.getX(), pos.getZ(), source.getWorld());
        source.sendFeedback(new TranslationTextComponent("commands.tffeature.nearest", nearbyFeature.name), false);

        // are you in a structure?
        ChunkGeneratorTFBase chunkGenerator = TFWorld.getChunkGenerator(source.getWorld());
        if (chunkGenerator != null && chunkGenerator.isBlockInStructureBB(pos)) {
            source.sendFeedback(new TranslationTextComponent("commands.tffeature.structure.inside"), false);

            source.sendFeedback(new TranslationTextComponent("commands.tffeature.structure.conquer.status", chunkGenerator.isStructureConquered(pos)), false);
            // are you in a room?

            // what is the spawn list
//						List<SpawnListEntry> spawnList = chunkGenerator.getPossibleCreatures(EnumCreatureType.monster, dx, dy, dz);
//						sender.sendMessage(new TextComponentTranslation("Spawn list for the area is:"));
//						for (SpawnListEntry entry : spawnList) {
//							sender.sendMessage(new TextComponentTranslation(entry.toString()));
//						}
        } else {
            source.sendFeedback(new TranslationTextComponent("commands.tffeature.structure.outside"), false);
        }

        return Command.SINGLE_SUCCESS;
    }

}
