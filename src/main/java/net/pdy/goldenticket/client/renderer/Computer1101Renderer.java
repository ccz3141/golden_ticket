
package net.pdy.goldenticket.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.pdy.goldenticket.entity.Computer1101Entity;

public class Computer1101Renderer extends HumanoidMobRenderer<Computer1101Entity, HumanoidModel<Computer1101Entity>> {
	public Computer1101Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<Computer1101Entity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(Computer1101Entity entity) {
		return new ResourceLocation("golden_ticket:textures/entities/computer1101.png");
	}
}
