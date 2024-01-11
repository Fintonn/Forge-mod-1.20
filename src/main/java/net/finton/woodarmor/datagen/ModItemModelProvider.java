package net.finton.woodarmor.datagen;

import net.finton.woodarmor.WoodArmorMod;
import net.finton.woodarmor.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WoodArmorMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.STONE_STEEL);
        simpleItem(ModItems.RAW_STONE_STEEL);
        simpleItem(ModItems.WOOD_PIECE);
        simpleItem(ModItems.STONE_INGOT);
        simpleItem(ModItems.WOOD_CHIPS);

        handheldItem(ModItems.STONE_STEEL_SWORD);
        handheldItem(ModItems.STONE_STEEL_PICKAXE);
        handheldItem(ModItems.STONE_STEEL_AXE);
        handheldItem(ModItems.STONE_STEEL_SHOVEL);
        handheldItem(ModItems.STONE_STEEL_HOE);

        simpleItem(ModItems.METAL_DETECTOR);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(WoodArmorMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(WoodArmorMod.MOD_ID,"item/" + item.getId().getPath()));
    }

}
