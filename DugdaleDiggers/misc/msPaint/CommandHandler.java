package msPaint;

import java.awt.geom.Point2D;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayDeque;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

/** 
 * please note that this is not fully implemented
 * use the method headers so that the actual PApplet you have works
 * pl shelp make them
 */
public class CommandHandler {
	
	private int x1, x2, y1, y2;
	private PImage currentField;
	private PGraphics currentCommandField;
	private String currentCommand;
	private PApplet parent;
	private ArrayDeque<PImage> history;
	private ArrayDeque<PImage> future;

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
		
		currentField = new PImage(x2 - x1, y2 - y1);
		
		currentCommandField = parent.createGraphics(x2 - x1, y2 - y1); // no way to call it statically
		currentCommandField.beginDraw();
	}
	
	/**
	 * Draws the current image onto the parent, including commands in mid-execution
	 */
	public void draw() {
		
	}
	
	/**
	 * Starts a command.
	 * @command command the command to use
	 */
	public void newCommand(String command, String... args) {
		switch (command) {
		case "undo":
			undo();
			break;
		case "redo":
			undo();
			break;
		case "save":
			save();
			
		
		default:
			throw new InvalidParameterException("\"" + command + "\" is not a valid command.");
		}
		
		currentCommand = command;
	}
	
	/**
	 * Updates the command (mouse moved, etc);
	 */
	public void update() {
		switch (currentCommand) {
		case "undo":
		
		default:
			throw new InvalidParameterException("\"" + currentCommand + "\" is not a valid command.");
		} // should never run here but meh
	}
	
	/**
	 * Finalizes the current command.
	 * Call when command is done.
	 */
	public void finalize() {
		PGraphics temp = parent.createGraphics(x2 - x1, y2 - y1);
		temp.beginDraw();
		temp.image(currentField, 0, 0);
		temp.image(currentCommandField, 0, 0);
		currentField = temp.get();
		temp.endDraw();
		
		
		history.push(currentField.copy());
		future.clear();
	}
	
	/**
	 * Saves the draw area to the output file
	 */
	public void save() {
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
