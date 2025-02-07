package net.voidless.voidless.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.voidless.voidless.VoidlessMod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagGenerator extends BiomeTagsProvider {
    public ModBiomeTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
       // super(pOutput, Registries.BIOME, pProvider);
        super(pOutput, pProvider);
    }
    public ModBiomeTagGenerator(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255800_, p_256205_, VoidlessMod.MODID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
  /*      this.tag(BiomeTags.IS_FOREST)
        //this.tag(ModTags.Biomes.DARK_BIOMES)
                .add(ModBiomes.DARK_BIOME,
                        ModBiomes.DARK_OCEAN,
                        ModBiomes.DARKLANDS);
*/
    }


}
