package msPaint;

import processing.core.PApplet;

/**
 * Button w/ customizeable drawing & functionality.
 */
public abstract class Button {
	private PApplet parent;
	private float x1, y1, w, h;

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
	public void draw() {
		parent.fill(255);
		parent.stroke(0);
		parent.strokeWeight(1);
		parent.rect(x1, y1, w, h);
		drawInside();
	}
	
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
	
	/**
	 * Executed in draw() to draw the customized parts of the button.
	 */
	protected abstract void drawInside();
}