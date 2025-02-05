package net.voidless.voidless.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.blockentity.ModHangingSignBlockEntity;
import net.voidless.voidless.blockentity.ModSignBlockEntity;
import net.voidless.voidless.util.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, VoidlessMod.MODID);
/**
    public static final RegistryObject<BlockEntityType<AbyssalContainerEntity>> ABYSSAL_CONTAINER =
            BLOCK_ENTITIES.register("abyssal_container", () ->
                    BlockEntityType.Builder.of(AbyssalContainerEntity::new,
                            ModBlocks.ABYSSAL_CONTAINER.get()).build(null));**/
    /**public static final RegistryObject<BlockEntityType<AbyssalChestEntity>> CHEST =
        BLOCK_ENTITIES.register("chest", () ->
                BlockEntityType.Builder.of(AbyssalChestEntity::new,
                ModBlocks.CHEST.get()
        ).build(null));**//**
    public static final RegistryObject<BlockEntityType<PolisherBlockEntity>> POLISHER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("polisher_block_entity", () ->
                    BlockEntityType.Builder.of(PolisherBlockEntity::new,
                            ModBlocks.POLISHER.get()).build(null));
    public static final RegistryObject<BlockEntityType<SpecialFurnaceBE>> SPECIAL_FURNACE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("special_furnace_block_entity", () ->
                    BlockEntityType.Builder.of(SpecialFurnaceBE::new,
                            ModBlocks.SPECIAL_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<CandyCaneFurnaceBlockEntity>> CANDY_CANE_FURNACE_BLOCK_ENTITY =
                    BLOCK_ENTITIES.register("candy_cane_furnace_block_entity", () ->
                            BlockEntityType.Builder.of(CandyCaneFurnaceBlockEntity::new,
                            ModBlocks.CANDY_CANE_FURNACE.get()).build(null));**/


    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.DARK_SIGN.get(), ModBlocks.DARK_WALL_SIGN.get()

                            ).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            ModBlocks.DARK_HANGING_SIGN.get(), ModBlocks.DARK_WALL_HANGING_SIGN.get()

                            ).build(null));

    //public static final RegistryObject<BlockEntityType<?>> CRATE_ABYSS = register("crate_abyss", ModBlocks.CRATE_ABYSS, AbyssalCrateEntity::new);

    private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
                                                               BlockEntityType.BlockEntitySupplier<?> supplier) {
        return BLOCK_ENTITIES.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
