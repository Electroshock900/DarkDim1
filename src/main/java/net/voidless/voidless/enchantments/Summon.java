package net.voidless.voidless.enchantments;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.voidless.voidless.entity.custom.Cactus_Buddy2;
import net.voidless.voidless.entity.custom.WarTortoise;
import net.voidless.voidless.entity.custom.WarTortoiseHybrid;
import net.voidless.voidless.util.ModEntities;

public record Summon() implements EnchantmentEntityEffect {
    public static MapCodec<Summon> CODEC = MapCodec.unit(Summon::new);
    public static Cactus_Buddy2 cactusBuddy;
    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse pItem, Entity entity, Vec3 vec3) {
        assert pItem.owner() != null;
        WarTortoiseHybrid T = ModEntities.WAR_TORTOISE_HYBRID.get().spawn(serverLevel,entity.getOnPos().multiply(2), MobSpawnType.TRIGGERED);
        if (pItem.owner() instanceof Player player){
            T.tame(player);
        }

        //serverLevel.addFreshEntity(new Cactus_Buddy2(ModEntities.CACTUS_BUDDY.get()., ));
        //pItem.owner().level()
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
