package net.voidless.voidless.util;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeTier;

import java.util.List;

public class ModMaterials {
    public static final Tier DARKNESS = new ForgeTier(13,10.3F,13.0F,13,ModTags.Blocks.VOIDKIN_BLOCKS,()->Ingredient.of(ModItems.DARK_SHARD.get()), ModTags.Blocks.INVALID_VOIDKIN_BLOCKS);
    public static final Tier BLOODY = new ForgeTier(13,133,13.0F,13,ModTags.Blocks.VOIDKIN_BLOCKS,()->Ingredient.of(ModItems.DARK_SHARD.get()), ModTags.Blocks.INVALID_VOIDKIN_BLOCKS);
    public static final Tier ANTI_CACTUS = new ForgeTier(13,130,13.0F,13,ModTags.Blocks.VOIDKIN_BLOCKS,()->Ingredient.of(ModItems.DARK_SHARD.get()), ModTags.Blocks.INVALID_VOIDKIN_BLOCKS);
    public static final Tier CACTUS = new ForgeTier(13,13,3.0F,7,ModTags.Blocks.VOIDKIN_BLOCKS,()->Ingredient.of(Blocks.CACTUS),ModTags.Blocks.INVALID_VOIDKIN_BLOCKS);
    public static final Tier DEITY = new ForgeTier(13,1300,3.0F,7,ModTags.Blocks.VOIDKIN_BLOCKS,()->Ingredient.of(Blocks.CACTUS),ModTags.Blocks.INVALID_VOIDKIN_BLOCKS);
}
