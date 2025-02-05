package net.voidless.voidless.worldgen.biomes;


import net.minecraft.resources.ResourceLocation;
import net.voidless.voidless.VoidlessMod;
import terrablender.api.Regions;

public class ModTerraBlender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "death_region"), 5));
    }
}
