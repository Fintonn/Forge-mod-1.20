package net.finton.woodarmor.item;

import net.finton.woodarmor.WoodArmorMod;
import net.finton.woodarmor.item.custom.FuelItem;
import net.finton.woodarmor.item.custom.MetalDetectorItem;
import net.finton.woodarmor.item.custom.ModFoodProperties;
import net.finton.woodarmor.item.custom.ModToolTiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WoodArmorMod.MOD_ID);

    public static final RegistryObject<Item> WOOD_PIECE = ITEMS.register("wood_piece",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STONE_INGOT = ITEMS.register("stone_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_STONE_STEEL = ITEMS.register("raw_stone_steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STONE_STEEL = ITEMS.register("stone_steel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STONE_STEEL_SWORD = ITEMS.register("stone_steel_sword",
            () -> new SwordItem(ModToolTiers.STONE_STEEL, 1, 1, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> STONE_STEEL_PICKAXE = ITEMS.register("stone_steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_STEEL, 1, 1, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> STONE_STEEL_AXE = ITEMS.register("stone_steel_axe",
            () -> new AxeItem(ModToolTiers.STONE_STEEL, 5, 1, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> STONE_STEEL_HOE = ITEMS.register("stone_steel_hoe",
            () -> new HoeItem(ModToolTiers.STONE_STEEL, 1, 1, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> STONE_STEEL_SHOVEL = ITEMS.register("stone_steel_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_STEEL, 1, 1, new Item.Properties().durability(256)));



    //public static final RegistryObject<Item> STONE_HELMET = ITEMS.register("stone_helmet",
            //() -> new ArmorItem(ModArmorMaterials.STONE, ArmorItem.Type.HELMET, new Item.Properties()));
   // public static final RegistryObject<Item> STONE_CHESTPLATE = ITEMS.register("stone_chestplate",
        //() -> new ArmorItem(ModArmorMaterials.STONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
   // public static final RegistryObject<Item> STONE_LEGGINGS = ITEMS.register("stone_leggings",
           // () -> new ArmorItem(ModArmorMaterials.STONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
   // public static final RegistryObject<Item> STONE_BOOTS = ITEMS.register("stone_boots",
           // () -> new ArmorItem(ModArmorMaterials.STONE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(512)));

    public static final RegistryObject<Item> WOOD_CHIPS = ITEMS.register("wood_chips",
            () -> new Item(new Item.Properties().food(ModFoodProperties.WOOD_CHIPS)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
