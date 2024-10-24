package de.hasenchamp.tutorialmod.item;

import de.hasenchamp.tutorialmod.TutorialMod;
import de.hasenchamp.tutorialmod.item.custom.ChiselItem;
import de.hasenchamp.tutorialmod.item.custom.FuelItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.minecraft.world.entity.ai.attributes.Attributes.*;

public class ModItems
{
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> Hasenchampionite = Items.register("hasenchampionite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Raw_Hasenchampionite = Items.register("raw_hasenchampionite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Chisel = Items.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> KOHLRABI = Items.register("kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodPorperties.KOHLRABI)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    if (Screen.hasShiftDown()) {
                        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.kohlrabi.shift_down"));
                    }
                    else {
                        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.kohlrabi"));
                    }
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> AURORA_ASHES = Items.register("aurora_ashes",
            () -> new FuelItem(new Item.Properties(), 2400));


    public static void register (IEventBus eventBus)
    {
     Items.register(eventBus);
    }
}
