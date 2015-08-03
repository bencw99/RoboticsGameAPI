package api.graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import api.constants.Constants;
import api.entity.Entity;

/**
 * This class is an extension of SpriteManager that holds a set of Sprites that can be cycled between for the purpose of animation creations.
 * The animations can be individually stepped frame for frame or set to run automatically or loop. Animation will always have an active Sprite
 * that will be drawn when the inheritted draw method is called. The drawable interface means this class can be held in a SpriteManager.
 * 
 * @author Jonathan Zwiebel
 * @version July 26th, 2015
 */
public class Animation extends SpriteManager implements Drawable {	
	/** The name of this Animation **/
	private String name;

	/** How many update cycles have been called on this particular Sprite (0 indexed) **/
	private int currentTick;

	/** The current Sprite that should be drawn **/
	private int currentFrame;

	/** How many game update cycles will be called before the animaion moves to the next Sprite **/
	private int ticksPerFrame;

	/** Will the animation loop back to the original Sprite once it hits the last one **/
	private boolean cycleMode;

	/** Will the animation automatically step between Sprites **/
	private boolean autoMode;

	/**
	 * Constructor
	 * @param entity the entity to which this Animation belongs
	 * @param sprites an ArrayList of Sprites for this Animation
	 */
	public Animation(Entity entity, ArrayList<Drawable> sprites) {
		super(entity, sprites);
		currentTick = -1;
		currentFrame = 0;
		ticksPerFrame = Constants.DEFAULT_ANIMATION_TICKS_PER_FRAME;
		cycleMode = Constants.DEFAULT_CYCLE_MODE;
		autoMode = Constants.DEFAULT_AUTO_MODE;
	}

	// Inherited methods from Drawable

	public void draw(Graphics g) {
		drawableElements.get(currentFrame).draw(g);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	/**
	 * The periodic update method that is called if autoMode is true
	 * Will call stepFrame if the tick hits the final value
	 */
	public void animationUpdate() {
		currentTick++;
		if(currentTick == ticksPerFrame) {
			stepFrame();
			currentTick = 0;
		}
	}

	/**
	 * Moves forward one frame in the animation, will cycle back to original frame
	 * if in cycleMode otherwise will go to the final frame (which is not in the cycle)
	 */
	public void stepFrame() {
		currentFrame++;
		if(currentFrame == drawableElements.size() - 1) {
			if(!cycleMode) {
				setAutoMode(false);
			}
			else {
				currentFrame = 0;
			}
		}
	}

	public boolean getAutoMode() {
		return autoMode;
	}

	public boolean getCycleMode() {
		return cycleMode;
	}

	public void setAutoMode(boolean myMode) {
		autoMode = myMode;
	}

	public void setCycleMode(boolean myMode) {
		cycleMode = myMode;
	}

	public int getTicksPerFrame() {
		return ticksPerFrame;
	}

	public void setTicksPerFrame(int ticksPerFrame) {
		this.ticksPerFrame = ticksPerFrame;
	}
}
