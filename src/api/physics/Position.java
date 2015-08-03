package api.physics;

/** A class representing the position
 */
public class Position {
	/** The x-coordinate of this position **/
	private double xPos;
	
	/** The y-coordinate of this position **/
	private double yPos;
	
	/** Default constructor, initializes position to coordinates (0, 0)
	 * 
	 */
	public Position() {
		this(0, 0);
	}
	
	/** Parameterized constructor, initializes position coordinates to given parameters
	 * 
	 * @param x	The x-coordinate instance initialized to
	 * @param y	The y-coordinate instance initialized to
	 */
	public Position(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/**
	 * Translates this position by the given x and y differentials
	 * 
	 * @param dx the x differential
	 * @param dy the y differential
	 */
	public void translate(double dx, double dy) {
		translateX(dx);
		translateY(dy);
	}
	
	/**
	 * Translates this position by the given vector differentials
	 * 
	 * @param vec the translation vector
	 */
	public void translate(Vector vec) {
		translate(vec.getX(), vec.getY());
	}
	
	/**
	 * Translates this position by the given x differential
	 * 
	 * @param dx the x differential
	 */
	public void translateX(double dx) {
		xPos += dx;
	}
	
	/**
	 * Translates this position by the given y differential
	 * 
	 * @param dy the y differential
	 */
	public void translateY(double dy) {
		yPos += dy;
	}
	
	/**
	 * @return x-coordinate of instance
	 */
	public double getX() {
		return xPos;
	}

	/**
	 * @return y-coordinate of instance
	 */
	public double getY() {
		return yPos;
	}

	/**
	 * @param x the value the x-coordinate is set to
	 */
	public void setX(double xPos) {
		this.xPos = xPos;
	}

	/**
	 * @param y the value the y-coordinate is set to
	 */
	public void setY(double yPos) {
		this.yPos = yPos;
	}
}
