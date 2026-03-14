
package net.pdy.goldenticket.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.pdy.goldenticket.entity.PmtxEntity;

public class PmtxRenderer extends HumanoidMobRenderer<PmtxEntity, HumanoidModel<PmtxEntity>> {
	public PmtxRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<PmtxEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(PmtxEntity entity) {
		return new ResourceLocation("golden_ticket:textures/entities/sha_fu_fu_.png");
	}
}
