package de.hasenchamp.tutorialmod.datagen;

import de.hasenchamp.tutorialmod.TutorialMod;
import de.hasenchamp.tutorialmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.Hasenchampionite_Block.get())
                .add(ModBlocks.Raw_Hasenchampionite_Block.get())
                .add(ModBlocks.Hasenchampionite_Ore.get())
                .add(ModBlocks.Hasenchampionite_Deepslate_Ore.get())
                .add(ModBlocks.MAGIC_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.Hasenchampionite_Deepslate_Ore.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get());

    }

}
