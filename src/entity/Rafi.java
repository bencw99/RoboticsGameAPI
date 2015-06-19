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
		spritesArray = new String[]{"rafi", "images\\rafi.png"};
		loadSprites();
		
		activeSprite = "INVISIBLE";
		setPos(new Position(500, 500));
		setDim(new Dimension(512, 512));
	}

	@Override
	public void update() {
		cycle++;
		if(cycle == 5000) {
			activeSprite = "rafi";
		}
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

}
