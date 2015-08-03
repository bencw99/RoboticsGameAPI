package api.graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import api.entity.Entity;
import api.graphics.Animation;

/**
 * This class is used to instantiate a manager object for every entity that controls
 * it's Sprites and make it easy for a user to choose which Sprite to display
 * Also includes functionality to loop between various Sprites for animations
 * 
 * @author Jonathan Zwiebel
 * @version June 26th, 2015
 */
public class SpriteManager {
	/** An ArrayList that will hold all of the Drawable elements, Sprites and Animations, that this object can manage **/
	protected ArrayList<Drawable> drawableElements;

	/** The Entity that this manager belongs to **/
	private Entity entity;

	/** The current Drawable object being displayed **/
	Drawable activeDrawable;

	/**
	 * Constructor
	 * @param entity the Entity that this manager belongs to 
	 * @param sprites the ArrayList of Drawables that this manager will manage
	 */
	public SpriteManager(Entity entity, ArrayList<Drawable> drawableElements) {
		this.entity = entity;
		this.drawableElements = drawableElements;
	}

	/**
	 * Called periodically with game updates, this will update the Sprite to be shown
	 * and called the Animation update method
	 * @param g an AWT Graphics object
	 * @param activeDrawable the name of the current Sprite or Animation to display
	 */
	public void update(Graphics g, String activeDrawable) {
		boolean caught = false;
		for(Drawable d : drawableElements) {
			if (d.getName() == activeDrawable) {
				caught = true;
				this.activeDrawable = d;
				if(d instanceof Animation) {
					if(((Animation) d).getAutoMode()) {
						((Animation) d).animationUpdate();
					}
				}
				d.draw(g);
			}
		}

		if(!caught) {
			System.out.println("Invalid drawable name: " + activeDrawable + " for " + entity.getClass().getName());
			System.exit(0);
		}
	}

	public ArrayList<Drawable> getDrawableElements() {
		return drawableElements;
	}

	public void setDrawableElements(ArrayList<Drawable> drawableElements) {
		this.drawableElements = drawableElements;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Drawable getActiveDrawable() {
		return activeDrawable;
	}

	public void setActiveDrawable(Drawable activeDrawable) {
		this.activeDrawable = activeDrawable;
	}


	// Call down methods

	public void stepFrame() {
		for(Drawable d : drawableElements) {
			if(d instanceof Animation) {
				((Animation) d).stepFrame();
			}
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

	public void setTicksPerFrame(int ticks) {
		for(Drawable d : drawableElements) {
			if(d instanceof Animation) {
				((Animation) d).setTicksPerFrame(ticks);
			}
		}
	}
}
