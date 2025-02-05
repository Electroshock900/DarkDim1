package net.voidless.voidless.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.entity.custom.SeatEntity;
import net.voidless.voidless.entity.custom.*;
import net.voidless.voidless.entity.projectiles.*;
import net.voidless.voidless.entity.projectiles.Anti_Cactus_Spine;
import net.voidless.voidless.entity.projectiles.Blood_Spine;

public class ModEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VoidlessMod.MODID);

    /**
    public static RegistryObject<EntityType<Thrown_Chakram>> CHAKRAM = ENTITY_TYPES.register("chakram",
            ()->EntityType.Builder.of((EntityType.EntityFactory<Thrown_Chakram>) Thrown_Chakram::new, MobCategory.MISC)
                    .sized(2F,2F)
                    .build(DeathMod.MODID + "chakram"));**/

public static RegistryObject<EntityType<AresArrow>> ARESARROW = ENTITY_TYPES.register("aresarrow",
        ()->EntityType.Builder.of((EntityType.EntityFactory<AresArrow>) AresArrow::new, MobCategory.MISC)
                .sized(0.5F, 0.5F)
                .clientTrackingRange(4)
                .updateInterval(20)
                .build(VoidlessMod.MODID + "aresarrow"));


    public static final RegistryObject<EntityType<ChakramEntity>> CHAKRAM = ENTITY_TYPES.register("chakram",
            () -> EntityType.Builder.<ChakramEntity>of( ChakramEntity::new,
                            MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "chakram").toString()));

    public static final RegistryObject<EntityType<TomahawkProjectileEntity>> TOMAHAWK =
            ENTITY_TYPES.register("tomahawk", () -> EntityType.Builder.<TomahawkProjectileEntity>of(TomahawkProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("tomahawk"));

    public static RegistryObject<EntityType<Cactus_Spine>> SPINE = ENTITY_TYPES.register("spine",
            ()->EntityType.Builder.of((EntityType.EntityFactory<Cactus_Spine>) Cactus_Spine::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(VoidlessMod.MODID + "spine"));

    public static RegistryObject<EntityType<Anti_Cactus_Spine>> ANTI_SPINE = ENTITY_TYPES.register("anti_spine",
            ()->EntityType.Builder.of((EntityType.EntityFactory<Anti_Cactus_Spine>) Anti_Cactus_Spine::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(VoidlessMod.MODID + "spine"));
    public static RegistryObject<EntityType<Blood_Spine>> BLOODSPINE = ENTITY_TYPES.register("blood_spine",
            ()->EntityType.Builder.of((EntityType.EntityFactory<Blood_Spine>) Blood_Spine::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(4)
                    .updateInterval(20)
                    .build(VoidlessMod.MODID + "blood_spine"));

    //Cactus Buddy
    public static final RegistryObject<EntityType<Cactus_Buddy2>> CACTUS_BUDDY =
            ENTITY_TYPES.register("cactus_buddy",
                    () -> EntityType.Builder.of(Cactus_Buddy2::new, MobCategory.CREATURE)
                            .sized(0.4f, 0.4f)
                            .build("cactus_buddy")
            );

    public static final RegistryObject<EntityType<Skull_Entity>> SKULL =
            ENTITY_TYPES.register("skull",
                    () -> EntityType.Builder.of(Skull_Entity::new, MobCategory.MONSTER)
                            .sized(1.0f, 1.0f)
                            .build("skull")
            );


    public static final RegistryObject<EntityType<Mini_Skull_Entity>> MINI_SKULL =
            ENTITY_TYPES.register("mini_skull",
                    ()-> EntityType.Builder.of(Mini_Skull_Entity::new, MobCategory.MONSTER)
                            .sized(1.0F,1.0F)
                            .build("mini_skull")
            );

    public static final RegistryObject<EntityType<Eyeball_Monster>> EYEBALL_MONSTER =
            ENTITY_TYPES.register("eyeball_monster",
                    ()-> EntityType.Builder.of(Eyeball_Monster::new, MobCategory.MONSTER)
                            .sized(1f,1f)
                            .build("eyeball_monster")
            );/**
    public static final RegistryObject<EntityType<Lion_Thing>> LION_THING =
            ENTITY_TYPES.register("lion_thing",
                    ()-> EntityType.Builder.of(Lion_Thing::new,MobCategory.MONSTER)
                            .sized(1f,1f)
                            .build(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"lion_thing").toString())
            );**/

    public static final RegistryObject<EntityType<MantaRayEntity>> MANTA_RAY =
            ENTITY_TYPES.register("manta_ray",() ->
                    EntityType.Builder.of(MantaRayEntity::new,MobCategory.AMBIENT)
                            .sized(2f,2f)
                            .build("manta_ray")
                            );
    public static final RegistryObject<EntityType<OwlEntity>> OWL =
            ENTITY_TYPES.register("owl",() ->
                    EntityType.Builder.of(OwlEntity::new,MobCategory.AMBIENT)
                            .sized(1f,2f)
                            .build("owl")
                            );
    public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN =
            ENTITY_TYPES.register("penguin",() ->
                    EntityType.Builder.of(PenguinEntity::new,MobCategory.AMBIENT)
                            .sized(1f,2f)
                            .build("penguin")
                            );

    public static final RegistryObject<EntityType<SeatEntity>> SEAT =
            ENTITY_TYPES.register("seat",()->
                    EntityType.Builder.of(SeatEntity::new,MobCategory.MISC)
                            .sized(0.5f,0.5f)
                            .build("seat")
            );
    public static final RegistryObject<EntityType<CheeseHorse>> CHEESE_HORSE =
            ENTITY_TYPES.register("cheese_horse", ()->
                    EntityType.Builder.of(CheeseHorse::new, MobCategory.MISC)
                            .sized(1.3964844F, 1.6F)
                            .eyeHeight(1.52F)
                            .passengerAttachments(1.44375F)
                            .build("cheese_horse")
            );
    public static final RegistryObject<EntityType<WarTortoise>> WAR_TORTOISE =
            ENTITY_TYPES.register("war_tortoise", ()->
                    EntityType.Builder.of(WarTortoise::new, MobCategory.MISC)
                            .sized(2f,1.3f)
                            .passengerAttachments(1.33375F)
                            .build("war_tortoise")
            );
    public static final RegistryObject<EntityType<WarTortoiseHybrid>> WAR_TORTOISE_HYBRID =
            ENTITY_TYPES.register("war_tortoise_hybrid", ()->
                    EntityType.Builder.of(WarTortoiseHybrid::new, MobCategory.MISC)
                            .sized(2f,1.3f)
                            .passengerAttachments(1.33375F)
                            .build("war_tortoise_hybrid")
            );

public static final RegistryObject<EntityType<WarTurtle>> WAR_TURTLE =
            ENTITY_TYPES.register("war_turtle", ()->
                    EntityType.Builder.of(WarTurtle::new, MobCategory.MISC)
                            .sized(2f,1.5f)
                            .passengerAttachments(1.33375F)
                            .build("war_turtle")
            );

    /**
    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_boat"));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_chest_boat"));
**/
    public static void register(IEventBus eventbus) {
        ENTITY_TYPES.register(eventbus);}
}

