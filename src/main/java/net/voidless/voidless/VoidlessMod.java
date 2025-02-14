package net.voidless.voidless;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.voidless.voidless.entity.render.*;
import net.voidless.voidless.fluid.ModFluidTypes;
import net.voidless.voidless.fluid.ModFluids;
import net.voidless.voidless.screen.custom.WarTortoiseHybridScreen;
import net.voidless.voidless.screen.custom.WarTortoiseScreen;
import net.voidless.voidless.screen.custom.WarTurtleScreen;
import net.voidless.voidless.util.*;
import net.voidless.voidless.worldgen.biomes.ModTerraBlender;
import net.voidless.voidless.worldgen.biomes.surface.ModSurfaceRules;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VoidlessMod.MODID)
public class VoidlessMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "voidless";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public VoidlessMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        //DeathFeatures.register(modEventBus);
        ModEffects.register(modEventBus);

        ModEntities.register(modEventBus);
        ModParticles.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModSounds.register(modEventBus);
        ModTabs.register(modEventBus);

        ModEnchantmentEffects.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModPoiTypes.register(modEventBus);
        ModTerraBlender.registerBiomes();



        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock) {
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
            //LOGGER.info(String.valueOf(ModParticles.GHOSTLY_FLAME_FX.getKey().location()));
            //LOGGER.info(ModParticles.GHOSTLY_FLAME_FX.getId().toString());
            //LOGGER.info(ModParticles.GHOSTLY_FLAME_FX.getId().getPath());
        }
        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, ModSurfaceRules.makeRules());


        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(Blocks.CACTUS);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            EntityRenderers.register(ModEntities.TOMAHAWK.get(), TomahawkProjectileRenderer::new);
            EntityRenderers.register(ModEntities.CHAKRAM.get(), Chakram_Renderer::new);
            EntityRenderers.register(ModEntities.CACTUS_BUDDY.get(), Cactus_Buddy_Renderer::new);
            EntityRenderers.register(ModEntities.EYEBALL_MONSTER.get(), Eyeball_Monster_Renderer::new);
            //EntityRenderers.register(ModEntities.LION_THING.get(), Lion_Thing_Renderer::new);
            EntityRenderers.register(ModEntities.MANTA_RAY.get(), Manta_Ray_Renderer::new);
            EntityRenderers.register(ModEntities.MINI_SKULL.get(), Mini_Skull_Renderer::new);
            EntityRenderers.register(ModEntities.OWL.get(), OwlRenderer::new);
            EntityRenderers.register(ModEntities.PENGUIN.get(), PenguinRenderer::new);
            EntityRenderers.register(ModEntities.SKULL.get(), Skull_Renderer::new);
            EntityRenderers.register(ModEntities.CHEESE_HORSE.get(), CheeseHorseRenderer::new);
            EntityRenderers.register(ModEntities.WAR_TORTOISE.get(), War_Tortoise_Renderer::new);
            EntityRenderers.register(ModEntities.WAR_TORTOISE_HYBRID.get(), War_Tortoise_Hybrid_Renderer::new);
            EntityRenderers.register(ModEntities.WAR_TURTLE.get(), War_Turtle_Renderer::new);

            MenuScreens.register(ModMenuTypes.WAR_TURTLE_MENU.get(), WarTurtleScreen::new);
            MenuScreens.register(ModMenuTypes.WAR_TORTOISE_MENU.get(), WarTortoiseScreen::new);
            MenuScreens.register(ModMenuTypes.WAR_TORTOISE_HYBRID_MENU.get(), WarTortoiseHybridScreen::new);
            //RegisterParticleProvidersEvent.registerSpriteSet(ModParticles.GHOSTLY_FLAME_FX.get())


        }
    }
}
