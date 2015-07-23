package graphics;

import java.awt.Graphics;
import java.util.ArrayList;

public class Animation implements Drawable {
	private ArrayList<Sprite> sprites;	
	
	/** The name of this Sprite **/
	private String name;
	
	/** How many game update cycles will be called before the {@link  sprite.Sprite} is changed in animation mode **/
	private int ticksPerFrame = 1;
	
	/** How many update cycles have been played on this {@link  sprite.Sprite} **/
	private int currentTick = 0;
			
	/** The current {@link  sprite.Sprite} **/
	private int currentFrame = 0;

	@Override
	public void draw(Graphics g) {
		
	}
	
	public String getName() {
		return name;
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
	
	public int getTicksPerFrame() {
		return ticksPerFrame;
	}

	public void setTicksPerFrame(int ticksPerFrame) {
		this.ticksPerFrame = ticksPerFrame;
	}
}
