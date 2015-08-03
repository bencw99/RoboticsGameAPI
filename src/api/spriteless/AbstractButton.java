package api.spriteless;

import javax.swing.*;

import api.physics.Position;

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

  	/**
  	 * Sets the button text to the given text
  	 * 
  	 * @param text the text to be displayed
  	 */
	public void setButtonText(String text) {
		setText(text);
	}
	
	/**
	 * Gets the text on the button
	 * 
	 * @return the button text
	 */
	public String getButtonText() {
		return getText();
	}
	
	/**
	 * Initializes the AbstractButton
	 */
	public void init() {
		setEnabled(true);
	}
	
	/**
	 * Disables the AbstractButton
	 */
	public void disable() {
		setEnabled(false);
	}

	/**
	 * Sets the dimension of this AbstractButton to the given dimension
	 * 
	 * @param dim the dimension to set 
	 */
    public void setDimension(Dimension dim) {
        this.dim = dim;
        setPreferredSize(dim);
        setSize(dim);
    }

    /**
     * Sets the dimension of this AbstractButton to the given width and height
     * 
     * @param width the width to set the dimension to
     * @param height the height to set the dimension to
     */
    public void setDimension(double width, double height) {
        this.dim.setSize(width, height);
        setPreferredSize(dim);
        setSize(dim);
    }

    /**
     * Gets the dimension of this AbstractButton
     * 
     * @return the dimension of this AbstractButton
     */
    public Dimension getDimension() {
        return this.dim;
    }

    /**
     * Sets the position of this AbstractButton to the given position
     * 
     * @param p the position to set
     */
	public void setPosition(Position p) {
		this.pos.setX(p.getX());
		this.pos.setY(p.getY());
	}

	/**
	 * Sets the position of this AbstractButton to the given coordinates
	 * 
	 * @param xPos the x coordinate of the position to set
	 * @param yPos the y coordinate of the position to set
	 */
	public void setPosition(double xPos, double yPos) {
		this.pos.setX(xPos);
		this.pos.setY(yPos);
	}
	
	/**
	 * Gets the position of this AbstractButton
	 * 
	 * @return the position of this AbstractButton
	 */
	public Position getPosition() {
		return pos;
	}
	
	/**
	 * Gets the x coordinate of this AbstractButton
	 * 
	 * @return the x coordinate of the position of this AbstractButton
	 */
	public double getXPosition() {
		return pos.getX();
	}
	
	/**
	 * Gets the y coordinate of this AbstractButton
	 * 
	 * @return the y coordinate of the position of this AbstractButton
	 */
	public double getYPosition() {
		return pos.getY();
	}


}
