package net.voidless.voidless.util;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.enchantments.LifeSteal;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> LIFE_STEAL =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, VoidlessMod.MODID);

    public static final RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> LIFESTEAL =
            LIFE_STEAL.register("life_steal",() -> LifeSteal.CODEC);

    public static void register(IEventBus eventBus){
        LIFE_STEAL.register(eventBus);
    }
}
