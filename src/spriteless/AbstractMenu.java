package spriteless;

import physics.Position;

import java.awt.*;

public class AbstractMenu extends Container implements SpritelessElement {

	private static final long serialVersionUID = 1L;

    private Position p;

    private Dimension dim;

    public AbstractMenu() {
    	this(0, 0);
    }
    
    public AbstractMenu(double xPos, double yPos) {
    	super();
    	setLayout(new GridLayout(3, 0, 0, 0));
    	p = new Position(xPos, yPos);
        dim = new Dimension(1000, 1000);
        setPreferredSize(dim);
    }

    public void addSpritelessElement(SpritelessElement menuElement) {
        changeToMenuPosition(menuElement);
        add((Component) menuElement);
        menuElement.init();
    }

    public void changeToMenuPosition(SpritelessElement menuElement) {
        menuElement.setPosition(this.getXPosition() + menuElement.getXPosition(), this.getYPosition() + menuElement.getYPosition());
    }

    public void update() {
    	for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(getComponent(x));
            element.update();
        }
    }

    public void init() {
    }

    public void formatGridLayout(int numberOfRows, int numberOfColumns) {
        setLayout(new GridLayout(numberOfRows, numberOfColumns, 0, 0));
    }

    public void disable() {
    	for(int x = 0; x < this.getComponentCount(); x++) {
        	SpritelessElement element = (SpritelessElement)(getComponent(x));
            element.disable();
        }
    }

    public void setDimension(Dimension dim) {
        double widthScaler = dim.getWidth() / this.dim.getWidth();
        double heightScaler = dim.getHeight() / this.dim.getHeight();

        for(int x = 0; x < getComponentCount(); x++) {
            SpritelessElement element = (SpritelessElement) (getComponent(x));
            element.getDimension().setSize(element.getDimension().getWidth() * widthScaler, element.getDimension().getHeight() * heightScaler);
        }

        this.dim = dim;
    }

    public void setDimension(double width, double height) {
        this.dim.setSize(width, height);
    }

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
