package triangle_part_B;

import java.awt.geom.Point2D;
import processing.core.PApplet;

public class TriangleProcessing extends PApplet{
	
	Triangle tri;
	Button a, b, c;

	public static void main(String[] args) {
		PApplet.main("triangle_part_B.TriangleProcessing");
	}

	public void settings() {
		size(1600, 800);
	}
	
	public void setup() {
	    ellipseMode(RADIUS);
	    rectMode(CORNERS);
	    //cursor(CROSS);
	    
	    tri = new Triangle(new Point2D.Float(100, 100), 
				new Point2D.Float(500, 700), 
				new Point2D.Float(200, 700));
	    a = new Button(this, tri.getPoints()[0].x, tri.getPoints()[0].y, 25, "A");
	    b = new Button(this, tri.getPoints()[1].x, tri.getPoints()[1].y, 25, "B");
	    c = new Button(this, tri.getPoints()[2].x, tri.getPoints()[2].y, 25, "C");
	}
	
	public void draw() {
		background(84, 84, 84);
		updatePos();
		drawTriangle();
		drawInfo();
	}
	
	private void updatePos() {
		a.updatePos();
		b.updatePos();
		c.updatePos();
		
		tri.setPoint(0, a.getPos());
		tri.setPoint(1, b.getPos());
		tri.setPoint(2, c.getPos());
	}

	private void drawInfo() {
		fill(0xffc7c7c7);
		rect(1200, 0, 1600, 800);
		
		noStroke();
		fill(0, 0, 0);
		textSize(40);
		textAlign(LEFT);

		text(String.format("Side AB: %.2f", tri.getLengthAB()), 1210, 40); 
		text(String.format("Side BC: %.2f", tri.getLengthBC()), 1210, 80); 
		text(String.format("Side AC: %.2f", tri.getLengthAC()), 1210, 120); 
		
		text(String.format("Angle A: %.2f", tri.getAngleA()), 1210, 200); 
		text(String.format("Angle B: %.2f", tri.getAngleB()), 1210, 240); 
		text(String.format("Angle C: %.2f", tri.getAngleC()), 1210, 280); 
		
		text(String.format("Area: %.2f", tri.getArea()), 1210, 360); 
		text(String.format("Perimeter: %.2f", tri.getPerimeter()), 1210, 400);
		
		a.draw();
		b.draw();
		c.draw();
	}

	private void drawTriangle() {
		fill(0xff32a940);
		Point2D.Float[] points = tri.getPoints();
		
		triangle(points[0].x, points[0].y, points[1].x, points[1].y, points[2].x, points[2].y);
	}

	public void mousePressed() {
		if (!a.startDrag()) {
			if (!b.startDrag()) {
				c.startDrag();
			}
		}
    } // it works and tbh that's good enough
	
	public void mouseReleased() {
		a.endDrag();
		b.endDrag();
		c.endDrag();
    }
	
	public static boolean inBounds(int x, int y) {
		return x > 0 && x < 1200 && y > 0 && y < 800;
	}
}
