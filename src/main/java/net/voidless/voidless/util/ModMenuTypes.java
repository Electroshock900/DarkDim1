package net.voidless.voidless.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.screen.custom.WarTortoiseHybridMenu;
import net.voidless.voidless.screen.custom.WarTortoiseMenu;
import net.voidless.voidless.screen.custom.WarTurtleMenu;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, VoidlessMod.MODID);
    public static final RegistryObject<MenuType<WarTurtleMenu>> WAR_TURTLE_MENU =
            registerMenuType("war_turtle", WarTurtleMenu::create);
    public static final RegistryObject<MenuType<WarTortoiseMenu>> WAR_TORTOISE_MENU =
            registerMenuType("war_tortoise", WarTortoiseMenu::create);
public static final RegistryObject<MenuType<WarTortoiseHybridMenu>> WAR_TORTOISE_HYBRID_MENU =
            registerMenuType("war_tortoise_hybrid", WarTortoiseHybridMenu::create);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory){
        return MENUS.register(name, ()-> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }
}
