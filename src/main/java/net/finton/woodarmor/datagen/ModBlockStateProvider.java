package net.finton.woodarmor.datagen;

import net.finton.woodarmor.WoodArmorMod;
import net.finton.woodarmor.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WoodArmorMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.WOOD_PIECE_BUNDLE);
        blockWithItem(ModBlocks.RAW_STONE_STEEL_BLOCK);

        blockWithItem(ModBlocks.STONE_STEEL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_STONE_STEEL_ORE);

    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
