package msPaint.uiElements;

import msPaint.Button;
import msPaint.Window;
import processing.core.PApplet;
import processing.core.PConstants;

public class RedoButton extends Button {

	public RedoButton(PApplet parent, float x1, float y1) {
		super(parent, x1, y1, 50, 50);
	}

	@Override
	protected void draw() {
		parent.fill(0);
		parent.arc(x1 + 32.5f, y1 + 20, 20, 20, -PConstants.PI * 4 / 3, 0, PConstants.PIE);
		parent.fill(Window.TOOLBAR_BACKGROUND);
		parent.arc(x1 + 32.5f, y1 + 20, 10, 10, -PConstants.PI * 4 / 3, 0, PConstants.PIE);
		parent.fill(0);
		parent.triangle(x1 + 40, y1 + 30, x1 + 50, y1 + 20, x1 + 30, y1 + 20);
	}

	@Override
	protected void click() {
		Window.cmd.newCommand("redo", "");
	}

}
