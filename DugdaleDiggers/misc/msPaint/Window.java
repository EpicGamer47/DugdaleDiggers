package msPaint;

import msPaint.uiElements.*;
import processing.core.PApplet;

public class Window extends PApplet {
	
	public static final int TOOLBAR_BACKGROUND = 0xFF70686d;

	public static CommandHandler cmd;
	
	Button[] buttons;
	
	Slider[] sliders;
	
	ToggleSwitch[] toggles;
	
	TextBlock[] text;
	
	TextBox[] inputBoxes;
	
	public static void main(String[] args) {
		PApplet.main("msPaint.Window");
	}
	
	public void setup() {
		buttons = new Button[] {
				new UndoButton(this, 200, 25),
				new RedoButton(this, 300, 25)
		};
		sliders = new Slider[0];
		toggles = new ToggleSwitch[0];
		text = new TextBlock[0];
		inputBoxes = new TextBox[0];
	}
	
	public void settings() {
		size(1600, 900);
	}
	
	public void draw() {
		background(255, 255, 255);
		drawToolbar();
		drawUIElements();
//		cmd.draw();
	}

	private void drawToolbar() {
		noStroke();
		fill(TOOLBAR_BACKGROUND);
		rect(0, 0, 1600, 100);
	}
	
	private void drawUIElements() {
		for (Button b : buttons) {
			b.draw();
		}
		for (Slider s : sliders) {
			s.draw();
		}
		for (ToggleSwitch t : toggles) {
			t.draw();
		}
		for (TextBlock tlb : text) {
			tlb.draw();
		}
		for (TextBox tb : inputBoxes) {
			tb.draw();
		}
	}
	
	public void mouseClicked() {
		for (TextBox tb : inputBoxes) {
			tb.mouseClicked(mouseX, mouseY);
		}
		for (Button b : buttons) {
			b.testForClick(mouseX, mouseY);
		}
		for (ToggleSwitch t : toggles) {
			t.mouseClicked(mouseX, mouseY);
		}
	}
	
	public void mouseDragged() {
		for (Slider s : sliders) {
			s.dragged(mouseX, mouseY);
		}
	}
	
	public void keyPressed() {
		for (TextBox tb : inputBoxes) {
			tb.keyDown(key, keyCode);
		}
	}
	
	private boolean inDrawingBounds(int x, int y) {
		return x >= 0 && x <= 1600 && y >= 100 && y <= 900;
	}
}
