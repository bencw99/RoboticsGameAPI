package entity;

import physics.Vector;

import input.InputListener;
import world.World;
import game.Game.State;
import graphics.Sprite;
import graphics.SpriteManager;

public class TestEntity extends Entity {
	
	public TestEntity(World world) {
		super(world);
		setSpriteManager(new SpriteManager(this, new Sprite(this, "happy", "happy.jpg")));
	}

	@Override
	public void init() {
		translate(new Vector(100, 100));
	}

	@Override
	public void update() {
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}
}
