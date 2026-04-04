package com.super_awesome_baby.legendary_ark.event;

import com.super_awesome_baby.legendary_ark.LegendaryArk;
import com.super_awesome_baby.legendary_ark.client.renderer.RenderMeshItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;

@Mod.EventBusSubscriber(modid = LegendaryArk.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClientModBusEvent {
    public ClientModBusEvent() {
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerRenderers(PatchedRenderersEvent.RegisterItemRenderer event) {
        event.addItemRenderer(ResourceLocation.fromNamespaceAndPath(LegendaryArk.MOD_ID, "mesh_item"), RenderMeshItem::new);
    }

}
