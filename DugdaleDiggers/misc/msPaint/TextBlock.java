package msPaint;

import processing.core.PApplet;

/**
 * A block of text on screen that cannot be changed by the user.
 */
public class TextBlock {

	private PApplet a;
	private float x;
	private float y;
	private String text;
	private int textColor;
	private float fontSize;
	
	public TextBlock(PApplet a, float x, float y, String text, int textColor, float fontSize) {
		this.a = a;
		this.x = x;
		this.y = y;
		this.text = text;
		this.textColor = textColor;
		this.fontSize = fontSize;
	}
	
	public void draw() {
		a.fill(textColor);
		a.textSize(fontSize);
		a.text(text, x, y);
	}
}
