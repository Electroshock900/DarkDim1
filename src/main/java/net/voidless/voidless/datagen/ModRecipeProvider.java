package net.voidless.voidless.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModBlocks;
import net.voidless.voidless.util.ModItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> DARK_SHARD_SMELTABLES = List.of(ModBlocks.DARK_SHARD_ORE.get(),ModBlocks.DEEPSLATE_DARK_SHARD_ORE.get(),ModBlocks.NETHER_DARK_SHARD_ORE.get());
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(output, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {

//FOOD BLOCK COOKING
        oreSmelting(consumer, List.of(ModBlocks.BBR.get()), RecipeCategory.FOOD, ModBlocks.BBC.get(), 0.7F, 200, "bbr_bbc");
        oreSmelting(consumer, List.of(ModBlocks.BCR.get()), RecipeCategory.FOOD, ModBlocks.BCC.get(), 0.7F, 200, "bcr_bcc");
        oreSmelting(consumer, List.of(ModBlocks.BMR.get()), RecipeCategory.FOOD, ModBlocks.BMC.get(), 0.7F, 200, "bmr_bmc");
        oreSmelting(consumer, List.of(ModBlocks.BPR.get()), RecipeCategory.FOOD, ModBlocks.BPC.get(), 0.7F, 200, "bpr_bpc");

        oreSmelting(consumer, List.of(ModItems.RAW_DARK_SHARD.get()), RecipeCategory.BUILDING_BLOCKS, ModItems.DARK_SHARD.get(), 0.7F, 50, "rds_ds");
        oreBlasting(consumer, List.of(ModItems.RAW_DARK_SHARD.get()), RecipeCategory.BUILDING_BLOCKS, ModItems.DARK_SHARD.get(), 1.4F, 25, "rds_ds_blasting");

        oreSmelting(consumer, DARK_SHARD_SMELTABLES,RecipeCategory.MISC,ModItems.DARK_SHARD.get(),0.25F,200,"darkshard");
        oreBlasting(consumer, DARK_SHARD_SMELTABLES,RecipeCategory.MISC, ModItems.DARK_SHARD.get(),0.50F,100,"darkshard");
//FOOD BLOCKS
        nineBlockStorageRecipes(consumer,RecipeCategory.FOOD, Items.BEEF,RecipeCategory.FOOD, ModBlocks.BBR.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.FOOD, Items.COOKED_BEEF,RecipeCategory.FOOD, ModBlocks.BBC.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.FOOD, Items.CHICKEN,RecipeCategory.FOOD, ModBlocks.BCR.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.FOOD, Items.COOKED_CHICKEN,RecipeCategory.FOOD, ModBlocks.BCC.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.FOOD, Items.MUTTON,RecipeCategory.FOOD, ModBlocks.BMR.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.FOOD, Items.COOKED_MUTTON,RecipeCategory.FOOD, ModBlocks.BMC.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.FOOD, Items.PORKCHOP,RecipeCategory.FOOD, ModBlocks.BPR.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.FOOD, Items.COOKED_PORKCHOP,RecipeCategory.FOOD, ModBlocks.BPC.get());
//DARK SHARDS
        nineBlockStorageRecipes(consumer,RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_DARK_SHARD.get(),RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_DARKNESS_BLOCK.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.BUILDING_BLOCKS, ModItems.DARK_SHARD.get(),RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARKNESS_BLOCK.get());
//CHAKRAM
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CHAKRAM.get())
                .pattern("SSS")
                .pattern("SFS")
                .pattern("SSS")
                .define('S', ModItems.DARK_SHARD.get())
                .define('F', Items.STICK)
                .unlockedBy(getHasName(ModItems.CHAKRAM.get()),has(ModItems.CHAKRAM.get()))
                .save(consumer);
/**
        nineBlockStorageRecipes(consumer,RecipeCategory.BUILDING_BLOCKS, ModItems.ANTI_SPINE.get(),RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANTI_CACTUS.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.BUILDING_BLOCKS, ModItems.BLOOD_SPINE.get(),RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_CACTUS.get());
        nineBlockStorageRecipes(consumer,RecipeCategory.BUILDING_BLOCKS, ModItems.CACTUS_SPINE.get(),RecipeCategory.BUILDING_BLOCKS, Blocks.CACTUS );

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ANTI_CACTUS_SWORD.get())
                        .pattern("  C")
                        .pattern(" C ")
                        .pattern("S  ")
                                .define('S',Items.STICK)
                                .define('C',ModBlocks.ANTI_CACTUS.get())
                                        .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.END_CACTUS_SWORD.get())
                        .pattern("  C")
                        .pattern(" C ")
                        .pattern("S  ")
                                .define('S',Items.STICK)
                                .define('C',ModBlocks.END_CACTUS.get())
                                        .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLOOD_CACTUS_SWORD.get())
                        .pattern("  C")
                        .pattern(" C ")
                        .pattern("S  ")
                                .define('S',Items.STICK)
                                .define('C',ModBlocks.DARK_CACTUS.get())
                                        .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CACTUS_SWORD.get())
                        .pattern("  C")
                        .pattern(" C ")
                        .pattern("S  ")
                                .define('S',Items.STICK)
                                .define('C',Blocks.CACTUS)
                                        .save(consumer);
**/
        nineBlockStorageRecipes(consumer,RecipeCategory.BUILDING_BLOCKS,ModItems.SOUL_MUD.get(),RecipeCategory.BUILDING_BLOCKS,Blocks.SOUL_SOIL);

//SIGNS

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS,ModItems.DARK_SIGN.get(),3)
                .pattern("DDD")
                .pattern("DDD")
                .pattern(" 3 ")
                .define('3', Items.STICK)
                .define('D', ModBlocks.DARK_PLANKS.get())
                .unlockedBy(getHasName(Items.STICK),has(Items.STICK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS,ModItems.DARK_HANGING_SIGN.get(),6)
                .pattern("C C")
                .pattern("DDD")
                .pattern("DDD")
                .define('C', Items.CHAIN)
                .define('D', ModBlocks.STRIPPED_DARK_LOG.get())
                .unlockedBy(getHasName(Blocks.CHAIN),has(Blocks.CHAIN))
                .save(consumer);

/**
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.DARK_SHARD.get(),9)
                .requires(ModBlocks.DARKNESS_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.DARKNESS_BLOCK.get()), has(ModBlocks.DARKNESS_BLOCK.get()))
                .save(consumer);
**/

    }
    protected static void nineBlockStorageRecipes(RecipeOutput p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }
    protected static void nineBlockStorageRecipes(RecipeOutput p_250423_, RecipeCategory p_250083_, ItemLike p_250042_, RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_, String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_)).save(p_250423_, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_).unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, p_250475_));
    }
}
