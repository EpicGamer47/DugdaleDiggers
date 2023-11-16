package msPaint;

import processing.core.PApplet;

/**
 * A block of text on screen that cannot be changed by the user.
 */
public class TextBlock {

	protected PApplet a;
	protected float x;
	protected float y;
	protected String text;
	protected int textColor;
	protected float fontSize;
	
	/**
	 * Creates a new TextBlock
	 * @param a the papplet
	 * @param x The x-coordinate of the text.
	 * @param y The y-coordinate of the text.
	 * @param text The text.
	 * @param textColor The color of the text.
	 * @param fontSize The font size.
	 */
	public TextBlock(PApplet a, float x, float y, String text, int textColor, float fontSize) {
		this.a = a;
		this.x = x;
		this.y = y;
		this.text = text;
		this.textColor = textColor;
		this.fontSize = fontSize;
	}
	
	/**
	 * Draws the text.
	 */
	public void draw() {
		a.fill(textColor);
		a.textSize(fontSize);
		a.text(text, x, y);
	}
}
