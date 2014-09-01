package com.dacin.test.tile;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;

import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import com.dacin.test.shader.ShaderUtils;
import com.dacin.test.shader.Texture;
import com.dacin.test.stage.Stage;

public class Spike extends Tile {


	private int rotation; // 0^ 1> 2v 3<

	private static Texture texture = new Texture("Textures/Tile/Spike.png");

	public Spike(int setX, int setY, int r) {
		super(setX, setY);
		rotation = r;
		// setTextureUnit0(ShaderUtils.TextureShaderId);
	}

	public void tick() {
		colidePlayer();

	}

	public void render() {

		// draw quad
		GL11.glPushMatrix();


		ARBShaderObjects.glUseProgramObjectARB(ShaderUtils.TextureShaderId);
		glBindTexture(GL_TEXTURE_2D, texture.getID());

		GL11.glLoadIdentity();
		GL11.glTranslatef(x, y, 0);
		GL11.glRotatef(rotation * 90, 0.0f, 0.0f, 1f);
		GL11.glTranslatef(-x, -y, 0);


		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(x - 16, y - 16);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(x + 16, y - 16);
		GL11.glTexCoord2f(0.5f, 0.0f);
		GL11.glVertex2f(x, (y + 16));
		GL11.glEnd();

		glBindTexture(GL_TEXTURE_2D, 0);
		ARBShaderObjects.glUseProgramObjectARB(0);

		GL11.glPopMatrix();

	}

	public void colidePlayer() {
		float plx = Stage.player.x;
		float ply = Stage.player.y;
		// rotate to match up-state
		float plnx = rotation == 0 ? plx : rotation == 1 ? x + (ply - y) : rotation == 2 ? 2 * x - plx : x - (ply - y);
		float plny = rotation == 0 ? ply : rotation == 1 ? y - (plx - x) : rotation == 2 ? 2 * y - ply : y + (plx - x);
		// distance (for corners)
		if (((plnx - this.x) * (plnx - this.x) + (plny - this.y + 4) * (plny - this.y + 4)) > 28 * 29) return;
		// 3 triangle sides(circle hitbox)
		if (plny < y - 24) return;
		if (plny > (1 * (plnx - x) + y + 24)) return;
		if (plny > (-1 * (plnx - x) + y + 24)) return;
		// fix beside jump kill
		if (plnx < x - 23 || plnx > x + 23) return;

		Stage.player.kill();
	}

	public void setTextureUnit0(int programId) {
		// Please note your program must be linked before calling this and I
		// would advise the program be in use also.
		int loc = GL20.glGetUniformLocation(programId, "texture1");
		// First of all, we retrieve the location of the sampler in memory.
		GL20.glUniform1i(loc, 0);
		// Then we pass the 0 value to the sampler meaning it is to use texture
		// unit 0.
	}
}
