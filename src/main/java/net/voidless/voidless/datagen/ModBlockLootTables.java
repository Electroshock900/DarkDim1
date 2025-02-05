package net.voidless.voidless.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.util.ModBlocks;
import net.voidless.voidless.util.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures, HolderLookup.Provider pRegistries) {
        super(pExplosionResistant, pEnabledFeatures, pRegistries);
    }

    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.DEATH_BLOCK.get());
        dropSelf(ModBlocks.DARKNESS_BLOCK.get());
        dropSelf(ModBlocks.RAW_DARKNESS_BLOCK.get());


        dropSelf(ModBlocks.SOUND_BLOCK.get());



        //FOOD BLOCKS
        dropSelf(ModBlocks.BBC.get());
        dropSelf(ModBlocks.BBR.get());
        dropSelf(ModBlocks.BCR.get());
        dropSelf(ModBlocks.BCC.get());
        dropSelf(ModBlocks.BMR.get());
        dropSelf(ModBlocks.BMC.get());
        dropSelf(ModBlocks.BPR.get());
        dropSelf(ModBlocks.BPC.get());

        //DARK BIOME STUFF
        dropSelf(ModBlocks.DARK_GRASS.get());
        dropSelf(ModBlocks.DARK_DIRT.get());
        dropSelf(ModBlocks.BLOODY_DIRT.get());
        dropSelf(ModBlocks.VOID_DIRT.get());
        //dropSelf(ModBlocks.DARK_STONE.get());
        dropSelf(ModBlocks.DARK_COBBLESTONE.get());
        //dropSelf(ModBlocks.BLOOD_STONE.get());
        dropSelf(ModBlocks.BLOOD_COBBLESTONE.get());
        //dropSelf(ModBlocks.VOID_STONE.get());
        dropSelf(ModBlocks.VOID_COBBLESTONE.get());
        dropSelf(ModBlocks.DARK_CACTUS.get());
        dropSelf(ModBlocks.BLOOD_CACTUS.get());
        dropSelf(ModBlocks.END_CACTUS.get());
        dropSelf(ModBlocks.ANTI_CACTUS.get());
        dropSelf(ModBlocks.DARK_SAPLING.get());
        dropSelf(ModBlocks.BLOOD_SAPLING.get());
        dropSelf(ModBlocks.VOID_SAPLING.get());

        add(ModBlocks.DARK_STONE.get(),(block)-> createSingleItemTableWithSilkTouch(ModBlocks.DARK_COBBLESTONE.get(),ModBlocks.DARK_STONE.get().asItem()));
        add(ModBlocks.BLOOD_STONE.get(),(block)-> createSingleItemTableWithSilkTouch(ModBlocks.BLOOD_COBBLESTONE.get(),ModBlocks.BLOOD_STONE.get().asItem()));
        add(ModBlocks.VOID_STONE.get(),(block)-> createSingleItemTableWithSilkTouch(ModBlocks.VOID_COBBLESTONE.get(),ModBlocks.VOID_STONE.get().asItem()));


        //ORES
        add(ModBlocks.DARK_SHARD_ORE.get(),(block)->
                createOreDrop(ModBlocks.DARK_SHARD_ORE.get(), ModItems.RAW_DARK_SHARD.get()));
        add(ModBlocks.DEEPSLATE_DARK_SHARD_ORE.get(),(block)->
                createOreDrop(ModBlocks.DEEPSLATE_DARK_SHARD_ORE.get(), ModItems.RAW_DARK_SHARD.get()));
        add(ModBlocks.NETHER_DARK_SHARD_ORE.get(),(block)->
                createOreDrop(ModBlocks.NETHER_DARK_SHARD_ORE.get(), ModItems.RAW_DARK_SHARD.get()));


        dropSelf(ModBlocks.DARK_LOG.get());
        dropSelf(ModBlocks.DARK_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_DARK_LOG.get());
        dropSelf(ModBlocks.STRIPPED_DARK_WOOD.get());


        dropSelf(ModBlocks.DARK_PLANKS.get());
        dropSelf(ModBlocks.DARK_STAIRS.get());
        dropSelf(ModBlocks.DARK_PRESSURE_PLATE.get());
        add(ModBlocks.DARK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DARK_SLAB.get()));
        add(ModBlocks.DARK_DOOR.get(),
                block -> createDoorTable(ModBlocks.DARK_DOOR.get()));
        dropSelf(ModBlocks.DARK_BUTTON.get());
        //dropSelf(ModBlocks.DARK_SLAB.get());
        dropSelf(ModBlocks.DARK_WALL.get());
        dropSelf(ModBlocks.DARK_TRAPDOOR.get());
        dropSelf(ModBlocks.DARK_FENCE.get());
        dropSelf(ModBlocks.DARK_FENCE_GATE.get());

        add(ModBlocks.DARK_SIGN.get(), block ->
                createSingleItemTable(ModItems.DARK_SIGN.get()));
        add(ModBlocks.DARK_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.DARK_SIGN.get()));
        add(ModBlocks.DARK_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.DARK_HANGING_SIGN.get()));
        add(ModBlocks.DARK_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.DARK_HANGING_SIGN.get()));


        dropSelf(ModBlocks.VOID_LOG.get());
        dropSelf(ModBlocks.VOID_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_VOID_LOG.get());
        dropSelf(ModBlocks.STRIPPED_VOID_WOOD.get());
        dropSelf(ModBlocks.VOID_PLANKS.get());
        dropSelf(ModBlocks.VOID_STAIRS.get());

        dropSelf(ModBlocks.VOID_PRESSURE_PLATE.get());
        add(ModBlocks.VOID_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VOID_SLAB.get()));
        add(ModBlocks.VOID_DOOR.get(),
                block -> createDoorTable(ModBlocks.VOID_DOOR.get()));
        dropSelf(ModBlocks.VOID_BUTTON.get());
        //dropSelf(ModBlocks.VOID_SLAB.get());
        dropSelf(ModBlocks.VOID_WALL.get());
        dropSelf(ModBlocks.VOID_TRAPDOOR.get());
        dropSelf(ModBlocks.VOID_FENCE.get());
        dropSelf(ModBlocks.VOID_FENCE_GATE.get());
        add(ModBlocks.VOID_SIGN.get(), block ->
                createSingleItemTable(ModItems.VOID_SIGN.get()));
        add(ModBlocks.VOID_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.VOID_SIGN.get()));
        add(ModBlocks.VOID_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.VOID_HANGING_SIGN.get()));
        add(ModBlocks.VOID_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.VOID_HANGING_SIGN.get()));


