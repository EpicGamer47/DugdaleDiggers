package msPaint;

import processing.core.PApplet;

/**
 * Button w/ customizable drawing & functionality.
 */
public abstract class Button {
	protected PApplet parent;
	protected float x1, y1, w, h;

	public Button(PApplet parent, float x1, float y1, float w, float h) {
		this.parent = parent;

		this.x1 = x1;
		this.y1 = y1;
		
		this.w = w;
		this.h = h;
	}

	/**
	 * Draws the button.
	 */
	protected abstract void draw();
	
	/**
	 * Tests if the button is clicked on, and runs click() if it is.
	 * @param mouseX x of mouse
	 * @param mouseY y of mouse
	 */
	public void testForClick(int mouseX, int mouseY) {
		if (mouseX >= x1 && mouseX <= x1 + w && mouseY >= y1 && mouseY <= y1 + h)
			click();
	}
	
	/**
	 * Executed when button is clicked on.
	 */
	protected abstract void click();
}