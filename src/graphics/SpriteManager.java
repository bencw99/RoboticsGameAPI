package graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import graphics.Animation;

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
	protected ArrayList<Drawable> drawableElements;

	/** The {@link  entity.Entity} that this manager belongs to **/
	private Entity entity;
	
	Drawable activeDrawable;

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
		for(int i = 0; i < drawableElements.size(); i++) {
		Drawable d = drawableElements.get(i);
			if (d.getName() == activeDrawable) {
				if(d instanceof Animation) {
					((Animation) d).animationUpdate();
				}
				this.activeDrawable = d;
				d.draw(g);
				caught = true;
				break;
			}
		}

		// Catches and quits the program if an illegal Sprite is attempted to be displayed
		if(!caught) {
			System.out.println("Invalid drawable name: " + activeDrawable + " for " + entity.getClass().getName());
			System.exit(0);
		}
	}

	public void step() {
		if(activeDrawable instanceof Animation) {
			((Animation) activeDrawable).step();
		}
	}
	
	public void setCycleMode(boolean cycleMode) {
		for(Drawable d : drawableElements) {
			if(d instanceof Animation) {
				((Animation) d).setCycleMode(cycleMode);
			}
		}
	}
	
	
	public void setAutoMode(boolean autoMode) {
		for(Drawable d : drawableElements) {
			if(d instanceof Animation) {
				((Animation) d).setAutoMode(autoMode);
			}
		}
	}

	
	public Entity getEntity() {
		return entity;
	}
}
