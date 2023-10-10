package msPaint;

import processing.core.PApplet;

/**
 * Slider UI element - slide a button to set a value.
 */
public class Slider {

	private PApplet a;
	private float x;
	private float y;
	private float w;
	
	private float bX;
	private static final float BUTTON_R = 25;
	
	private double min;
	private double max;
	private double value;
	
	public Slider(PApplet a, float x, float y, float w, double min, double max) {
		this.a = a;
		this.x = x;
		this.y = y;
		this.w = w;
		this.min = min;
		this.max = max;
		this.bX = x;
		this.value = min;
	}
	
	/**
	 * Draws the slider on screen.
	 */
	public void draw() {
		//Line
		a.strokeWeight(5);
		a.stroke(0);
		a.line(x, y, x + w, y);
		//Slider circle
		a.fill(255);
		a.strokeWeight(1);
		a.circle(bX, y, BUTTON_R);
	}
	
	/**
	 * Gets the value of the slider
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Changes the value of the slider and updates it visually. Throws an exception if new value is outside the range of min-max.
	 * @param val The new value.
	 */
	public void setValue(double val) {
		if (val < min || val > max) {
			throw new IllegalArgumentException("Value outside of range of slider.");
		}
		value = val;
		bX = (float) (getScalePerPixel() * value);
	}
	
	/**
	 * Gets the minimum value for the slider (all the way left)
	 * @return the minimum value
	 */
	public double getMin() {
		return min;
	}
	
	/**
	 * Gets the maximum value for the slider (all the way right)
	 * @return the maximum value
	 */
	public double getMax() {
		return max;
	}
	
	/**
	 * Gets the amount the value should change by per pixel whenever the slider is moved.
	 * @return the amount the value should change by per pixel whenever the slider is moved
	 */
	public double getScalePerPixel() {
		return (max - min) / w;
	}
	
	private boolean inSliderButtonBounds(int mouseX, int mouseY) {
		return PApplet.dist(mouseX, mouseY, bX, y) <= BUTTON_R;
	}
	
	/**
	 * Call during mouseDragged()
	 */
	public void dragged(int mouseX, int mouseY) {
		if (!inSliderButtonBounds(mouseX, mouseY) || mouseX < x || mouseX > x + w)
			return;
		bX = mouseX;
		value = (mouseX - x) * getScalePerPixel() + min;
	}
}
