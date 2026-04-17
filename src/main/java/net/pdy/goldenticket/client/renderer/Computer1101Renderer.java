
package net.pdy.goldenticket.client.renderer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.pdy.goldenticket.entity.Computer1101Entity;
import org.jetbrains.annotations.NotNull;

public class Computer1101Renderer extends HumanoidMobRenderer<Computer1101Entity, HumanoidModel<Computer1101Entity>> {
	public Computer1101Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		HumanoidModel<Computer1101Entity> innerArmor = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR));
		HumanoidModel<Computer1101Entity> outerArmor = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR));

		this.addLayer(new HumanoidArmorLayer<>(this, innerArmor, outerArmor, context.getModelManager()));
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull Computer1101Entity entity) {
		return ResourceLocation.fromNamespaceAndPath("golden_ticket", "textures/entities/computer1101.png");
	}
}
