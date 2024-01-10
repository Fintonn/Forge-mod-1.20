package net.finton.woodarmor.datagen.loot;

import net.finton.woodarmor.block.ModBlocks;
import net.finton.woodarmor.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.WOOD_PIECE_BUNDLE.get());
        this.dropSelf(ModBlocks.RAW_STONE_STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.STONE_STEEL_BLOCK.get());

        this.add(ModBlocks.STONE_STEEL_ORE.get(),
                block -> createOreDrop(ModBlocks.STONE_STEEL_ORE.get(), ModItems.RAW_STONE_STEEL.get()));
        this.add(ModBlocks.DEEPSLATE_STONE_STEEL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_STONE_STEEL_ORE.get(), ModItems.RAW_STONE_STEEL.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
