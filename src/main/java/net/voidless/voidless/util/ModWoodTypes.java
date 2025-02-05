package net.voidless.voidless.util;

import net.voidless.voidless.VoidlessMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType DARK = WoodType.register(new WoodType(VoidlessMod.MODID + ":dark", BlockSetType.DARK_OAK));
    public static final WoodType BLOOD = WoodType.register(new WoodType(VoidlessMod.MODID + ":blood", BlockSetType.DARK_OAK));
    public static final WoodType VOID = WoodType.register(new WoodType(VoidlessMod.MODID + ":void", BlockSetType.DARK_OAK));
}