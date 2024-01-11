package net.finton.woodarmor.datagen;

import net.finton.woodarmor.WoodArmorMod;
import net.finton.woodarmor.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WoodArmorMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.WOOD_PIECE_BUNDLE);
        blockWithItem(ModBlocks.RAW_STONE_STEEL_BLOCK);
        blockWithItem(ModBlocks.STONE_STEEL_BLOCK);
        blockWithItem(ModBlocks.SOUND_BLOCK);

        blockWithItem(ModBlocks.STONE_STEEL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_STONE_STEEL_ORE);

        stairsBlock((StairBlock) ModBlocks.WOOD_PIECE_STAIRS.get(), blockTexture(ModBlocks.WOOD_PIECE_BUNDLE.get()));
        slabBlock(((SlabBlock) ModBlocks.WOOD_PIECE_SLAB.get()), blockTexture(ModBlocks.WOOD_PIECE_BUNDLE.get()), blockTexture(ModBlocks.WOOD_PIECE_BUNDLE.get()));

        blockItem(ModBlocks.WOOD_PIECE_SLAB);
        blockItem(ModBlocks.WOOD_PIECE_STAIRS);

    }



    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("woodarmor:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
