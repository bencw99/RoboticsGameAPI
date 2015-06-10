package entity;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Collection;

import constants.Constants;
import physics.Dimension;
import physics.Position;
import physics.Vector;
import world.World;

public class Mobile extends Entity implements Interactable, Updateable {
	
	/** The movement vector of this mobile entity */
	Vector vel;
	
	/**
	 * Parameterized constructor, initializes entity world to given parameters
	 */
	public Mobile(World world) {
		super(world);
		this.vel = new Vector();
	}
	
	/**
	 * Parameterized constructor, initializes entity position and dimensions to given parameters
	 */
	public Mobile(World world, Position pos, Dimension dim, Vector vel) {
		super(world, pos, dim, vel);
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
	
	/**
	 * Update the position of this mobile entity based on its current velocity
	 */
	@Override
	public void update() {
		this.getPos().translate(new Vector(vel.getX()/Constants.UPDATES_PER_SEC, vel.getY()/Constants.UPDATES_PER_SEC));
		collide(this.getWorld().getEntities());
	}

	@Override
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Polygon getInteractionRegion()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
