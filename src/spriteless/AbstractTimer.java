package spriteless;

import physics.Position;
import physics.Dimension;
import java.awt.*;

public abstract class AbstractTimer extends TextArea implements SpritelessElement{
	private static final long serialVersionUID = 1L;

	private Position pos;

    private Dimension dim;

	private double startTime; //In milliseconds
	private double currentTime; //In seconds
	
	private boolean displayText; //A boolean that tells us if we want to display text or not

	public abstract void disable();
	
	public AbstractTimer() {
        super();
		pos = new Position(0, 0);
		displayText = true;
        this.setEditable(true);
		this.setFocusable(false);
	}
	
	public AbstractTimer(boolean displayText) {
        super();
		pos = new Position(0, 0);
		this.displayText = displayText;
		this.setEditable(true);
		this.setFocusable(false);
	}
	
	public AbstractTimer(double xPos, double yPos, boolean displayText) {
		super();
        pos = new Position(xPos, yPos);
		this.displayText = displayText;
		this.setEditable(false);
		this.setFocusable(false);
	}
	
	public AbstractTimer(double xPos, double yPos) {
		super();
        pos = new Position(xPos, yPos);
		this.displayText = true;
		this.setEditable(false);
		this.setFocusable(false);
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
		displayText = true;
	}
	
	public void hide() {
		displayText = false;
	}
	
	public void update() {
		currentTime = (System.currentTimeMillis() - startTime)/1000;
		if(displayText == true) {
			this.setText(String.valueOf(currentTime));
		}

        else {
            this.setText("");
        }
	}

    public void setDimension(Dimension dim) {
        this.dim = dim;
    }

    public void setDimension(double width, double height) {
        this.dim.setWidth(width);
        this.dim.setHeight(height);
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
