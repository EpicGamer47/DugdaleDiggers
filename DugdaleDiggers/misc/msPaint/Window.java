package msPaint;

import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class Window extends PApplet {
	
	CommandHandler h;
	
	public static void main(String[] args) {
		PApplet.main("msPaint.Window");
	}
	
	public void setup() {
		
	}
	
	public void settings() {
		size(1600, 900);
	}
	
	public void draw() {
//		background(255, 255, 255);
		drawToolbar();
	}

	private void drawToolbar() {
		noStroke();
		fill(0xFF70686d);
		rect(0, 0, 1600, 100);
	}
	
	public void mouseClicked() {
		
	}
	
	private boolean inDrawingBounds(int x, int y) {
		return x >= 0 && x <= 1600 && y >= 100 && y <= 900;
	}
}
