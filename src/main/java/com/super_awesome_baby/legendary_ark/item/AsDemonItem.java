package com.super_awesome_baby.legendary_ark.item;

import com.super_awesome_baby.legendary_ark.LegendaryArk;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.world.item.WeaponItem;

@Mod.EventBusSubscriber(modid = LegendaryArk.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AsDemonItem extends WeaponItem {
    public AsDemonItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (isHoldingWeapon(player)) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingUpdate(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player player) {
            if (isHoldingWeapon(player) && entity.hasEffect(MobEffects.LEVITATION)) {
                entity.removeEffect(MobEffects.LEVITATION);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingKnockBack(LivingKnockBackEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player player) {
            if (isHoldingWeapon(player)) {
                event.setCanceled(true);
            }
        }
    }

    private static boolean isHoldingWeapon(Player player) {
        return player.getMainHandItem().getItem() instanceof AsDemonItem;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false; // 禁止耐久损耗
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment.category == EnchantmentCategory.WEAPON;
    }

    @Override
    public int getEnchantmentValue() {
        return 30;
    }
}

