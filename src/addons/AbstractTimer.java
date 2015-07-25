package addons;

import physics.Position;

import java.awt.*;

public abstract class AbstractTimer extends TextArea implements SpritelessElement{
	
	Position pos;

	private double startTime; //In milliseconds
	private double currentTime; //In seconds
	
	private boolean displayText; //A boolean that tells us if we want to display text or not
	
	private TextArea text; //The text that gets displayed

	public abstract void disable();
	
	public AbstractTimer() {
		pos = new Position(0, 0);
		displayText = true;
        this.setEditable(true);
		this.setFocusable(false);
		text = new TextArea();
	}
	
	public AbstractTimer(boolean displayText) {
		pos = new Position(0, 0);
		this.displayText = displayText;
		this.setEditable(true);
		this.setFocusable(false);
        text = new TextArea();
        
	}
	
	public AbstractTimer(double xPos, double yPos, boolean displayText) {
		pos = new Position(xPos, yPos);
		this.displayText = displayText;
		this.setEditable(false);
		this.setFocusable(false);
        text = new TextArea();
        
	}
	
	public AbstractTimer(double xPos, double yPos) {
		pos = new Position(xPos, yPos);
		this.displayText = true;
		this.setEditable(false);
		this.setFocusable(false);
        text = new TextArea();
        
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
