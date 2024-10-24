package de.hasenchamp.tutorialmod.datagen;

import de.hasenchamp.tutorialmod.TutorialMod;
import de.hasenchamp.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.Hasenchampionite.get());
        basicItem(ModItems.Raw_Hasenchampionite.get());
        basicItem(ModItems.Chisel.get());
        basicItem(ModItems.KOHLRABI.get());
        basicItem(ModItems.AURORA_ASHES.get());
    }
}
