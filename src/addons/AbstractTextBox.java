package addons;

import physics.Position;

import java.awt.*;

public abstract class AbstractTextBox extends TextArea implements NonEntityElement{

    private TextArea text;

    private Position p;

    private double xPos;
    private double yPos;

    private int numberOfRows;
    private int numberOfColumns;

    private String hiddenText;

    public abstract void update();

    public AbstractTextBox(String s) {
        text = new TextArea(s);
    }

    public AbstractTextBox() {
        text = new TextArea("");
    }

    public AbstractTextBox(int numberOfRows, int numberOfColumns) {
        text = new TextArea(numberOfRows, numberOfColumns);
    }

    public AbstractTextBox(String text, int numberOfRows, int numberOfColumns) {
        this.text = new TextArea(text, numberOfRows, numberOfColumns);
    }

	public void init() {
        text.setEnabled(true);
	}

	public void disable() {
        text.setEnabled(false);
	}

	public void setPosition(Position p) {
        this.p = p;
	}

	public void setPosition(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
	}
	
	public Position getPosition() {
		return this.p;
	}

	public double getXPosition() {
        return this.xPos;
	}

	public double getYPosition() {
		return this.yPos;
	}

	public void show() {
        text.setText(hiddenText);
	}

	public void hide() {
        hiddenText = text.getText();
		text.setText("");
	}

}
