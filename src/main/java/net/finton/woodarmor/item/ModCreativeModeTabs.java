package net.finton.woodarmor.item;

import net.finton.woodarmor.WoodArmorMod;
import net.finton.woodarmor.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WoodArmorMod.MOD_ID);

public static final RegistryObject<CreativeModeTab> WOOD_ARMOR_TAB = CREATIVE_MODE_TABS.register("wood_armor_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WOOD_PIECE.get()))
                .title(Component.translatable("creativetab.wood_armor_tab"))
                .displayItems((displayParameters, output) -> {
                    output.accept(ModItems.WOOD_PIECE.get());
                    output.accept(ModItems.STONE_INGOT.get());
                    output.accept(ModItems.RAW_STONE_STEEL.get());
                    output.accept(ModItems.STONE_STEEL.get());

                    output.accept(ModBlocks.WOOD_PIECE_BUNDLE.get());
                    output.accept(ModBlocks.RAW_STONE_STEEL_BLOCK.get());
                    output.accept(ModBlocks.STONE_STEEL_BLOCK.get());
                    output.accept(ModBlocks.SOUND_BLOCK.get());


                    output.accept(ModBlocks.STONE_STEEL_ORE.get());
                    output.accept(ModBlocks.DEEPSLATE_STONE_STEEL_ORE.get());

                    //output.accept(ModItems.STONE_HELMET.get());
                    //output.accept(ModItems.STONE_CHESTPLATE.get());
                    //output.accept(ModItems.STONE_LEGGINGS.get());
                    //output.accept(ModItems.STONE_BOOTS.get());

                    output.accept(ModItems.METAL_DETECTOR.get());
                    output.accept(ModItems.WOOD_CHIPS.get());

                }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
