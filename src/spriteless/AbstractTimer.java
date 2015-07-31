package spriteless;

import physics.Position;
import java.awt.*;

public abstract class AbstractTimer extends TextArea implements SpritelessElement{
	private static final long serialVersionUID = 1L;

	private Position pos;

    private Dimension dim;

	private double startTime; //In milliseconds
	private double currentTime; //In seconds

	public abstract void disable();
	
	public AbstractTimer() {
        this(0, 0, true);
	}
	
	public AbstractTimer(boolean displayText) {
		this(0, 0, displayText);
	}
	
	public AbstractTimer(double xPos, double yPos, boolean displayText) {
		super();
        pos = new Position(xPos, yPos);
		setVisible(displayText);
		setEditable(false);
		setFocusable(false);
	}
	
	public AbstractTimer(double xPos, double yPos) {
		this(xPos, yPos, true);
	}
	
	public void init() {
		startTime = System.currentTimeMillis();
	}

    public void reset() {
        startTime = System.currentTimeMillis();
    }

    public double getTime() {
        currentTime = (System.currentTimeMillis() - startTime)/1000;
        return currentTime;
    }

	public void show() {
		setVisible(true);
	}
	
	public void hide() {
		setVisible(false);
	}
	
	public void update() {
		currentTime = (System.currentTimeMillis() - startTime)/1000;
		setText(String.valueOf(currentTime));
	}

    public void setDimension(Dimension dim) {
        this.dim = dim;
    }

    public void setDimension(double width, double height) {
        this.dim.setSize(width, height);
    }

    public Dimension getDimension() {
        return this.dim;
    }

	public void setPosition(Position p) {
		this.pos = p;
	}

	public void setPosition(double xPos, double yPos) {
		this.pos.setX(xPos);
		this.pos.setY(yPos);
	}

	public Position getPosition() {
		return this.pos;
	}

	public double getXPosition() {
		return this.pos.getX();
	}

	public double getYPosition() {
		return this.pos.getY();
	}
}
