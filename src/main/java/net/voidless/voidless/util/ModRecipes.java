package net.voidless.voidless.util;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.voidless.voidless.VoidlessMod;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, VoidlessMod.MODID);


    /**public static final RegistryObject<RecipeSerializer<PolisherRecipe>> POLISHER_SERIALIZER =
            SERIALIZERS.register("polisher", () -> PolisherRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<SpecialFurnaceRecipe>> SPECIAL_FURNACE_SERIALIZER =
            SERIALIZERS.register("special_furnace", () -> SpecialFurnaceRecipe.Serializer.INSTANCE);
**/
    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
