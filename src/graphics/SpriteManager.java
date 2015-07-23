package graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import entity.Entity;

/**
 * This class is used to instantiate a manager object that each {@link  entity.Entity} will have to manage
 * it's {@link  sprite.Sprite}s and make it easy for a user to choose which {@link  sprite.Sprite} to display
 * Also includes functionality to loop between various {@link  sprite.Sprite}, for animations
 * 
 * @author Jonathan Zwiebel
 * @version June 19th, 2015
 */
public class SpriteManager {
	/** An <code>ArrayList</code> that will hold all of the {@link  sprite.Sprite} that this object can manage **/
	private ArrayList<Drawable> drawableElements;
		
	/** The {@link  entity.Entity} that this manager belongs to **/
	private Entity entity;
	
	/**
	 * Constructs a SpriteManager object by taking an <code>ArrayList</code> of {@link  sprite.Sprite}s
	 * 
	 * @param entity the {@link  entity.Entity} that this manager belongs to 
	 * @param sprites the {@link  sprite.Drawable}s that this manager will manage
	 */
	public SpriteManager(Entity entity, ArrayList<Drawable> drawableElements) {
		this.entity = entity;
		this.drawableElements = drawableElements;
	}
	
	/**
	 * Called periodically with game updates, this will update the current graphics of the {@link  sprite.Sprite}
	 * by delegating it to draw itself
	 * 
	 * @param g an AWT <code>Graphics</code> object
	 * @param activeDrawables the name of the current {@link  sprite.Sprite}
	 */
	public void update(Graphics g, String activeDrawable) {
		// Loads the Drawable
		boolean caught = false;
		for(Drawable d : drawableElements) {
			if (d.getName() == activeDrawable) {
				d.draw(g);
				caught = true;
				break;
			}
		}
		
		// Catches and quits the program if an illegal Sprite is attempted to be displayed
		if(!caught) {
			System.out.println("Invalid drawable name: " + drawableElements + " for " + entity.getClass().getName());
			System.exit(0);
		}
	}
	
	public Entity getEntity() {
		return entity;
	}
}
