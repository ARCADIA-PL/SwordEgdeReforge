package com.super_awesome_baby.legendary_ark.init;

import com.super_awesome_baby.legendary_ark.LegendaryArk;
import com.super_awesome_baby.legendary_ark.item.AsDemonItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import yesman.epicfight.world.item.WeaponItem;

public class LegendaryArkItem {
    public static final DeferredRegister<net.minecraft.world.item.Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, LegendaryArk.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> EFJ_ITEM_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LegendaryArk.MOD_ID);

    public static final RegistryObject<WeaponItem> AS_DEMON = ITEM.register("as_demon", () ->
            new AsDemonItem(Tiers.NETHERITE, 2, -2.4F, new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

    public static final RegistryObject<CreativeModeTab> ITEM_TAB_MAIN = EFJ_ITEM_TAB.register("legendary_ark_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.legendary_ark.items"))
            .icon(() -> new ItemStack(AS_DEMON.get()))
            .displayItems((parameters, tabData) -> {
                tabData.accept(AS_DEMON.get());
            }).build());

    public static void register(IEventBus eventBus) {
        ITEM.register(eventBus);
    }
}
