package com.super_awesome_baby.sword_edge_reforge;

import com.mojang.logging.LogUtils;
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

@SuppressWarnings("removal")
@Mod(SwordEdgeReforge.MOD_ID)
public class SwordEdgeReforge {
    public static final String MOD_ID = "sword_edge_reforge";
    private static final Logger LOGGER = LogUtils.getLogger();
    private final FMLJavaModLoadingContext context;

    public SwordEdgeReforge(FMLJavaModLoadingContext context) {
        this.context = context;
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        forgeEventBus.register(this);
        initializeModules(modEventBus, forgeEventBus);

    }

    private void initializeModules(IEventBus modEventBus, IEventBus forgeEventBus) {
        registerRegistries(modEventBus);
    }

    private void registerRegistries(IEventBus modEventBus) {
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
