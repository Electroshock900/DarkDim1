package net.voidless.voidless.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.voidless.voidless.fluid.ModFluids;
import net.voidless.voidless.util.ModParticles;

public class BloodDripParticle extends TextureSheetParticle {
    public boolean isGlowing = false;
    private final Fluid type;

    protected BloodDripParticle(ClientLevel pLevel, double pX, double pY, double pZ, Fluid pFluid) {
        super(pLevel, pX, pY, pZ);
        this.type = pFluid;
        this.gravity = 0.75F;
        this.friction = 0.999F;
        this.yd = (double)(this.random.nextFloat() * 0.4F + 0.05F);
        this.quadSize *= this.random.nextFloat() * 2.0F + 0.2F;
        this.lifetime = (int)(16.0 / (Math.random() * 0.8 + 0.2));
    }
    protected Fluid getType() {
        return this.type;
    }
    public int getLightColor(float pPartialTick) {
        return this.isGlowing ? 240 : super.getLightColor(pPartialTick);
    }

    protected void preMoveUpdate() {
        if (this.lifetime-- <= 0) {
            this.remove();
        }

    }
    protected void postMoveUpdate(){}
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.preMoveUpdate();
        if (!this.removed) {
            this.yd -= (double)this.gravity;
            this.move(this.xd, this.yd, this.zd);
            this.postMoveUpdate();
            if (!this.removed) {
                this.xd *= 0.9800000190734863;
                this.yd *= 0.9800000190734863;
                this.zd *= 0.9800000190734863;
                if (this.type != ModFluids.BLOOD_FLUID.get()) {
                    BlockPos $$0 = BlockPos.containing(this.x, this.y, this.z);
                    FluidState $$1 = this.level.getFluidState($$0);
                    if ($$1.getType() == this.type && this.y < (double)((float)$$0.getY() + $$1.getHeight(this.level, $$0))) {
                        this.remove();
                    }

                }
            }
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static TextureSheetParticle createObsidianTearHangParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        BloodDripParticle.DripHangParticle $$8 = new BloodDripParticle.DripHangParticle(pLevel, pX, pY, pZ, ModFluids.BLOOD_FLUID.get(), ParticleTypes.FALLING_OBSIDIAN_TEAR);
        $$8.isGlowing = true;
        $$8.gravity *= 0.01F;
        $$8.lifetime = 100;
        $$8.setColor(0.51171875F, 0.03125F, 0.890625F);
        return $$8;
    }

