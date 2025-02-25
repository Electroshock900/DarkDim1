package net.voidless.voidless.enchantments;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;
import net.voidless.voidless.entity.custom.Cactus_Buddy;
import net.voidless.voidless.entity.custom.Mo2;
import net.voidless.voidless.util.ModEntities;

public record Summon() implements EnchantmentEntityEffect {
    public static MapCodec<Summon> CODEC = MapCodec.unit(Summon::new);
    public static Cactus_Buddy cactusBuddy;
    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse pItem, Entity entity, Vec3 vec3) {
        assert pItem.owner() != null;
        Mo2 T = ModEntities.MO2.get().spawn(serverLevel,entity.getOnPos().multiply(2), MobSpawnType.TRIGGERED);
        /*if (pItem.owner() instanceof Player player){
            assert T != null;
            T.tame(player);
        }*/

        serverLevel.addFreshEntity(new Mo2(ModEntities.MO2.get()
                , entity.level()
                ));
        //pItem.owner().level()
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
