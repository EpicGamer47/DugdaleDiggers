package msPaint.uiElements;

import msPaint.Button;
import msPaint.Window;
import processing.core.PApplet;
import processing.core.PConstants;

public class UndoButton extends Button {

	public UndoButton(PApplet parent, float x1, float y1) {
		super(parent, x1, y1, 50, 50);
	}

	@Override
	protected void click() {
//		Window.cmd.newCommand("undo", "");
	}

	@Override
	protected void draw() {
		parent.fill(0);
		parent.noStroke();
		parent.arc(x1 + 17.5f, y1 + 20, 20, 20, -PConstants.PI, PConstants.PI / 3, PConstants.PIE);
		parent.fill(Window.TOOLBAR_BACKGROUND);
		parent.arc(x1 + 17.5f, y1 + 20, 10, 10, -PConstants.PI, PConstants.PI / 3, PConstants.PIE);
		parent.fill(0);
		parent.triangle(x1 + 10, y1 + 30, x1, y1 + 20, x1 + 20, y1 + 20);
	}

}
