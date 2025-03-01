package net.voidless.voidless.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModTags;
import net.voidless.voidless.worldgen.biomes.ModBiomes;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagGenerator extends BiomeTagsProvider {
    public ModBiomeTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
        super(pOutput, pProvider);
    }
    public ModBiomeTagGenerator(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255800_, p_256205_, VoidlessMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Biomes.BLOOD_OCEANS)
        //this.tag(ModTags.Biomes.DARK_BIOMES)
                .add(ModBiomes.DARK_OCEAN);

        this.tag(ModTags.Biomes.DARK_BIOMES)
                .add(ModBiomes.DARK_BIOME,
                        ModBiomes.DARKLANDS);

        this.tag(ModTags.Biomes.BLOOD_BIOMES)
                .add(ModBiomes.BLOOD_BIOME);
    }


}
