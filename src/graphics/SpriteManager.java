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
	private ArrayList<Sprite> sprites;
		
	/** The {@link  entity.Entity} that this manager belongs to **/
	private Entity entity;
	
	/** Is this manager currently in animation mode? **/
	boolean animationMode = false;
	
	/** How many game update cycles will be called before the {@link  sprite.Sprite} is changed in animation mode **/
	private int ticksPerFrame = 1;
	
	/** How many update cycles have been played on this {@link  sprite.Sprite} **/
	private int currentTick = 0;
			
	/** The current {@link  sprite.Sprite} **/
	private int currentFrame = 0;
	
	/**
	 * Constructs a SpriteManager object by taking an <code>ArrayList</code> of {@link  sprite.Sprite}s
	 * 
	 * @param entity the {@link  entity.Entity} that this manager belongs to 
	 * @param sprites the {@link  sprite.Sprite}s that this manager will manage
	 */
	public SpriteManager(Entity entity, ArrayList<Sprite> sprites) {
		this.entity = entity;
		this.sprites = sprites;
	}
	
	/**
	 * Called periodically with game updates, this will update the current graphics of the {@link  sprite.Sprite}
	 * by delegating it to draw itself
	 * 
	 * @param g an AWT <code>Graphics</code> object
	 * @param activeSprite the name of the current {@link  sprite.Sprite}
	 */
	public void update(Graphics g, String activeSprite) {
		// Calls the special animationUpdate method and breaks this one if in animation mode
		if(animationMode) {
			animationUpdate(g);
			return;
		}
		
		
		// Loads the Sprite
		boolean caught = false;
		for(Sprite s : sprites) {
			if (s.getName() == activeSprite) {
				s.draw(g);
				caught = true;
				break;
			}
		}
		
		// Catches and quits the program if an illegal Sprite is attempted to be displayed
		if(!caught) {
			System.out.println("Invalid sprite name: " + activeSprite);
			System.exit(0);
		}
	}
	
	/**
	 * A special update method called when in animation mode that will cycle the {@link  sprite.Sprite}s at a 
	 * rate of 1 {@link  sprite.Sprite} every ticksPerFrame update cycles
	 * 
	 * @param g an AWT <code>Graphics</code> object
	 */
	public void animationUpdate(Graphics g) {
		currentTick++;
		if(currentTick == ticksPerFrame) {
			currentTick = 1;
			currentFrame++;
			if(currentFrame == sprites.size()) {
				currentFrame = 0;
			}
		}
		sprites.get(currentFrame).draw(g);
	}
	
	public void setAnimationMode(boolean animationMode) {
		this.animationMode = animationMode;
	}
	
	public boolean getanimationMode() {
		return animationMode;
	}
	
	public int getTicksPerFrame() {
		return ticksPerFrame;
	}

	public void setTicksPerFrame(int ticksPerFrame) {
		this.ticksPerFrame = ticksPerFrame;
	}
	
	public Entity getEntity() {
		return entity;
	}
}
