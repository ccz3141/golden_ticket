
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.pdy.goldenticket.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pdy.goldenticket.client.renderer.PdyRenderer;
import net.pdy.goldenticket.client.renderer.Computer1101Renderer;
import net.pdy.goldenticket.client.renderer.PmtxRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GoldenTicketModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(GoldenTicketModEntities.PDY.get(), PdyRenderer::new);
		event.registerEntityRenderer(GoldenTicketModEntities.PMTX.get(), PmtxRenderer::new);
		event.registerEntityRenderer(GoldenTicketModEntities.COMPUTER_1101.get(), Computer1101Renderer::new);
	}
}
