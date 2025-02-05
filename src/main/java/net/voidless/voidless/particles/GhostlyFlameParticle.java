package net.voidless.voidless.particles;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;

public class GhostlyFlameParticle extends TextureSheetParticle  {
    public GhostlyFlameParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                                   SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.friction = 0.8F;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize *= 1.85F;
        this.lifetime = 40;
        this.setSpriteFromAge(spriteSet);

        this.rCol = 1f;
        this.gCol = 0.3f;
        this.bCol = 0.9f;
    }
    protected GhostlyFlameParticle(ClientLevel world, double x, double y, double z) {
        super(world, x, y, z,0,0,0.3D);
        // Particle properties
        this.setSize(1.3F, 1.3F);
        this.lifetime = 40; // Adjust lifetime
    }

    private void fadeOut() {
        this.alpha = (-(1/(float)lifetime) * age + 1);
    }
    //private void spiralOut(){this.alpha = (-(1/(float)lifetime)*age+1) ; }


    @Override
    public void tick() {
        super.tick();
        //spiralOut();
        this.move(Math.sin(0.3D), 0.3D, Math.sin(0.3D));
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public float getQuadSize(float pScaleFactor) {
        return this.quadSize * Mth.clamp(((float)this.age + pScaleFactor) / (float)this.lifetime * 32.0F, 0.0F, 1.0F);
    }
    public void render(VertexConsumer pBuffer, Camera pRenderInfo, float pPartialTicks) {
        //if (this.delay <= 0) {
            this.alpha = 1.0F - Mth.clamp(((float)this.age + pPartialTicks) / (float)this.lifetime, 0.0F, 1.0F);
            Quaternionf $$3 = new Quaternionf();
            $$3.rotationX(-1.0472F);
            this.renderRotatedQuad(pBuffer, pRenderInfo, $$3, pPartialTicks);
            $$3.rotationYXZ(-3.1415927F, 1.0472F, 0.0F);
            this.renderRotatedQuad(pBuffer, pRenderInfo, $$3, pPartialTicks);
        //}
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            GhostlyFlameParticle GFP = new GhostlyFlameParticle(pLevel, pX, pY, pZ, this.sprites, pXSpeed, pYSpeed, pZSpeed);
            GFP.pickSprite(this.sprites);
            return GFP;
        }
    }/*
    public static class Factory implements ParticleProvider<ParticleOptions> {
        @Override
        public Particle createParticle(ParticleOptions type, ClientLevel world, double x, double y, double z, double mx, double my, double mz) {
            return new GhostlyFlameParticle(world, x, y, z);
        }
    }*/

}
