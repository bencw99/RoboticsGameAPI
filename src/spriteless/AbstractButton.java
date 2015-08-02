package spriteless;

import physics.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractButton extends JButton implements SpritelessElement, ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * The dimension of the AbstractButton
	 */
    private Dimension dim;

    /**
     * The position of the AbstractButton
     */
	private Position pos;

	/**
	 * Default constructor for AbstractButton
	 * Default position is (0, 0)
	 * Default dimension is (10, 10)
	 */
	public AbstractButton() {
		this(new Position(0, 0), new Dimension(10, 10));
	}
	
	/**
	 * Constructor for AbstractButton
	 * 
	 * @param p the position of the AbstractButton
	 * @param d the dimension of the AbstractButton
	 */
	public AbstractButton(Position p, Dimension d) {
		pos = p;
		dim = d;
		setPreferredSize(dim);
		setSize(dim);
		addActionListener(this);
	}

	/**
	 * Updates the AbstractButton
	 * This method is called multiple times a second
	 */
	public abstract void update();
	
	/**
	 * This method is called whenever the button is pressed
	 */
	public abstract void actionPerformed(ActionEvent e);

	/**
	 * Makes the AbstractButton visible
	 */
    public final void show() {
        setVisible(true);
    }

    /**
     * Makes the AbstractButton invisible
     */
  	public final void hide() {
        setVisible(false);
    }

	public void setButtonText(String text) {
		setText(text);
	}
	
	public String getButtonText() {
		return getText();
	}
	
	public void init() {
		setEnabled(true);
	}
	
	public void disable() {
		setEnabled(false);
	}

    public void setDimension(Dimension dim) {
        this.dim = dim;
        setPreferredSize(dim);
        setSize(dim);
    }

    public void setDimension(double width, double height) {
        this.dim.setSize(width, height);
        setPreferredSize(dim);
        setSize(dim);
    }

    public Dimension getDimension() {
        return this.dim;
    }

	public void setPosition(Position p) {
		this.pos.setX(p.getX());
		this.pos.setY(p.getY());
	}

	public void setPosition(double xPos, double yPos) {
		this.pos.setX(xPos);
		this.pos.setY(yPos);
	}
	
	public Position getPosition() {
		return pos;
	}
	
	public double getXPosition() {
		return pos.getX();
	}
	
	public double getYPosition() {
		return pos.getY();
	}


}
