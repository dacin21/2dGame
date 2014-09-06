package com.dacin.test.shader;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glValidateProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.GL20;

public class ShaderUtils {

	private ShaderUtils() {
	}
	public static int TextureShaderId = ShaderUtils.load("res/Shaders/Texture.vert", "res/Shaders/Texture.frag");

	public static int load(String vertPath, String fragPath) {
		String vert = loadAsString(vertPath);
		String frag = loadAsString(fragPath);
		return create(vert, frag);

	}

	private static int create(String vert, String frag) {
		int program = glCreateProgram();
		int vertID = glCreateShader(GL_VERTEX_SHADER);
		int fragID = glCreateShader(GL_FRAGMENT_SHADER);
		glShaderSource(vertID, vert);
		glShaderSource(fragID, frag);
		glCompileShader(vertID);
		if (glGetShaderi(vertID, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to compile vertex shader!");
			System.err.println(glGetShaderInfoLog(vertID, 2048));
		}
		glCompileShader(fragID);
		if (glGetShaderi(fragID, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Failed to compile fragment shader!");
			System.err.println(glGetShaderInfoLog(fragID, 2048));
		}

		glAttachShader(program, vertID);
		glAttachShader(program, fragID);
		
		

		// Position information will be attribute 0
		GL20.glBindAttribLocation(program, 0, "in_Position");
		// Color information will be attribute 1
		GL20.glBindAttribLocation(program, 1, "in_Color");
		// Texture information will be attribute 2
		GL20.glBindAttribLocation(program, 2, "in_TextureCoord");
		
		
		
		
		glLinkProgram(program);
		glValidateProgram(program);
		return program;
	}

	private static String loadAsString(String file) {
		String result = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
			
			String buffer = "";
			while ((buffer = reader.readLine()) != null) {
				result += buffer + "\n";
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		

		return result;
	}

}
