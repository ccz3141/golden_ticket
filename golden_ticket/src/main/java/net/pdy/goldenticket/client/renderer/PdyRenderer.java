
package net.pdy.goldenticket.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.pdy.goldenticket.entity.PdyEntity;
import org.jetbrains.annotations.NotNull;

public class PdyRenderer extends HumanoidMobRenderer<PdyEntity, HumanoidModel<PdyEntity>> {
	public PdyRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		HumanoidModel<PdyEntity> innerArmor = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR));
		HumanoidModel<PdyEntity> outerArmor = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR));

		this.addLayer(new HumanoidArmorLayer<>(this, innerArmor, outerArmor, context.getModelManager()));
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull PdyEntity entity) {
		return ResourceLocation.fromNamespaceAndPath("golden_ticket", "textures/entities/pdy.png");
	}
}
