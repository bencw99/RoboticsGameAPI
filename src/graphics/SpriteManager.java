package graphics;

import java.util.ArrayList;

public class SpriteManager {
	private ArrayList<Sprite> sprites;
	
	private int currentSprite = 1;
	
	boolean cycleMode = false;
	private int ticksPerCycle = 1;
	
	// loading single sprites
	public SpriteManager(Sprite sprite) {
		sprites = new ArrayList<Sprite>();
		sprites.add(sprite);
	}
	
	// loading a 'sprite AL'
	public SpriteManager(ArrayList<Sprite> sprites) {
		this.sprites = sprites;
	}
	
	public void update() {

	}
	
	//gets and sets
							public void setCycleMode(boolean cycleMode) {
								this.cycleMode = cycleMode;
							}
							
							public boolean getCycleMode() {
								return cycleMode;
							}
							
							public int getTicksPerCycle() {
								return ticksPerCycle;
							}
						
							public void setTicksPerCycle(int ticksPerCycle) {
								this.ticksPerCycle = ticksPerCycle;
							}

	private int getIndex(String name) {
		for(int i = 0; i <= sprites.size(); i++) {
			if(sprites.get(i).getName() == name) {
				return i;
			}
		}
		return -1;
	}
}
