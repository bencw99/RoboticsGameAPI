package physics;

public class Dimension {
	/** The width of this dimension */
	private double width;
	
	/** The height of this dimension */
	private double height;
	
	/** Default constructor, initializes dimension to width 0 and height 0
	 * 
	 */
	public Dimension() {
		this(64, 64);
	}
	
	/** Parameterized constructor, initializes dimension width and height to given parameters
	 * 
	 * @param width	The x-coordinate instance initialized to
	 * @param height	The y-coordinate instance initialized to
	 */
	public Dimension(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
}
