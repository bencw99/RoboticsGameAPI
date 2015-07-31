package spriteless;

import physics.Position;
import physics.Dimension;
import java.awt.*;

public abstract class AbstractTextBox extends TextArea implements SpritelessElement{
	private static final long serialVersionUID = 1L;

	private Position p;

    private Dimension dim;

    public abstract void update();

    public AbstractTextBox(String s) {
    	super(s);
        p = new Position(0, 0);
        setEditable(false);
        setFocusable(false);
    }

    public AbstractTextBox() {
        super("");
        p = new Position(0, 0);
        setEditable(false);
        setFocusable(false);
    }

    public AbstractTextBox(int numberOfRows, int numberOfColumns) {
        super(numberOfRows, numberOfColumns);
    }

    public AbstractTextBox(String text, int numberOfRows, int numberOfColumns) {
        super(text, numberOfRows, numberOfColumns, SCROLLBARS_NONE);
    }

	public void init() {
        setEnabled(true);
	}

	public void disable() {
        setEnabled(false);
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
        setVisible(true);
	}

	public void hide() {
        setVisible(false);
	}

}
