package net.voidless.voidless.datagen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.util.ModBlocks;
import net.voidless.voidless.util.ModItems;
import net.voidless.voidless.worldgen.portal.DeathPortalBlock_Current;
import net.voidless.voidless.worldgen.portal.VoidPortalBlock;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, VoidlessMod.MODID,existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DARK_SHARD);
        simpleItem(ModItems.RAW_DARK_SHARD);
        /**
        simpleItem(ModItems.ARESARROW);
        simpleItem(ModItems.CACTUS_SPINE);
        simpleItem(ModItems.BLOOD_SPINE);
        simpleItem(ModItems.ANTI_SPINE);
        **/
        simpleItem(ModItems.REGROWTHAXE);

        simpleBlockItem(ModBlocks.DARK_DOOR);
        fenceItem(ModBlocks.DARK_FENCE, ModBlocks.DARK_PLANKS);
        buttonItem(ModBlocks.DARK_BUTTON,ModBlocks.DARK_PLANKS);
        wallItem(ModBlocks.DARK_WALL, ModBlocks.DARK_PLANKS);
        evenSimplerBlockItem(ModBlocks.DARK_STAIRS);
        evenSimplerBlockItem(ModBlocks.DARK_SLAB);
        evenSimplerBlockItem(ModBlocks.DARK_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.DARK_FENCE_GATE);
        trapdoorItem(ModBlocks.DARK_TRAPDOOR);

        simpleBlockItem(ModBlocks.BLOOD_DOOR);
        fenceItem(ModBlocks.BLOOD_FENCE, ModBlocks.DARK_PLANKS);
        buttonItem(ModBlocks.BLOOD_BUTTON,ModBlocks.DARK_PLANKS);
        wallItem(ModBlocks.BLOOD_WALL, ModBlocks.BLOOD_PLANKS);
        evenSimplerBlockItem(ModBlocks.BLOOD_STAIRS);
        evenSimplerBlockItem(ModBlocks.BLOOD_SLAB);
        evenSimplerBlockItem(ModBlocks.BLOOD_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.BLOOD_FENCE_GATE);
        trapdoorItem(ModBlocks.BLOOD_TRAPDOOR);
        simpleBlockItemBlockTexture(ModBlocks.BLOOD_PLANKS);
        evenSimplerBlockItem(ModBlocks.VOID_PLANKS);


        evenSimplerBlockItem(ModBlocks.VOID_STONE);
        evenSimplerBlockItem(ModBlocks.VOID_COBBLESTONE);
        simpleBlockItem(ModBlocks.VOID_DOOR);
        fenceItem(ModBlocks.VOID_FENCE, ModBlocks.VOID_PLANKS);
        buttonItem(ModBlocks.VOID_BUTTON,ModBlocks.VOID_PLANKS);
        wallItem(ModBlocks.VOID_WALL, ModBlocks.VOID_PLANKS);
        evenSimplerBlockItem(ModBlocks.VOID_STAIRS);
        evenSimplerBlockItem(ModBlocks.VOID_SLAB);
        evenSimplerBlockItem(ModBlocks.VOID_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.VOID_FENCE_GATE);
        trapdoorItem(ModBlocks.VOID_TRAPDOOR);

        //simpleBlockItem(ModBlocks.DARK_SIGN);
        //simpleBlockItem(ModBlocks.DARK_HANGING_SIGN);
        saplingItem(ModBlocks.DARK_SAPLING);
        saplingItem(ModBlocks.BLOOD_SAPLING);
        saplingItem(ModBlocks.VOID_SAPLING);

        //evenSimplerBlockItem(ModBlocks.DARKSIDE_PORTAL);

        trimmedArmorItem(ModItems.AMETHYST_HELMET);
        trimmedArmorItem(ModItems.AMETHYST_CHESTPLATE);
        trimmedArmorItem(ModItems.AMETHYST_LEGGINGS);
        trimmedArmorItem(ModItems.AMETHYST_BOOTS);
/**
        simpleBlockItem(ModBlocks.BBR);
        simpleBlockItem(ModBlocks.BBC);
        simpleBlockItem(ModBlocks.BCR);
        simpleBlockItem(ModBlocks.BCC);
        simpleBlockItem(ModBlocks.BMR);
        simpleBlockItem(ModBlocks.BMC);
        simpleBlockItem(ModBlocks.BPR);
        simpleBlockItem(ModBlocks.BPC);**/

        withExistingParent(ModItems.CBSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.CHSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.EMSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.SSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.MSSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        //withExistingParent(ModItems.LTSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.MRSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.OSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.PSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.WTSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.WTUSE.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.WTHSE.getId().getPath(), mcLoc("item/template_spawn_egg"));

        //untrimmedArmorItem(ModItems.WAR_TORTOISE_ARMOR);
        simpleItem(ModItems.WAR_TURTLE_ARMOR);
        simpleItem(ModItems.NETHERITE_WAR_TURTLE_ARMOR);
        simpleBlockItemBlockTexture(ModBlocks.LOTUS);
        evenSimplerDarkSidePortalItem(ModBlocks.DARKSIDE_PORTAL);

        }
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = VoidlessMod.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
    private void untrimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = VoidlessMod.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(armorItemPath)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(VoidlessMod.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    } public void evenSimplerDarkSidePortalItem(RegistryObject<DeathPortalBlock_Current> block) {
        this.withExistingParent(VoidlessMod.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void evenSimplerDarkSidePortalItem2(RegistryObject<VoidPortalBlock> block) {
        this.withExistingParent(VoidlessMod.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder DPBBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"block/" + item.getId().getPath()));
    }
}

