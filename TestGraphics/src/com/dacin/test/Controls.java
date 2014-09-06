package com.dacin.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.lwjgl.input.Keyboard;

public class Controls {
	public boolean ctrl, up, down, left, right, shoot, jump, reset;
	public int upKey=Keyboard.KEY_W;
	public int downKey=Keyboard.KEY_S;
	public int leftKey=Keyboard.KEY_A;
	public int rightKey=Keyboard.KEY_D;
	public int shootKey=Keyboard.KEY_X;
	public int jumpKey=Keyboard.KEY_Y;
	public Controls(){
		reloadKeys();
		up=down=left=right=shoot=jump=reset=ctrl=false;
		int a = Keyboard.KEY_X;
	}
	
	
	public void checkKeys(){
		//mouseX = Mouse.getX();
		//mouseY = Mouse.getY();
		while (Keyboard.next()) {

			if (Keyboard.getEventKey() == Keyboard.KEY_LCONTROL) {
				if (Keyboard.getEventKeyState()) {
					ctrl = true;
				} else {
					ctrl = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_Y) {
				if (Keyboard.getEventKeyState() && ctrl) {
					Main.pause = true;
					reloadKeys();
				} else {
				}
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_R) {
				if (Keyboard.getEventKeyState()) {
					reset = true;
				} else {
					reset = false;
				}
			}
			if (Keyboard.getEventKey() == upKey) {
				if (Keyboard.getEventKeyState()) {
					up = true;
				} else {
					up = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == downKey) {
				if (Keyboard.getEventKeyState()) {
					down = true;
				} else {
					down = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == leftKey) {
				if (Keyboard.getEventKeyState()) {
					left = true;
				} else {
					left = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == rightKey) {
				if (Keyboard.getEventKeyState()) {
					right = true;
				} else {
					right = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == shootKey) {
				if (Keyboard.getEventKeyState()) {
					shoot = true;
				} else {
					shoot = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == jumpKey) {
				if (Keyboard.getEventKeyState()) {
					jump = true;
				} else {
					jump = false;
				}
				continue;
			}
			
			
		}

	}
	
	private void reloadKeys(){
		System.out.println("Config File");
	    try {
			BufferedReader br = new BufferedReader(new FileReader("Controls.txt"));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	        	parseLine(line);
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        String everything = sb.toString();
		    System.out.println(everything);
	    } catch(Exception e){
	    	e.printStackTrace();
	    }
	    System.out.println("Done");
	}
	private void parseLine(String line){
		if(line.startsWith("//")) return;
		try{
			line = line.replaceAll(" ", "");
		if(line.startsWith("Up=")) 		upKey = 	Integer.parseInt(line.substring(3),10);
		if(line.startsWith("Right="))	rightKey =	Integer.parseInt(line.substring(6),10);
		if(line.startsWith("Down=")) 	downKey = 	Integer.parseInt(line.substring(5),10);
		if(line.startsWith("Left="))	leftKey = 	Integer.parseInt(line.substring(5),10);
		if(line.startsWith("Jump="))	jumpKey = 	Integer.parseInt(line.substring(5),10);
		if(line.startsWith("Shoot="))	shootKey = 	Integer.parseInt(line.substring(6),10);
		}catch(NumberFormatException e){
			System.err.print("Invalid config file line: ");
			System.err.print(line);
		}
	}


}

