package net.voidless.voidless.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModBlocks;
import net.voidless.voidless.util.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvidewr, CompletableFuture<TagLookup<Block>> blockTag, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, pProvidewr, blockTag, VoidlessMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ModItems.AMETHYST_HELMET.get(),
                        ModItems.AMETHYST_CHESTPLATE.get(),
                        ModItems.AMETHYST_LEGGINGS.get(),
                        ModItems.AMETHYST_BOOTS.get()
                );
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DARK_LOG.get().asItem())
                .add(ModBlocks.DARK_WOOD.get().asItem())
                .add(ModBlocks.BLOOD_LOG.get().asItem())
                .add(ModBlocks.BLOOD_WOOD.get().asItem())
                .add(ModBlocks.VOID_LOG.get().asItem())
                .add(ModBlocks.VOID_WOOD.get().asItem())

                .add(ModBlocks.STRIPPED_DARK_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_DARK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BLOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BLOOD_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_VOID_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_VOID_WOOD.get().asItem())

        ;
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.DARK_PLANKS.get().asItem())
                .add(ModBlocks.BLOOD_PLANKS.get().asItem())
                .add(ModBlocks.VOID_PLANKS.get().asItem())

        ;
        this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(ModBlocks.DARK_STONE.get().asItem(),
                ModBlocks.BLOOD_STONE.get().asItem(),
                ModBlocks.VOID_STONE.get().asItem()
                );
        //this.tag(ItemTags.)
          //      .add(ModItems.BAR_BRAWL_MUSIC_DISC.get()
            //    );
    }

}