dropSelf(ModBlocks.BLOOD_LOG.get());
        dropSelf(ModBlocks.BLOOD_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_BLOOD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_BLOOD_WOOD.get());
        dropSelf(ModBlocks.BLOOD_PLANKS.get());
        dropSelf(ModBlocks.BLOOD_STAIRS.get());

        dropSelf(ModBlocks.BLOOD_PRESSURE_PLATE.get());
        add(ModBlocks.BLOOD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLOOD_SLAB.get()));
        add(ModBlocks.BLOOD_DOOR.get(),
                block -> createDoorTable(ModBlocks.BLOOD_DOOR.get()));
        dropSelf(ModBlocks.BLOOD_BUTTON.get());
        dropSelf(ModBlocks.BLOOD_WALL.get());
        dropSelf(ModBlocks.BLOOD_TRAPDOOR.get());
        dropSelf(ModBlocks.BLOOD_FENCE.get());
        dropSelf(ModBlocks.BLOOD_FENCE_GATE.get());

        add(ModBlocks.BLOOD_SIGN.get(), block ->
                createSingleItemTable(ModItems.BLOOD_SIGN.get()));
        add(ModBlocks.BLOOD_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.BLOOD_SIGN.get()));
        add(ModBlocks.BLOOD_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.BLOOD_HANGING_SIGN.get()));
        add(ModBlocks.BLOOD_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.BLOOD_HANGING_SIGN.get()));

        dropSelf(ModBlocks.LOTUS.get());
        add(ModBlocks.POTTED_LOTUS.get(),
                createPotFlowerItemTable(ModBlocks.LOTUS.get()));
        add(ModBlocks.POTTED_ANTI_CACTUS.get(),
                createPotFlowerItemTable(ModBlocks.ANTI_CACTUS.get()));
        add(ModBlocks.POTTED_BLOOD_CACTUS.get(),
                createPotFlowerItemTable(ModBlocks.BLOOD_CACTUS.get()));
        add(ModBlocks.POTTED_END_CACTUS.get(),
                createPotFlowerItemTable(ModBlocks.END_CACTUS.get()));
        add(ModBlocks.POTTED_DARK_CACTUS.get(),
                createPotFlowerItemTable(ModBlocks.DARK_CACTUS.get()));
//dropSelf(ModBlocks.DEATH_PORTAL.get());

        //dropSelf(ModBlocks.POLISHER.get());


        add(ModBlocks.DARK_LEAVES.get(),(block)->
                createLeavesDrops(block,ModBlocks.DARK_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES)
        );dropSelf(ModBlocks.DARK_SAPLING.get());
        add(ModBlocks.BLOOD_LEAVES.get(),(block)->
                createLeavesDrops(block,ModBlocks.BLOOD_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES)
        );dropSelf(ModBlocks.BLOOD_SAPLING.get());
        add(ModBlocks.VOID_LEAVES.get(),(block)->
                createLeavesDrops(block,ModBlocks.VOID_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES)
        );dropSelf(ModBlocks.VOID_SAPLING.get());

    }

}
