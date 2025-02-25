package net.voidless.voidless.util;

import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.advancements.critereon.TagPredicate;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.DamageImmunity;
import net.minecraft.world.item.enchantment.effects.ReplaceDisk;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.DamageSourceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.voidless.voidless.VoidlessMod;
import net.voidless.voidless.enchantments.LifeSteal;
import net.voidless.voidless.fluid.ModFluids;

import java.util.Optional;

public class ModEnchantments {

    public static final ResourceKey<Enchantment> LIFESTEAL = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"life_steal"));
    public static final ResourceKey<Enchantment> BLOOD_WALKER = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(VoidlessMod.MODID,"blood_walker"));


    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, LIFESTEAL, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5,
                        13,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.CURSE))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM, new LifeSteal()));

        register(context, BLOOD_WALKER, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
                2,
                2,
                Enchantment.dynamicCost(10, 10),
                Enchantment.dynamicCost(25, 10),
                4,
                new EquipmentSlotGroup[]{EquipmentSlotGroup.FEET}))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.BOOTS_EXCLUSIVE))
                .withEffect(EnchantmentEffectComponents.DAMAGE_IMMUNITY,
                        DamageImmunity.INSTANCE,
                        DamageSourceCondition.hasDamageSource(
                                DamageSourcePredicate.Builder.damageType()
                                        .tag(TagPredicate.is(DamageTypeTags.BURN_FROM_STEPPING))
                                        .tag(TagPredicate.isNot(DamageTypeTags.BYPASSES_INVULNERABILITY))))
                .withEffect(EnchantmentEffectComponents.LOCATION_CHANGED,
                        new ReplaceDisk(
                                new LevelBasedValue.Clamped(
                                        LevelBasedValue.perLevel(3.0F, 1.0F),
                                        0.0F,
                                        16.0F),
                                LevelBasedValue.constant(1.0F),
                                new Vec3i(0, -1, 0),
                                Optional.of(BlockPredicate.allOf(
                                        new BlockPredicate[]{BlockPredicate.matchesTag(
                                                new Vec3i(0, 1, 0), BlockTags.AIR),
                                                BlockPredicate.matchesBlocks(new Block[]{ModBlocks.BLOOD_BLOCK.get()}),
                                                BlockPredicate.matchesFluids(new Fluid[]{ModFluids.BLOOD_FLUID.get()}),
                                                BlockPredicate.unobstructed()})), BlockStateProvider.simple(ModBlocks.CONGEALED_BLOOD.get()),
                                Optional.of(GameEvent.BLOCK_PLACE)),
                        LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS,
                                net.minecraft.advancements.critereon.EntityPredicate.Builder.entity().flags(net.minecraft.advancements.critereon.EntityFlagsPredicate.Builder.flags().setOnGround(true)))));
    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }

}
