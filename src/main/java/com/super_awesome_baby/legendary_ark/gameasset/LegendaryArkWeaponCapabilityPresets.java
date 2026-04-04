package com.super_awesome_baby.legendary_ark.gameasset;

import com.super_awesome_baby.legendary_ark.LegendaryArk;
import com.super_awesome_baby.legendary_ark.capability.AdvanceWeaponCapability;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = LegendaryArk.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LegendaryArkWeaponCapabilityPresets {

    public static final Function<Item, CapabilityItem.Builder> AS_DEMON = (item -> AdvanceWeaponCapability.builder()
            .category(CapabilityItem.WeaponCategories.SPEAR)
            .styleProvider((livingEntityPatch) -> CapabilityItem.Styles.TWO_HAND)
            .hitParticle(EpicFightParticles.HIT_BLADE.get())
            .hitSound(EpicFightSounds.BLADE_HIT.get())
            .collider(ColliderPreset.SPEAR)
            .canBePlacedOffhand(false)
            .reach(0.2F)
            .newAdvanceStyleCombo(CapabilityItem.Styles.TWO_HAND,
                    Animations.TACHI_AUTO1,
                    Animations.TACHI_AUTO2,
                    Animations.TACHI_AUTO3,
                    Animations.TACHI_DASH,
                    Animations.LONGSWORD_AIR_SLASH)
            .innateSkill(CapabilityItem.Styles.TWO_HAND, (itemstack) -> EpicFightSkills.GRASPING_SPIRE)
            .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, Animations.BIPED_HOLD_SPEAR)
            .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, Animations.BIPED_WALK_SPEAR)
            .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_SPEAR)
    );

    @SubscribeEvent
    public static void onWeaponCapabilityPresetRegistry(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(LegendaryArk.MOD_ID, "as_demon"), AS_DEMON);
    }

}
