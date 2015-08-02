package spriteless;

import physics.Position;

import java.awt.*;

public class AbstractMenu extends Container implements SpritelessElement {

	private static final long serialVersionUID = 1L;

    /**
     * The Position of this AbstractMenu
     */
    private Position p;

    /**
     * The Dimension of this AbstractMenu
     */
    private Dimension dim;

    /**
     * Default constructor for AbstractMenu
     * Default position is (0, 0)
     * Default dimension is (1000, 1000)
     */
    public AbstractMenu() {
    	this(0, 0);
    }

    /**
     * Constructor for AbstractMenu
     * Default dimension is (1000, 1000)
     *
     * @param xPos the x coordinate of the menu position
     * @param yPos the y coordinate of the menu position
     */
    public AbstractMenu(double xPos, double yPos) {
    	super();
    	setLayout(new GridLayout(3, 0, 0, 0));
    	p = new Position(xPos, yPos);
        dim = new Dimension(1000, 1000);
        setPreferredSize(dim);
    }

    /**
     * Adds an SpritelessElement to the menu
     *
     * @param menuElement the SpritelessElement to be added to the menu
     */
    public void addSpritelessElement(SpritelessElement menuElement) {
        changeToMenuPosition(menuElement);
        add((Component) menuElement);
        menuElement.init();
    }

    /**
     * Takes the original position of the SpritelessElement and changes it to be relative to the menu's position
     * If a SpritelessElement has position (30, 40) and the menu has Position (50, 50),
     * the SpritelessElement now has position (80, 90)
     *
     * @param menuElement the SpritelessElement to have its position changed
     */
    public void changeToMenuPosition(SpritelessElement menuElement) {
        menuElement.setPosition(this.getXPosition() + menuElement.getXPosition(), this.getYPosition() + menuElement.getYPosition());
    }

    /**
     * Updates the AbstractMenu.
     * This method is called multiple times a second
     */
    public void update() {
    	for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(getComponent(x));
            element.update();
        }
    }

    /**
     * Initializes the AbstractMenu
     */
    public void init() {
    }

    /**
     * Changes the format of the GridLayout
     *
     * @param numberOfRows the number of rows the GridLayout has
     * @param numberOfColumns the number of columns the GridLayout has
     */
    public void formatGridLayout(int numberOfRows, int numberOfColumns) {
        setLayout(new GridLayout(numberOfRows, numberOfColumns, 0, 0));
    }

    /**
     * Disables the AbstractMenu
     */
    public void disable() {
    	for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(getComponent(x));
            element.disable();
        }
    }

    /**
     * Sets the dimension of the menu to the given Dimension
     * Also scales the dimensions of the SpritelessElements inside accordingly
     *
     * @param dim the Dimension to set
     */
    public void setDimension(Dimension dim) {
        double widthScaler = dim.getWidth() / this.dim.getWidth();
        double heightScaler = dim.getHeight() / this.dim.getHeight();

        for(int x = 0; x < getComponentCount(); x++) {
            SpritelessElement element = (SpritelessElement) (getComponent(x));
            element.getDimension().setSize(element.getDimension().getWidth() * widthScaler, element.getDimension().getHeight() * heightScaler);
        }

        this.dim = dim;
    }

    /**
     * Sets the dimension of the menu to the given width and height
     * Also scales the dimensions of the SpritelessElements inside accordingly
     *
     * @param width the width of the new Dimension
     * @param height the height of the new Dimension
     */
    public void setDimension(double width, double height) {
        double widthScaler = width / this.dim.getWidth();
        double heightScaler = height / this.dim.getHeight();

        for(int x = 0; x < getComponentCount(); x++) {
            SpritelessElement element = (SpritelessElement) (getComponent(x));
            element.getDimension().setSize(element.getDimension().getWidth() * widthScaler, element.getDimension().getHeight() * heightScaler);
        }

        this.dim.setSize(width, height);
    }

    /**
     * Gets the Dimension of this AbstractMenu
     *
     * @return the Dimension of this AbstractMenu
     */
    public Dimension getDimension() {
        return this.dim;
    }

    public void show() {
        for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(getComponent(x));
            element.show();
        }
    }

    public void hide() {
        for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(getComponent(x));
            element.hide();
        }
    }
    
    public double getXPosition() {
        return this.p.getX();
    }

    public double getYPosition() {
        return this.p.getY();
    }

    public Position getPosition() {
        return p;
    }

    public void setPosition(double xPos, double yPos) {
        double xDifference = xPos - this.p.getX();
        this.p.setX(xPos);

        double yDifference = yPos = this.p.getY();
        this.p.setY(yPos);

        for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(getComponent(x));
            element.setPosition(element.getXPosition() + xDifference, element.getYPosition() + yDifference);
        }
    }

    public void setPosition(Position pos) {
        double xDifference = pos.getX() - this.p.getX();
        double yDifference = pos.getY() - this.p.getY();
        p = pos;
        for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(getComponent(x));
            element.setPosition(element.getXPosition() + xDifference, element.getYPosition() + yDifference);
        }
    }

}
