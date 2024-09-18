package de.hasenchamp.tutorialmod.item;

import de.hasenchamp.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> Hasenchampionite = Items.register("hasenchampionite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Raw_Hasenchampionite = Items.register("raw_hasenchampionite",
            () -> new Item(new Item.Properties()));

    public static void register (IEventBus eventBus)
    {
     Items.register(eventBus);
    }
}
