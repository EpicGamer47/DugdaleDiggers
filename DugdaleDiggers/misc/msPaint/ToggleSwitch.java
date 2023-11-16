package msPaint;

import processing.core.PApplet;

/**
 * Represents a switch that can be toggled on/off
 */
public class ToggleSwitch {

	private boolean on;
	private PApplet a;
	private float x;
	private float y;
	
	public ToggleSwitch(PApplet a, float x, float y) {
		this.a = a;
		this.x = x;
		this.y = y;
		on = false;
	}
	
	public boolean isOn() {
		return on;
	}
	
	public void setState(boolean on) {
		this.on = on;
	}
	
	public void draw() {
		//Line
		a.strokeWeight(5);
		a.stroke(0);
		a.line(x, y + 25, x + 50, y + 25);
		//Button
		a.strokeWeight(1);
		if (on) {
			a.fill(a.color(128, 255, 128));
			a.circle(x, y + 25, 25);
		}
		else {
			a.fill(90);
			a.circle(x + 50, y + 25, 25);
		}
	}
	
	public void mouseClicked(int mouseX, int mouseY) {
		if (mouseX >= x && mouseX <= x + 100 && mouseY >= y && mouseY <= y + 50) {
			on = !on;
		}
	}
}
