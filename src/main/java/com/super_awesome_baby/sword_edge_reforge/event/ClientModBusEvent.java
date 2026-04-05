package com.super_awesome_baby.sword_edge_reforge.event;

import com.super_awesome_baby.sword_edge_reforge.SwordEdgeReforge;
import com.super_awesome_baby.sword_edge_reforge.client.renderer.RenderMeshItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;

@Mod.EventBusSubscriber(modid = SwordEdgeReforge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ClientModBusEvent {
    public ClientModBusEvent() {
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerRenderers(PatchedRenderersEvent.RegisterItemRenderer event) {
        event.addItemRenderer(ResourceLocation.fromNamespaceAndPath(SwordEdgeReforge.MOD_ID, "mesh_item"), RenderMeshItem::new);
    }

}
