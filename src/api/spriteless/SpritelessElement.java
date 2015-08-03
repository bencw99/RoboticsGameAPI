package api.spriteless;

import java.awt.*;

import api.physics.Position;

public interface SpritelessElement{
    /**
     * Initializes the SpritelessElement
     */
    void init();

    /**
     * Updates the SpritelessELement.
     * This method is called multiple times a second.
     */
	void update();

    /**
     * Disables the SpritelessElement.
     */
	void disable();

    /**
     * Sets the position of the SpritelessElement to the given Position.
     *
     * @param p the Position to set
     */
	void setPosition(Position p);

    /**
     * Sets the position of the SpritelessElement to the given coordinates.
     *
     * @param xPos the x coordinate of the new Position
     * @param yPos the y coordinate of the new Position
     */
	void setPosition(double xPos, double yPos);

    /**
     * Sets the dimension of the SpritelessElement to the given Dimension.
     *
     * @param dim the Dimension to set
     */
    void setDimension(Dimension dim);

    /**
     * Sets the dimension of the SpritelessElement to the given width and height.
     *
     * @param width the width of the new Dimension
     * @param height the height of the new Dimension
     */
    void setDimension(double width, double height);

    /**
     * Gets the Dimension of this SpritelessElement
     *
     * @return the Dimension of this SpritelessElement
     */
    Dimension getDimension();

    /**
     * Gets the Position of this SpritelessElement
     *
     * @return the Position of this SpritelessElement
     */
	Position getPosition();

    /**
     * Gets the x position of this SpritelessElement
     *
     * @return the x coordinate of this SpritelessElement
     */
	double getXPosition();

    /**
     * Gets the y position of this SpritelessElement
     *
     * @return the y coordinate of this SpritelessElement
     */
	double getYPosition();

    /**
     * Makes this SpritelessElement visible
     */
	void show();

    /**
     * Makes this SpritelessElement invisible
     */
	void hide();
}
