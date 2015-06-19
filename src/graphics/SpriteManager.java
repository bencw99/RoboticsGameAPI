package graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import entity.Entity;

public class SpriteManager {
	private ArrayList<Sprite> sprites;
		
	private Entity entity;
	
	boolean cycleMode = false;
	
	private int ticksPerCycle = 1;
	private int currentTick = 0, currentCycle = 0;
	
	// loading single sprites
	public SpriteManager(Entity entity, Sprite sprite) {
		this.entity = entity;
		sprites = new ArrayList<Sprite>();
		sprites.add(sprite);
	}
	
	// loading a 'sprite AL'
	public SpriteManager(Entity entity, ArrayList<Sprite> sprites) {
		this.entity = entity;
		this.sprites = sprites;
	}
	
	public void update(Graphics g, String activeSprite) {
		if(cycleMode) {
			cycleUpdate(g);
			return;
		}
		
		boolean caught = false;
		for(Sprite s : sprites) {
			if (s.getName() == activeSprite) {
				s.draw(g);
				caught = true;
				break;
			}
		}
		if(!caught && activeSprite != "INVISIBLE") {
			System.out.println("Invalid sprite name: " + activeSprite);
			System.exit(0);
		}
	}
	
	public void cycleUpdate(Graphics g) {
		currentTick++;
		if(currentTick == ticksPerCycle) {
			currentTick = 1;
			currentCycle++;
			if(currentCycle == sprites.size()) {
				currentCycle = 0;
			}
		}
		sprites.get(currentCycle).draw(g);
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
