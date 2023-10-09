package msPaint;

import java.awt.geom.Point2D;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayDeque;

import processing.core.PApplet;
import processing.core.PGraphics;

/** 
 * please note that this is not fully implemented
 * use the method headers so that the actual PApplet you have works
 * pl shelp make them
 */
public abstract class CommandHandler {
	
	private int x1, x2, y1, y2;
	private PGraphics currentField;
	private PGraphics currentCommand;
	private PApplet parent;
	private ArrayDeque<PGraphics> history;
	private ArrayDeque<PGraphics> future;

	/**
	 * Takes in a PApplet and a bounding box for the paint area.
	 * @param parent The Processing Applet to draw on
	 * @param x1 The x-value of the top left corner
	 * @param y1 The y-value of the top left corner
	 * @param x2 The x-value of the bottom right corner
	 * @param y2 The y-value of the bottom right corner
	 */
	public CommandHandler(PApplet parent, int x1, int y1, int x2, int y2) {
		this.parent = parent;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		currentField = parent.createGraphics(x2 - x1, y2 - y1); // no way to call it statically
	}
	
	/**
	 * Draws the current image onto the parent, including commands in mid-execution
	 */
	public void draw() {
		
	}
	
	/**
	 * Starts a command.
	 */
	public void command(String command, Point2D point) {
		switch (command) {
		case "undo":
		
		default:
			throw new InvalidParameterException("\"" + command + "\" is not a valid command.");
		}
	}
	
	/**
	 * 
	 * @param point the click
	 */
	public void update(Point2D point) {
		switch (command) {
		case "undo":
		
		default:
			throw new InvalidParameterException("\"" + command + "\" is not a valid command.");
		}
	}
	
	/**
	 * Finalizes the current command.
	 * Call when command is done.
	 */
	public void finalize() {
		currentField.image(currentCommand, 0, 0);
		history.push((PGraphics) currentField.copy());
		future.clear();
	}
	
	/**
	 * Saves the draw area to the output file
	 */
	public void save(String path) {
		parent.selectOutput("Save to file: ", "saveCallback");
	}
	
	/**
	 * Only exists as a callback for save method (dont use this one)
	 * @param selection
	 */
	public void saveCallback(File selection) {
		if (selection == null)
			return;
		currentField.save(selection.getAbsolutePath());
	}
	
	/**
	 * Undos the last command.
	 * @return true if the the display changed, false otherwise
	 */
	private boolean undo() {
		if (history.isEmpty()) {
			return false;
		}
		
		future.push(currentField);
		currentField = history.pop();
		
		return true;
	}
	
	/**
	 * Redos the last undo.
	 * @return true if the the display changed, false otherwise
	 */
	private boolean redo() {
		if (future.isEmpty()) {
			return false;
		}
		
		history.push(currentField);
		currentField = future.pop();
		
		return true;
	}
}
