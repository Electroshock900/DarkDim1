package net.voidless.voidless.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.voidless.voidless.VoidlessMod;

public class ModTags {
    public ModTags(){}
    public static class Blocks{
        public static final TagKey<Block> VOIDLESS_INFINIBURN = createTag("voidless_infiniburn");
        public static final TagKey<Block> VOIDKIN_BLOCKS = createTag("voidkin_blocks");
        public static final TagKey<Block> INVALID_VOIDKIN_BLOCKS = createTag("invalid_voidkin_blocks");
        public static final TagKey<Block> VOIDLESS_BLOCKS = createTag("voidless_blocks");
        public static final TagKey<Block> PORTAL_DECO = createTag("voidless_portal_deco");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,name));
        }
    }
    public static class Items{
        public static final TagKey<Item> VOIDKIN_ITEMS = createTag("voidkin_items");
        public static final TagKey<Item> INVALID_VOIDKIN_ITEMS = createTag("invalid_voidkin_items");
        public static final TagKey<Item> VOIDLESS_ITEMS = createTag("voidless_items");
        public static final TagKey<Item> MO2FOOD = createTag("mo2_food");


        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,name));
        }
    }
    public static class Biomes{
        public static final TagKey<Biome> DARK_BIOMES = createTag("dark_biomes");
        public static final TagKey<Biome> BLOOD_BIOMES = createTag("blood_biomes");
        public static final TagKey<Biome> BLOOD_OCEANS = createTag("blood_oceans");

        /*private static TagKey<Biome> createTags(String name){
            return BiomeTags.create(ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,name));
        }*/
        private static TagKey<Biome> createTag(String pName) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, pName));
        }

        public static TagKey<Biome> createTag(String namepsace, String path) {
            return createTag(ResourceLocation.fromNamespaceAndPath(namepsace, path));
        }

        public static TagKey<Biome> createTag(ResourceLocation name) {
            return TagKey.create(Registries.BIOME, name);
        }
    }

}
