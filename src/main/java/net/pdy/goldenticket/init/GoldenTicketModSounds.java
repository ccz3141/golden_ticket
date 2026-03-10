
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.pdy.goldenticket.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pdy.goldenticket.GoldenTicketMod;

public class GoldenTicketModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GoldenTicketMod.MODID);
	public static final RegistryObject<SoundEvent> PDY_CHOCOLATE1 = REGISTRY.register("pdy_chocolate1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("golden_ticket", "pdy_chocolate1")));
	public static final RegistryObject<SoundEvent> PDY_CHOCOLATE_ZHONGSUOZHOUZHI = REGISTRY.register("pdy_chocolate_zhongsuozhouzhi", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("golden_ticket", "pdy_chocolate_zhongsuozhouzhi")));
	public static final RegistryObject<SoundEvent> PDY_CHOCOLATE_QUANZIDONGCHAOJIQIAOKELIGONGCHANG = REGISTRY.register("pdy_chocolate_quanzidongchaojiqiaokeligongchang",
			() -> SoundEvent.createVariableRangeEvent(new ResourceLocation("golden_ticket", "pdy_chocolate_quanzidongchaojiqiaokeligongchang")));
	public static final RegistryObject<SoundEvent> PDY_CHOCOLATE_RENYANGYITOUNIU = REGISTRY.register("pdy_chocolate_renyangyitouniu", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("golden_ticket", "pdy_chocolate_renyangyitouniu")));
}
