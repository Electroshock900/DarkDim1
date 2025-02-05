package net.voidless.voidless.datagen;


import net.minecraft.client.model.Model;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModBlocks;

import java.util.function.Function;
@Mod.EventBusSubscriber(modid= VoidlessMod.MODID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VoidlessMod.MODID, exFileHelper);
    }
    @SubscribeEvent
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DEATH_BLOCK);

//ORES
        blockWithItem(ModBlocks.DARK_SHARD_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_DARK_SHARD_ORE);
        blockWithItem(ModBlocks.NETHER_DARK_SHARD_ORE);
        blockWithItem(ModBlocks.DARKNESS_BLOCK);
        blockWithItem(ModBlocks.RAW_DARKNESS_BLOCK);
//FOOD BLOCKS
        blockWithItem(ModBlocks.BBR);
        blockWithItem(ModBlocks.BBC);
        blockWithItem(ModBlocks.BCR);
        blockWithItem(ModBlocks.BCC);
        blockWithItem(ModBlocks.BMR);
        blockWithItem(ModBlocks.BMC);
        blockWithItem(ModBlocks.BPR);
        blockWithItem(ModBlocks.BPC);

        //blockWithItem(ModBlocks.BLOOD_BLOCK);
//BIOME STUFF
        //blockWithItem(ModBlocks.DARK_GRASS);
        blockWithItem(ModBlocks.DARK_DIRT);
        blockWithItem(ModBlocks.DARK_STONE);
        blockWithItem(ModBlocks.DARK_COBBLESTONE);


        blockWithItem(ModBlocks.BLOODY_DIRT);
        blockWithItem(ModBlocks.BLOOD_STONE);
        blockWithItem(ModBlocks.BLOOD_COBBLESTONE);


        blockWithItem(ModBlocks.VOID_DIRT);
        blockWithItem(ModBlocks.VOID_STONE);
        blockWithItem(ModBlocks.VOID_COBBLESTONE);


        blockWithItem(ModBlocks.SOUND_BLOCK);
        blockWithItem(ModBlocks.DARK_PLANKS);
        blockWithItem(ModBlocks.BLOOD_PLANKS);
        blockWithItem(ModBlocks.VOID_PLANKS);




    simpleBlockWithItem(ModBlocks.LOTUS.get(), models().cross(blockTexture(ModBlocks.LOTUS.get()).getPath(),
            blockTexture(ModBlocks.LOTUS.get())).renderType("cutout"));
    simpleBlockWithItem(ModBlocks.POTTED_LOTUS.get(), models().singleTexture("potted_lotus", ResourceLocation.parse("flower_pot_cross"), "plant",
            blockTexture(ModBlocks.LOTUS.get())).renderType("cutout"));



    //simpleBlockWithItem(ModBlocks.POLISHER.get(), new ModelFile.UncheckedModelFile(modLoc("block/polisher")));

