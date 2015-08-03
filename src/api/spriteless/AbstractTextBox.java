package api.spriteless;

import java.awt.*;

import api.physics.Position;

public abstract class AbstractTextBox extends TextArea implements SpritelessElement{
	private static final long serialVersionUID = 1L;

    /**
     * The Position of this AbstractTextBox
     */
	private Position p;

    /**
     * The Dimension of this AbstractTextBox
     */
    private Dimension dim;

    /**
     * Updates the AbstractTextBox.
     * This method is called multiple times a second.
     */
    public abstract void update();

    /**
     * Default constructor for AbstractTextBox
     * Default position is (0, 0)
     * Default dimension is (50, 50)
     * Default text is null
     */
      public AbstractTextBox() {
          this("", 50, 50);
      }

    /**
     * Constructor for AbstractTextBox
     * Default position is (0, 0)
     * Default dimension is (50, 50)
     *
     * @param text the text to be displayed
     */
    public AbstractTextBox(String text) {
    	this(text, 50, 50);
    }

    /**
     * Constructor for AbstractTextBox
     * Default position is (0, 0)
     * Default text is null
     *
     * @param width the width of the AbstractTextBox
     * @param height the height of the AbstractTextBox
     */
    public AbstractTextBox(int width, int height) {
        this("", width, height);
    }

    /**
     * Constructor for AbstractTextBox
     * Default position is (0, 0)
     *
     * @param text the text to be displayed
     * @param width the width of the AbstractTextBox
     * @param height the height of the AbstractTextBox
     */
    public AbstractTextBox(String text, int width, int height) {
        super(text, height, width, SCROLLBARS_NONE);
        p = new Position(0, 0);
        dim = new Dimension(width, height);
        setPreferredSize(dim);
        setEditable(false);
        setFocusable(false);
    }

    /**
     * Initializes the AbstractTextBox
     */
	public void init() {
        setEnabled(true);
	}

    /**
     * Disables the AbstractTextBox
     */
	public void disable() {
        setEnabled(false);
	}

    /**
     * Sets the dimension of the AbstractTextBox to the given Dimension.
     *
     * @param dim the Dimension to set
     */
    public void setDimension(Dimension dim) {
        this.dim = dim;
    }

    /**
     * Sets the dimension of the AbstractTextBox to the given width and height.
     *
     * @param width the width of the new Dimension
     * @param height the height of the new Dimension
     */
    public void setDimension(double width, double height) {
        this.dim.setSize(width, height);
        setPreferredSize(dim);
    }

    /**
     * Gets the Dimension of this AbstractTextBox
     *
     * @return the Dimension of this AbstractTextBox
     */
    public Dimension getDimension() {
        return this.dim;
    }

    /**
     * Sets the position of the AbstractTextBox to the given Position.
     *
     * @param p the Position to set
     */
	public void setPosition(Position p) {
        this.p = p;
	}

    /**
     * Sets the position of the AbstractTextBox to the given coordinates.
     *
     * @param xPos the x coordinate of the new Position
     * @param yPos the y coordinate of the new Position
     */
	public void setPosition(double xPos, double yPos) {
        this.p.setX(xPos);
        this.p.setY(yPos);
	}

    /**
     * Gets the Position of this AbstractTextBox
     *
     * @return the Position of this AbstractTextBox
     */
	public Position getPosition() {
		return this.p;
	}

    /**
     * Gets the x position of this AbstractTextBox
     *
     * @return the x coordinate of this AbstractTextBox
     */
	public double getXPosition() {
        return this.p.getX();
	}

    /**
     * Gets the y position of this AbstractTextBox
     *
     * @return the y coordinate of this AbstractTextBox
     */
	public double getYPosition() {
		return this.p.getY();
	}

    /**
     * Makes this AbstractTextBox visible
     */
	public void show() {
        setVisible(true);
	}

    /**
     * Makes this AbstractTextBox invisible
     */
	public void hide() {
        setVisible(false);
	}
}
