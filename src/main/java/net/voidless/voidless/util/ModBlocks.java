package net.voidless.voidless.util;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.blocks.custom.CoagulatedBloodBlock;
import net.voidless.voidless.blocks.custom.CongealedBloodBlock;
import net.voidless.voidless.blocks.custom.signs.ModHangingSignBlock;
import net.voidless.voidless.blocks.custom.signs.ModStandingSignBlock;
import net.voidless.voidless.blocks.custom.signs.ModWallHangingSignBlock;
import net.voidless.voidless.blocks.custom.signs.ModWallSignBlock;
import net.voidless.voidless.blocks.types.BloodDripBlock;
import net.voidless.voidless.blocks.types.DeathLeavesBlock;
import net.voidless.voidless.blocks.types.ModFlammableRotatedPillarBlock;
import net.voidless.voidless.fluid.ModFluids;
import net.voidless.voidless.worldgen.portal.DeathPortalBlock_Current;
import net.voidless.voidless.worldgen.tree.ModTreeGrowers;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VoidlessMod.MODID);
    public static final DeferredRegister<Item> BLOCKITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VoidlessMod.MODID);

    public static final RegistryObject<Block> DARK_SHARD_ORE = registerBlock("dark_shard_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5),BlockBehaviour.Properties.of().strength(2.0f,2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHER_DARK_SHARD_ORE = registerBlock("nether_dark_shard_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,7),BlockBehaviour.Properties.of().strength(2.0f,2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_DARK_SHARD_ORE = registerBlock("deepslate_dark_shard_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,13),BlockBehaviour.Properties.of().strength(2.0f,2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARKNESS_BLOCK = registerBlock("dark_shard_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.0f,2.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_DARKNESS_BLOCK = registerBlock("raw_darkness_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(2.0f,2.0f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> BCR = registerBlock("chicken_block_raw",
            () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BCC = registerBlock("chicken_block_cooked",
            () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BPR = registerBlock("porkchop_block_raw",
            () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BPC = registerBlock("porkchop_block_cooked",
            () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BBR = registerBlock("beef_block_raw",
            () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BBC = registerBlock("beef_block_cooked",
            () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BMR = registerBlock("mutton_block_raw",
            () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BMC = registerBlock("mutton_block_cooked",
            () -> new Block(BlockBehaviour.Properties.of()));


    public static final RegistryObject<Block> DEATH_BLOCK = registerBlock("death_block",
            () -> new Block(BlockBehaviour.Properties.of()));
    //CACTUS
    public static final RegistryObject<Block> ANTI_CACTUS = registerBlock("anti_cactus",
            ()-> new CactusBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BLOOD_CACTUS = registerBlock("blood_cactus",
            ()-> new CactusBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> DARK_CACTUS = registerBlock("dark_cactus",
            () -> new CactusBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> END_CACTUS = registerBlock("end_cactus",
            () -> new CactusBlock(BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> POTTED_ANTI_CACTUS = BLOCKS.register("potted_anti_cactus",
     () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.ANTI_CACTUS,
     BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_CACTUS).noOcclusion()));
     public static final RegistryObject<Block> POTTED_DARK_CACTUS = BLOCKS.register("potted_dark_cactus",
     () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.DARK_CACTUS,
     BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_CACTUS).noOcclusion()));
     public static final RegistryObject<Block> POTTED_END_CACTUS = BLOCKS.register("potted_end_cactus",
     () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.END_CACTUS,
     BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_CACTUS).noOcclusion()));
     public static final RegistryObject<Block> POTTED_BLOOD_CACTUS = BLOCKS.register("potted_blood_cactus",
     () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.BLOOD_CACTUS,
     BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_CACTUS).noOcclusion()));
     
     
//DARK WOOD STUFF
    public static final RegistryObject<Block> DARK_SAPLING = registerBlock("dark_sapling", () -> new SaplingBlock(ModTreeGrowers.DARK, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
    public static final RegistryObject<Block> DARK_LOG = registerBlock("dark_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> DARK_WOOD = registerBlock("dark_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> DARK_LEAVES = registerBlock("dark_leaves", () -> new DeathLeavesBlock(BlockBehaviour.Properties.of()){
        //public static final RegistryObject<Block> DARK_LEAVES2 = registerBlock("dark_leaves2", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LEAVES)){
        @Override
        public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
            super.animateTick(blockState, level, blockPos, randomSource);
            if (randomSource.nextInt(4) == 0) {
                BlockPos blockpos = blockPos.below();
                BlockState blockstate = level.getBlockState(blockpos);
                if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
                    ParticleUtils.spawnParticleBelow(level, blockPos, randomSource, ParticleTypes.CHERRY_LEAVES);
                    ParticleUtils.spawnParticleBelow(level, blockPos, randomSource, ParticleTypes.SOUL_FIRE_FLAME);
                }
            }
        }
    });



    public static final RegistryObject<Block> DARK_SIGN = BLOCKS.register("dark_sign",
            () -> new ModStandingSignBlock(ModWoodTypes.DARK,BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> DARK_WALL_SIGN = BLOCKS.register("dark_wall_sign",
            () -> new ModWallSignBlock(ModWoodTypes.DARK,BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> DARK_HANGING_SIGN = BLOCKS.register("dark_hanging_sign",
            () -> new ModHangingSignBlock(ModWoodTypes.DARK,BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> DARK_WALL_HANGING_SIGN = BLOCKS.register("dark_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(ModWoodTypes.DARK,BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> STRIPPED_DARK_LOG = registerBlock("stripped_dark_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> STRIPPED_DARK_WOOD = registerBlock("stripped_dark_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> DARK_PLANKS = registerBlock("dark_planks", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));


    public static final RegistryObject<Block> DARK_STAIRS = registerBlock("dark_stairs",
            () -> new StairBlock(ModBlocks.DARK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of() ));

    public static final RegistryObject<Block> DARK_SLAB = registerBlock("dark_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of() ));

    public static final RegistryObject<Block> DARK_BUTTON = registerBlock("dark_button",
            () -> new ButtonBlock(BlockSetType.DARK_OAK,10,BlockBehaviour.Properties.of().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_PRESSURE_PLATE = registerBlock("dark_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> DARK_FENCE = registerBlock("dark_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of() ));
    public static final RegistryObject<Block> DARK_FENCE_GATE = registerBlock("dark_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.DARK,BlockBehaviour.Properties.of().sound(SoundType.WOOD), SoundEvents.ANVIL_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> DARK_WALL = registerBlock("dark_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> DARK_DOOR = registerBlock("dark_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> DARK_TRAPDOOR = registerBlock("dark_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of().sound(SoundType.WOOD).noOcclusion()));
    
//BLOOD WOOD STUFF
    public static final RegistryObject<Block> BLOOD_SAPLING = registerBlock("blood_sapling", () -> new SaplingBlock(ModTreeGrowers.BLOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
    public static final RegistryObject<Block> BLOOD_LOG = registerBlock("blood_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> BLOOD_WOOD = registerBlock("blood_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> BLOOD_LEAVES = registerBlock("blood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of()){
        //public static final RegistryObject<Block> BLOOD_LEAVES2 = registerBlock("blood_leaves2", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.BLOOD_OAK_LEAVES)){
        @Override
        public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
            super.animateTick(blockState, level, blockPos, randomSource);
            if (randomSource.nextInt(4) == 0) {
                BlockPos blockpos = blockPos.below();
                BlockState blockstate = level.getBlockState(blockpos);
                if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
                    ParticleUtils.spawnParticleBelow(level, blockPos, randomSource, ModParticles.DEATH_SKULLS.get());
                    ParticleUtils.spawnParticleBelow(level, blockPos, randomSource, ParticleTypes.SOUL_FIRE_FLAME);
                }
            }
        }
    });



    public static final RegistryObject<Block> BLOOD_SIGN = BLOCKS.register("blood_sign",
            () -> new ModStandingSignBlock(ModWoodTypes.BLOOD,BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BLOOD_WALL_SIGN = BLOCKS.register("blood_wall_sign",
            () -> new ModWallSignBlock(ModWoodTypes.BLOOD,BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BLOOD_HANGING_SIGN = BLOCKS.register("blood_hanging_sign",
            () -> new ModHangingSignBlock(ModWoodTypes.BLOOD,BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BLOOD_WALL_HANGING_SIGN = BLOCKS.register("blood_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(ModWoodTypes.BLOOD,BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> STRIPPED_BLOOD_LOG = registerBlock("stripped_blood_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> STRIPPED_BLOOD_WOOD = registerBlock("stripped_blood_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> BLOOD_PLANKS = registerBlock("blood_planks", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));


    public static final RegistryObject<Block> BLOOD_STAIRS = registerBlock("blood_stairs",
            () -> new StairBlock(ModBlocks.BLOOD_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of() ));

    public static final RegistryObject<Block> BLOOD_SLAB = registerBlock("blood_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of() ));

    public static final RegistryObject<Block> BLOOD_BUTTON = registerBlock("blood_button",
            () -> new ButtonBlock(BlockSetType.DARK_OAK,10,BlockBehaviour.Properties.of().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BLOOD_PRESSURE_PLATE = registerBlock("blood_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BLOOD_FENCE = registerBlock("blood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of() ));
    public static final RegistryObject<Block> BLOOD_FENCE_GATE = registerBlock("blood_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.BLOOD,BlockBehaviour.Properties.of().sound(SoundType.WOOD), SoundEvents.ANVIL_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> BLOOD_WALL = registerBlock("blood_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> BLOOD_DOOR = registerBlock("blood_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> BLOOD_TRAPDOOR = registerBlock("blood_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of().sound(SoundType.WOOD).noOcclusion()));


//VOID WOOD STUFF
    public static final RegistryObject<Block> VOID_SAPLING = registerBlock("void_sapling", () -> new SaplingBlock(ModTreeGrowers.VOID, BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING)));
    public static final RegistryObject<Block> VOID_LOG = registerBlock("void_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> VOID_WOOD = registerBlock("void_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> VOID_LEAVES = registerBlock("void_leaves", () -> new DeathLeavesBlock(BlockBehaviour.Properties.of()){
        //public static final RegistryObject<Block> VOID_LEAVES2 = registerBlock("void_leaves2", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.VOID_OAK_LEAVES)){
        @Override
        public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
            super.animateTick(blockState, level, blockPos, randomSource);
            if (randomSource.nextInt(4) == 0) {
                BlockPos blockpos = blockPos.below();
                BlockState blockstate = level.getBlockState(blockpos);
                if (!isFaceFull(blockstate.getCollisionShape(level, blockpos), Direction.UP)) {
                    ParticleUtils.spawnParticleBelow(level, blockPos, randomSource, ParticleTypes.CHERRY_LEAVES);
                    ParticleUtils.spawnParticleBelow(level, blockPos, randomSource, ParticleTypes.SOUL_FIRE_FLAME);
                }
            }
        }
    });



    public static final RegistryObject<Block> VOID_SIGN = BLOCKS.register("void_sign",
            () -> new ModStandingSignBlock(ModWoodTypes.VOID,BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> VOID_WALL_SIGN = BLOCKS.register("void_wall_sign",
            () -> new ModWallSignBlock(ModWoodTypes.VOID,BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> VOID_HANGING_SIGN = BLOCKS.register("void_hanging_sign",
            () -> new ModHangingSignBlock(ModWoodTypes.VOID,BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> VOID_WALL_HANGING_SIGN = BLOCKS.register("void_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(ModWoodTypes.VOID,BlockBehaviour.Properties.of()));

    public static final RegistryObject<Block> STRIPPED_VOID_LOG = registerBlock("stripped_void_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> STRIPPED_VOID_WOOD = registerBlock("stripped_void_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));
    public static final RegistryObject<Block> VOID_PLANKS = registerBlock("void_planks", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F)));


    public static final RegistryObject<Block> VOID_STAIRS = registerBlock("void_stairs",
            () -> new StairBlock(ModBlocks.VOID_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of() ));

    public static final RegistryObject<Block> VOID_SLAB = registerBlock("void_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of() ));

    public static final RegistryObject<Block> VOID_BUTTON = registerBlock("void_button",
            () -> new ButtonBlock(BlockSetType.DARK_OAK,10,BlockBehaviour.Properties.of().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> VOID_PRESSURE_PLATE = registerBlock("void_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> VOID_FENCE = registerBlock("void_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of() ));
    public static final RegistryObject<Block> VOID_FENCE_GATE = registerBlock("void_fence_gate",
            () -> new FenceGateBlock(ModWoodTypes.VOID,BlockBehaviour.Properties.of().sound(SoundType.WOOD), SoundEvents.ANVIL_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> VOID_WALL = registerBlock("void_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> VOID_DOOR = registerBlock("void_door",
            () -> new DoorBlock(BlockSetType.DARK_OAK, BlockBehaviour.Properties.of().sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> VOID_TRAPDOOR = registerBlock("void_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.DARK_OAK,BlockBehaviour.Properties.of().sound(SoundType.WOOD).noOcclusion()));



    //BUCKETS

    public static final RegistryObject<LiquidBlock> SOAP_WATER_BLOCK = registerBlock("soap_water_block",
            () -> new LiquidBlock(ModFluids.SOAP_WATER_FLUID, BlockBehaviour.Properties.of().noLootTable().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<LiquidBlock> DARK_ESSENCE_BLOCK = registerBlock("dark_essence_block",
            () -> new LiquidBlock(ModFluids.DARK_ESSENCE_FLUID, BlockBehaviour.Properties.of().noLootTable().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<LiquidBlock> ENDER_BLOOD_BLOCK = registerBlock("ender_blood_block",
            () -> new LiquidBlock(ModFluids.ENDER_BLOOD_FLUID, BlockBehaviour.Properties.of().noLootTable().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<LiquidBlock> DEITY_BLOOD_BLOCK = registerBlock("deity_blood_block",
            () -> new LiquidBlock(ModFluids.DEITY_BLOOD_FLUID, BlockBehaviour.Properties.of().noLootTable().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<LiquidBlock> BLOOD_BLOCK = registerBlock("blood_block",
            () -> new LiquidBlock(ModFluids.BLOOD_FLUID, BlockBehaviour.Properties.of().noLootTable().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> COAGULATED_BLOOD = registerBlock("blood_coagulated",
            ()-> new CoagulatedBloodBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> CONGEALED_BLOOD = registerBlock("blood_congealed",
            ()-> new CongealedBloodBlock(BlockBehaviour.Properties.of()));

    //DARK BIOME STUFF
    public static final RegistryObject<Block> DARK_GRASS = registerBlock("dark_grass_block",
            ()-> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> DARK_DIRT = registerBlock("dark_dirt",
            ()-> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> DARK_STONE = registerBlock("dark_stone",
            ()-> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> DARK_COBBLESTONE = registerBlock("dark_cobblestone",
            ()-> new Block(BlockBehaviour.Properties.of()));


    public static final RegistryObject<Block> BLOODY_DIRT = registerBlock("bloody_dirt",
    ()-> new BloodDripBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BLOOD_STONE = registerBlock("blood_stone",
            ()-> new BloodDripBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> BLOOD_COBBLESTONE = registerBlock("blood_cobblestone",
            ()-> new BloodDripBlock(BlockBehaviour.Properties.of()));


    public static final RegistryObject<Block> VOID_DIRT = registerBlock("void_dirt",
            ()-> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> VOID_STONE = registerBlock("void_stone",
            ()-> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> VOID_COBBLESTONE = registerBlock("void_cobblestone",
            ()-> new Block(BlockBehaviour.Properties.of()));

    /**public static final RegistryObject<Block> ABYSSAL_CONTAINER = registerBlock("abyssal_container",
     ()-> new AbyssalContainer(BlockBehaviour.Properties.copy(Blocks.CHEST),AbyssalContainerEntity::new));**/

    /**
     public static final RegistryObject<CrusherBlock> CRUSHER = registerBlock("crusher",
     () -> new CrusherBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(5f, 20f)));
     **/
    /**
     public static final RegistryObject<ExampleAdvancedBlock> EXAMPLE_ADVANCED_BLOCK = BLOCKS.register("example_advanced_block",
     () -> new ExampleAdvancedBlock(BlockBehaviour.Properties.copy(Blocks.ANVIL)
     //.mapColor(MapColor.TERRACOTTA_YELLOW)
     .strength(5.0f, 15f)
     ));
     **/

    //public static final RegistryObject<Block> MOB_SLAYER = BLOCKS.register("mob_slayer",
    //() -> new MobSlayerBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));**/
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            ()-> new Block(BlockBehaviour.Properties.of().sound(ModSounds.SOUND_BLOCK_SOUNDS)));

    public static final RegistryObject<Block> LOTUS = registerBlock("lotus",
            () -> new FlowerBlock(ModEffects.DRAIN.getHolder().get(),2,
                    BlockBehaviour.Properties.of()
                            .noCollission().instabreak().noOcclusion().mapColor(DyeColor.BLUE)
                            .sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_LOTUS = BLOCKS.register("potted_lotus",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.LOTUS,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_CACTUS).noOcclusion()));

    public static final RegistryObject<DeathPortalBlock_Current> DARKSIDE_PORTAL =
            registerBlock("darkside_portal", () -> new DeathPortalBlock_Current(BlockBehaviour.Properties.of().noLootTable()));

    public static final RegistryObject<DeathPortalBlock_Current> VOID_PORTAL =
            registerBlock("void_portal", () -> new DeathPortalBlock_Current(//BlockBehaviour.Properties.of().noLootTable()));
                    BlockBehaviour.Properties.of().noCollission().noLootTable().randomTicks().strength(-1.0F).sound(SoundType.GLASS).lightLevel((p_50884_) -> {
                        return 11;
                    }).pushReaction(PushReaction.BLOCK)));

    /*public static final RegistryObject<Block> MODPORTAL =
            registerBlock("modportal", ()-> new ModPortalBlock(BlockBehaviour.Properties.of().noLootTable()));
*/



    private static FlowerPotBlock flowerPot(Block p_278261_, FeatureFlag... p_278322_) {
        BlockBehaviour.Properties blockbehaviour$properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (p_278322_.length > 0) {
            blockbehaviour$properties = blockbehaviour$properties.requiredFeatures(p_278322_);
        }

        return new FlowerPotBlock(p_278261_, blockbehaviour$properties);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),
                new Item.Properties() ));
    }
    public static void register(IEventBus eventbus) {BLOCKS.register(eventbus);}
    public static void registerBlockItems(IEventBus eventbus) {BLOCKITEMS.register(eventbus);}
}



