package api.spriteless;

import java.awt.*;

import api.physics.Position;

public abstract class AbstractTimer extends TextArea implements SpritelessElement{
	private static final long serialVersionUID = 1L;

    /**
     * The Position of this AbstractTimer
     */
	private Position pos;

    /**
     * The Dimension of this AbstractTimer
     */
    private Dimension dim;

    /**
     * The time at which this AbstractTimer began counting
     * This is in milliseconds.
     */
	private double startTime;

    /**
     * How long this AbstractTimer has been counting
     * This is in seconds.
     */
	private double currentTime;

    /**
     * Disables this AbstractTimer
     */
	public abstract void disable();

    /**
     * Default constructor for AbstractTimer
     * Default position is (0, 0)
     * Displays time by default
     */
	public AbstractTimer() {
        this(0, 0, true);
	}

    /**
     * Constructor for AbstractTimer
     * Default position is (0, 0)
     *
     * @param displayText whether or not  you want to display time
     */
	public AbstractTimer(boolean displayText) {
		this(0, 0, displayText);
	}

    /**
     * Constructor for AbstractTimer
     *
     * @param xPos the x coordinate of the AbstractTimer position
     * @param yPos the y coordinate of the AbstractTimer position
     * @param displayText whether or not you want to display time
     */
	public AbstractTimer(double xPos, double yPos, boolean displayText) {
		super();
        pos = new Position(xPos, yPos);
        dim = new Dimension(100, 50);
        setPreferredSize(dim);
		setVisible(displayText);
		setEditable(false);
		setFocusable(false);
	}

    /**
     * Constructor for AbstractTimer
     *
     * @param xPos the x coordinate of the AbstractTimer position
     * @param yPos the y coordinate of the AbstractTimer position
     */
	public AbstractTimer(double xPos, double yPos) {
		this(xPos, yPos, true);
	}

    /**
     * Initializes the AbstractTimer
     */
	public void init() {
        startTime = System.currentTimeMillis();
	}

    /**
     * Resets the AbstractTimer to 0
     */
    public void reset() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Gets the time of the AbstractTimer
     *
     * @return the time since the AbstractTimer began counting
     */
    public double getTime() {
        currentTime = (System.currentTimeMillis() - startTime)/1000;
        return currentTime;
    }

    /**
     * Makes this AbstractTimer visible
     */
	public void show() {
		setVisible(true);
	}

    /**
     * Makes this AbstractTimer invisible
     */
	public void hide() {
		setVisible(false);
	}

    /**
     * Updates the AbstractTimer
     * This method is called multiple times a second
     */
	public void update() {
		currentTime = (System.currentTimeMillis() - startTime)/1000;
		setText(String.valueOf(currentTime));
	}

    /**
     * Sets the Dimension of this AbstractTimer to the given Dimension
     *
     * @param dim the Dimension to set
     */
    public void setDimension(Dimension dim) {
        this.dim = dim;
    }

    /**
     * Sets the Dimension of this AbstractTimer to the given width and height
     *
     * @param width the width of the new Dimension
     * @param height the height of the new Dimension
     */
    public void setDimension(double width, double height) {
        this.dim.setSize(width, height);
        setPreferredSize(dim);
    }

    /**
     * Gets the Dimension of this AbstractTimer
     *
     * @return the dimension of this AbstractTimer
     */
    public Dimension getDimension() {
        return this.dim;
    }

    /**
     * Sets the Position of this AbstractTimer to the given Position
     *
     * @param p the Position to set
     */
	public void setPosition(Position p) {
		this.pos = p;
	}

    /**
     * Sets the Position of this AbstractTimer to the given coordinates
     *
     * @param xPos the x coordinate of the new Position
     * @param yPos the y coordinate of the new Position
     */
	public void setPosition(double xPos, double yPos) {
		this.pos.setX(xPos);
		this.pos.setY(yPos);
	}

    /**
     * Gets the Position of this AbstractTimer
     *
     * @return the position of this AbstractTimer
     */
	public Position getPosition() {
		return this.pos;
	}

    /**
     * Gets the x coordinate of this AbstractTimer
     *
     * @return the x coordinate of the position of this AbstractTimer
     */
	public double getXPosition() {
		return this.pos.getX();
	}

    /**
     * Gets the y coordinate of this AbstractTimer
     *
     * @return the y coordinate of the position of this AbstractTimer
     */
	public double getYPosition() {
		return this.pos.getY();
	}
}
