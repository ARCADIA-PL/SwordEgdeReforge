package com.super_awesome_baby.legendary_ark.gameasset;

import com.super_awesome_baby.legendary_ark.LegendaryArk;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.MovementAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;

@Mod.EventBusSubscriber(modid = LegendaryArk.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AsDemonAnimations {

    public static AnimationManager.AnimationAccessor<StaticAnimation> ASD_IDLE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> ASD_WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> ASD_RUN;

    public AsDemonAnimations() {}

    public static void build(AnimationManager.AnimationBuilder animationBuilder) {
    }
}
