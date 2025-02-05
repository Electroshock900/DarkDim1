package net.voidless.voidless.fluid;


import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModBlocks;
import net.voidless.voidless.util.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, VoidlessMod.MODID);

    public static final RegistryObject<FlowingFluid> SOAP_WATER_FLUID = FLUIDS.register("soap_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SOAP_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SOAP_WATER = FLUIDS.register("flowing_soap_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SOAP_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> ENDER_BLOOD_FLUID = FLUIDS.register("ender_blood_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.ENDER_BLOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ENDER_BLOOD = FLUIDS.register("flowing_ender_blood",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.ENDER_BLOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> BLOOD_FLUID = FLUIDS.register("blood_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.BLOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BLOOD = FLUIDS.register("flowing_blood_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.BLOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DEITY_BLOOD_FLUID = FLUIDS.register("deity_blood_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.DEITY_BLOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_DEITY_BLOOD = FLUIDS.register("flowing_deity_blood_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.DEITY_BLOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DARK_ESSENCE_FLUID = FLUIDS.register("dark_essence_fluid",
            ()-> new ForgeFlowingFluid.Source(ModFluids.DARK_ESSENCE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_DARK_ESSENCE = FLUIDS.register("flowing_dark_essence",
            ()-> new ForgeFlowingFluid.Flowing(ModFluids.DARK_ESSENCE_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties SOAP_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SOAP_WATER_FLUID_TYPE2, SOAP_WATER_FLUID, FLOWING_SOAP_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.SOAP_WATER_BLOCK)
            .bucket(ModItems.SOAP_WATER_BUCKET);
    public static final ForgeFlowingFluid.Properties ENDER_BLOOD_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.ENDER_BLOOD_FLUID_TYPE, ENDER_BLOOD_FLUID, FLOWING_ENDER_BLOOD)
            .slopeFindDistance(12).levelDecreasePerBlock(2).block(ModBlocks.ENDER_BLOOD_BLOCK)
            .bucket(ModItems.ENDER_BLOOD_BUCKET);
    public static final ForgeFlowingFluid.Properties BLOOD_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.BLOOD_FLUID_TYPE, BLOOD_FLUID, FLOWING_BLOOD)
            .slopeFindDistance(12).levelDecreasePerBlock(1).block(ModBlocks.BLOOD_BLOCK)
            .bucket(ModItems.BLOOD_BUCKET);

    public static final ForgeFlowingFluid.Properties DEITY_BLOOD_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.DEITY_BLOOD_FLUID_TYPE, DEITY_BLOOD_FLUID, FLOWING_DEITY_BLOOD)
            .slopeFindDistance(13).levelDecreasePerBlock(3).block(ModBlocks.DEITY_BLOOD_BLOCK)
            .bucket(ModItems.DEITY_BLOOD_BUCKET);

    public static final ForgeFlowingFluid.Properties DARK_ESSENCE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.DARK_ESSENCE_FLUID_TYPE, DARK_ESSENCE_FLUID, FLOWING_DARK_ESSENCE)
            .slopeFindDistance(45).levelDecreasePerBlock(3).block(ModBlocks.DARK_ESSENCE_BLOCK)
            .bucket(ModItems.DARK_ESSENCE_BUCKET);



    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
