package net.voidless.voidless.particles;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;

public class GhostFlameParticle extends Particle {
    public GhostFlameParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
    }

    @Override
    public void tick() {
        super.tick();
        this.move(Math.sin(1.3D), Math.sin(1.3D), Math.sin(1.3D));
        this.setColor( 0.5F - (float) (this.age / this.lifetime),0.0F, 1.0F);
    }

    public GhostFlameParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
    }

    @Override
    public void render(VertexConsumer vertexConsumer, Camera camera, float v) {

    }

    @Override
    public ParticleRenderType getRenderType() {
        return null;
    }
}
