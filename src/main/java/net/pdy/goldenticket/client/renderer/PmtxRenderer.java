
package net.pdy.goldenticket.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.pdy.goldenticket.entity.PmtxEntity;
import org.jetbrains.annotations.NotNull;

public class PmtxRenderer extends HumanoidMobRenderer<PmtxEntity, HumanoidModel<PmtxEntity>> {
	public PmtxRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		HumanoidModel<PmtxEntity> innerArmor = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR));
		HumanoidModel<PmtxEntity> outerArmor = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR));

		this.addLayer(new HumanoidArmorLayer<>(this, innerArmor, outerArmor, context.getModelManager()));
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull PmtxEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("golden_ticket", "textures/entities/pmtx.png");
	}
}