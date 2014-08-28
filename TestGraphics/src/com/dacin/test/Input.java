package com.dacin.test;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input {
	public int mouseX = 0;
	public int mouseY = 0;
	public boolean up = false;
	public boolean down = false;
	public boolean right = false;
	public boolean left = false;
	public boolean w = false;
	public boolean s = false;
	public boolean q = false;
	public boolean e = false;
	public boolean r = false;

	public Input() {

	}

	public void getKeys() {
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
				if (Keyboard.getEventKeyState()) {
					up = true;
				} else {
					up = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
				if (Keyboard.getEventKeyState()) {
					down = true;
				} else {
					down = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
				if (Keyboard.getEventKeyState()) {
					left = true;
				} else {
					left = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
				if (Keyboard.getEventKeyState()) {
					right = true;
				} else {
					right = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_Q) {
				if (Keyboard.getEventKeyState()) {
					q = true;
				} else {
					q = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_E) {
				if (Keyboard.getEventKeyState()) {
					e = true;
				} else {
					e = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_W) {
				if (Keyboard.getEventKeyState()) {
					w = true;
				} else {
					w = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_S) {
				if (Keyboard.getEventKeyState()) {
					s = true;
				} else {
					s = false;
				}
				continue;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_R) {
				if (Keyboard.getEventKeyState()) {
					r = true;
				} else {
					r = false;
				}
				continue;
			}
		}
	}

}
