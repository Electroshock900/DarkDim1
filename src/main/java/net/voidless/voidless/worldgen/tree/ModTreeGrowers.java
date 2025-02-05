package net.voidless.voidless.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower DARK = new TreeGrower(VoidlessMod.MODID + ":dark_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.DARK_TREE_KEY),Optional.empty());
    public static final TreeGrower BLOOD = new TreeGrower(VoidlessMod.MODID + ":blood_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.BLOOD_TREE_KEY),Optional.empty());
    public static final TreeGrower VOID = new TreeGrower(VoidlessMod.MODID + ":void_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.VOID_TREE_KEY),Optional.empty());

}
