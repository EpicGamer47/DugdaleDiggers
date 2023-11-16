package msPaint;

import processing.core.PApplet;

/**
 * Button that launches a dropdown menu when clicked.
 */
public abstract class DropdownMenu {

	protected PApplet a;
	protected float x;
	protected float y;
	protected float w;
	protected float h;
	
	protected float menuW;
	protected float menuH;
	protected boolean menuVisible;
	
	public DropdownMenu(PApplet a, float x, float y, float w, float h, float menuW, float menuH) {
		this.a = a;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.menuW = menuW;
		this.menuH = menuH;
		this.menuVisible = false;
	}
	
	public void draw() {
		drawButton();
		if (menuVisible)
			drawMenu();
	}
	
	protected abstract void drawButton();
	
	protected abstract void drawMenu();
	
	protected abstract void menuClicked(int mouseX, int mouseY);
	
	public void click(int mouseX, int mouseY) {
		if (mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
			menuVisible = !menuVisible;
		}
		else if (menuVisible && mouseX >= x && mouseX <= x + menuW && mouseY >= y + h && mouseY <= y + h + menuH) {
			menuClicked(mouseX, mouseY);
		}
		else {
			menuVisible = false;
		}
	}
}
