package spriteless;

import physics.Position;
import java.awt.*;

public abstract class AbstractTextBox extends TextArea implements SpritelessElement{
	private static final long serialVersionUID = 1L;

	private Position p;

    private Dimension dim;

    public abstract void update();

    public AbstractTextBox(String s) {
    	this(s, 50, 50);
    }

    public AbstractTextBox() {
        this("", 50, 50);
    }

    public AbstractTextBox(int width, int height) {
        this("", width, height);
    }

    public AbstractTextBox(String text, int width, int height) {
        super(text, height, width, SCROLLBARS_NONE);
        p = new Position(0, 0);
        dim = new Dimension(width, height);
        setPreferredSize(dim);
        setEditable(false);
        setFocusable(false);
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
        this.dim.setSize(width, height);
        setPreferredSize(dim);
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
