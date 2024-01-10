package net.finton.woodarmor.datagen;

import net.finton.woodarmor.WoodArmorMod;
import net.finton.woodarmor.block.ModBlocks;
import net.finton.woodarmor.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> STONE_STEEL_SMELTABLES = List.of(ModItems.RAW_STONE_STEEL.get(),
            ModBlocks.STONE_STEEL_ORE.get(), ModBlocks.DEEPSLATE_STONE_STEEL_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) { super(pOutput); }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WOOD_PIECE_BUNDLE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.WOOD_PIECE.get())
                .unlockedBy("has_wood_piece", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.WOOD_PIECE.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WOOD_PIECE.get(), 9)
                .requires(ModBlocks.WOOD_PIECE_BUNDLE.get())
                .unlockedBy("has_wood_piece_bundle", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.WOOD_PIECE_BUNDLE.get()).build()))
                .save(pWriter);
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_STONE_STEEL.get(), RecipeCategory.MISC, ModBlocks.RAW_STONE_STEEL_BLOCK.get(),
                "woodarmor:raw_stone_steel", "stone_steel", "woodarmor:raw_stone_steel_block", "stone_steel");

        oreSmelting(pWriter, STONE_STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STONE_STEEL.get(), 0.25f, 200, "stone_steel");
        oreBlasting(pWriter, STONE_STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STONE_STEEL.get(), 0.25f, 100, "stone_steel");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                    pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, WoodArmorMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
