package com.super_awesome_baby.legendary_ark;

import com.mojang.logging.LogUtils;
import com.super_awesome_baby.legendary_ark.client.sound.LegendaryArkSounds;
import com.super_awesome_baby.legendary_ark.init.LegendaryArkItem;
import com.super_awesome_baby.legendary_ark.particle.LegendaryArkParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import yesman.epicfight.main.EpicFightExtensions;

@SuppressWarnings("removal")
@Mod(LegendaryArk.MOD_ID)
public class LegendaryArk {
    public static final String MOD_ID = "legendary_ark";
    private static final Logger LOGGER = LogUtils.getLogger();
    private final FMLJavaModLoadingContext context;

    public LegendaryArk(FMLJavaModLoadingContext context) {
        this.context = context;
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        forgeEventBus.register(this);
        initializeModules(modEventBus, forgeEventBus);

    }

    private void initializeModules(IEventBus modEventBus, IEventBus forgeEventBus) {
        registerRegistries(modEventBus);

        context.registerExtensionPoint(EpicFightExtensions.class, () -> new EpicFightExtensions(LegendaryArkItem.ITEM_TAB_MAIN));
    }

    private void registerRegistries(IEventBus modEventBus) {
        LegendaryArkItem.register(modEventBus);
        LegendaryArkItem.EFJ_ITEM_TAB.register(modEventBus);
        LegendaryArkSounds.SOUNDS.register(modEventBus);
        LegendaryArkParticles.PARTICLES.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
