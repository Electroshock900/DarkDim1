package net.voidless.voidless.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.voidless.voidless.VoidlessMod;

import java.util.Set;

public class ModPoiTypes {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, VoidlessMod.MODID);
    public static final ResourceKey<PoiType> DARKSIDE_PORTAL = createKey("darkside_portal");
    //public static final RegistryObject<PoiType> VOID_PORTAL = register(,DARKSIDE_PORTAL,getBlockStates(ModBlocks.DARKSIDE_PORTAL2.get()),0,1))

    public static ResourceKey<PoiType> createKey(String name){
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, name));
    }
    private static Set<BlockState> getBlockStates(Block pBlock) {
        return ImmutableSet.copyOf(pBlock.getStateDefinition().getPossibleStates());
    }
    private static PoiType register(Registry<PoiType> pKey, ResourceKey<PoiType> pValue, Set<BlockState> pMatchingStates, int pMaxTickets, int pValidRange) {
        PoiType poitype = new PoiType(pMatchingStates, pMaxTickets, pValidRange);
        Registry.register(pKey, pValue, poitype);
        return poitype;
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        //VILLAGER_PROFESSIONS.register(eventBus);
    }
    public static PoiType bootstrap(Registry<PoiType> pRegistry) {
    return register(pRegistry, DARKSIDE_PORTAL, getBlockStates(ModBlocks.VOID_PORTAL.get()), 0, 1);
    }
}
