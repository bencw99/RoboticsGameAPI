package api.physics;

/** 
 * A class representing a vector
 */
public class Vector {
	/** The x displacement of this vector **/
	private double dx;
	
	/** The y displacement of this vector **/
	private double dy;
	
	/** Default constructor, initializes vector to magnitude zero
	 * 
	 */
	public Vector() {
		this(0, 0);
	}
	
	/** Parameterized constructor, initializes vector fields to given values
	 * 
	 * @param dx	the value the x displacement is set to
	 * @param dy	the value the y displacement is set to
	 */
	public Vector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	/**
	 * Translates this vector by the given x and y differentials
	 * 
	 * @param dx the x differential
	 * @param dy the y differential
	 */
	public void translate(double dx, double dy) {
		translateX(dx);
		translateY(dy);
	}
	
	/**
	 * Translates this vector by the given vector differentials
	 * 
	 * @param vec the translation vector
	 */
	public void translate(Vector vec) {
		translate(vec.getX(), vec.getY());
	}
	
	/**
	 * Translates this vector by the given x differential
	 * 
	 * @param dx the x differential
	 */
	public void translateX(double dx) {
		this.dx += dx;
	}
	
	/**
	 * Translates this vector by the given y differential
	 * 
	 * @param dy the y differential
	 */
	public void translateY(double dy) {
		this.dy += dy;
	}
	
	/** Scales this vector by the given scalar and returns the result, INSTANCE NOT CHANGED
	 * 
	 * @param scalar	the scalar the vector is scaled by
	 * @return the scaled vector
	 */
	public Vector scale(double scalar) {
		return new Vector(dx * scalar, dy * scalar);
	}
	
	/**
	 * Returns the magnitude of this vector
	 * 
	 * @return the magnitude
	 */
	public double magnitude() {
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	/**
	 * Returns the three dimensional cross product magnitude of the two vectors
	 * 
	 * @param a	the first vector to be crossed
	 * @param b	the second vector to be crossed
	 * @return	the cross product magnitude
	 */
	public static double cross(Vector a, Vector b) {
		return a.getX()*b.getY() - a.getY()*b.getX();
	}
	
	/**
	 * Returns the dot priduct of the two vectors
	 * 
	 * @param a	the first vector to be dotted
	 * @param b	the second vector to be dotted
	 * @return	the dot product
	 */
	public static double dot(Vector a, Vector b) {
		return a.getX()*b.getX() + a.getY()*b.getY();
	}
	
	/**
	 * Returns the sum of the two given vectors
	 * 
	 * @param a	the first vector to be added
	 * @param b	the scond vector to be added
	 * @return	the sum
	 */
	public static Vector add(Vector a, Vector b) {
		return new Vector(a.getX() + b.getX(), a.getY() + b.getY());
	}
	
	/**
	 * @return x of instance
	 */
	public double getX() {
		return dx;
	}

	/**
	 * @return y of instance
	 */
	public double getY() {
		return dy;
	}

	/**
	 * @param x the value the x is set to
	 */
	public void setX(double dx) {
		this.dx = dx;
	}

	/**
	 * @param y the value the y is set to
	 */
	public void setY(double dy) {
		this.dy = dy;
	}
}
