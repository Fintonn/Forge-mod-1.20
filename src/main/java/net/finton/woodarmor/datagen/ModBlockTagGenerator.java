package net.finton.woodarmor.datagen;

import net.finton.woodarmor.WoodArmorMod;
import net.finton.woodarmor.block.ModBlocks;
import net.finton.woodarmor.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WoodArmorMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.STONE_STEEL_ORE.get()).addTags(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.STONE_STEEL_BLOCK.get(),
                    ModBlocks.RAW_STONE_STEEL_BLOCK.get(),
                    ModBlocks.STONE_STEEL_ORE.get(),
                    ModBlocks.DEEPSLATE_STONE_STEEL_ORE.get(),
                    ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STONE_STEEL_BLOCK.get(),
                        ModBlocks.RAW_STONE_STEEL_BLOCK.get(),
                        ModBlocks.STONE_STEEL_ORE.get(),
                        ModBlocks.DEEPSLATE_STONE_STEEL_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.DEEPSLATE_STONE_STEEL_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.WOOD_PIECE_SLAB.get(),
                        ModBlocks.WOOD_PIECE_STAIRS.get(),
                        ModBlocks.WOOD_PIECE_BUNDLE.get());
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
