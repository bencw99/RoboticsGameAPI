package addons;

import physics.Position;

import java.awt.*;

public abstract class AbstractTextBox extends TextArea implements SpritelessElement{

    private TextArea text;

    private Position p;

    private int numberOfRows;
    private int numberOfColumns;

    private String hiddenText;

    public abstract void update();

    public AbstractTextBox(String s) {
    	text = new TextArea("");
        p = new Position(0, 0);
        this.setEditable(false);
        this.setFocusable(false);
        this.setText(s);
    }

    public AbstractTextBox() {
        text = new TextArea("");
        p = new Position(0, 0);
        this.setEditable(false);
        this.setFocusable(false);
    }

    public AbstractTextBox(int numberOfRows, int numberOfColumns) {
        text = new TextArea(numberOfRows, numberOfColumns);
    }

    public AbstractTextBox(String text, int numberOfRows, int numberOfColumns) {
        this.text = new TextArea(text, numberOfRows, numberOfColumns);
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
        hiddenText = text.getText();
		this.setText("");
	}

}
