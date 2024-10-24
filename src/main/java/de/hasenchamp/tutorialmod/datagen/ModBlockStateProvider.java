package de.hasenchamp.tutorialmod.datagen;


import de.hasenchamp.tutorialmod.TutorialMod;
import de.hasenchamp.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.Hasenchampionite_Block);
        blockWithItem(ModBlocks.Raw_Hasenchampionite_Block);

        blockWithItem(ModBlocks.Hasenchampionite_Ore);
        blockWithItem(ModBlocks.Hasenchampionite_Deepslate_Ore);

        blockWithItem(ModBlocks.MAGIC_BLOCK);


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
