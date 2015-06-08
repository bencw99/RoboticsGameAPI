package entity;

import java.awt.Graphics;
import java.util.Collection;

import physics.Vector;
import world.World;

public class Mobile extends Entity {
	
	/** The movement vector of this mobile entity */
	Vector vel;
	
	/**
	 * Constructor, initializes world
	 * @param world
	 */
	public Mobile(World world) {
		super(world);
	}

	/**
	 * Update the position of this mobile entity based on its current velocity
	 */
	public void update() {
		this.getPos().translate(vel);
		collide(this.getWorld().getEntities());
	}

	/**
	 * Detect and deal with collisions with other entities in the world
	 * @param entities
	 * @return whether or not a collision is detected
	 */
	public boolean collide(Collection<Entity> entities) {
		//TODO
		return false;
	}

	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}
}
