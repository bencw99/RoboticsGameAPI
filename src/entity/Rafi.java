package entity;

import physics.Dimension;
import physics.Position;
import world.World;

public class Rafi extends Entity {

	int cycle = 0;
	
	public Rafi(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		spritesArray = new String[]{"rafi", "images/rafi.png", "ok-rafi", "images/rafi-2.png"};
		loadSprites();
		
		activeSprite = "INVISIBLE";
		setPos(new Position(500, 500));
		setDim(new Dimension(512, 512));
	}

	@Override
	public void update() {
		cycle++;
		if(cycle == 6000) {
			activeSprite = "rafi";
			setFrameLength(600);
			setAnimationMode(true);
		}
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

}
