package net.voidless.voidless.util;


import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.fluid.ModFluids;
import net.voidless.voidless.item.armor.WarTortoiseArmor;
import net.voidless.voidless.item.armor.WarTortoiseHybridArmor;
import net.voidless.voidless.item.armor.WarTurtleArmor;
import net.voidless.voidless.item.custom.*;

import static net.voidless.voidless.VoidlessMod.MODID;

public class ModItems {

    // Create a Deferred Register to hold Items which will all be registered under the "voidless" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    //public static final DeferredRegister<Entity> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<Item> RAW_DARK_SHARD = ITEMS.register("raw_dark_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DARK_SHARD = ITEMS.register("dark_shard", () -> new Item(new Item.Properties()));

//Weapons and Shields
    public static final RegistryObject<Item> TURTLESHIELD = ITEMS.register("turtle_shield", () -> new ShieldItem(new Item.Properties()));

    public static final RegistryObject<Item> CACTUS_SWORD = ITEMS.register("cactus_sword", () -> new CactusSwordItem(ModMaterials.CACTUS,3,2.0F,new Item.Properties()));
    public static final RegistryObject<Item> ANTI_CACTUS_SWORD = ITEMS.register("anti_cactus_sword", () -> new AntiCactusSwordItem(ModMaterials.CACTUS,3,2.0F,new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_CACTUS_SWORD = ITEMS.register("cactus_blood_sword", () -> new BloodCactusSwordItem(ModMaterials.CACTUS,3,2.0F,new Item.Properties()));
    public static final RegistryObject<Item> END_CACTUS_SWORD = ITEMS.register("cactus_end_sword", () -> new EndCactusSwordItem(ModMaterials.CACTUS,3,2.0F,new Item.Properties()));

    public static final RegistryObject<Item> CACTUS_SPINE = ITEMS.register("cactus_spine",()->new Cactus_Spine_Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> BLOOD_SPINE = ITEMS.register("blood_spine",()->new Blood_Spine_Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ANTI_SPINE = ITEMS.register("anti_spine",()->new Anti_Cactus_Spine_Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> CHAKRAM = ITEMS.register("chakram", () -> new ChakramItem(ModMaterials.DARKNESS,0,6.0F,new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> TOMAHAWK = ITEMS.register("tomahawk", () -> new TomahawkItem(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> SCYTHE = ITEMS.register("scythe", ()-> new ScytheItem(ModMaterials.DARKNESS, 13,3.0F, new Item.Properties()));
    //public static final RegistryObject<Item> ARESBOW = ITEMS.register("aresbow", ()-> new AresBowItem(new Item.Properties().fireResistant()));
    //public static final RegistryObject<Item> ARESARROW = ITEMS.register("ares_arrow", ()-> new AresArrowItem(new Item.Properties().fireResistant().stacksTo(64)));

    public static final RegistryObject<Item> REGROWTHAXE = ITEMS.register("regrowth_axe", () -> new AxeOfRegrowthItem(ModMaterials.CACTUS,0,3, new Item.Properties()));


    //public static final RegistryObject<Item> BEETLEWINGS = ITEMS.register("beetlewings", ()-> new BeetleWingsItem(new Item.Properties().durability(543).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SOUL_COIN = ITEMS.register("soul_coin", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SOUL_MUD = ITEMS.register("soul_mud",()-> new Item(new Item.Properties()));

//Spawn Eggs
    public static final RegistryObject<Item> CBSE = ITEMS.register("cactus_egg", () -> new ForgeSpawnEggItem(ModEntities.CACTUS_BUDDY,0x649832,0xbabf95,new Item.Properties()));
    public static final RegistryObject<Item> CHSE = ITEMS.register("cheese_egg", () -> new ForgeSpawnEggItem(ModEntities.CHEESE_HORSE,0x649832,0xbabf95,new Item.Properties()));
    public static final RegistryObject<Item> EMSE = ITEMS.register("eyeball_monster_egg", () -> new ForgeSpawnEggItem(ModEntities.EYEBALL_MONSTER,0xffffff,0xf5ffc4,new Item.Properties()));
    public static final RegistryObject<Item> SSE = ITEMS.register("skull_egg", () -> new ForgeSpawnEggItem(ModEntities.SKULL,0xffffff,0xffffff,new Item.Properties()));
    public static final RegistryObject<Item> MSSE = ITEMS.register("mini_skull_egg", () -> new ForgeSpawnEggItem(ModEntities.MINI_SKULL,0x432f02,0xff24ff,new Item.Properties()));
    //public static final RegistryObject<Item> LTSE = ITEMS.register("lion_thing_egg", () -> new ForgeSpawnEggItem(ModEntities.LION_THING,0x773d3d,0x2e2e2e,new Item.Properties()));
    public static final RegistryObject<Item> MOSE = ITEMS.register("mo_egg", () -> new ForgeSpawnEggItem(ModEntities.MO,0x014415,0x800303,new Item.Properties()));
    public static final RegistryObject<Item> MO2SE = ITEMS.register("mo2_egg", () -> new ForgeSpawnEggItem(ModEntities.MO2,0x014415,0x800303,new Item.Properties()));
    public static final RegistryObject<Item> MRSE = ITEMS.register("manta_ray_egg", () -> new ForgeSpawnEggItem(ModEntities.MANTA_RAY,0x773d3d,0x2e2e2e,new Item.Properties()));
    public static final RegistryObject<Item> OSE = ITEMS.register("owl_egg", () -> new ForgeSpawnEggItem(ModEntities.OWL,0x773d3d,0xcba5a5,new Item.Properties()));
    public static final RegistryObject<Item> PSE = ITEMS.register("penguin_egg", () -> new ForgeSpawnEggItem(ModEntities.PENGUIN,0x473d77,0x756aa9,new Item.Properties()));
    public static final RegistryObject<Item> WTSE = ITEMS.register("war_tortoise_egg", () -> new ForgeSpawnEggItem(ModEntities.WAR_TORTOISE,0x5d2c28,0xbf6f4a,new Item.Properties()));
    public static final RegistryObject<Item> WTUSE = ITEMS.register("war_turtle_egg", () -> new ForgeSpawnEggItem(ModEntities.WAR_TURTLE,0x5d2c28,0xbf6f4a,new Item.Properties()));
    public static final RegistryObject<Item> WTHSE = ITEMS.register("war_turtle_hybrid_egg", () -> new ForgeSpawnEggItem(ModEntities.WAR_TORTOISE_HYBRID,0x335933,0xbf6f4a,new Item.Properties()));


//Buckets
    public static final RegistryObject<Item> SOAP_WATER_BUCKET = ITEMS.register("soap_water_bucket",
            () -> new BucketItem(ModFluids.SOAP_WATER_FLUID,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> ENDER_BLOOD_BUCKET = ITEMS.register("ender_blood_bucket",
            () -> new BucketItem(ModFluids.ENDER_BLOOD_FLUID,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> BLOOD_BUCKET = ITEMS.register("blood_bucket",
            () -> new BucketItem(ModFluids.BLOOD_FLUID,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> DEITY_BLOOD_BUCKET = ITEMS.register("deity_blood_bucket",
            () -> new BucketItem(ModFluids.DEITY_BLOOD_FLUID,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(13)));
    public static final RegistryObject<Item> DARK_ESSENCE_BUCKET = ITEMS.register("dark_essence_bucket",
            () -> new BucketItem(ModFluids.DARK_ESSENCE_FLUID,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));


//Armor
    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new ArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> ABYSS_BOOTS = ITEMS.register("abyss_boots",
            () -> new ArmorItem(ModArmorMaterials.DARK, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> WAR_TORTOISE_ARMOR = ITEMS.register("war_tortoise_armor",
            ()-> new WarTortoiseArmor(ArmorMaterials.TURTLE, ArmorItem.Type.BODY, new Item.Properties()));
    public static final RegistryObject<Item> WAR_TORTOISE_HYBRID_ARMOR = ITEMS.register("war_tortoise_hybrid_armor",
            ()-> new WarTortoiseHybridArmor(ArmorMaterials.TURTLE, ArmorItem.Type.BODY, new Item.Properties()));
    public static final RegistryObject<Item> WAR_TORTOISE_HYBRID_ARMOR_IRON = ITEMS.register("war_tortoise_hybrid_armor_iron",
            ()-> new WarTortoiseHybridArmor(ArmorMaterials.TURTLE, ArmorItem.Type.BODY, new Item.Properties()));
    public static final RegistryObject<Item> WAR_TURTLE_ARMOR = ITEMS.register("iron_war_turtle_armor",
            ()-> new WarTurtleArmor(ArmorMaterials.TURTLE, ArmorItem.Type.BODY, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_WAR_TURTLE_ARMOR = ITEMS.register("netherite_war_turtle_armor",
            ()-> new WarTurtleArmor(ArmorMaterials.NETHERITE, ArmorItem.Type.BODY, new Item.Properties()));

/**
//MusicDiscs
    public static final RegistryObject<Item> MUCSIC_DSK_1 = ITEMS.register("bar_brawl_music_disc",
        ()-> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.BAR_BRAWL)));
**/
//Signs
    public static final RegistryObject<Item> DARK_SIGN = ITEMS.register("dark_sign",
            ()-> new SignItem(new Item.Properties().stacksTo(16),ModBlocks.DARK_SIGN.get(),ModBlocks.DARK_WALL_SIGN.get()));
    public static final RegistryObject<Item> DARK_HANGING_SIGN = ITEMS.register("dark_hanging_sign",
            ()-> new HangingSignItem(ModBlocks.DARK_HANGING_SIGN.get(),ModBlocks.DARK_WALL_HANGING_SIGN.get(),new Item.Properties().stacksTo(16)));
public static final RegistryObject<Item> BLOOD_SIGN = ITEMS.register("blood_sign",
            ()-> new SignItem(new Item.Properties().stacksTo(16),ModBlocks.DARK_SIGN.get(),ModBlocks.DARK_WALL_SIGN.get()));
    public static final RegistryObject<Item> BLOOD_HANGING_SIGN = ITEMS.register("blood_hanging_sign",
            ()-> new HangingSignItem(ModBlocks.DARK_HANGING_SIGN.get(),ModBlocks.DARK_WALL_HANGING_SIGN.get(),new Item.Properties().stacksTo(16)));
public static final RegistryObject<Item> VOID_SIGN = ITEMS.register("void_sign",
            ()-> new SignItem(new Item.Properties().stacksTo(16),ModBlocks.DARK_SIGN.get(),ModBlocks.DARK_WALL_SIGN.get()));
    public static final RegistryObject<Item> VOID_HANGING_SIGN = ITEMS.register("void_hanging_sign",
            ()-> new HangingSignItem(ModBlocks.DARK_HANGING_SIGN.get(),ModBlocks.DARK_WALL_HANGING_SIGN.get(),new Item.Properties().stacksTo(16)));

//RANDOM
    public static final RegistryObject<Item> DPITEM = ITEMS.register("dpitem",
        ()-> new DeathTPItem(new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventbus) {ITEMS.register(eventbus);}

}