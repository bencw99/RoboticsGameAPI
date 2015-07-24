package graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import entity.Entity;

public class Animation extends SpriteManager implements Drawable {	
	/** The name of this Sprite **/
	private String name;

	/** How many game update cycles will be called before the {@link  sprite.Sprite} is changed in animation mode **/
	private int ticksPerFrame = 400;

	/** How many update cycles have been played on this {@link  sprite.Sprite} **/
	private int currentTick = 0;

	/** The current {@link  sprite.Sprite} **/
	private int currentFrame = 0;

	private boolean cycleMode = false;

	@Override
	public void draw(Graphics g) {
		drawableElements.get(currentFrame).draw(g);
	}

	public Animation(Entity entity, ArrayList<Drawable> sprites) {
		super(entity, sprites);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * A special update method called when in animation mode that will cycle the {@link  sprite.Sprite}s at a 
	 * rate of 1 {@link  sprite.Sprite} every ticksPerFrame update cycles
	 * 
	 * @param g an AWT <code>Graphics</code> object
	 */
	public void animationUpdate(Graphics g) {
		if(cycleMode) {
			currentTick++;
			if(currentTick == ticksPerFrame) {
				currentTick = 1;
				currentFrame++;
				if(currentFrame == drawableElements.size()) {
					currentFrame = 0;
				}
			}
		}
	}

	public boolean isCycleMode() {
		return cycleMode;
	}

	public void setCycleMode(boolean cycleMode) {
		this.cycleMode = cycleMode;
	}

	public int getTicksPerFrame() {
		return ticksPerFrame;
	}

	public void setTicksPerFrame(int ticksPerFrame) {
		this.ticksPerFrame = ticksPerFrame;
	}
}
