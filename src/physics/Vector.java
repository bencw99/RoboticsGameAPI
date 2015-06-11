package physics;

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
	
	/** Scales this vector by the given scalar
	 * 
	 * @param scalar	the scalar the vector is scaled by
	 */
	public void scale(double scalar) {
		dx *= scalar;
		dy *= scalar;
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
