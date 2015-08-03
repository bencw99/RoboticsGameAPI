package api.graphics;

import java.awt.Graphics;

/**
 * An interface for obejcts Drawable by a SpriteManager
 * 
 * @author Jonathan Zwiebel
 * @version July 26th, 2015
 */
public interface Drawable {
	/**
	 * Draws this object
	 * @param g the graphics on which to draw this
	 */
	public void draw(Graphics g);

	/**
	 * Sets the name of this object 
	 * @param name new name
	 */
	public void setName(String name);

	/**
	 * Gets the name of this object
	 * @return the name of this object
	 */
	public String getName();
}
