package addons;

import java.awt.TextArea;

import javax.swing.Timer;

import java.awt.event.ActionEvent.*;

import physics.Position;

public abstract class AbstractTimer extends TextArea implements NonEntityElement{
	
	Position pos;
	
	private double xPos;
	private double yPos;
	
	private double startTime; //In milliseconds
	private double currentTime; //In seconds
	
	private boolean displayText; //A boolean that tells us if we want to display text or not
	
	private TextArea text; //The text that gets displayed

	public abstract void disable();
	
	public AbstractTimer() {
		displayText = false;
	}
	
	public AbstractTimer(boolean displayText) {
		this.displayText = displayText;
	}
	
	public void init() {
		startTime = System.currentTimeMillis();
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
			text = new TextArea(String.valueOf(currentTime));
		}	
	}

	public void setPosition(Position p) {
		this.pos = p;
	}

	public void setPosition(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
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
