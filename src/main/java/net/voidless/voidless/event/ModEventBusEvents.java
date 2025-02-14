package net.voidless.voidless.event;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.ModModelLayers;
import net.voidless.voidless.entity.custom.*;
import net.voidless.voidless.entity.model.*;
import net.voidless.voidless.particles.DeathSkullsParticle;
import net.voidless.voidless.particles.GhostlyFlameParticle;
import net.voidless.voidless.util.ModEntities;
import net.voidless.voidless.util.ModParticles;

@Mod.EventBusSubscriber(modid = VoidlessMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        //event.registerLayerDefinition(TriceratopsModel.LAYER_LOCATION, TriceratopsModel::createBodyLayer);
        event.registerLayerDefinition(TomahawkProjectileModel.LAYER_LOCATION, TomahawkProjectileModel::createBodyLayer);
        event.registerLayerDefinition(TChakram_Model.LAYER_LOCATION, TChakram_Model::createBodyLayer);
        event.registerLayerDefinition(Cactus_Buddy_Model.LAYER_LOCATION, Cactus_Buddy_Model::createBodyLayer);
        event.registerLayerDefinition(Eyeball_Monster_Model.LAYER_LOCATION, Eyeball_Monster_Model::createBodyLayer);
        //event.registerLayerDefinition(Lion_Thing_Model.LAYER_LOCATION, Lion_Thing_Model::createBodyLayer);
        event.registerLayerDefinition(Manta_Ray_Model.LAYER_LOCATION, Manta_Ray_Model::createBodyLayer);
        event.registerLayerDefinition(Mini_Skull_Entity_Model.LAYER_LOCATION, Mini_Skull_Entity_Model::createBodyLayer);
        event.registerLayerDefinition(Owl_Model.LAYER_LOCATION, Owl_Model::createBodyLayer);
        event.registerLayerDefinition(Penguin_Model.LAYER_LOCATION, Penguin_Model::createBodyLayer);
        event.registerLayerDefinition(Skull_Entity_Model.LAYER_LOCATION, Skull_Entity_Model::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.CHEESE_HORSE_LAYER, CheeseHorseModel::createBodyMesh);
        event.registerLayerDefinition(War_Tortoise_Hybrid_Model.LAYER_LOCATION, War_Tortoise_Hybrid_Model::createBodyLayer);
        event.registerLayerDefinition(War_Tortoise_Hybrid_Model.ARMOR_LAYER_LOCATION, War_Tortoise_Hybrid_Model::createBodyLayer);
        event.registerLayerDefinition(War_Tortoise_Model.LAYER_LOCATION, War_Tortoise_Model::createBodyLayer);
        event.registerLayerDefinition(War_Tortoise_Model.ARMOR_LAYER_LOCATION, War_Tortoise_Model::createBodyLayer);
        event.registerLayerDefinition(War_Turtle_Model.LAYER_LOCATION, War_Turtle_Model::createBodyLayer);
        event.registerLayerDefinition(War_Turtle_Model.ARMOR_LAYER_LOCATION, War_Turtle_Model::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CACTUS_BUDDY.get(), Cactus_Buddy2.setAttributes().build());
        event.put(ModEntities.EYEBALL_MONSTER.get(), Eyeball_Monster.setAttributes().build());
        //event.put(ModEntities.LION_THING.get(), Lion_Thing.setAttributes().build());
        event.put(ModEntities.MANTA_RAY.get(), MantaRayEntity.setAttributes().build());
        event.put(ModEntities.MINI_SKULL.get(), Mini_Skull_Entity.setAttributes().build());
        event.put(ModEntities.OWL.get(), OwlEntity.setAttributes().build());
        event.put(ModEntities.PENGUIN.get(), PenguinEntity.setAttributes().build());
        event.put(ModEntities.SKULL.get(), Skull_Entity.setAttributes().build());
        event.put(ModEntities.CHEESE_HORSE.get(), CheeseHorse.setAttributes().build());
        event.put(ModEntities.WAR_TORTOISE.get(), WarTortoise.setAttributes().build());
        event.put(ModEntities.WAR_TORTOISE_HYBRID.get(), WarTortoiseHybrid.setAttributes().build());
        event.put(ModEntities.WAR_TURTLE.get(), WarTurtle.createAttributes().build());
        }
        @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
    event.registerSpriteSet(ModParticles.GHOSTLY_FLAME_FX.get(),GhostlyFlameParticle.Provider::new);
    event.registerSpriteSet(ModParticles.DEATH_SKULLS.get(),DeathSkullsParticle.Provider::new);
    //event.registerSpriteSet(ModParticles.get(),GhostFlameParticle.Provider::new);
    }

    //private static void registerDimensionalStuff(RegisterDimensionSpecialEffectsEvent)
    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
       // event.register(ModEntities.TRICERATOPS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
        //        Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.OWL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);

        event.register(ModEntities.CHEESE_HORSE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);

        event.register(ModEntities.WAR_TORTOISE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.WAR_TORTOISE_HYBRID.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.WAR_TURTLE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
