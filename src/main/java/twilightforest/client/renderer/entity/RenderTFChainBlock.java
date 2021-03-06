package twilightforest.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import twilightforest.TwilightForestMod;
import twilightforest.client.model.entity.ModelTFGoblinChain;
import twilightforest.entity.EntityTFChainBlock;

public class RenderTFChainBlock extends EntityRenderer<EntityTFChainBlock> {

	private static final ResourceLocation textureLoc = TwilightForestMod.getModelTexture("blockgoblin.png");
	private final Model model;
	private final Model chainModel = new ModelTFGoblinChain();

	public RenderTFChainBlock(EntityRendererManager manager, Model modelTFSpikeBlock) {
		super(manager);
		this.model = modelTFSpikeBlock;
	}

	@Override
	public void render(EntityTFChainBlock chainBlock, float yaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer buffer, int light) {
		super.render(chainBlock, yaw, partialTicks, stack, buffer, light);

		stack.push();
		IVertexBuilder ivertexbuilder = buffer.getBuffer(this.model.getRenderType(textureLoc));

		float pitch = chainBlock.prevRotationPitch + (chainBlock.rotationPitch - chainBlock.prevRotationPitch) * partialTicks;
		stack.rotate(Vector3f.YP.rotationDegrees(180 - MathHelper.wrapDegrees(yaw)));
		stack.rotate(Vector3f.XP.rotationDegrees(pitch));

		stack.scale(-1.0F, -1.0F, 1.0F);
		this.model.render(stack, ivertexbuilder, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		stack.pop();

		renderChain(chainBlock, chainBlock.chain1, yaw, partialTicks, stack, buffer, light);
		renderChain(chainBlock, chainBlock.chain2, yaw, partialTicks, stack, buffer, light);
		renderChain(chainBlock, chainBlock.chain3, yaw, partialTicks, stack, buffer, light);
		renderChain(chainBlock, chainBlock.chain4, yaw, partialTicks, stack, buffer, light);
		renderChain(chainBlock, chainBlock.chain5, yaw, partialTicks, stack, buffer, light);
	}

	private void renderChain(EntityTFChainBlock chainBlock, Entity chain, float yaw, float partialTicks, MatrixStack stack, IRenderTypeBuffer buffer, int light) {
		if (chain != null) {
			double chainInX = (chain.getPosX() - chainBlock.getPosX());
			double chainInY = (chain.getPosY() - chainBlock.getPosY());
			double chainInZ = (chain.getPosZ() - chainBlock.getPosZ());

			stack.push();
			IVertexBuilder ivertexbuilder = buffer.getBuffer(this.chainModel.getRenderType(textureLoc));

			stack.translate(chainInX, chainInY, chainInZ);
			float pitch = chain.prevRotationPitch + (chain.rotationPitch - chain.prevRotationPitch) * partialTicks;
			stack.rotate(Vector3f.YP.rotationDegrees(180 - MathHelper.wrapDegrees(yaw)));
			stack.rotate(Vector3f.XP.rotationDegrees(pitch));

			stack.scale(-1.0F, -1.0F, 1.0F);
			this.chainModel.render(stack, ivertexbuilder, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			stack.pop();

			//when you allowed debugBoundingBox, you can see Hitbox
			if (this.renderManager.isDebugBoundingBox() && !chain.isInvisible() && !Minecraft.getInstance().isReducedDebug()) {
				stack.push();
				stack.translate(chainInX, chainInY, chainInZ);
				this.renderMultiBoundingBox(stack, buffer.getBuffer(RenderType.getLines()), chain, 0.25F, 1.0F, 0.0F);
				stack.pop();
			}
		}
	}

	private void renderMultiBoundingBox(MatrixStack stack, IVertexBuilder builder, Entity entity, float red, float grean, float blue) {
		AxisAlignedBB axisalignedbb = entity.getBoundingBox().offset(-entity.getPosX(), -entity.getPosY(), -entity.getPosZ());
		WorldRenderer.drawBoundingBox(stack, builder, axisalignedbb, red, grean, blue, 1.0F);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityTFChainBlock entity) {
		return textureLoc;
	}
}
