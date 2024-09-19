package de.hasenchamp.tutorialmod.block;


import de.hasenchamp.tutorialmod.TutorialMod;
import de.hasenchamp.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID );

    public static final RegistryObject<Block> Hasenchampionite_Block = registerBlock("hasenchampionite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> Raw_Hasenchampionite_Block = registerBlock("raw_hasenchampionite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> Hasenchampionite_Ore = registerBlock("hasenchampionite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),BlockBehaviour.Properties.of()
                    .strength(1.5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> Hasenchampionite_Deepslate_Ore = registerBlock("hasenchampionite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7),BlockBehaviour.Properties.of()
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Blocks.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register (IEventBus eventBus)
    {
        Blocks.register(eventBus);
    }
}
