package de.hasenchamp.tutorialmod.item;

import de.hasenchamp.tutorialmod.TutorialMod;
import de.hasenchamp.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> Hasenchampionite_Items_Tab = CREATIVE_MODE_TAB.register("hasenchamionite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Hasenchampionite.get()))
                    .title(Component.translatable("creativetab.tutorialmod.hasenchampionite_items"))
                    .displayItems((itemDisplayParameters, output) ->
                    {
                        output.accept(ModItems.Hasenchampionite.get());
                        output.accept(ModItems.Raw_Hasenchampionite.get());
                        output.accept(ModItems.Chisel.get());
                        output.accept(ModItems.KOHLRABI.get());
                        output.accept(ModItems.AURORA_ASHES.get());
                    })
                    .build());
public static final RegistryObject<CreativeModeTab> Hasenchampionite_Blocks_Tab = CREATIVE_MODE_TAB.register("hasenchamionite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.Hasenchampionite_Block.get()))
                    .title(Component.translatable("creativetab.tutorialmod.hasenchampionite_blocks"))
                    .displayItems((itemDisplayParameters, output) ->
                    {
                        output.accept(ModBlocks.Hasenchampionite_Block.get());
                        output.accept(ModBlocks.Raw_Hasenchampionite_Block.get());

                        output.accept(ModBlocks.Hasenchampionite_Ore.get());
                        output.accept(ModBlocks.Hasenchampionite_Deepslate_Ore.get());

                        output.accept(ModBlocks.MAGIC_BLOCK.get());


                    })
                    .build());


    public static void register(IEventBus eventBus)
    {
     CREATIVE_MODE_TAB.register(eventBus);
    }
}
