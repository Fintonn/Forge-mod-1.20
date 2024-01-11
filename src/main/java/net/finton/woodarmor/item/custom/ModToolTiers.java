package net.finton.woodarmor.item.custom;

import net.finton.woodarmor.WoodArmorMod;
import net.finton.woodarmor.item.ModItems;
import net.finton.woodarmor.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier STONE_STEEL = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1030, 5.0f, 2.5f, 12,
                    ModTags.Blocks.NEED_STONE_STEEL_TOOL, () -> Ingredient.of(ModItems.STONE_STEEL.get())),
            new ResourceLocation(WoodArmorMod.MOD_ID, "stone_steel"), List.of(Tiers.IRON), List.of());
}
