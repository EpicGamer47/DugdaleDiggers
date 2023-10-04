package triangle_part_B;

import processing.core.PApplet;
import static processing.core.PApplet.*;

import java.awt.geom.Point2D;

public class Button {
	private PApplet parent;
	private float x1, y1, r;
	private String name;
	private boolean dragging;

	public Button(PApplet parent, float x1, float y1, float r, String name) {
		this.parent = parent;

		this.r = r;
		this.x1 = x1;
		this.y1 = y1;

		this.name = name;
	}

	public void draw() {
		parent.fill(0xf0, 0x00, 0x00, 0x80);
		parent.ellipse(x1, y1, r, r);

		parent.textSize(30);
		parent.fill(0x00);
		parent.textAlign(CENTER, CENTER);
		parent.text(name, x1 - r, y1 - r, x1 + r, y1 + r);

	}

	public void updatePos() {
		if (dragging) {
			x1 = parent.mouseX;
			y1 = parent.mouseY;
		}
	}

	/**
	 * 
	 * @param mouseX
	 * @param mouseY
	 * @return if the object is being dragging
	 */
	public boolean startDrag() {
		dragging = PApplet.dist(parent.mouseX, parent.mouseY, x1, y1) <= r;
		return dragging;
	}
	
	public void endDrag() {
		dragging = false;
	}
	
	public boolean isBeingDragged() {
		return dragging;
	}
	
	public Point2D.Float getPos() {
		return new Point2D.Float(x1, y1);
	}
}