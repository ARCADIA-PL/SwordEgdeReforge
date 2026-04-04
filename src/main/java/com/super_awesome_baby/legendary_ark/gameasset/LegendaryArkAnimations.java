package com.super_awesome_baby.legendary_ark.gameasset;

import com.super_awesome_baby.legendary_ark.LegendaryArk;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.AnimationManager;

@Mod.EventBusSubscriber(modid = LegendaryArk.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LegendaryArkAnimations {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(LegendaryArk.MOD_ID, LegendaryArkAnimations::build);
    }

    private static void build(AnimationManager.AnimationBuilder animationBuilder) {
        AsDemonAnimations.build(animationBuilder);
    }
}
