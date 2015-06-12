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
		
	}

	@Override
	public void update() {

	}

	@Override
	public void disable() {

	}
}
