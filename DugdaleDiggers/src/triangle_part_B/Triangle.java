package triangle_part_B;

//import bullshit // SWITCH angle c -> a, a -> b, b -> c
import java.awt.geom.Point2D;

/**
 * A 2 dimensional triangle
 */
public class Triangle {	
	
	public static void main(String[] args) {
		Triangle t = new Triangle(new Point2D.Float(10, 10), 
									new Point2D.Float(5, 7), 
									new Point2D.Float(200, 7));
		
		System.out.println("debugger");
	}
	
	Point2D.Float[] p;
	
	/**
	 * Constructs a triangle with vertices at the specified points
	 * 
	 * @param a vertex a
	 * @param b vertex b
	 * @param c vertex c
	 */
	public Triangle(Point2D.Float a, Point2D.Float b, Point2D.Float c) {
		p = new Point2D.Float[] {a, b, c};
	}
	
	/**
	 * Returns the length of side ab.
	 * 
	 * @return the length of side ab.
	 */
	public double getLengthAB() {
		return p[0].distance(p[1]);
	}

	/**
	 * Returns the length of side bc.
	 * 
	 * @return the length of side bc
	 */
	public double getLengthBC() {
		return p[1].distance(p[2]);
	}

	/**
	 * Returns the length of side ac.
	 * 
	 * @return the length of side ac
	 */
	public double getLengthAC() {
		return p[0].distance(p[2]);
	}

	/**
	 * Returns the measure of angle a, in degrees.
	 * 
	 * @return the measure of angle a, in degrees
	 */
	public double getAngleA() {
		double ab2 = getLengthAB() * getLengthAB();
		double ac2 = getLengthAC() * getLengthAC();
		double bc2 = getLengthBC() * getLengthBC();
		
		double ab = getLengthAB();
		double ac = getLengthAC();
		//double bc = getLengthBC();
		
		return Math.toDegrees(Math.acos((ab2 + ac2 - bc2) / (2 * ab * ac)));
	}

	/**
	 * Returns the measure of angle b, in degrees.
	 * 
	 * @return the measure of angle b, in degrees
	 */
	public double getAngleB() {
		double ab2 = getLengthAB() * getLengthAB();
		double ac2 = getLengthAC() * getLengthAC();
		double bc2 = getLengthBC() * getLengthBC();
		
		double ab = getLengthAB();
		//double ac = getLengthAC();
		double bc = getLengthBC();
		
		return Math.toDegrees(Math.acos((ab2 + bc2 - ac2) / (2 * ab * bc)));
	}

	/**
	 * Returns the measure of angle c, in degrees.
	 * 
	 * @return the measure of angle c, in degrees
	 */
	public double getAngleC() {
		double ab2 = getLengthAB() * getLengthAB();
		double ac2 = getLengthAC() * getLengthAC();
		double bc2 = getLengthBC() * getLengthBC();
		
		//double ab = getLengthAB();
		double ac = getLengthAC();
		double bc = getLengthBC();
		
		return Math.toDegrees(Math.acos((ac2 + bc2 - ab2) / (2 * ac * bc)));
	}

	/**
	 * Returns the perimeter.
	 * 
	 * @return the perimeter
	 */
	public double getPerimeter() {
		return getLengthAB() + getLengthAC() + getLengthBC(); // TODO: implement
	}

	/**
	 * Returns the area.
	 * 
	 * @return the area
	 */
	public double getArea() {
		double s = getPerimeter() / 2; // semi-perimeter
		double ab = getLengthAB();
		double ac = getLengthAC();
		double bc = getLengthBC();
				
		return Math.sqrt(s * (s - ab) * (s - ac) * (s - bc)); // TODO: implement
	}
	
	public Point2D.Float[] getPoints() {
		return p;
	}
	
	public void setPoint(int i, Point2D.Float point) {
		p[i] = point;
	}
}
