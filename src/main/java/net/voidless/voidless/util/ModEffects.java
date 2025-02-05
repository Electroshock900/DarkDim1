package net.voidless.voidless.util;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.effects.GhostFlameFX;
import net.voidless.voidless.effects.Spectre;
import net.voidless.voidless.effects.VampireDrainEffect;


public class ModEffects {

        public static final DeferredRegister<MobEffect> FX = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, VoidlessMod.MODID);
        public static final RegistryObject<MobEffect> ECTO_PYRO = FX.register("ecto_pyro",
                () -> new GhostFlameFX(MobEffectCategory.BENEFICIAL,0xF312468));

        public static final RegistryObject<MobEffect> SPECTRE = FX.register("spectre",
                ()-> new Spectre(MobEffectCategory.BENEFICIAL, 0x3124683 ));
        public static final RegistryObject<MobEffect> DRAIN = FX.register("vampire",
                () -> new VampireDrainEffect(MobEffectCategory.NEUTRAL, 0x630000));

        public static void register(IEventBus eventbus){FX.register(eventbus);}
    }
    