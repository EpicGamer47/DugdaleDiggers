package msPaint;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Represents a text box that can be edited by the user.
 */
public class TextBox extends TextBlock {

	private boolean selected;
	
	private int editPos;
	
	/**
	 * Creates a new TextBox
	 * @param a The papplet
	 * @param x The x-coordinate
	 * @param y The y-coordinate
	 * @param text The starting text in the box.
	 * @param textColor The color of the text.
	 * @param fontSize The font size.
	 */
	public TextBox(PApplet a, float x, float y, String text, int textColor, float fontSize) {
		super(a, x, y, text, textColor, fontSize);
		selected = false;
		editPos = text.length();
	}
	
	/**
	 * Run in mouseClicked method, selects/deselects textbox
	 * @param mouseX
	 * @param mouseY
	 */
	public void mouseClicked(int mouseX, int mouseY) {
		float w = a.textWidth(text);
		float h = a.textAscent();
		if (mouseX >= x && mouseX <= w + x && mouseY >= y - h && mouseY <= y) {
			selected = true;
		}
		else {
			selected = false;
		}
		System.out.println(selected);
	}
	
	/**
	 * Run during keyPressed for typing
	 * @param key
	 * @param keyCode
	 */
	public void keyDown(char key, int keyCode) {
//		System.out.println(editPos);
		if (!selected) {
			return;
		}
		if (key == PConstants.CODED) {
			if (keyCode == PConstants.LEFT) {
				editPos = Math.max(0, editPos - 1);
			}
			else if (keyCode == PConstants.RIGHT) {
				editPos = Math.min(text.length(), editPos + 1);
			}
		}
		else if (PConstants.BACKSPACE == key) {
			if (text.isEmpty())
				return;
			if (editPos == 0) {
				text = text.substring(1);
			}
			else if (editPos == text.length()) {
				text = text.substring(0, editPos - 1);
				editPos--;
			}
			else {
				text = text.substring(0, editPos - 1) + text.substring(editPos);
				editPos--;
			}
		}
		else {
			char c = key;
			if (c == PConstants.ENTER)
				c = '\n';
			if (editPos == 0) {
				text = c + text;
				editPos++;
			}
			else if (editPos == text.length()) {
				text += c;
				editPos++;
			}
			else {
				text = text.substring(0, editPos) + c + text.substring(editPos);
				editPos++;
			}
		}
//		System.out.println(editPos);
	}

}
