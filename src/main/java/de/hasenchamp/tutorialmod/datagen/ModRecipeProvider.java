package de.hasenchamp.tutorialmod.datagen;

import de.hasenchamp.tutorialmod.TutorialMod;
import de.hasenchamp.tutorialmod.block.ModBlocks;
import de.hasenchamp.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> Hasenchampionte_Smeltable = List.of(ModItems.Raw_Hasenchampionite.get(),
                ModBlocks.Hasenchampionite_Ore.get(), ModBlocks.Hasenchampionite_Deepslate_Ore.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.Hasenchampionite_Block.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.Hasenchampionite.get())
                .unlockedBy(getHasName(ModItems.Hasenchampionite.get()), has(ModItems.Hasenchampionite.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Hasenchampionite.get(), 9)
                .requires(ModBlocks.Hasenchampionite_Block.get())
                .unlockedBy(getHasName(ModBlocks.Hasenchampionite_Block.get()), has(ModBlocks.Hasenchampionite_Block.get())).save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Hasenchampionite.get(), 32)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MAGIC_BLOCK.get()), has(ModBlocks.MAGIC_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":hasenchampionite_from_magic_block");
        // nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.Raw_Hasenchampionite.get(), RecipeCategory.MISC, ModBlocks.Raw_Hasenchampionite_Block.get());

        oreSmelting(pRecipeOutput, Hasenchampionte_Smeltable, RecipeCategory.MISC, ModItems.Hasenchampionite.get(), 0.25f, 200, "hasenchampionite");
        oreBlasting(pRecipeOutput, Hasenchampionte_Smeltable, RecipeCategory.MISC, ModItems.Hasenchampionite.get(), 0.25f, 100, "hasenchampionite");
    }
    protected static void oreSmelting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(
            RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix
    ) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
}