//DARK WOOD STUFF
        //DARK WOOD
        saplingBlock(ModBlocks.DARK_SAPLING);
        blockItem(ModBlocks.DARK_LOG);
        blockItem(ModBlocks.DARK_WOOD);
        blockItem(ModBlocks.STRIPPED_DARK_LOG);
        blockItem(ModBlocks.STRIPPED_DARK_WOOD);
        //blockItem(ModBlocks.DARK_LEAVES);
        leavesBlock(ModBlocks.DARK_LEAVES);
        logBlock(((RotatedPillarBlock) ModBlocks.DARK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.DARK_WOOD.get()), blockTexture(ModBlocks.STRIPPED_DARK_LOG.get()), blockTexture(ModBlocks.STRIPPED_DARK_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DARK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DARK_WOOD.get()), blockTexture(ModBlocks.STRIPPED_DARK_LOG.get()), blockTexture(ModBlocks.STRIPPED_DARK_LOG.get()));

        stairsBlock(((StairBlock) ModBlocks.DARK_STAIRS.get()), blockTexture(ModBlocks.DARK_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.DARK_SLAB.get()), blockTexture(ModBlocks.DARK_PLANKS.get()), blockTexture(ModBlocks.DARK_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.DARK_BUTTON.get()), blockTexture(ModBlocks.DARK_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.DARK_PRESSURE_PLATE.get()), blockTexture(ModBlocks.DARK_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.DARK_FENCE.get()), blockTexture(ModBlocks.DARK_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.DARK_FENCE_GATE.get()), blockTexture(ModBlocks.DARK_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.DARK_WALL.get()), blockTexture(ModBlocks.DARK_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.DARK_DOOR.get()), modLoc("block/dark_door_bottom"), modLoc("block/dark_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.DARK_TRAPDOOR.get()), modLoc("block/dark_trapdoor"), true, "cutout");
        
        signBlock((StandingSignBlock) ModBlocks.DARK_SIGN.get(), (WallSignBlock) ModBlocks.DARK_WALL_SIGN.get(),
                blockTexture(ModBlocks.DARK_PLANKS.get()));
        hangingSignBlock(ModBlocks.DARK_HANGING_SIGN.get(), ModBlocks.DARK_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.DARK_PLANKS.get()));

 //BLOOD WOOD STUFF
        //BLOOD WOOD
        saplingBlock(ModBlocks.BLOOD_SAPLING);
        blockItem(ModBlocks.BLOOD_LOG);
        blockItem(ModBlocks.BLOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_BLOOD_LOG);
        blockItem(ModBlocks.STRIPPED_BLOOD_WOOD);
        //blockItem(ModBlocks.BLOOD_LEAVES);
        leavesBlock(ModBlocks.BLOOD_LEAVES);
        logBlock(((RotatedPillarBlock) ModBlocks.BLOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.BLOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_BLOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_BLOOD_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BLOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_BLOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_BLOOD_LOG.get()));

        stairsBlock(((StairBlock) ModBlocks.BLOOD_STAIRS.get()), blockTexture(ModBlocks.BLOOD_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.BLOOD_SLAB.get()), blockTexture(ModBlocks.BLOOD_PLANKS.get()), blockTexture(ModBlocks.BLOOD_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.BLOOD_BUTTON.get()), blockTexture(ModBlocks.BLOOD_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.BLOOD_PRESSURE_PLATE.get()), blockTexture(ModBlocks.BLOOD_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.BLOOD_FENCE.get()), blockTexture(ModBlocks.BLOOD_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.BLOOD_FENCE_GATE.get()), blockTexture(ModBlocks.BLOOD_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.BLOOD_WALL.get()), blockTexture(ModBlocks.BLOOD_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.BLOOD_DOOR.get()), modLoc("block/blood_door_bottom"), modLoc("block/blood_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.BLOOD_TRAPDOOR.get()), modLoc("block/blood_trapdoor"), true, "cutout");
        
        signBlock((StandingSignBlock) ModBlocks.BLOOD_SIGN.get(), (WallSignBlock) ModBlocks.BLOOD_WALL_SIGN.get(),
                blockTexture(ModBlocks.BLOOD_PLANKS.get()));
        hangingSignBlock(ModBlocks.BLOOD_HANGING_SIGN.get(), ModBlocks.BLOOD_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.BLOOD_PLANKS.get()));

//VOID WOOD STUFF
        //VOID WOOD
        saplingBlock(ModBlocks.VOID_SAPLING);
        blockItem(ModBlocks.VOID_LOG);
        blockItem(ModBlocks.VOID_WOOD);
        blockItem(ModBlocks.STRIPPED_VOID_LOG);
        blockItem(ModBlocks.STRIPPED_VOID_WOOD);
        //blockItem(ModBlocks.VOID_LEAVES);
        leavesBlock(ModBlocks.VOID_LEAVES);
        logBlock(((RotatedPillarBlock) ModBlocks.VOID_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.VOID_WOOD.get()), blockTexture(ModBlocks.STRIPPED_VOID_LOG.get()), blockTexture(ModBlocks.STRIPPED_VOID_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_VOID_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_VOID_WOOD.get()), blockTexture(ModBlocks.STRIPPED_VOID_LOG.get()), blockTexture(ModBlocks.STRIPPED_VOID_LOG.get()));

        stairsBlock(((StairBlock) ModBlocks.VOID_STAIRS.get()), blockTexture(ModBlocks.VOID_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.VOID_SLAB.get()), blockTexture(ModBlocks.VOID_PLANKS.get()), blockTexture(ModBlocks.VOID_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.VOID_BUTTON.get()), blockTexture(ModBlocks.VOID_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.VOID_PRESSURE_PLATE.get()), blockTexture(ModBlocks.VOID_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.VOID_FENCE.get()), blockTexture(ModBlocks.VOID_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.VOID_FENCE_GATE.get()), blockTexture(ModBlocks.VOID_PLANKS.get()));
        wallBlock(((WallBlock) ModBlocks.VOID_WALL.get()), blockTexture(ModBlocks.VOID_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.VOID_DOOR.get()), modLoc("block/void_door_bottom"), modLoc("block/void_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.VOID_TRAPDOOR.get()), modLoc("block/void_trapdoor"), true, "cutout");
        
        signBlock((StandingSignBlock) ModBlocks.VOID_SIGN.get(), (WallSignBlock) ModBlocks.VOID_WALL_SIGN.get(),
                blockTexture(ModBlocks.VOID_PLANKS.get()));
        hangingSignBlock(ModBlocks.VOID_HANGING_SIGN.get(), ModBlocks.VOID_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.VOID_PLANKS.get()));
        
/**
 axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DARK_LOG.get()), blockTexture(ModBlocks.STRIPPED_DARK_LOG.get()),
 ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "block/stripped_dark_log_top"));
 axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_DARK_WOOD.get()), blockTexture(ModBlocks.STRIPPED_DARK_LOG.get()),
 blockTexture(ModBlocks.STRIPPED_DARK_LOG.get()));**/
        simpleBlock(ModBlocks.DARKSIDE_PORTAL.get());
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }
    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get()))/*.renderType("cutout")*/);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(VoidlessMod.MODID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    /**
     public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
     Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

     getVariantBuilder(block).forAllStates(function);
     }

     private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
     ConfiguredModel[] models = new ConfiguredModel[1];
     models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
     new ResourceLocation(DeathMod.MODID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

     return models;
     }

     public void makeCornCrop(CropBlock block, String modelName, String textureName) {
     Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

     getVariantBuilder(block).forAllStates(function);
     }

     private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
     ConfiguredModel[] models = new ConfiguredModel[1];
     models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
     new ResourceLocation(DeathMod.MODID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

     return models;
     }**/

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }


}
