package net.voidless.voidless.util;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VoidlessMod.MODID);


    public static final RegistryObject<CreativeModeTab> DEATH_TAB = CREATIVE_MODE_TABS.register("death_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.DARK_SHARD.get()))
                    .title(Component.translatable("creativetab.voidless.death_tab"))
                    .displayItems((pParameters, pOutput) ->{
                        pOutput.accept(ModBlocks.DEATH_BLOCK.get());
                        //pOutput.accept(ModItems.FIRE_CHARM.get());
//ORES AND BLOCKS OF ORES
                        pOutput.accept(ModItems.RAW_DARK_SHARD.get());
                        pOutput.accept(ModItems.DARK_SHARD.get());
                        pOutput.accept(ModBlocks.DARK_SHARD_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_DARK_SHARD_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_DARK_SHARD_ORE.get());
                        pOutput.accept(ModBlocks.RAW_DARKNESS_BLOCK.get());
                        pOutput.accept(ModBlocks.DARKNESS_BLOCK.get());

//FOOD BLOCKS
                        pOutput.accept(ModBlocks.BBR.get());
                        pOutput.accept(ModBlocks.BBC.get());
                        pOutput.accept(ModBlocks.BPR.get());
                        pOutput.accept(ModBlocks.BPC.get());
                        pOutput.accept(ModBlocks.BMR.get());
                        pOutput.accept(ModBlocks.BMC.get());
                        pOutput.accept(ModBlocks.BCR.get());
                        pOutput.accept(ModBlocks.BCC.get());


//ARMORMENTS
                        pOutput.accept(ModItems.REGROWTHAXE.get());
/**
                        pOutput.accept(ModItems.CACTUS_SWORD.get());
                        pOutput.accept(ModItems.ANTI_CACTUS_SWORD.get());
                        pOutput.accept(ModItems.BLOOD_CACTUS_SWORD.get());
                        pOutput.accept(ModItems.END_CACTUS_SWORD.get());
                        pOutput.accept(ModItems.CACTUS_SPINE.get());
                        pOutput.accept(ModItems.ANTI_SPINE.get());
                        pOutput.accept(ModItems.BLOOD_SPINE.get());**/

                        pOutput.accept(ModItems.SCYTHE.get());
                        pOutput.accept(ModItems.AMETHYST_HELMET.get());
                        pOutput.accept(ModItems.AMETHYST_CHESTPLATE.get());
                        pOutput.accept(ModItems.AMETHYST_LEGGINGS.get());
                        pOutput.accept(ModItems.AMETHYST_BOOTS.get());
                        pOutput.accept(ModItems.WAR_TURTLE_ARMOR.get());
                        //pOutput.accept(ModItems.NETHERITE_WAR_TURTLE_ARMOR.get());
                        pOutput.accept(ModItems.WAR_TORTOISE_ARMOR.get());
                        pOutput.accept(ModItems.WAR_TORTOISE_HYBRID_ARMOR.get());
                        pOutput.accept(ModItems.CHAKRAM.get());
                        pOutput.accept(ModItems.TOMAHAWK.get());
                        pOutput.accept(ModItems.TURTLESHIELD.get());
                        /**pOutput.accept(ModItems.ARESBOW.get());
                        //pOutput.accept(ModItems.ARESARROW.get());
                        pOutput.accept(ModItems.BEETLEWINGS.get());**/
//SPAWN EGGS
                        pOutput.accept(ModItems.CBSE.get());
                        pOutput.accept(ModItems.CHSE.get());
                        pOutput.accept(ModItems.EMSE.get());
                        pOutput.accept(ModItems.SSE.get());
                        pOutput.accept(ModItems.MSSE.get());
                        //pOutput.accept(ModItems.LTSE.get());
                        pOutput.accept(ModItems.MRSE.get());
                        pOutput.accept(ModItems.OSE.get());
                        pOutput.accept(ModItems.PSE.get());
                        pOutput.accept(ModItems.WTUSE.get());
                        pOutput.accept(ModItems.WTSE.get());
                        pOutput.accept(ModItems.WTHSE.get());

                        pOutput.accept(ModItems.SOUL_MUD.get());
                        pOutput.accept(ModItems.SOUL_COIN.get());

                        pOutput.accept(ModItems.DPITEM.get());
                        pOutput.accept(ModBlocks.DARKSIDE_PORTAL2.get());
                        pOutput.accept(ModBlocks.MODPORTAL.get());
                        pOutput.accept(ModBlocks.DARKSIDE_PORTAL.get());


                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> DEATH_NATURE = CREATIVE_MODE_TABS.register("death_nature_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.DARK_DIRT.get()))
                    .title(Component.translatable("creativetab.voidless.death_nature_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {
                        pOutput.accept(ModBlocks.DARK_GRASS.get());
                        pOutput.accept(ModBlocks.DARK_DIRT.get());
                        pOutput.accept(ModBlocks.DARK_STONE.get());
                        pOutput.accept(ModBlocks.DARK_COBBLESTONE.get());
                        pOutput.accept(ModBlocks.DARK_SAPLING.get());
                        pOutput.accept(ModBlocks.DARK_LEAVES.get());
                        pOutput.accept(ModBlocks.DARK_LOG.get());
                        pOutput.accept(ModBlocks.DARK_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_DARK_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_DARK_WOOD.get());
                        pOutput.accept(ModBlocks.DARK_PLANKS.get());
                        pOutput.accept(ModBlocks.DARK_STAIRS.get());
                        pOutput.accept(ModBlocks.DARK_SLAB.get());
                        pOutput.accept(ModBlocks.DARK_WALL.get());
                        pOutput.accept(ModBlocks.DARK_DOOR.get());
                        pOutput.accept(ModBlocks.DARK_FENCE.get());
                        pOutput.accept(ModBlocks.DARK_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.DARK_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.DARK_BUTTON.get());
                        pOutput.accept(ModBlocks.DARK_SIGN.get());
                        pOutput.accept(ModBlocks.DARK_HANGING_SIGN.get());

                        pOutput.accept(ModBlocks.BLOOD_STONE.get());
                        pOutput.accept(ModBlocks.BLOOD_COBBLESTONE.get());
                        pOutput.accept(ModBlocks.BLOOD_SAPLING.get());
                        pOutput.accept(ModBlocks.BLOOD_LEAVES.get());
                        pOutput.accept(ModBlocks.BLOOD_LOG.get());
                        pOutput.accept(ModBlocks.BLOOD_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_BLOOD_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_BLOOD_WOOD.get());
                        pOutput.accept(ModBlocks.BLOOD_PLANKS.get());
                        pOutput.accept(ModBlocks.BLOOD_STAIRS.get());
                        pOutput.accept(ModBlocks.BLOOD_SLAB.get());
                        pOutput.accept(ModBlocks.BLOOD_WALL.get());
                        pOutput.accept(ModBlocks.BLOOD_DOOR.get());
                        pOutput.accept(ModBlocks.BLOOD_FENCE.get());
                        pOutput.accept(ModBlocks.BLOOD_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.BLOOD_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.BLOOD_BUTTON.get());
                        /**pOutput.accept(ModBlocks.BLOOD_SIGN.get());
                        pOutput.accept(ModBlocks.BLOOD_HANGING_SIGN.get());**/

                        pOutput.accept(ModBlocks.VOID_STONE.get());
                        pOutput.accept(ModBlocks.VOID_COBBLESTONE.get());
                        pOutput.accept(ModBlocks.VOID_SAPLING.get());
                        pOutput.accept(ModBlocks.VOID_LEAVES.get());
                        pOutput.accept(ModBlocks.VOID_LOG.get());
                        pOutput.accept(ModBlocks.VOID_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_VOID_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_VOID_WOOD.get());
                        pOutput.accept(ModBlocks.VOID_PLANKS.get());
                        pOutput.accept(ModBlocks.VOID_STAIRS.get());
                        pOutput.accept(ModBlocks.VOID_SLAB.get());
                        pOutput.accept(ModBlocks.VOID_WALL.get());
                        pOutput.accept(ModBlocks.VOID_DOOR.get());
                        pOutput.accept(ModBlocks.VOID_FENCE.get());
                        pOutput.accept(ModBlocks.VOID_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.VOID_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.VOID_BUTTON.get());
                        /**pOutput.accept(ModBlocks.VOID_SIGN.get());
                        pOutput.accept(ModBlocks.VOID_HANGING_SIGN.get());**/



                        pOutput.accept(ModBlocks.ANTI_CACTUS.get());
                        pOutput.accept(ModBlocks.BLOOD_CACTUS.get());
                        pOutput.accept(ModBlocks.DARK_CACTUS.get());
                        pOutput.accept(ModBlocks.END_CACTUS.get());

                        pOutput.accept(ModBlocks.LOTUS.get());
                        pOutput.accept(ModBlocks.BLOOD_BLOCK.get());
                        pOutput.accept(ModBlocks.ENDER_BLOOD_BLOCK.get());
                        pOutput.accept(ModBlocks.DEITY_BLOOD_BLOCK.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> ABYSS_TAB = CREATIVE_MODE_TABS.register("abyss_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.DARK_DIRT.get()))
                    .title(Component.translatable("creativetab.voidless.abyss_tab"))
                    .displayItems((pParameters, pOutput) ->
                    {

                        //pOutput.accept(ModItems.ARESBOW.get());
                        //pOutput.accept(ModItems.ARESARROW.get());
                        pOutput.accept(ModItems.ANTI_CACTUS_SWORD.get());
                        pOutput.accept(ModItems.ANTI_SPINE.get());
                        pOutput.accept(ModItems.CACTUS_SWORD.get());
                        pOutput.accept(ModItems.CACTUS_SPINE.get());
                        pOutput.accept(ModItems.BLOOD_CACTUS_SWORD.get());
                        pOutput.accept(ModItems.BLOOD_SPINE.get());
                        pOutput.accept(ModItems.END_CACTUS_SWORD.get());
                        //pOutput.accept(ModItems.SPINE.get());
                        pOutput.accept(ModItems.ABYSS_BOOTS.get());
                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
