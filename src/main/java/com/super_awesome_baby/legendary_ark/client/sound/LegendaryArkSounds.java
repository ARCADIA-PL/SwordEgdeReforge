package com.super_awesome_baby.legendary_ark.client.sound;

import com.super_awesome_baby.legendary_ark.LegendaryArk;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LegendaryArkSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LegendaryArk.MOD_ID);
    private static RegistryObject<SoundEvent> registerSound(String name) {
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath(LegendaryArk.MOD_ID, name);
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(resourceLocation));

    }
}
