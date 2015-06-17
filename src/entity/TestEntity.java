package entity;

import world.World;
import graphics.Sprite;
import graphics.SpriteManager;

public class TestEntity extends Entity {
	
	public TestEntity(World world) {
		super(world);
		spriteManager = new SpriteManager(new Sprite("happy", "happy.jpg"));
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}
}