    public static TextureSheetParticle createObsidianTearFallParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        BloodDripParticle $$8 = new BloodDripParticle.FallAndLandParticle(pLevel, pX, pY, pZ, ModFluids.BLOOD_FLUID.get(), ParticleTypes.LANDING_OBSIDIAN_TEAR);
        $$8.isGlowing = true;
        $$8.gravity = 0.01F;
        ((BloodDripParticle)$$8).setColor(0.51171875F, 0.03125F, 0.890625F);
        return $$8;
    }

    public static TextureSheetParticle createObsidianTearLandParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        BloodDripParticle $$8 = new BloodDripParticle.DripLandParticle(pLevel, pX, pY, pZ, ModFluids.BLOOD_FLUID.get());
        $$8.isGlowing = true;
        $$8.lifetime = (int)(28.0 / (Math.random() * 0.8 + 0.2));
        ((BloodDripParticle)$$8).setColor(0.51171875F, 0.03125F, 0.890625F);
        return $$8;
    }

    public static TextureSheetParticle createBloodDripHangParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        BloodDripParticle.DripHangParticle $$8 = new BloodDripParticle.DripHangParticle(pLevel, pX, pY, pZ, ModFluids.BLOOD_FLUID.get(), ModParticles.DRIPPING_BLOOD.get());
        $$8.isGlowing = false;
        $$8.gravity *= 0.01F;
        $$8.lifetime = 100;
        //$$8.setColor(0.51171875F, 0.03125F, 0.890625F);
        $$8.setColor(0.42071875F, 0.03125F, 0.0890625F);
        return $$8;
    }

    public static TextureSheetParticle createBloodDripFallParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        BloodDripParticle $$8 = new BloodDripParticle.FallAndLandParticle(pLevel, pX, pY, pZ, ModFluids.BLOOD_FLUID.get(), ModParticles.LANDING_BLOOD.get());
        $$8.isGlowing = false;
        $$8.gravity = 0.01F;
        //$$8.setColor(0.51171875F, 0.03125F, 0.890625F);
        $$8.setColor(0.42071875F, 0.03125F, 0.0890625F);
        return $$8;
    }

    public static TextureSheetParticle createBloodDripLandParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        BloodDripParticle $$8 = new BloodDripParticle.DripLandParticle(pLevel, pX, pY, pZ, ModFluids.BLOOD_FLUID.get());
        $$8.isGlowing = false;
        $$8.lifetime = (int)(28.0 / (Math.random() * 0.8 + 0.2));
        $$8.setColor(0.42071875F, 0.03125F, 0.0890625F);
        return $$8;
    }
    public static TextureSheetParticle createDeityBloodDripHangParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        BloodDripParticle.DripHangParticle $$8 = new BloodDripParticle.DripHangParticle(pLevel, pX, pY, pZ, ModFluids.DEITY_BLOOD_FLUID.get(), ModParticles.DRIPPING_DEITY_BLOOD.get());
        $$8.isGlowing = false;
        $$8.gravity *= 0.01F;
        $$8.lifetime = 100;
        //$$8.setColor(0.51171875F, 0.03125F, 0.890625F);
        $$8.setColor(0.42071875F, 0.03125F, 0.0890625F);
        return $$8;
    }

    public static TextureSheetParticle createDeityBloodDripFallParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        BloodDripParticle $$8 = new BloodDripParticle.FallAndLandParticle(pLevel, pX, pY, pZ, ModFluids.DEITY_BLOOD_FLUID.get(), ModParticles.LANDING_DEITY_BLOOD.get());
        $$8.isGlowing = false;
        $$8.gravity = 0.01F;
        //$$8.setColor(0.51171875F, 0.03125F, 0.890625F);
        $$8.setColor(0.42071875F, 0.03125F, 0.0890625F);
        return $$8;
    }

    public static TextureSheetParticle createDeityBloodDripLandParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        BloodDripParticle $$8 = new BloodDripParticle.DripLandParticle(pLevel, pX, pY, pZ, ModFluids.DEITY_BLOOD_FLUID.get());
        $$8.isGlowing = false;
        $$8.lifetime = (int)(28.0 / (Math.random() * 0.8 + 0.2));
        $$8.setColor(0.42071875F, 0.03125F, 0.0890625F);
        return $$8;
    }

    @OnlyIn(Dist.CLIENT)
    private static class DripHangParticle extends BloodDripParticle {
        private final ParticleOptions fallingParticle;

        DripHangParticle(ClientLevel pLevel, double pX, double pY, double pZ, Fluid pType, ParticleOptions pFallingParticle) {
            super(pLevel, pX, pY, pZ, pType);
            this.fallingParticle = pFallingParticle;
            this.gravity *= 0.02F;
            this.lifetime = 40;
        }

        protected void preMoveUpdate() {
            if (this.lifetime-- <= 0) {
                this.remove();
                this.level.addParticle(this.fallingParticle, this.x, this.y, this.z, this.xd, this.yd, this.zd);
            }

        }

        protected void postMoveUpdate() {
            this.xd *= 0.02;
            this.yd *= 0.02;
            this.zd *= 0.02;
        }
    }
    @OnlyIn(Dist.CLIENT)
    private static class FallAndLandParticle extends BloodDripParticle.FallingParticle {
        protected final ParticleOptions landParticle;

        FallAndLandParticle(ClientLevel pLevel, double pX, double pY, double pZ, Fluid pType, ParticleOptions pLandParticle) {
            super(pLevel, pX, pY, pZ, pType);
            this.landParticle = pLandParticle;
        }

        protected void postMoveUpdate() {
            if (this.onGround) {
                this.remove();
                this.level.addParticle(this.landParticle, this.x, this.y, this.z, 0.0, 0.0, 0.0);
            }

        }
    }
    @OnlyIn(Dist.CLIENT)
    private static class FallingParticle extends BloodDripParticle {
        FallingParticle(ClientLevel pLevel, double pX, double pY, double pZ, Fluid pType) {
            this(pLevel, pX, pY, pZ, pType, (int)(64.0 / (Math.random() * 0.8 + 0.2)));
        }

        FallingParticle(ClientLevel pLevel, double pX, double pY, double pZ, Fluid pType, int pLifetime) {
            super(pLevel, pX, pY, pZ, pType);
            this.lifetime = pLifetime;
        }

        protected void postMoveUpdate() {
            if (this.onGround) {
                this.remove();
            }

        }
    }
    @OnlyIn(Dist.CLIENT)
    static class DripLandParticle extends BloodDripParticle {
        DripLandParticle(ClientLevel p_106102_, double p_106103_, double p_106104_, double p_106105_, Fluid p_106106_) {
            super(p_106102_, p_106103_, p_106104_, p_106105_, p_106106_);
            this.lifetime = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        }
    }

}
