package addons;

import physics.Position;

import java.awt.*;

public abstract class AbstractTextBox extends TextArea implements SpritelessElement{

    private Position p;

    private int numberOfRows;
    private int numberOfColumns;

    private String hiddenText;

    public abstract void update();

    public AbstractTextBox(String s) {
    	super(s);
        p = new Position(0, 0);
        this.setEditable(false);
        this.setFocusable(false);
    }

    public AbstractTextBox() {
        super("");
        p = new Position(0, 0);
        this.setEditable(false);
        this.setFocusable(false);
    }

    public AbstractTextBox(int numberOfRows, int numberOfColumns) {
        super(numberOfRows, numberOfColumns);
    }

    public AbstractTextBox(String text, int numberOfRows, int numberOfColumns) {
        super(text, numberOfRows, numberOfColumns);
    }

	public void init() {
        this.setEnabled(true);
	}

	public void disable() {
        this.setEnabled(false);
	}

	public void setPosition(Position p) {
        this.p = p;
	}

	public void setPosition(double xPos, double yPos) {
        this.p.setX(xPos);
        this.p.setY(yPos);
	}
	
	public Position getPosition() {
		return this.p;
	}

	public double getXPosition() {
        return this.p.getX();
	}

	public double getYPosition() {
		return this.p.getY();
	}

	public void show() {
        this.setText(hiddenText);
	}

	public void hide() {
        hiddenText = this.getText();
		this.setText("");
	}

}
